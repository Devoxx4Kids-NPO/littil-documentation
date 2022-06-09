# littil-documentation

This repository contains high-level documentation about the Littil platform, including a karate mock server implementation and 
a set of end to end tests (based on cucumber) containing detailed, human-readable specifications. 

Each separate repository in the [Littil space](https://github.com/Devoxx4Kids-NPO) also contains more detailed technical documentation.

* [What is Littil?](https://littil.org/)
* [Project setup](CONTRIBUTE.md)
* [Conceptual model and data model](model.md)

## Gherkin feature files 
Detailed documentation of features and scenarios can be found under [integration/src/test/resources/org/littil/integration](./integration/src/test/resources/org/littil/integration).

## Running the mock backend server
This uses the [karate Netty](https://karatelabs.github.io/karate/karate-netty/) framework. You run the server as follows:

```bash
cd mockbackend
./run.sh
```

## Documentation site
Our documentation, which is published via GitHub pages, is generated with [MkDocs (with a custom material theme)](https://squidfunk.github.io/mkdocs-material/).
You can find instructions below about writing documentation, previewing and building the documentation.

### Prerequisites
We created a custom image which includes all tools needed to write documentation using MkDocs, Markdown and PlantUML.
Because of this, you only need docker installed on your machine when writing and building documentation locally. You
can find instructions [here](https://docs.docker.com/get-docker/) on how to install docker on your machine.

### Docker image
If you are in need to install an extra plugin for example, you can create a new image using the Dockerfile located at:
`./Dockerfile`. Alter the file accordingly and then run:

```shell
$ docker build . -t <new_tag>
```

### Preview documentation site locally
When you want to preview the documentation site locally you can use the same Docker container which is used to build
the documentation. Run the following command `in the root of the project` to preview the new documentation site. The example below uses the latest image
available on [Docker hub](https://hub.docker.com/r/pepijnschildkamp/mkdocs-material-plantuml).

```shell
$ docker run --rm -it -p 8000:8000 -v ${PWD}:/docs ghcr.io/devoxx4kids-npo/littil-documentation:latest
```

The documentation site should be available at `http://localhost:8000`.

You can also use your local build image by changing the last parameter with the tag you used.

### Building the site artifacts
Building the documentation site is done via the GitHub Actions when merging the documentation to the trunk repository.
Though, if you are in need to inspect the generated site artifacts you can run the following command.

```shell
$ docker run --rm -it -p 8000:8000 -v ${PWD}:/docs ghcr.io/devoxx4kids-npo/littil-documentation:latest build
```

The generated artifacts are located in the directory `./site`. Make sure you do not commit this directory to the repository.

### Altering the theme
If you want to alter the theme of the documentation site you have 2 options. When only changing colors you can enhance
the file `./docs/stylesheets/extra.css`. The littil theme itself is located at `./docs/theme/littil-theme`. Follow the
[guide of MkDocs Material](https://squidfunk.github.io/mkdocs-material/customization/#extending-the-theme) on how to overwrite the theme.

### Writing documentation

#### MkDocs specifications
To create or alter the menu you need to alter the tile `./mkdocs.yml` in the root of the project. The rest of the documentation
is written in regular Markdown files. Please read the following [instructions](https://www.mkdocs.org/user-guide/writing-your-docs/)
for more details.

#### Drawing diagrams using PlantUML
This documentation site supports PlantUML to draw diagrams as code. During the generation of the site it will look for
files within the directory `./docs/diagrams/src`.Generated diagrams are stored in the directory `./docs/diagrams/out`
in `SVG` format to which you can refer to in your markdown pages as an image.

In example: `![image description](diagrams/out/example.svg)`.

Please see [the plugin repository](https://github.com/quantorconsulting/mkdocs_build_plantuml) for more detailed instructions.