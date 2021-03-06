<%@page import="java.util.Map"%>
<%@page import="java.util.LinkedList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.Incident"%>
<%@page import="model.Venue"%>
<%@page import="java.util.HashMap"%>
<!DOCTYPE html>
<html>
    <head>
        <style>
            body {
                background-image: url('images/background.png');
            }
            footer {
                position: fixed;
                bottom: 0;
                width: 100%;
                height: 2.5rem;   
                left: 0;
                width: 100%;
                background-color: white;
                color: black;
                text-align: center;
            }    
        </style>
        <meta charset="utf-8">
        <meta name="viewport" content="initial-scale=1,maximum-scale=1,user-scalable=no">
        <!-- Mapbox imports -->
        <link href="https://api.mapbox.com/mapbox-gl-js/v2.4.1/mapbox-gl.css" rel="stylesheet">
        <script src="https://api.mapbox.com/mapbox-gl-js/v2.4.1/mapbox-gl.js"></script>
        <style>
            body { margin: 0; padding: 0; }
            #map { height: 400px; width: 100%; }
        </style>
        <title>Incident Reporting System</title>
        <!--Load the AJAX API for Google Charts-->
        <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
        <script type="text/javascript">
            // Load the Google Visualization API and the corechart package.
            google.charts.load('current', {'packages': ['corechart']});
            // Set a callback to run when the Google Visualization API is loaded.
            google.charts.setOnLoadCallback(drawChart);
            // Callback that creates and populates a data table,
            // instantiates the pie chart, passes in the data and
            // draws it.
            function drawChart() {

                // Create the data table.
                var data = new google.visualization.DataTable();
                data.addColumn('string', 'Incident Type');
                data.addColumn('number', 'Occurances');
                data.addRows([
                    //For each incident type, register the incident type and number of times it occured
            <c:forEach var="Section" items="${GraphData}">
                    ['${Section.key}', ${Section.value} ],
            </c:forEach>
                ]);
                // Set chart options
                var options
                var persistView = localStorage['persistView'];
                if (persistView == "graphs") {
                    options = {'title': 'Incidents',
                        'width': '100%',
                        'height': 500};
                } else {
                    options = {'title': 'Incidents',
                        'width': 600,
                        'height': 500};

                }
                // Instantiate and draw our chart, passing in our options.
                var chart = new google.visualization.PieChart(document.getElementById('chart_div'));
                chart.draw(data, options);
            }

        </script>
    </head>
    <body>
        <%-- User Access Control, currently disabled as we decided against restricting access
                <c:choose>
                <c:when test="${empty sessionScope.user}">
                    <jsp:include page="error.jsp" />
                </c:when>
                <c:otherwise> --%>

        <!-- Include the following page for Navbar and Global Style Imports -->
        <jsp:include page="components/navbar.jsp" />
        <div class="container">
            <div class="row">
                <div class="col-md-2 col-sm-0"></div>
                <div class="col-md-8 col-sm-12">
                    <div class="card" style="margin-top:2rem;">
                        <nav>

                            <h1 class="card-header">Graphs and Maps</h1>
                            <div class="card-body">
                                <div class="nav nav-tabs" id="nav-tab" role="tablist">
                                    <button class="nav-link" id="nav-maps-tab" data-bs-toggle="tab" data-bs-target="#nav-maps" type="button" role="tab" aria-controls="nav-maps" aria-selected="true" onclick="changePersistView('maps')">Maps</button>
                                    <button class="nav-link" id="nav-graphs-tab" data-bs-toggle="tab" data-bs-target="#nav-graphs" type="button" role="tab" aria-controls="nav-graphs" aria-selected="false" onclick="changePersistView('graphs')">Graphs</button>
                                </div>
                        </nav>
                        <div class="tab-content" id="nav-tabContent" style="margin: 1rem;">
                            <div class="tab-pane fade" id="nav-maps" role="tabpanel" aria-labelledby="nav-maps-tab">
                                <form action="GraphsMaps" method="GET">
                                    <p>Filter Map by Incident Type: </p>
                                    <div class="mb-3">
                                        <select class="form-select" name="map_type">
                                            <option value="" selected>Reset to Default Map (Incident Count by Venue)</option>
                                            <c:forEach var="IncidentType" items="${IncidentTypeCount}">
                                                <option value="${IncidentType.key}">Only ${IncidentType.key} Incidents</option>
                                            </c:forEach>                                           

                                        </select>
                                    </div>
                                    <button type="submit" class="btn btn-primary">View</button>
                                    <br>
                                </form>
                                <br>
                                <p strong>Currently Viewing: ${MapType} Map</p>
                                <!-- Div filled by maps Javascript at bottom of page -->
                                <div id="map"></div>
                            </div>
                            <div class="tab-pane fade" id="nav-graphs" role="tabpanel" aria-labelledby="nav-graphs-tab" style="margin: 1rem;">
                                <form action="GraphsMaps" method="GET">
                                    <p>Choose Graph Type: </p>
                                    <div class="mb-3">
                                        <select class="form-select" aria-label="Default select example" name="graph_type">
                                            <option value="" selected>Reset to Default Graph (Number of Incidents by Type)</option>
                                            <c:forEach var="IncidentType" items="${IncidentTypeCount}">
                                                <option value="@${IncidentType.key}">${IncidentType.key} Count by Venue </option>
                                            </c:forEach>    
                                            <c:forEach var="Venue" items="${Venues}">
                                                <option value="v${Venue.id}">${Venue.name} Breakdown by Offence Types </option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <button type="submit" class="btn btn-primary">View</button>
                                    <br>
                                </form>
                                <br>
                                <p strong>Currently Viewing: ${GraphType} Graph</p>

                                <!-- Div filled by charts Javascript at top of page -->
                                <div id="chart_div"></div>
                            </div>
                        </div>



                    </div>
                </div>
            </div>
        </div>

        <!-- Import mapbox SDK for Geocoding -->
        <script src="https://unpkg.com/@mapbox/mapbox-sdk/umd/mapbox-sdk.min.js"></script>
        <script>
        //Display correct view based on stored value (map or graphs)
        $(document).ready(function () {
            var persistView = localStorage['persistView'];
            if (persistView == "graphs") {
                $("#nav-graphs-tab").addClass("active");
                $("#nav-graphs").addClass("show active");
            } else {
                $("#nav-maps-tab").addClass("active");
                $("#nav-maps").addClass("show active");
                }});

        //Store current view so that when the page refreshes (apply filter), the same view is displayed upon reload        
        function changePersistView(viewType) {
            localStorage['persistView'] = viewType;
            setTimeout(function () {
            map.resize();}, 500);
        };
        
        </script>
        <script>
            //Create map
            mapboxgl.accessToken = 'pk.eyJ1Ijoiam9zZXBoamRyZXciLCJhIjoiY2t0NDQwbzAyMG9wcTJ3cGdqdzFyNDFyZiJ9.UImioRYUuYdHqXu0oU3ibw';
            const mapboxClient = mapboxSdk({accessToken: mapboxgl.accessToken});
            const map = new mapboxgl.Map({
                container: 'map',
                style: 'mapbox://styles/mapbox/streets-v11',
                center: [151.209290, -33.868820],
                zoom: 9
            });
            // Create a marker for each venue and add it to the map.
            <c:forEach var="Venue" items="${MapData}">
            //If we don't have a latitude or longitude, use Geocode API to look up address then add a marker
            if ('${Venue.key.lat}' == '0.0' || '${Venue.key.lon}' == '0.0') {
                mapboxClient.geocoding
                        .forwardGeocode({
                            query: '${Venue.key.address}',
                            autocomplete: false,
                            limit: 1
                        })
                        .send()
                        .then((response) => {
                            if (
                                    !response ||
                                    !response.body ||
                                    !response.body.features ||
                                    !response.body.features.length
                                    ) {
                                console.error('Invalid response:');
                                console.error(response);
                                return;
                            }
                            const feature = response.body.features[0];
                            new mapboxgl.Marker({color: 'red'}).setLngLat(feature.center)
                                    .setPopup(new mapboxgl.Popup({offset: 25})
                                            .setHTML('<h5>${Venue.key.name}</h5><p>Number of incidents: ${Venue.value} </p>'))
                                    .addTo(map);
                        })
            }
            //Else if we have a longitude and latitude, just add the marker to the map            
            else {
                new mapboxgl.Marker({color: 'red'})
                        .setLngLat([${Venue.key.lon}, ${Venue.key.lat}])
                        .setPopup(new mapboxgl.Popup({offset: 25})
                                .setHTML('<h5>${Venue.key.name}</h5><p>Number of incidents: ${Venue.value} </p>'))
                        .addTo(map);
            }

            </c:forEach>
            //Ensure map is displayed at correct size
            map.on('load', function () {
                map.resize();
            });
        </script><br><br><br>
        <footer>
            <p>Copyright &copy; 2021 | Incident Reporting System </p>
        </footer>
    </body>
</html>
