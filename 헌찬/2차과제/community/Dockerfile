# Base image with OpenJDK 17
FROM openjdk:17-jdk-slim

# Copy the JAR file into the container
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar

# Expose the application port
EXPOSE 8081

# Run the application
ENTRYPOINT ["java", "-jar", "/app.jar"]
