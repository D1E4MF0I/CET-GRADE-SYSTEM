# Use the official Maven image to build the app with JDK 17
FROM maven:3.8.3-openjdk-17 AS build

# Set the working directory in the container
WORKDIR /app

# Copy the pom.xml and source code into the container
COPY pom.xml .
COPY src ./src

# Package the application as a WAR file
RUN mvn clean package -DskipTests

# Use the official Tomcat image to run the app
FROM tomcat:9.0-jdk17-openjdk-slim

# Set the working directory in the container
WORKDIR /usr/local/tomcat/webapps/

# Copy the packaged WAR file from the build stage
COPY --from=build /app/target/CET-GRADE-SYSTEM-0.0.1-SNAPSHOT.war ./CET-GRADE-SYSTEM-0.0.1-SNAPSHOT.war

# Expose the port the application runs on
EXPOSE 80

# Tomcat uses the default entry point
