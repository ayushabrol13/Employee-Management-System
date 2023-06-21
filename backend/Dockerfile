FROM openjdk:17
ADD target/emp-repository.jar emp-repository.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "emp-repository.jar"]