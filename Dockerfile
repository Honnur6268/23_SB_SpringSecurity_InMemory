FROM openjdk:17
MAINTAINER Honnur
COPY  target/SpringSecurityApplication.jar  /usr/app/
WORKDIR /usr/app
EXPOSE 8080
ENTRYPOINT [“java”, “-jar”,”SpringSecurityApplication.jar”]
