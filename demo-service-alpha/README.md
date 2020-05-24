# demo-spring-boot-dockerized
Demo repository to create a simple Spring Boot Docker Image and run it as container


## Getting started

### Dev environment setup
* Use IntelliJ or Eclipse as IDE
* As standalone editor VSCode is recommended (especially for Kubernetes or Docker)
* Ensure Docker is installed
    * If Windows is used, the usage of a Linux VM is highly recommended (OracleVM, Vagrant)
* Ensure Maven is installed and points to the right JRE
    * Otherwise you may use given Maven executable (./mvnw)
* Additional tooling
    * OpenJDK 11+
    * DBeaver for Database access
    * Postman for REST CRUD operations against APIs

### Run the application
#### Manually
1. Start Postgres DB container by executing `./start-postgreSQL.sh`
2. Start the application in Spring profile `ldev`
    * either by IDE 
    * with Maven (`mvn springboot:run`)
    * or by CLI `java -jar target/spring-boot-microservices-service-0.0.1-SNAPSHOT.jar`
#### Docker compose 
1. Run `./docker-run.sh` to create an base image of the application
2. Run `docker-compose up`

#### Hint 
* Make sure to give your shell scripts execution rights: `` chmod +x``
* In bash you stop a script by pressing `CTRL+C`
* run `./docker-logs.sh` in a new terminal to see server logs
* A nice tutorial can be found here: https://medium.com/@isurunuwanthilaka/docker-zero-to-hero-with-springboot-postgres-e0b8c3a4dccb
