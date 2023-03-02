FROM adoptopenjdk/openjdk11:ubi
ARG JAR_FILE=target/*.jar
RUN mkdir /opt/app
COPY ${JAR_FILE} /opt/app/app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-Dspring.datasource.username=${DB_USERNAME}", "-Dspring.datasource.password=${DB_PASSWORD}", "-jar", "/opt/app/app.jar"]