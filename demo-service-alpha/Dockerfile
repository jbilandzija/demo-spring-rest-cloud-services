FROM openjdk:8-alpine
VOLUME /tmp
ADD target/spring-boot-microservices-service-0.0.1-SNAPSHOT.jar app.jar
RUN sh -c 'touch /app.jar'
EXPOSE 9088
ENTRYPOINT ["java","-Dspring.profiles.active=docker", "-jar", "/app.jar"]
