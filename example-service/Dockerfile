FROM maven:3.8.3-openjdk-17
EXPOSE 8080/tcp
COPY maven/target/*.jar /opt/app.jar
WORKDIR /opt
#ENTRYPOINT [ "java", "-jar", "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005","/opt/app.jar" ]
ENTRYPOINT [ "java", "-jar", "/opt/app.jar" ]
