FROM openjdk:8-jre-slim
COPY /target/ziglu.newsfeed-0.0.1-SNAPSHOT.jar /usr/src/ziglu/
WORKDIR /usr/src/ziglu
EXPOSE 8080
CMD ["java", "-jar", "ziglu.newsfeed-0.0.1-SNAPSHOT.jar"]