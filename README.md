# Plantilla Gradle para aplicación de consola

Plantilla de proyecto [Gradle][gradle] para crear una aplicación de consola
y una librería consumida por esta. La aplicación de consola usa [Picocli][picocli] 
para facilitar la composición de comandos y parámetros.

## Estructura del proyecto

La estructura del proyecto es la clásica de un proyecto
gradle con varios subproyectos. Nos encontraremos los 
siguientes archivos y carpetas:

- `lib` Subproyecto para la librería.
- `app` Subproyecto para la aplicación de consola.
- `gradlew[.bat]` Script para usar gradle incluido en el proyecto.
- `settings.gradle` Archivo de configuración donde se define el nombre del proyecto
  así como los subproyectos incluidos.

Para establecer un nombre de proyecto diferentes, deberá
editarse en el archivo `settings.gradle` la siguiente línea:

```
rootProject.name = 'my-custom-project-name'
```

## Librería
El subproyecto de librería está destinado a crear la lógica
de negocio separada de la propia aplicación. 

## Aplicación
El subproyecto de aplicación está destinado a la implementación de
una aplicación de consola (CLI - Command Line Interface).

Para ayudar a su creación, se incluye ya la dependencia de [Picocli][picocli]; una
librería que ayuda a crear la interface pudiendo definir comandos, parámetros
opcionales, repeticiones de parámetros, ...

## Compilación del proyecto
Para compilar el proyecto completo
```
./gradlew build
```

Para compilar uno de los subproyectos en concreto:
```
./gradlew build -p lib
./gradlew build -p app
```
## Comprobar tests en el proyecto
Para lanzar todos los tests del proyecto
```
./gradlew test
```

Para lanzar los test de un subproyecto en concreto:
```
./gradlew test -p lib
./gradlew test -p app
```
## Uso de la aplicación de consola

Al compilar el subproyecto `app` se genera una distribución de la
aplicación como archivo comprimido `build/distributions/app.zip`. 
Al descomprimir, nos aparecerá una carpeta `app` que contendrá los .jar
generados de la compilacion (subcarpeta `lib`) y los scripts para 
lanzarla la aplicación (subcarpeta `app`). 



[gradle]: https://gradle.org
[picocli]: https://picocli.info