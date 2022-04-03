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
cd mockbackend/src/main/resources
./run.sh
```
