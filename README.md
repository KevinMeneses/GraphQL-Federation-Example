# PoC de GraphQL Federation

## Descripción de la prueba
Esta prueba de concepto consiste en la implementacion de la arquitectura que permite escalar servicios o microservicios 
de GraphQL llamada GraphQL Federation o Apollo Federation, por la compañía Apollo, quienes fueron los pioneros en implementar
este concepto.

## Objetivos de la prueba
El objetivo de esta prueba es implementar de manera simple la arquitectura de GraphQL Federation definiendo los componentes
necesarios que son: Servicios GraphQL + Federated Router, para explicar su estructura y funcionamiento.

## Pasos implementados para la prueba

### Configuracion del proyecto
Se creó un nuevo proyecto de spring utilizando [Spring Initializr](https://start.spring.io/) donde es posible seleccionar
algunas de las librerias comunes de spring framework, entre ellas Spring for GraphQL. Además se incluyo la dependencia de
la libreria de soporte de Apollo Federation para Java en los diferentes modulos.

### Definición de los servicios
Se definieron 3 dominios para manejar información sobre: Dueños, Mascotas y Paseos, cada uno con sus propios datos e 
identificadores propios y de entidades relacionadas.

### Creacion de los componentes
Se crearon 3 servicios de GraphQL, uno para cada dominio con sus respectivos esquemas de GraphQL que incluyen referencias 
a nodos externos o padres como se indica en la documentación de [Apollo Federation](https://www.apollographql.com/docs/federation/entities-advanced)
al momento de definir los subgrafos, y también se definieron los respectivos solucionadores de referencias para asociar
identificadores entre entidades.

### Configuracion del supergrafo
Se crearon los archivos de configuración: 
- supergraph.yaml para las configuraciones del supergrafo como: la version de Federation, los diferentes subgrafos, sus 
URLs y la ubicacion de sus esquemas GraphQL.
- router.yaml para las configuraciones del enrutador de Federation con opciones como: los puertos del enrutador, el
sandbox para hacer las consultas al supergrafo y la configuracion de errores, entre otras opciones.

### Rover CLI para manejar el supergrafo
Se siguieron los pasos de la documentación de Apollo Federation para la instalación de Rover CLI que consiste en correr el 
comando `curl -sSL https://rover.apollo.dev/nix/latest | sh` en MacOS o Linux y después dentro de la raiz del proyecto 
se corrio el comando `rover dev --supergraph-config ./supergraph.yaml` para realizar la composición del supergrafo, correr
el router y así poder realizar consultas en el `localhost:4000` usando el sandbox.

## Tecnologias usadas en la prueba
- Kotlin
- Spring boot (Web y GraphQL)
- Apollo Federation
- Rover CLI

## Resultados
Primero se realizaron pruebas desde una máquina con Windows, pero no fue posible que Rover CLI funcionara correctamente
al correr el comando de composión del supergrafo por un error sin descripción; sin embargo, al correrlo en una máquina con
MacOS funcionó correctamente. La aplicación es capaz de mostrar la información del supergrafo exitosamente, conectando 
la información de cada dominio o modelo a través del gateway o router y permitiendo definir el esquema de los datos que
se desean obtener del nodo padre y sus hijos a traves de la interfaz gráfica o sandbox.

## Conclusiones
GraphQL Federation es una arquitectura conveniente para escalar servicios que utilizan GraphQL, tiene buen soporte
para multiples lenguajes, en este caso Java o Kotlin; sin embargo, al revisar los ejemplos parece resultar más fácil 
de configurar en otros lenguajes como JavaScript cuya implementación luce más sencilla y elegante. También, el problema 
de Rover CLI con Windows fue desgastante y difícil entender lo qué estaba sucediendo, actualmente es un issue abierto 
en el repositorio de Rover con pocos detalles de la situación. También existe la posibilidad de implementar un Router 
propio, pero no se logró explorar por restricciones de tiempo.