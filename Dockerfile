#
# Build stage
#
FROM maven:3.8.6-openjdk-18 AS build
COPY src /cinema_base/src
COPY pom.xml /cinema_base
RUN mvn -f /cinema_base/pom.xml clean package

#
# Package stage
#
FROM amazoncorretto:18-alpine3.14
ARG JAR_FILE
COPY --from=build /cinema_base/target/cinema_base.jar /usr/local/lib/cinema_base.jar
EXPOSE 5557
ENTRYPOINT ["java","-jar","/usr/local/lib/cinema_base.jar"]