FROM amazoncorretto:17.0.9-alpine

WORKDIR /app

COPY ./build/libs/ms-users-0.0.1-SNAPSHOT.jar .

ENV APP_PORT 8801
EXPOSE $APP_PORT

ENTRYPOINT ["java", "-jar", "ms-users-0.0.1-SNAPSHOT.jar"]