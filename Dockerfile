FROM openjdk:8-jre-alpine
COPY ./build/libs/api-0.0.1.jar /code/
WORKDIR /code
CMD ["/usr/bin/java", "-jar", "api-0.0.1.jar"]