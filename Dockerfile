FROM openjdk:17
ADD target/cinema-api-docker.jar cinema-api-docker.jar
ENTRYPOINT ["java", "-jar","cinema-api-docker.jar"]
EXPOSE 8080