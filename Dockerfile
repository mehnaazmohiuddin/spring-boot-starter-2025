#Just tells how to run the code actually. whatever we would do to run our code in our terminal
# Dockerfile
FROM openjdk:21
COPY target/spring-boot-0.0.1-SNAPSHOT.jar app.jar
ENV SECRET_KEY=mehnaaz123
ENTRYPOINT ["java", "-jar", "/app.jar"]