#Watch store service

This application serves to manage uploading products(watches) to the e-shop warehouse.
 
**Project description**

This project is developed with Java 11 and with Spring boot (v2.5.1).
It uses PostgreSQL database as data repository. To create database schema assign *create* value to variable *spring:jpa:hibernate:dl-auto* in yml file.

Project can be run on different profiles such as: dev, unit, stage, prod. At this moment only dev profile is supported with *.yml* file.

Project uses **maven** to deal with its dependencies(check pom.xml) also uses it as build tool.

Project structure is separated to "layers", starting from *repository* (DB data persistence, communication etc.), then *service*(business logic) and finally
*web*(exposing endpoints to communicate with other services via *REST* API with HTTP)
