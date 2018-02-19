# Loader_e2a

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/512e4b265b9e46a5b0f47bb4ace9f262)](https://www.codacy.com/app/jelabra/Loader_e2a?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=Arquisoft/Loader_e2a&amp;utm_campaign=Badge_Grade)
[![Build Status](https://travis-ci.org/Arquisoft/Loader_e2a.svg?branch=master)](https://travis-ci.org/Arquisoft/Loader_e2a)
[![codecov](https://codecov.io/gh/Arquisoft/Loader_e2a/branch/master/graph/badge.svg)](https://codecov.io/gh/Arquisoft/Loader_e2a)

Loader - e2a

Enlace al repositorio común de Agents y Loader, que contiene la documentación: [inci_e2a](https://github.com/Arquisoft/inci_e2a)

# Autores

* Herminio García González (@herminiogg)

* Jose Emilio Labra Gayo (@labra)

## AUTORES 2016-2017:

* Daniel Bermejo Blanco (@UO204115)

* Pedro Fernández Álvarez (@UO244928)

* Darío Alonso Díaz (@UO237089)

* Jonathan Vallés Robla (@UO231850)

## AUTORES 2017-2018:

* César Camblor García (@UO251281)

* Pablo Díaz Rancaño (@UO251017)

* Fernando De la Torre Cueva (@UO245182)

* Pablo Álvarez Álvarez (@UO251561)

## Introducción al repositorio

Este repositorio pertenece a la parte *Loader* del grupo de trabajo **E2a**,
encargada de cargar agentes (personas, sensores, entidades, etc.) que envían incidencias
al sistema. La carga se lleva a cabo desde un fichero Excel, y se almacenan los datos
en una base de datos para, posteriormente, ser procesada por la parte *Agent*.

## Cómo ejecutar el proyecto

Lo primero que hay que hacer para ejecutar el proyecto es clonarlo o descargarlo. A continuación,
se debe importar (**COMO [MAVEN](http://maven.apache.org/download.cgi)**) el proyecto descargado en su entorno favorito.
Una vez que se tenga el proyecto importado, hay que abrir la línea de comandos y trasladarse hasta
la carpeta raíz del proyecto (*xxx\xxx\...\Loader_e2a*).

**Para que los tests que hacen uso de la base de datos funcionen, se necesita abrir el fichero .bat del directorio "BBDDTesting/data/startup.bat".**

A continuación, se ejecuta la siguiente instrucción:

```bash
C:\...\Loader_e2a>mvn exec:java -Dexec.mainClass="es.uniovi.asw.Application" -Dexec.args="excel ruta_fichero_excel ruta_fichero_csv"
```

>Por ejemplo, ruta_fichero_excel puede ser:
```
src/test/resources/test.xlsx
```
>ruta_fichero_csv:
```
src/test/resources/TiposAgentes.csv
```
