FROM adoptopenjdk/openjdk8
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} tu-van-dinh-duong.jar
ENTRYPOINT ["java", "-jar", "/tu-van-dinh-duong.jar"]
EXPOSE 8081