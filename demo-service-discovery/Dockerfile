FROM openjdk:8-alpine
VOLUME /tmp
ADD target/spring-boot-microservices-service-discovery-0.0.1-SNAPSHOT.jar app.jar
RUN sh -c 'touch /app.jar'
EXPOSE 8761
ENTRYPOINT [ "sh", "-c", "java -Dspring-boot.run.profiles=ldev,docker -jar /app.jar" ]
