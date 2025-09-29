FROM openjdk:latest
COPY ./target/app-runner.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "app-runner.jar"]