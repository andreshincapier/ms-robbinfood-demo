FROM adoptopenjdk/maven-openjdk13 AS compile
ARG HOME_DIR="/ram-orchestator"
WORKDIR $HOME_DIR
COPY ./main.gradle ./build.gradle
COPY . $HOME_DIR
RUN chmod +x $HOME_DIR/gradlew && $HOME_DIR/gradlew bootJar
COPY applications/microservice/build/libs/applications-microservice-*.jar $HOME_DIR/serviceramor.jar
FROM adoptopenjdk/openjdk11 AS jar
RUN addgroup --system spring && adduser --system spring --ingroup spring
USER spring:spring
RUN mkdir -p /tmp/logs && chown spring:spring /tmp/logs
ARG HOME_DIR="/ram-orchestator"
COPY --chown=spring --from=compile $HOME_DIR/serviceramor.jar .
VOLUME /tmp/logs
ENTRYPOINT ["java", "-jar", "/serviceramor.jar"]