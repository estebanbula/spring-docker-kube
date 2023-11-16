FROM amazoncorretto:17.0.9-alpine

WORKDIR /app

COPY ./build/libs/ms-courses-0.0.1-SNAPSHOT.jar .

EXPOSE 8802

ENTRYPOINT ["java", "-jar", "ms-courses-0.0.1-SNAPSHOT.jar"]