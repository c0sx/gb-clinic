FROM openjdk:8-jdk
EXPOSE 8080:8080
RUN mkdir /app
COPY ./build/install/gb-clinic/ /app/
WORKDIR /app/bin

CMD ["./gb"]