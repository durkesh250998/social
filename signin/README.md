# Spring Boot Kafka Quickstart

This project demonstrates how to use Apache Kafka with Spring Boot for sending and receiving user email messages.

## Prerequisites
- Java 17 or higher
- Maven
- [Download Apache Kafka](https://kafka.apache.org/downloads)

## Kafka Setup (macOS/Linux)

```sh
# Download and extract Kafka
wget https://downloads.apache.org/kafka/3.6.1/kafka_2.13-3.6.1.tgz
tar -xzf kafka_2.13-3.6.1.tgz
cd kafka_2.13-3.6.1

# Start Zookeeper (in a new terminal)
bin/zookeeper-server-start.sh config/zookeeper.properties

# Start Kafka broker (in a new terminal)
bin/kafka-server-start.sh config/server.properties

# Create the topic
bin/kafka-topics.sh --create \
  --topic user-email-topic \
  --bootstrap-server localhost:9092 \
  --partitions 1 \
  --replication-factor 1

# List topics
bin/kafka-topics.sh --list --bootstrap-server localhost:9092
```

## Spring Boot Application

- Configure Kafka properties in `src/main/resources/application.properties`.
- The topic name should match `user-email-topic`.
- Use the provided producer and consumer services to send and receive messages.

## Running the App

```sh
./mvnw spring-boot:run
```

## Useful Links
- [Apache Kafka Documentation](https://kafka.apache.org/documentation/)
- [Spring for Apache Kafka](https://docs.spring.io/spring-kafka/docs/current/reference/html/)