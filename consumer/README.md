# Spring Kafka Consumer

- Build the application using Gradle:

```shell
./gradlew clean build
```

- Then run Docker commands to build the image and run the application:

```shell
docker build -t spring-kafka/consumer .
docker run -p 8081:8081 spring-kafka/consumer
```
