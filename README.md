# Health Check In Spring Boot

Cómo monitorizar microservicios con Spring Boot Admin

## Documentaciones

[Spring Boot Admin Reference Guide](https://codecentric.github.io/spring-boot-admin/2.2.1/)
[Cómo monitorizar microservicios con Spring-Boot-Admin](https://www.paradigmadigital.com/dev/monitorizar-microservicios-spring-boot-admin/)

## Configurar Spring Boot Admin

Para configurar Spring Boot Admin en un proyecto, primero debe realizar el proceso de instalar las dependencias y configuraciones necesarias, tal como se muestra a continuación:

### Inicializar proyecto

Para inicializar el proyecto se recomienda utilizar [Spring Initializr](https://start.spring.io/) y configurar las siguientes dependencias para el proyecto en cuestión.

![Depenencias](./screenshots/1.png)

Adicionalmente, se deben agregar las dependencias de Swagger como se muestra a continuación:

**Maven**

```
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger-ui</artifactId>
    <version>2.9.2</version>
</dependency>
```

**Gradle**

```
compile 'io.springfox:springfox-swagger2:2.9.2'
compile 'io.springfox:springfox-swagger-ui:2.9.2'
```

### Configurando Archivos

Una vez se completa el proceso de instalación de las dependencias se debe proceder a configurar tanto el archivo main.java, así como también el archivo YML o propierties de nuestro proyecto, para este ejemplo se utilizará un archivo YML.

#### Main.java

Se deben agregar las siguientes líneas para importar las librerías correspondientes.

```
@EnableAdminServer
@EnableSwagger2
@EnableJpaAuditing
```

## Acerca de Spring Boot Admin

