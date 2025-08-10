Last update: 8/9/2025
# Spring Boot Kafka Demo

This project demonstrates the integration of Apache Kafka with a Spring Boot application. It includes both producer and consumer implementations, showcasing how to send and receive messages using Kafka.

## Prerequisites

- Java 11 or higher
- Maven
- Docker
- Docker Compose
- **Docker Desktop** (or an equivalent Docker runtime)

## Project Structure

- `KafkaDemoApplication.java`: The main Spring Boot application class
- `KafkaConfig.java`: Configuration class for Kafka producers and consumers
- `MessageProducer.java`: Service class for sending messages to Kafka topics
- `MessageConsumer.java`: Service class for consuming messages from Kafka topics
- `MessageController.java`: REST controller for sending messages via HTTP endpoints
- `Dockerfile`: Defines how to build the Spring Boot application container
- `docker-compose.yml`: Defines the multi-container setup for Kafka, Zookeeper, and the application

## Setting up Kafka

To run Kafka locally, use the `docker-compose.yml` file in the project root. It defines the following services:

- **Zookeeper**: Manages Kafka cluster metadata and coordination.
- **Kafka**: The message broker for producing and consuming messages.

```yaml
version: '3'
services:
  zookeeper:
    image: confluentinc/cp-zookeeper:latest
    environment:
      ZOOKEEPER_CLIENT_PORT: 2181
      ZOOKEEPER_TICK_TIME: 2000
    ports:
      - "2181:2181"

  kafka:
    image: confluentinc/cp-kafka:latest
    depends_on:
      - zookeeper
    ports:
      - "9092:9092"
    environment:
      KAFKA_BROKER_ID: 1
      KAFKA_ZOOKEEPER_CONNECT: zookeeper:2181
      KAFKA_ADVERTISED_LISTENERS: PLAINTEXT://localhost:9092
      KAFKA_LISTENER_SECURITY_PROTOCOL_MAP: PLAINTEXT:PLAINTEXT
      KAFKA_INTER_BROKER_LISTENER_NAME: PLAINTEXT
      KAFKA_OFFSETS_TOPIC_REPLICATION_FACTOR: 1
```

## Running the Application

There are two ways to run this application:

### Option 1: Running everything in Docker (Recommended)

1. Build the application:
   ```bash
   mvn clean package
   ```

2. Start all services (Kafka, Zookeeper, and Spring Boot app) using Docker Compose:
   ```bash
   docker-compose up -d
   ```

3. Check the application logs:
   ```bash
   docker-compose logs -f app
   ```

### Option 2: Running Spring Boot locally

1. Start Kafka using Docker Compose:
   ```bash
   docker-compose up -d zookeeper kafka
   ```

2. Build the application:
   ```bash
   mvn clean install
   ```

3. Run the application:
   ```bash
   mvn spring-boot:run
   ```

## Testing the Application

1. Send a message using cURL:
   ```bash
   curl -X POST -H "Content-Type: text/plain" -d "Hello Kafka!" http://localhost:8080/api/messages
   ```

2. Check the application logs to see the consumed message:
   ```
   Received message: Hello Kafka!
   ```

## How it Works

1. **Producer**: The `MessageProducer` class uses `KafkaTemplate` to send messages to a Kafka topic.
   - Messages can be sent via the REST endpoint in `MessageController`
   - The endpoint accepts POST requests with the message in the request body

2. **Consumer**: The `MessageConsumer` class uses the `@KafkaListener` annotation to consume messages.
   - It automatically listens to the specified topic ("demo-topic")
   - When a message is received, it's printed to the console

3. **Configuration**: The `KafkaConfig` class sets up:
   - Kafka producer and consumer factories
   - Topic creation
   - Serialization/deserialization configurations

## Important Configuration Properties

- Kafka broker: `localhost:9092`
- Consumer group: `demo-group`
- Topic: `demo-topic`
- Message format: String (both key and value)

## Notes

- The application creates a topic named "demo-topic" automatically on startup
- Messages are processed in the order they are received within each partition
- When running in Docker, the application connects to Kafka using the service name `kafka:9092`
- When running locally, the application connects to Kafka using `localhost:9092`
- The Docker setup includes:
  - Zookeeper container for Kafka cluster management
  - Kafka broker container for message handling
  - Spring Boot application container for the demo application
- The consumer group ensures that messages are distributed among multiple consumers if scaled
- The application uses String serialization for simplicity, but can be modified to use JSON or other formats
