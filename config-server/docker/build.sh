#!/bin/bash
echo "Building image for limits service"
docker build -t amiura/config-server ../.
echo "Finish building image"