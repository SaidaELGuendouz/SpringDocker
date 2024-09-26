# Utiliser l'image de base de OpenJDK JDK 21
FROM openjdk:21-jdk-slim

# Définir le répertoire de travail dans le conteneur
WORKDIR /app

# Argument pour le chemin du fichier JAR à copier
ARG jar_file=target/visualisation-grafana-0.0.1-SNAPSHOT.jar

# Copier le fichier JAR dans le conteneur
COPY ${jar_file} /app/app.jar

# Exposer le port sur lequel l'application Spring Boot va tourner
EXPOSE 8080

# Définir la commande pour exécuter le fichier JAR
ENTRYPOINT ["java", "-jar", "/app/app.jar"]

