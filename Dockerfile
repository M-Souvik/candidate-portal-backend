# ==========================
# Stage 1: Build the application
# ==========================
FROM eclipse-temurin:21-jdk AS builder

# Set working directory inside container
WORKDIR /app

# Copy Gradle wrapper and build configuration files
COPY gradlew .
COPY gradle gradle
COPY build.gradle settings.gradle ./

# Give execute permissions to gradlew
RUN chmod +x gradlew

# Download Gradle dependencies (for caching)
RUN ./gradlew dependencies --no-daemon || true

# Copy the application source code
COPY src src

# Build the Spring Boot JAR file
RUN ./gradlew bootJar --no-daemon

# ==========================
# Stage 2: Run the application
# ==========================
FROM eclipse-temurin:21-jre

# Set working directory
WORKDIR /app

# Copy the built JAR file from the builder stage
COPY --from=builder /app/build/libs/*.jar app.jar

# Expose the default Spring Boot port
EXPOSE 8080

# Run the Spring Boot JAR
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
