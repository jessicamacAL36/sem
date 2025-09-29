FROM openjdk:latest
COPY ./target/app-runner.jar /tmp  <-- UPDATED NAME
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "app-runner.jar"]  <-- UPDATED NAME