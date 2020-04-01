FROM java:8-jdk-alpine

COPY maven/${project.artifactId}-${project.version}.jar /usr/app/

WORKDIR /usr/app

ENTRYPOINT ["java", "-jar", "${project.artifactId}-${project.version}.jar"]