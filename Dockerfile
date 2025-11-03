# Use OpenJDK 17 base image
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy everything
COPY . .

# Build the app
RUN ./gradlew build -x test

# Run the app
CMD ["java", "-jar", "build/libs/candidatestats-0.0.1-SNAPSHOT.jar"]
