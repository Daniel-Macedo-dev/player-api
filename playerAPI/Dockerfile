FROM openjdk:24-jdk
WORKDIR /app
COPY target/playerAPI-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
EXPOSE 8081
