# ASD-IncidentReportingSystem RUNS ON NETBEANS 12 AND UP
## Install instructions
1. Clone repo to local drive
2. Open cloned repo as project in Netbeans
3. Create JavaDB with the following details;
  - DB URL: jdbc:derby://localhost:1527/
  - DB Name: incidentrs
  - DB User: incidentrs
  - DB Password: password123
  - DB Driver: org.apache.derby.jdbc.ClientDriver
4. Execute "createAllTables.sql" and "populateTables.sql" from /web/SQL/ on JavaDB instance above
5. Set target server as Glassfish (4.1.2 or greater), ensure JDK 8 is present.
6. Click "Clean and Build" before running

