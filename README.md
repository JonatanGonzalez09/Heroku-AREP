# Laboratorio 2 #
El objetivo ofrece cálculos estadísticos básicos como la media y la desviación estándar de una serie de datos a través de un servicio web usando el micro framework **Spark**.

**La aplicacion se encuentra desplegada en heroku** [Prepresione aqui](https://secure-sierra-48914.herokuapp.com/) **para probar.**

## Prerrequisitos ##
Se debe tener conocimientos claros de la programación Orientada a objetos y de las fórmulas para hallar la media y la desviación estándar, también es necesario tener instalado Java 1.8 y también Apache Maven 3.6.0 en el equipo donde se ejecutara la aplicación.

## Ejecutando Pruebas ##
Al ejecutar el comando ```mvn test``` se podrá ver la ejecución de las pruebas de unidad realizadas con **JUnit**

## Construido con ##
[Maven](https://maven.apache.org/): Para la gestión de dependencias.

[Spark](http://sparkjava.com/): Para la gestion de la parte de aplicacion Web.

## Modelo ##
![myimage-alt-tag](https://github.com/JonatanGonzalez09/Heroku-AREP/blob/master/src/resources/Modelo.PNG)

## Documentación Javadoc ##
Para generar la documentacion javadoc, fue necesario ejecutar los siguientes comandos:

```
- mvn javadoc:javadoc
- mvn javadoc:jar
- mvn javadoc:aggregate
- mvn javadoc:aggregate-jar
- mvn javadoc:test-javadoc
- mvn javadoc:test-jar
- mvn javadoc:test-aggregate
- mvn javadoc:test-aggregate-jar
```
La ruta donde encontrara la documentacion es la siguiente: **target\site\apidocs\edu\escuelaing\arep\designprimer**

## Descripción del diseño ##
En el siguiente vinculo encontrara el respectivo PDF de la descripción del diseño desarrollado en LaTeX.
[Click](https://github.com/JonatanGonzalez09/Heroku-AREP/blob/master/src/resources/INTRODUCTION_TO_COMPUTER_SYSTEM_DESIGN_.pdf)

## Ejecución ##
Para empaquetar el proyecto se ejecuta el comando:
```
mvn package
```
Para ejecutar las pruebas se ejecuta el comando:
```
mvn test
```

## Licencia ##
Este proyecto cuenta con la licencia [**GNU General Public License v3.0**](https://github.com/JonatanGonzalez09/Heroku-AREP/blob/master/LICENSE)

## Autor ##
Jonatan Esteban Gonzalez Rodriguez 
