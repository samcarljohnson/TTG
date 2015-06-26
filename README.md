# TTG
TTG Web App

This web application was created and run in OSX v10.10.3, Eclipse Luna for Java EE v4.4.2, with my tomcat server setup properly. This is important to note because the way that eclipse runs tomcat7 is different than when simply running 'catalina start' from the command line, as the homebrew installation suggests. There is even a different webapps folder that these webapps are deployed from: tomcat7-->libexec-->wtwebapps

Pay attention to the details above and proceed...  

The easiest way to run this web application is to follow these steps:
1. Ensure that the tomcat7 server is configured properly before importing at all
2. Install the latest version of Eclipse and import the project.
3. Right click on one of the .html files within WebContent, and select 'Run as'-->'Run on server'
