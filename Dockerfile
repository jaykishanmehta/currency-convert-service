FROM maven:3-openjdk-8-slim as builder
WORKDIR /usr/currency-convert-service
COPY . .
RUN mvn clean install -Dmaven.test.skip
FROM openjdk:8-jre-alpine
WORKDIR /usr/currency-convert-service
COPY --from=builder /usr/currency-convert-service/target/currency-convert-service-1.0-SNAPSHOT.jar .
CMD [ "java", "-jar", "currency-convert-service-1.0-SNAPSHOT.jar" ]
EXPOSE 8080
