FROM openjdk:17
WORKDIR /
COPY . .
EXPOSE 80
CMD java -jar karate.jar -m teacher.feature -p 80


# docker build -t littlmockbackend .
# docker run -name littlmockbackend -p 8090:80 littlmockbackend
