# Spring Cloud practice
 
  Spring Cloud practice .
  
### Config server

 * ```mkdir -p $HOME/config-repo```
 * Execute ```git init```
 * Inside the folder git-localconfig-repo copy the content inside the folder ```$HOME/config-repo```
 * Commit the config files
 * Inside the config-server execute the command ```mvn clean spring-boot:run```
 * The config server is running on port 8888
 * Go to the url ```localhost:8888/limits-service/default``` to see the config  from the Git repository
 
### Limits service

 * Inside the folder limits-service 
 * Run the command : ```mvn clean spring-boot:run```
 * Go to the url : ```localhost:8080/limits```
 * You will see the config from the Git repository


