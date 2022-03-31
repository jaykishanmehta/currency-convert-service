FROM maven:3-jdk-11-slim as builder
MAINTAINER Jaykishan Mehta <jaykishanmehta1991@gmail.com>
WORKDIR /usr/currency-convert-service
COPY . .
RUN mvn clean install -Dmaven.test.skip
FROM openjdk:11.0.14.1-jre
WORKDIR /usr/currency-convert-service
COPY --from=builder /usr/currency-convert-service/target/currency-convert-service-0.0.1-SNAPSHOT.jar .
CMD [ "java", "-Dspring.profiles.active=prod", "-jar", "currency-convert-service-0.0.1-SNAPSHOT.jar" ]
EXPOSE 8080
