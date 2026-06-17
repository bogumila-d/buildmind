# Webpage Service - Docker Setup Guide

This document explains how to start the webpage service within a Docker container.

## Prerequisites

Before you begin, ensure you have the following installed on your system:
- **Docker** (version 20.10 or higher)
- **Docker Compose** (version 1.29 or higher)
- **Git** (for cloning the repository)

## Project Structure


## Technology Stack

- **Framework**: Spring Boot 3.5.0
- **Language**: Kotlin 2.1.20
- **Java Version**: JDK 24
- **Build Tool**: Gradle
- **Server Port**: 8080

## Getting Started

### 1. Clone the Repository

```bash
git clone <repository-url>
cd webpage
### Start the Service
``` bash
docker-compose up --build
```
### Start in Detached Mode (Background)
``` bash
docker-compose up -d --build
```
### Stop the Service
``` bash
docker-compose down
```
### View Service Logs
``` bash
docker-compose logs -f webpage
```
### Rebuild the Image
``` bash
docker-compose build --no-cache
```
### Access the Container Shell
``` bash
docker exec -it webpage-service /bin/bash
```


## Building Locally (Without Docker)
If you want to build and run locally without Docker:
``` bash
# Build the project
./gradlew build

# Run the application
./gradlew bootRun
```

http://localhost:8080

## Troubleshooting
### Port Already in Use
If port 8080 is already in use, you can modify the port mapping in : `compose.yaml`
``` yaml
ports:
  - "8081:8080"  # Change 8081 to your desired port
```
### Docker Daemon Not Running
Ensure Docker is running on your system:
``` bash
docker ps
```
### Build Issues
Clear Docker cache and rebuild:
``` bash
docker-compose build --no-cache
docker-compose up
```
### View Detailed Logs
``` bash
docker-compose logs -f webpage
```

### Clean Build
``` bash
./gradlew clean
rm -rf build/
rm -rf .gradle/
./gradlew build
./gradlew clean build --refresh-dependencies
./gradlew dependencies --configuration compileClasspath
```

### Setup env vars
``` bash
./env.sh
```

## MongoDB Setup

MongoDB is automatically started as a service in Docker Compose. The connection details are:
- **Host**: mongodb-service (or localhost:27017 when running locally)
- **Database**: webpage_db
- **Username**: <username_placeholder>
- **Password**: <password_placeholder>

### Local MongoDB Connection
If running locally without Docker, ensure MongoDB is running on `localhost:27017`.



## Dependencies
The service includes the following key dependencies:
- Spring Boot Web Starter
- Jackson JSON processor with Kotlin support
- Kotlin reflection library
- JUnit 5 for testing

## Additional Resources
- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Docker Documentation](https://docs.docker.com/)
- [Kotlin Documentation](https://kotlinlang.org/docs/home.html)


http://localhost:8080

