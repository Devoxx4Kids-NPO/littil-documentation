# Setting up your local develop environment

If you want to contribute to the LITTIL website you need to set up a development environment. The website static environment based on [Angular.io](https://angular.io).

## Prerequisites

- NodeJS LTS >= 16
- NPM 8

### Nodejs

Nodejs is used to generate the static files via Angular. The LITTIL website is tested and build on the LTS version of NodeJS 16.
When installing NodeJS you will get an installation of NPM as well.

#### Windows & MacOS

To install NodeJS on Windows or MacOS you can simply download it from [the website](https://nodejs.org/en/).

#### Linux

The easiest way to install NodeJS is by using your package manager. For instructions on your distribution see [the website as well](https://nodejs.org/en/download/package-manager/)

### Installation

To run the Frontend locally, follow these steps:

1. Download the repository from [Github|https://github.com/Devoxx4Kids-NPO/littil-frontend]
1. Open the repository folder in your IDE ([VSCode download page|https://code.visualstudio.com/download])
1. Open a terminal and run:

```shell
$ npm install
```

1. To get the OpenAPI specs locally, run:

```shell
$ npm openapi
```

1. Now you are ready to start the application, run:

```shell
$ npm start
```

1. Read the `README.md` file for more information about the Frontend repository.

# Docker

The LITTIL website is a static site that can run on any HTTP webserver. In example, you can use Nginx to serve the static files.
If you want an image based on this project running in Nginx you can use the following guide:

## Prerequisites

- Docker

## Installation of Docker

#### MacOS & Windows

The easiest way to install docker on your Windows or MacOS machine is by installing docker-desktop. You can find the
installation files on [docker download page](https://www.docker.com/get-started).

#### Linux

Please see the following documentation on how to get Docker installed on your preferred Linux distribution:
[Official Docker Documentation](https://docs.docker.com/engine/install/#server)
locally on your machine.

## Building an image

This projects ships 2 docker files. The file `./src/docker/Dockerfile.build` can be used to build the project within
a container. This is ideal when you don't have NodeJS installed local on your device.

You can use `./src/docker/Dockerfile.host` if you already have build the project local on your device, and you
want to create an image with this build.

Use the following command in the root of the project to start building an image and tag it. Feel free to choose a tag of your own.

```shell
$ docker build . -f src/docker/Dockerfile.(build|host) -t littil/littil-org-website:latest
```

After a successful build you can start running the image using Docker via:

```shell
$ docker run -it -p 8081:80 littil/littil-org-website:latest
```

_Parameters_

- You can either use `-d` instead of `-it` if you want to start the container in `detached mode`.
- The container exposes port 80 by default. If your machine is already using this port you can map the
  container port to another local port on your device using `-p`. In the example above the mapping is from port 80 to port 8081.

You can now navigate to `http://localhost:8081` using your browser. You should see the LITTIL website.

### Get the ID of a container

To start, stop or access your container you need its ID. You can find this ID by running:

```shell
$ docker ps
```

The correct ID is in column `CONTAINER ID`.

### Access the container

If you need access to the Nginx webserver you can simply gain access with `Bash` using the `CONTAINER ID`
which you can look up as described above.

```shell
$ docker exec -it <CONTAINER ID> /bin/bash
```

### Stopping the container

When you have started your container in `detached mode` and you want to stop it, you need to do this with the Docker CLI tool.
First look up the `CONTAINER ID` and then run:

```shell
$ docker stop <CONTAINER ID>
```

### Remove the container

If you want to remove the container from your machine you should look up the `CONTAINER ID` and then run:

```shell
$ docker rm <CONTAINER ID>
```
