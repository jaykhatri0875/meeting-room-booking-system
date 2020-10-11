# Meetopia (Meeting Room Booking System):

## Project Features

1. Database is hosted at `db4free.net` for testing. However you can use your local MySQL database
2. Queries for database schema initialization are contained in the `application`
3. Allows easy management among admin, manager and member for performing room booking
4. Servlets are connected to JSP files to act as a controller
5. All jar files are available in `application`


## Branch Rules

1. `master`- Available for production
2. `develop` - Still in development phase
3. Rest all the 8 branches belong to individual contributors connected to `develop`


## To Run the Project

1. git clone REMOTE_URL "https://github.com/jaykhatri0875/meeting-room-booking-system"
2. Open Eclipse/STS and select any workspace
3. After the workspace is open, select `File` -> `New` -> `Dynamic Web Project`
4. Uncheck default location and browse to `application` inside the newly created folder (in Step 1)
5. Name the project -  "Meetopia" (To avoid any build issues)
6. Hit `Next` two times to move to the next page
7. Check on the `Create web.xml` and click on `Finish`
8. Import `tomcat-api.jar`,`json-simple-1.1.1.jar` via project build path
9. Import `mysql-connector-java-8.0.11.jar` similarly if connecting to RemoteDB
10. Run the project


## Troubleshoot Hints

1. Clean and build the project
2. Clean the server published resources
3. Run the project via `Run As` -> `Run on Server`
