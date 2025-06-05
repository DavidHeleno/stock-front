# Etapa 1: Build da aplicação com Gradle e Java 21
FROM gradle:8-jdk21-alpine AS build
WORKDIR /home/gradle/project
COPY . .

# 👉 Ignora os testes
RUN gradle build -x test --no-daemon

# Etapa 2: Imagem final só com JRE para rodar o app
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY --from=build /home/gradle/project/build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
