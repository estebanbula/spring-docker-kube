FROM amazoncorretto:17.0.9-alpine

WORKDIR /app

COPY ./build/libs/ms-courses-0.0.1-SNAPSHOT.jar .

ENV APP_PORT 8802
EXPOSE $APP_PORT

ENTRYPOINT ["java", "-jar", "ms-courses-0.0.1-SNAPSHOT.jar"]