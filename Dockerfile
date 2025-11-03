# ==============================
# Stage 1: Build the application
# ==============================
FROM eclipse-temurin:21-jdk AS builder

# Set the working directory
WORKDIR /app

# Copy Gradle files first for caching
COPY gradlew .
COPY gradle gradle
COPY build.gradle settings.gradle ./

# Make gradlew executable
RUN chmod +x gradlew

# Download dependencies
RUN ./gradlew dependencies --no-daemon || true

# Copy application source
COPY src src

# Build the application
RUN ./gradlew bootJar --no-daemon

# ==============================
# Stage 2: Run the application
# ==============================
FROM eclipse-temurin:21-jre

# Working directory
WORKDIR /app

# Copy jar from builder stage
COPY --from=builder /app/build/libs/*.jar app.jar

# Expose port 8080
EXPOSE 8080

# Run the app
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
