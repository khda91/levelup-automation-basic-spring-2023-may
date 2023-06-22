FROM markhobson/maven-chrome:jdk-11

COPY . /home/app

WORKDIR /home/app

ENTRYPOINT mvn clean test
