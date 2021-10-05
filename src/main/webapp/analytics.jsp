<%@page import="java.util.Map"%>
<%@page import="java.util.LinkedList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.Incident"%>
<%@page import="model.Venue"%>
<%@page import="java.util.HashMap"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="initial-scale=1,maximum-scale=1,user-scalable=no">
        <link href="https://api.mapbox.com/mapbox-gl-js/v2.4.1/mapbox-gl.css" rel="stylesheet">
        <script src="https://api.mapbox.com/mapbox-gl-js/v2.4.1/mapbox-gl.js"></script>
        <style>
            body { margin: 0; padding: 0; }
            #map { height: 400px; width: 100%; }
        </style>
        <title>Incident Reporting System</title>
        <!--Load the AJAX API-->
        <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
        <script type="text/javascript">
            // Load the Visualization API and the corechart package.
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
            <c:forEach var="IncidentType" items="${IncidentTypeCount}">
                    ['${IncidentType.key}', ${IncidentType.value} ],
            </c:forEach>
                ]);

                // Set chart options
                var options = {'title': 'Incidents',
                    'width': 800,
                    'height': 500};

                // Instantiate and draw our chart, passing in some options.
                var chart = new google.visualization.PieChart(document.getElementById('chart_div'));
                chart.draw(data, options);
            }

        </script>
    </head>
    <body>
        <!-- Include the following page for Navbar and Global Style Imports -->
        <jsp:include page="components/navbar.jsp" />
        <!-- Card for Demo Purposes, feel free to copy for pages -->
        <div class="row">
            <div class="col-md-2 col-sm-0"></div>
            <div class="col-md-8 col-sm-12">
                <div class="card" style="margin-top:2rem;">
                    <h1 class="card-header">Analytics</h1>
                    <div class="card-body">
                        <h5 class="card-title">Incident Types</h5>
                        <div id="chart_div"></div>
                        <br>
                        <h5 class="card-title">Incident Map</h5>
                        <div id="map"></div>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://unpkg.com/@mapbox/mapbox-sdk/umd/mapbox-sdk.min.js"></script>

        <script>
            mapboxgl.accessToken = 'pk.eyJ1Ijoiam9zZXBoamRyZXciLCJhIjoiY2t0NDQwbzAyMG9wcTJ3cGdqdzFyNDFyZiJ9.UImioRYUuYdHqXu0oU3ibw';
            const mapboxClient = mapboxSdk({accessToken: mapboxgl.accessToken});
            const map = new mapboxgl.Map({
                container: 'map',
                style: 'mapbox://styles/mapbox/streets-v11',
                center: [151.209290, -33.868820],
                zoom: 9
            });

            // Create a default Marker and add it to the map.
            <c:forEach var="Venue" items="${VenueIncidentCount}">
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
            } else {
                new mapboxgl.Marker({color: 'red'})
                        .setLngLat([${Venue.key.lon}, ${Venue.key.lat}])
                        .setPopup(new mapboxgl.Popup({offset: 25})
                                .setHTML('<h5>${Venue.key.name}</h5><p>Number of incidents: ${Venue.value} </p>'))
                        .addTo(map);
            }

            </c:forEach>


        </script>
    </body>
</html>
