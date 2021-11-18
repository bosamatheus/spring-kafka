# Spring Kafka Producer

- Build the application using Gradle:

```shell
./gradlew clean build
```

- Then run Docker commands to build the image and run the application:

```shell
docker build -t spring-kafka/producer .
docker run -p 8080:8080 spring-kafka/producer
```
