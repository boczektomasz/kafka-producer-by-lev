FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN printenv
RUN mvn -f /home/app/pom.xml clean package -Dhttps.proxyHost=$https_proxy -Dhttp.proxyHost=$http_proxy -Dhttp.proxyPort=8080

#
# Package stage
#
FROM openjdk:11-jre-slim
COPY --from=build /home/app/target/kafka-producer-1.0.jar /usr/local/lib/kafka.jar
# EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/kafka.jar"]