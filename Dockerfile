FROM openjdk:8
ADD target/sport-tournament.jar sport-tournament.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","sport-tournament.jar"]