FROM maven:3.9-eclipse-temurin-21 AS dev
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
CMD ["mvn", "spring-boot:run", "-Dspring-boot.run.fork=false"]