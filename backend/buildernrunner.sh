#!/bin/bash

# Stop all running containers
docker stop $(docker ps -q)

# Remove all stopped containers
docker rm $(docker ps -a -q)

cd /home/miguel/Documents/uni/arep/AREP08/backend/post

sudo docker build -t post-service-img .

cd /home/miguel/Documents/uni/arep/AREP08/backend/posts

sudo docker build -t posts-service-img .

sudo docker run -d -p 27017:27017 -v mongodb:/data/db -v mongodb_config:/data/configdb --name postsdb --network my_network mongo:3.6.1 mongod

sudo docker run -d -p 8080:8080 --name post-service --network my_network post-service-img

sudo docker run -d -p 8081:8080 --name posts-service --network my_network posts-service-img