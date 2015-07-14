# TTG
TTG Web App

This web application was created and run in OSX v10.10.3, Eclipse Luna for Java EE v4.4.2, with my tomcat server setup properly. This is important to note because the way that eclipse runs tomcat7 is different than when simply running 'catalina start' from the command line, as the homebrew installation suggests. There is even a different webapps folder that these webapps are deployed from: tomcat7-->libexec-->wtwebapps

Pay attention to the details above and proceed...  

The easiest way to run this web application is to follow these steps:
1. Ensure that the tomcat7 server is configured properly before importing at all
2. Install the latest version of Eclipse and import the project.
3. Right click on one of the .html files within WebContent, and select 'Run as'-->'Run on server'

7-1-15

Added a button to index.html - Tagged with and id that is used in the servlet
Added a button click listener to postForm.js - Used in index.html to intercept the button click and do RESTful stuff.
Added RouterServlet.java - Grabs the GET request from the client and makes the appropriate call to CategroyDAO.
Added CategoryDAO.java - Makes the SQL call to the stored procedure on the sugarcrm database and uses Gson to send the contents of the results back to the client (postForm.js).
Added SugarAccount.java - The java object class for the stored procedure results.

7-13-15
--Note to self-- Successfully migrated this proejct to the new machine.

