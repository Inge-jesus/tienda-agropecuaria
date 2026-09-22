# Tienda Agropecuaria - API REST con Persistencia y Observabilidad

## Descripción del Proyecto
Evolución de la API REST para la gestión de productos e insumos agropecuarios. La solución incorpora persistencia relacional con MySQL, integración con servicios API externos para la conversión de divisas en tiempo real, y observabilidad mediante Spring Boot Actuator y Prometheus.

## Tecnologías Utilizadas
- **Java 17 / Spring Boot 3.x**
- **Spring Data JPA & Hibernate**
- **MySQL Database 8.x**
- **Spring Boot Actuator & Micrometer**
- **Prometheus Metric Exporter**
- **RestClient**

## Configuración de MySQL
1. Crear la base de datos en MySQL local o remoto:
   ```sql
   CREATE DATABASE tienda_agropecuaria_db;
   