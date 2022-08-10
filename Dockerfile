FROM openjdk:11
EXPOSE 8080
COPY ./FacturacionProyect-1.0.jar FacturacionProyect-1.0.jar
CMD [ "java", "-jar", "FacturacionProyect-1.0.jar" ]


