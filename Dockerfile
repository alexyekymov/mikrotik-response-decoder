FROM adoptopenjdk/openjdk11:ubi
ADD . /src
WORKDIR /src
RUN chmod +x mvnw
RUN ./mvnw package -DskipTests
EXPOSE 8081

ENTRYPOINT ["java","-jar","target/mikrotik-response-decoder-1.0.0.jar"]
