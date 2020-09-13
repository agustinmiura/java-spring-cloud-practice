#!/bin/bash
echo "Running docker image"
./build.sh
docker run -p 8080:8080 amiura/limit-server