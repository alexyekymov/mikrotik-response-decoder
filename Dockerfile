FROM adoptopenjdk/openjdk11:alpine
ADD . /src
WORKDIR /src
RUN ./mvnw package -DskipTests
EXPOSE 8081

ENTRYPOINT ["java","-jar","-Dspring.datasource.username=${DB_USERNAME}", "-Dspring.datasource.password=${DB_PASSWORD}","target/mikrotik-response-decoder-0.0.1-SNAPSHOT.jar"]