FROM markhobson/maven-chrome:jdk-11

ENV HEADLESS="true"

COPY . /home/app

WORKDIR /home/app

ENTRYPOINT mvn clean test
