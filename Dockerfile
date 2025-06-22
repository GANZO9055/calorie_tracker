# 1 этап - сборка проекта в jar файл
FROM maven:3.9.9-openjdk-17 as maven
RUN mkdir calorie_tracker
WORKDIR calorie_tracker
COPY . .
RUN mvn package -Dmaven.test.skip=true
CMD ["mvn", "liquibase:update", "-Pdocker"]

# 2 этап - указание запуска проекта
FROM openjdk:17.0.2-jdk
WORKDIR calorie_tracker
COPY --from=maven /calorie_tracker/target/calorie_tracker.jar calorie.jar
CMD java -jar calorie.jar