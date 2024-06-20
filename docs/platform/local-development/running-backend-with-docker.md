
# Running the Back-end with docker

There are different solutions to run the **back-end**. 
You can run the backend with maven and start it with `.mvnw quarkus:dev`. 

It is also possible to run the backend with docker. 
Use the .env.example to create a .env file with the credentials that are required to run the backend.

## Running backend with local build image

Build a docker image with the docker file src/main/docker/Dockerfile.jvm in this project.
Follow the instructions in this file to build the docker image.
Start the backend with this docker image with the command : 
```
docker-compose -f docker-compose-local.yml up -d
```

To stop the back-end run the command 
```
docker-compose -f docker-compose-local.yml down
```


## running backend with ghcr.io image

Instead of building a local docker image it is also possible to run the back-end with a docker image from ghcr.io. This image is build  by the workflow of the back-end repository in GitHb.

Create a GitHub token with scopes of *write:packages* and *delete:packages*.
Login with your GitHub account and the created token with the command 
```
docker login ghcr.io -u <gitHubUsername> -p <gitHubAccessToken>
``` 

Start the back-end with 
```
docker-compose -f docker-compose-ghcr.yml up -d
```
To stop the back-end run the command 
```
docker-compose -f docker-compose-ghcr.yml down
```


Look for the available tags at [ghcr.io/devoxx4kids-NP/littil-backend](https://ghcr.io/devoxx4kids-NPO/littil-backend)
