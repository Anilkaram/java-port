FROM tomcat:8-jre11
COPY tomcat-users.xml /usr/local/tomcat/conf/
COPY target/portfolio-website.war /usr/local/tomcat/webapps/myapp.war

EXPOSE 8080
