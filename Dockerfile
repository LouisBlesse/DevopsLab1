# deployment
FROM openjdk:11-jdk-oracle
COPY ./target/*.jar /usr/local/lib/app.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","/usr/local/lib/app.jar"]