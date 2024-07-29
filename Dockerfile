FROM openjdk:17

COPY build/libs/new-profile-app-0.0.1-SNAPSHOT.jar new-profile-app.jar

CMD ["java","-jar","new-profile-app.jar"]