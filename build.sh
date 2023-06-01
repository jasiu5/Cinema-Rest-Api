#!/bin/bash
mvn install -DskipTests

docker build -t cinema-api-docker.jar .

docker-compose up -d