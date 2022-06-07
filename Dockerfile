FROM adoptopenjdk/openjdk11:ubi
COPY . KhodeLanta.jar
EXPOSE 8090
CMD [ "java", "-jar", "KhodeLanta.jar"]