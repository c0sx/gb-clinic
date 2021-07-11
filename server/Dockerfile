FROM openjdk:8-jdk
EXPOSE 8080:8080
COPY . /
RUN ./gradlew installDist
WORKDIR ./build/install/gbclinic/bin
