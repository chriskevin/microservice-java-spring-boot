# Java Spring Boot Microservice Test Project ![GitHub](https://img.shields.io/github/license/chriskevin/microservice-java-spring-boot.svg)
Microservice implemented in Java using Spring Boot. Mainly for exploratory learning.

## Project Health
[![Build Status](https://travis-ci.org/chriskevin/microservice-java-spring-boot.svg?branch=master)](https://travis-ci.org/chriskevin/microservice-java-spring-boot)
[![Maintainability](https://api.codeclimate.com/v1/badges/34f7730463dcead87cd3/maintainability)](https://codeclimate.com/github/chriskevin/microservice-java-spring-boot/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/34f7730463dcead87cd3/test_coverage)](https://codeclimate.com/github/chriskevin/microservice-java-spring-boot/test_coverage)
[![codecov](https://codecov.io/gh/chriskevin/microservice-java-spring-boot/branch/master/graph/badge.svg)](https://codecov.io/gh/chriskevin/microservice-java-spring-boot)
[![Known Vulnerabilities](https://snyk.io/test/github/chriskevin/microservice-java-spring-boot/badge.svg)](https://snyk.io/test/github/chriskevin/microservice-java-spring-boot)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=se.chriskevin.se%3Amicroservice-spring-boot&metric=alert_status)](https://sonarcloud.io/dashboard?id=se.chriskevin.se%3Amicroservice-spring-boot)
[![codebeat badge](https://codebeat.co/badges/61875621-3862-49ad-8477-401920053202)](https://codebeat.co/projects/github-com-chriskevin-microservice-java-spring-boot-master)

---

## System Requirements
Java 11 is required to build the project, [JDK 11](https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html). You also need to have the [IntelliJ Lombok Plugin](https://plugins.jetbrains.com/plugin/6317-lombok-plugin) or [Setup Eclipse](https://projectlombok.org/setup/eclipse) for annotation preprocessing.

Note: Remember to check that your IDE is using language level 11 as well (Project and Modules).

## Useful Commands
* Run unit tests `mvn test`
* Run integration tests `mvn verify`
* Run mutation tests `mvn pitest:mutationCoverage`
* Format code `mvn spotless:apply`
* Start microservice `mvn spring-boot:run`

Note: Maven wrapper is included in project so all mvn commands can be called using `./mvnw` instead.

## Docker
The Maven build lifecyle creates a Docker image with the service by utilizing [dockerfile-maven-plugin](https://github.com/spotify/dockerfile-maven).

* Build image `mvn package` or `mvn dockerfile:build`
* Run service in container `docker run -p 8080:8080 -t chrisxkevin/microservice-java-spring-boot`