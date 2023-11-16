FROM amazoncorretto:17.0.9-alpine

WORKDIR /app

COPY ./build/libs/ms-users-0.0.1-SNAPSHOT.jar .

EXPOSE 8801

ENTRYPOINT ["java", "-jar", "ms-users-0.0.1-SNAPSHOT.jar"]