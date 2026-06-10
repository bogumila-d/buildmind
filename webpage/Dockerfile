FROM gradle:8.14-jdk24 AS build

WORKDIR /app

COPY settings.gradle.kts build.gradle.kts ./
COPY src ./src

RUN gradle clean bootJar --no-daemon

FROM eclipse-temurin:24-jre

WORKDIR /app

COPY --from=build /app/build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
