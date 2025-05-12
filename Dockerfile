FROM tomcat:8-jre11

COPY target/*.war /usr/local/tomcat/webapps/ROOT.war

EXPOSE 8080
