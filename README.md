# 📦 Kafka with Spring Boot – Real-time Messaging App

This project is a practical implementation of **Apache Kafka** using **Spring Boot**, following a step-by-step tutorial that covers core Kafka concepts and builds a real-world app to consume and produce real-time stream data (e.g., from Wikimedia).

## 🧭 Table of Contents
- [Overview](#overview)
- [Kafka Concepts Covered](#kafka-concepts-covered)
- [Tech Stack](#tech-stack)
- [Getting Started](#getting-started)
- [Kafka Configuration](#kafka-configuration)
- [REST API](#rest-api)
- [Real-World Integration](#real-world-integration)
- [Resources](#resources)

## 🧠 Overview

You’ll learn to:
- Set up and run Kafka locally
- Create Kafka Topics
- Build Producers and Consumers in Spring Boot
- Work with JSON serialization/deserialization
- Ingest live data using WebClient and publish it to Kafka topics

## 📘 Kafka Concepts Covered

- What is a Message Broker
- Kafka Cluster, Brokers, Producers, Consumers
- Topics, Partitions & Offsets
- Consumer Groups
- JSON serialization/deserialization
- WebClient integration with Kafka (WebFlux)
- Real-world data streaming (Wikimedia)

## 🧰 Tech Stack

- Java 17+
- Spring Boot
- Apache Kafka
- Spring Kafka
- WebClient (WebFlux)
- Docker (optional)
- Wikimedia RecentChange Stream API

## 🚀 Getting Started

### 1. Install Kafka (KRaft Mode or Docker)

Follow official instructions for [Kafka KRaft mode](https://kafka.apache.org/documentation/#kraft).

```bash
# Format storage
bin/kafka-storage.sh format -t <uuid> -c config/kraft/server.properties

# Start Kafka
bin/kafka-server-start.sh config/kraft/server.properties
```

### 2. Clone the Project

```bash
git clone https://github.com/your-username/kafka-springboot-app.git
cd kafka-springboot-app
```

### 3. Run Spring Boot App

```bash
./mvnw spring-boot:run
```

## ⚙️ Kafka Configuration

Configure Kafka in `application.yml`:

```yaml
spring:
  kafka:
    bootstrap-servers: localhost:9092
    consumer:
      group-id: myGroup
      auto-offset-reset: earliest
    producer:
      key-serializer: org.apache.kafka.common.serialization.StringSerializer
      value-serializer: org.apache.kafka.common.serialization.StringSerializer
```

## 🧾 REST API

- `POST /api/messages`: Send a plain text or JSON message to Kafka.
- `GET /api/messages`: Fetch messages (if stored or forwarded downstream).

## 🌐 Real-World Integration

A dedicated service uses `WebClient` to stream real-time changes from the Wikimedia API and publishes each change as a Kafka message. The consumer then listens and logs or processes that stream.

## 📚 Resources

- 🎥 YouTube Tutorial: [Kafka + Spring Boot | Full Course](https://www.youtube.com/watch?v=KQDTtvZMS9c)
- 📄 [Apache Kafka Documentation](https://kafka.apache.org/documentation/)
- 💡 [Spring Kafka Docs](https://spring.io/projects/spring-kafka)

---

Made with ❤️ while learning Kafka and real-time data pipelines.
