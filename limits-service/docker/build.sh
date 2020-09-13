#!/bin/bash
echo "Building image for limits service"
docker build -t amiura/limit-server ../.
echo "Finish building image"