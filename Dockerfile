FROM openjdk:11
MAINTAINER hienkwan
COPY target/spring-boot-pizza.jar spring-boot-pizza.jar
ENTRYPOINT ["java","-jar","spring-boot-pizza.jar"]