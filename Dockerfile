FROM eclipse-temurin:17

LABEL MAINTAINER="AK@gmail.com"

WORKDIR /app

COPY target/springboot-rest-api-0.0.1-SNAPSHOT.jar /app/springboot-rest-api.jar

ENTRYPOINT ["java", "-jar", "springboot-rest-api.jar"]