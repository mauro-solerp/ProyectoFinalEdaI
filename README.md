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

### Ejecución de la aplicación de consola

Para ejecutar la aplicación de consola, se pueden usar los siguientes script:

Crear un par clave-valor
```
app.bat create <clave> <valor>
```
Crear un par clave-valor en la colección indicada
```
app.bat create <clave> -c <coleccion>
```
Obtener el valor de una clave
```
app.bat get <clave>
```
Obtener el valor de una clave en la colección indicada
```
app.bat get <clave> -c <coleccion>
```
Eliminar un par clave-valor
```
app.bat remove <clave>
```
Eliminar un par clave-valor en la colección indicada
```
app.bat remove <clave> -c <coleccion>
```
Actualizar el valor de una clave
```
app.bat update <clave> <valor>
```
Actualizar el valor de una clave en la colección indicada
```
app.bat update <clave> <valor> -c <coleccion>
```
Obtener todas las claves
```
app.bat getAll
```
Obtener todas las claves de la colección indicada
```
app.bat getAll -c <coleccion>
```
Obtener la cantidad total de claves almacenadas
```
app.bat getAll -s
```
Devuelve true si contiene la clave indicada
```
app.bat contains <clave>
```
Devuelve true si contiene la clave en la colección indicada
```
app.bat contains <clave> -c <coleccion>
```

## Mejoras para subir nota implementadas

### Test unitarios
Se realizaron test para verificar que los métodos de la librería funcionan correctamente.

### Documentación
Todos los métodos y clases están documentados con JavaDoc

### Git
El proyecto cuenta con un repositorio Git en el que se han realizado commits con mensajes descriptivos de cada una de las funcionalidades implementadas
url del repositorio: https://github.com/mauro-solerp/ProyectoFinalEdaI

### Colecciones
Se implementó la funcionalidad de poder crear colecciones que guarden pares de clave-valor y poder acceder a ellas.
Para que la aplicación reconozca la coleccion se debe indicar mediante los parámetros opcionales {-c, --collect} y el nombre de la coleccion.
Si no se usa este parámetro la información se guardara en la colección por defecto de la cache.

### Persistencia con Encriptacion
Se implementó la funcionalidad de poder guardar la información de las colecciones en un archivo de texto encriptado con AES.



[gradle]: https://gradle.org
[picocli]: https://picocli.info