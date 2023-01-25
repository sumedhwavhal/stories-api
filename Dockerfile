FROM openjdk:17-jdk-alpine
COPY target/storiesapi-0.0.1-SNAPSHOT.jar storiesapi-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/storiesapi-0.0.1-SNAPSHOT.jar"]