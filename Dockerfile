FROM openjdk:11
ARG TAG
RUN mkdir -p  /usr/src/app/
WORKDIR /usr/src/app/
COPY . /usr/src/app/
RUN ./gradlew assemble
CMD ./gradlew run