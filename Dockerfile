FROM openjdk:8

COPY target/app-0.0.1-SNAPSHOT.jar app-0.0.1-SNAPSHOT.jar

CMD ["java", "-jar", "app-0.0.1-SNAPSHOT.jar"]
