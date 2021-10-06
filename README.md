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
Joseph Drew (13212206): 
  Model: Offender.java, Warning.java, Venue.java (Not Complete)
  View: index.jsp, analytics.jsp, issuewarning.jsp, components/imports.jsp, components/navbar.jsp, success.jsp, error.jsp, democard.jsp
  Controller: IssueWaringServlet.java, EmailServlet.java, AnalyticsServlet.java
  Model.DAO: DBManager.java
  Test Packages: Model: WarningTest.java
  Assigned Features: Issue Warning, Graphical Report Generation (Analytics)
