FROM maven:3.9.5-eclipse-temurin-21 AS build
WORKDIR /app

# Copy and build project
COPY . .
RUN mvn clean package -DskipTests

# Production stage
FROM eclipse-temurin:21-jdk
WORKDIR /app

COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
