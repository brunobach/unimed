FROM openjdk:8-alpine
RUN apk update && apk add bash
RUN mkdir -p /opt/app
ENV PROJECT_HOME /opt/app
COPY ./api/target/api-0.0.1-SNAPSHOT.jar $PROJECT_HOME
WORKDIR  $PROJECT_HOME
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=prod","api-0.0.1-SNAPSHOT.jar"] 