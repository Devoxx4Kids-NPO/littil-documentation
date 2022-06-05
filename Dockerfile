FROM squidfunk/mkdocs-material

RUN  pip install --no-cache-dir mkdocs-build-plantuml-plugin mkdocs-exclude

RUN apk update && apk upgrade && \
    apk add --no-cache gcc musl-dev openjdk11-jdk curl fontconfig ttf-dejavu

RUN mkdir /graphviz && \
  apk add --update graphviz

RUN curl -o plantuml.jar -L http://sourceforge.net/projects/plantuml/files/plantuml.1.2022.5.jar/download && echo "47c95b77e13cd9667ddfc8dc1188ceefac01a109  plantuml.jar" | sha1sum -c - && mv plantuml.jar /opt/plantuml.jar
RUN echo $'#!/bin/sh\n\njava -jar '/opt/plantuml.jar' ${@}' >> /usr/local/bin/plantuml
RUN ["chmod", "+x", "/usr/local/bin/plantuml"]

CMD ["serve", "--dev-addr=0.0.0.0:8000"]