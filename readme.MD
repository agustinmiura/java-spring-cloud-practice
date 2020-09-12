# Spring Cloud practice

Spring Cloud practice .

### Setup

- Install Java Jdk version 11 .
- Install Docker .
- Setup the database for the currency service.

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
