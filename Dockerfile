# Use Maven to build the application
FROM maven:3.9.8-amazoncorretto-17-al2023 AS build
WORKDIR /app
COPY PanipuriParadiseProject/pom.xml .
COPY PanipuriParadiseProject/src ./src
RUN mvn clean package -DskipTests

# Use OpenJDK to run the application
FROM openjdk:17-slim-buster
WORKDIR /app
COPY --from=build /app/target/PanipuriParadiseProject-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
