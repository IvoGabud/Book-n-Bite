FROM maven:3.9.9-eclipse-temurin-23-alpine AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean install

FROM openjdk:23-jdk
WORKDIR /app
COPY --from=build app/target/app-0.0.1-SNAPSHOT.jar ./booknbite.jar
EXPOSE 8080
CMD ["java", "-jar", "booknbite.jar"]