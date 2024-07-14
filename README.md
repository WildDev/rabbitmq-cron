### Description

RabbitMQ based cron events emitter service. It is not supposed to be scalable,
so you need to run only one auto-restart replica. Well-suited for small and medium-sized apps.

[![Java CI with Maven](https://github.com/WildDev/rabbitmq-cron/actions/workflows/maven.yml/badge.svg)](https://github.com/WildDev/rabbitmq-cron/actions/workflows/maven.yml) [![Docker Image CI](https://github.com/WildDev/rabbitmq-cron/actions/workflows/docker-image.yml/badge.svg)](https://github.com/WildDev/rabbitmq-cron/actions/workflows/docker-image.yml)

### How it works

1. Build & Run
2. Fork it by creation of any queue
3. Bind it to `scheduler` exchange with a predefined routing key (e.g. `minute` or `second`)

Sample `new-items-poll-tick-queue` configuration:

```
rabbitmqadmin declare queue name=new-items-poll-tick-queue durable=false
rabbitmqadmin declare binding source=scheduler destination_type=queue destination=new-items-poll-tick-queue routing_key=minute
```

An example message to be emitted:

```
Exchange 	scheduler
Routing Key 	second
...
headers:	
content_encoding:	UTF-8
content_type:	application/json
...
Payload
Encoding: string

{"timestamp":"2024-09-24 10:00:00"}
```

### Get started

Build requirements:
* latest JDK and Maven

Runtime stack:
* Java 20
* RabbitMQ 4

Checkout the project and build it using `mvn package` command

An example run:

```cmd
java -jar -Xmx256M target/rabbitmq-cron.jar \
    --server.port=8000 \
    --spring.rabbitmq.host=rabbitmq \
    --spring.rabbitmq.port=5671 \
    --spring.rabbitmq.username=guest \
    --spring.rabbitmq.password=guest
```

Also available on [Docker Hub](https://hub.docker.com/r/wilddev/rabbitmq-cron)
