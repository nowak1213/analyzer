FROM openjdk:8-jre-alpine
ADD target/analyzer-0.0.1-SNAPSHOT.jar analyzer-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "analyzer-0.0.1-SNAPSHOT.jar"]
