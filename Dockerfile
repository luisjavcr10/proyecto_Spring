# Usa una imagen base de JDK
FROM eclipse-temurin:17-jdk

# Crea un directorio para la aplicación
WORKDIR /app

# Copia el archivo .jar de la aplicación al contenedor
COPY build/libs/luiscastillo-market-1.0.jar app.jar

# Expone el puerto que usa tu aplicación
EXPOSE 8090

# Ejecuta la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
