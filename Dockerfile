# Use the latest stable Java 21 LTS from Eclipse Temurin
FROM eclipse-temurin:21-jdk

# Set working directory
WORKDIR /app

# Copy the built JAR file into the container
COPY target/MultiPlayerTicTacToe-0.0.1-SNAPSHOT.jar app.jar

# Expose port 8080
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "app.jar"]
