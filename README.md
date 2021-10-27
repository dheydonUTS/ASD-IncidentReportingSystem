# ASD-IncidentReportingSystem RUNS ON NETBEANS 12 AND UP

## Install instructions
1. Clone repo to local drive
2. Open cloned repo as project in Netbeans IDE
3. Create JavaDB with the following details;
  - DB URL: jdbc:derby://localhost:1527/
  - DB Name: incidentrs
  - DB User: incidentrs
  - DB Password: password123
  - DB Driver: org.apache.derby.jdbc.ClientDriver
4. Execute "createAllTables.sql" and "populateTables.sql" from /web/SQL/ on JavaDB instance above
5. Set target server as Glassfish (4.1.2 or greater), ensure JDK 8 is present.
6. Click "Clean and Build" before running

## Usage instructions
1. Click the 'play' button in Netbeans to run the porject and start glassfish server
2. Wait for your browser to open the project alternatively navigate to (http://localhost:8080/ASD-IncidentReportingSystem/) or whatever port is set in your glassfish server
3. Login to navigate the site fully

## Contributions
### Dominic Heydon (13270071):
  * Model: Incident.java, User.java, Offender.java
  * View: Incident.jsp, Ticket.jsp, Login.jsp, ViewIncident.jsp, EditIncident.jsp, components/navbar.jsp
  * Controller: IncidentServlet, AllocateTicket, LoginServlet,Validator
  * Model.DAO: DBManager.java
  * TestPackages: validatorTest.java, allocateTicketTest.java, IncidentTest.java,UserTest.java
  * SQL: Create & Populate Scripts
  * Assigned Features: Incident Record Creation, Ticket Creation and Staff Ticket allocation

### Joseph Drew (13212206): 
  * Model: Offender.java, Warning.java, Venue.java (Not Complete)
  * View: index.jsp, analytics.jsp, issuewarning.jsp, components/imports.jsp, components/navbar.jsp, success.jsp, error.jsp, democard.jsp
  * Controller: IssueWaringServlet.java, EmailServlet.java, AnalyticsServlet.java
  * Model.DAO: DBManager.java
  * Test Packages: Model: WarningTest.java
  * Assigned Features: Issue Warning, Graphs Reports and Analytics

### Arun Mohindra (13538208):
  * View: Login.jsp, Register.jsp, AnonReport.jsp, Logout.jsp, Account.jsp, components/navbar.jsp
  * Controller: AnonIncidentServlet.java, LoginServlet.java, RegisterServlet.java, editAccountServlet.java
  * Model.DAO: DBManager.java
  * TestPackages: RegisterServletTest.java
  * SQL: Populate Script
  * Assigned Features: User Access Management, Anonymous Reporting

### Christian Lopez(13252794):
  * View: addVenue.jsp editVenue.jsp manageVenues.jsp offenderDashboard.jsp offender.jsp components/navbar.jsp
  * Controller: Validator.java, addVenueServlet, deleteVenueServlet, listVenueServlet, listOffenderServlet, updateVenueServlet
  * Model.DAO: DBManager.java
  * TestPackages: OffenderTest.java
  * SQL: Populate Script
  * Assigned Features: Offender Dashboard, Manage Venues

### Zwe Htin Aung (13485673):
  * Model: Incident.java, User.java, Offender.java, Venue.java
  * View:  components/navbar.jsp
  * Controller: IncidentServlet, AllocateTicket, LoginServlet,Validator
  * Model.DAO: DBManager.java, DBConnector.java, DB.jaca
  * SQL: Create & Populate & Delete Scripts
  * Assigned Features: Incident report Generation, Venue Report generation

### Adam McCaffery (12946265):
  * Model: Offender.java
  * View:  components/navbar.jsp, ViewIncidentsAndTickets.jsp, genReports.jsp.
  * Controller: MyIncidentsServlet, IncidentsLocationReportServlet, GeneralReportsServlet
  * Model.DAO: DBManager.java
  * Assigned Features: General Report Generation, My Tickets and Incidents
