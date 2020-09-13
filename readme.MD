# Spring Cloud practice

Spring Cloud practice .

### Setup

- Install Java Jdk version 11 .
- Install Docker .
- Setup the database for the currency service.
- Start the Configuration server.
- Start the Eureka server.
- Start the Exchange service .
- Start the Conversion service .

### Config server

- `mkdir -p $HOME/config-repo`
- Execute `git init`
- Inside the folder git-localconfig-repo copy the content inside the folder `$HOME/config-repo`
- Commit the config files
- Inside the config-server execute the command `mvn clean spring-boot:run`
- The config server is running on port 8888
- Go to the url `localhost:8888/limits-service/default` to see the config from the Git repository

### Limits service

- Inside the folder limits-service
- Run the command : `mvn clean spring-boot:run`
- Go to the url : `localhost:8080/limits`
- You will see the config from the Git repository

### Currency Service

- Uses a H2 sql in memory database

- Inside the folder currency-service run the command : `mvn clean spring-boot:run`
- Use the command : curl `http://localhost:8000/currency-exchange/from/USD/to/INR`
- To run the instance on a different server run the command with : `-Dserver.port=8001`
- Access the h2 database manager in the url `http://localhost:8000/h2-console/`

### Currency Exchange Service :

- Calls the currency service to get the results .
- Use the command : curl `http://localhost:8100/currency-converter/from/USD/to/INR/quantity/1000`

## Eureka Naming Server

- Eureka Naming Server that runs .
- Run the command : `cd netflix-eureka-naming-server && mvn clean spring-boot:run`
- Access the url : `http://localhost:8761/`

## Netflix Zuul Server

Netflix Zuul Api Gateway

- Run the command : `cd netflix-zuul-api-gateway-server && mvn clean spring-boot:run`
- Access the url `http://localhost:8000/currency-exchange/from/EUR/to/INR` to query the exchange service .
- Access the url `http://localhost:8765/currency-exchange-service/currency-exchange/from/EUR/to/INR` to query the service using the Api Gateway.
- Access the url `http://localhost:8100/currency-converter-feign/from/USD/to/INR/quantity/1000`
- Access to the currency conversion service using Zuul `http://localhost:8765/currency-conversion-service/currency-converter-feign/from/USD/to/INR/quantity/100`

## Rabbit MQ and Zipkin

- Inside the docker folder execute the command : `docker-compose up`
- To shudown execute : `docker-compose down`
- Check the url : `http://localhost:15672/#/` with credentials `guest:guest`
- Check the url : `http://localhost:9411/zipkin/`

## Order to run everything with Zipkin

- Run `cd docker/service && docker-compose up` to start the Rabbit MQ server.
- Run `cd docker/zipkin && docker-compose up` to start the Zipkin Server .
- Run the following microservices in order :
  - NetflixEurekaNamingServerApplication
  - Currency exchange.
  - Currency conversion.
  - Netflix Zulu Gateway.
- Query the microservice `http://localhost:8100/currency-converter-feign/from/EUR/to/INR/quantity/100`
- Check the logs on Zipkin

## Spring Cloud Bus

- Start the RabbitMq Docker .- Run `cd docker/service && docker-compose up` to start the Rabbit MQ server.
- Run `cd docker/service && docker-compose up` to start the Rabbit MQ server.
- Update the `application.properties` in :
  - Configuration server .
  - Limits service .
- Endpoint to refresh all the configurations : `curl -X POST http://localhost:8080/actuator/bus-refresh`
