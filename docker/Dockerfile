FROM adoptopenjdk:11-jre-hotspot
MAINTAINER Jaykishan Mehta <jaykishanmehta1991@gmail.com>

ARG JAR_FILE=*.jar
COPY ${JAR_FILE} application.jar

ENTRYPOINT ["java", "-jar", "application.jar"]
EXPOSE 8080