FROM openjdk:11
# FROM maven:3.8-jdk-11
COPY ./target/FacturacionProyect-1.0-SNAPSHOT.jar FacturacionProyect-1.0-SNAPSHOT.jar
EXPOSE 8080
CMD [ "java", "-jar", "FacturacionProyect-1.0.jar" ]

# docker build -t facturacion/main .
# docker run -p8080:8080 facturacion/main

