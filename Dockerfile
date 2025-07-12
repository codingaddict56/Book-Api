# Step 1: Use OpenJDK base image
FROM openjdk:17-jdk-slim

# Step 2: Set a working directory inside the container
WORKDIR /app

# Step 3: Copy your jar file into the container
COPY target/my-app.jar app.jar
# Replace "my-app.jar" with your actual jar name

# Step 4: Expose the port
EXPOSE 8080

# Step 5: Start the Spring Boot application
ENTRYPOINT ["java", "-jar", "target/book-api-0.0.1-SNAPSHOT.jar app.jar"]
