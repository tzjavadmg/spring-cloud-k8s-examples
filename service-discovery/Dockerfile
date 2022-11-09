#FROM maven:3.8.3-openjdk-17
FROM quay.io/jkube/jkube-java:0.0.16
ENV JAVA_APP_DIR=/deployments
EXPOSE 8080 8778 9779
#EXPOSE 5005
WORKDIR /deployments
COPY maven/target/*.jar /deployments/app.jar
#ENTRYPOINT [ "java", "-jar", "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005","/deployments/app.jar" ]