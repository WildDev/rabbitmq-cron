FROM maven:3.9.4-eclipse-temurin-20

MAINTAINER https://github.com/WildDev

COPY . /
RUN --mount=type=cache,target=$MAVEN_CONFIG mvn clean package

FROM eclipse-temurin:20-jre

ENV JAVA_OPTS=-Xmx256M
ENV RABBIT_HOST=rabbitmq
ENV RABBIT_USER=guest
ENV RABBIT_PASS=guest
ENV RABBIT_PORT=5672
ENV SERVER_PORT=8080

COPY --from=0 /target/rabbitmq-cron.jar /

ENTRYPOINT java -jar $JAVA_OPTS /rabbitmq-cron.jar \
 --server.port=$SERVER_PORT \
 --spring.rabbitmq.host=$RABBIT_HOST \
 --spring.rabbitmq.port=$RABBIT_PORT \
 --spring.rabbitmq.username=$RABBIT_USER \
 --spring.rabbitmq.password=$RABBIT_PASS
