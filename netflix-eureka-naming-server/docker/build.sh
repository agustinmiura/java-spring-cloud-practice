#!/bin/bash
echo "Building image for limits service"
../mvn clean install -DskipTests
docker build -t amiura/naming-server ../.
echo "Finish building image"