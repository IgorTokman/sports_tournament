FROM openjdk:8
ADD target/springboot-docker-compose.jar springboot-docker-compose.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","springboot-docker-compose.jar"]