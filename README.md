# 🚀 API REST con Spring Boot, MySQL y Redis Cache

Una API RESTful construida con Spring Boot que implementa operaciones CRUD básicas para la gestión de productos, utilizando **MySQL** como base de datos persistente y **Redis** como capa de caché para optimizar radicalmente los tiempos de respuesta.

## 🛠️ Tecnologías Utilizadas

* **Java 21**
* **Spring Boot 3.x** (Web, Data JPA, Cache, Data Redis)
* **MySQL** (Base de datos relacional)
* **Redis** (Almacenamiento en memoria / Caché)
* **Lombok** (Reducción de código boilerplate)
* **Maven** (Gestión de dependencias)

## 🏗️ Arquitectura y Flujo de Caché

Este proyecto demuestra un entendimiento sólido de optimización de recursos mediante el patrón *Cache-Aside*:
1. **Cache Miss (`@Cacheable`):** En la primera petición, si el dato no está en Redis, se consulta a MySQL, se devuelve al usuario y se guarda en memoria.
2. **Cache Hit:** En peticiones subsecuentes, el dato se extrae directamente de Redis en milisegundos, reduciendo la carga en la base de datos principal.
3. **Cache Eviction & Put (`@CacheEvict` / `@CachePut`):** Al actualizar o eliminar un registro, la caché se sincroniza automáticamente para evitar datos obsoletos (fantasmas).

## 🚀 Endpoints Principales

La API expone los siguientes servicios bajo la ruta base `/api/productos`:

| Método | Endpoint | Descripción | Comportamiento de Caché |
| :--- | :--- | :--- | :--- |
| `GET` | `/{id}` | Obtiene un producto por su ID | Almacena el resultado en Redis (`@Cacheable`) |
| `PUT` | `/{id}` | Actualiza los datos de un producto | Actualiza MySQL y refresca la llave en Redis (`@CachePut`) |
| `DELETE` | `/{id}` | Elimina un producto del sistema | Borra el registro en MySQL y purga la llave en Redis (`@CacheEvict`) |

## ⚙️ Instalación y Configuración Local

### Prerrequisitos
* Java JDK 21+ instalado.
* Servidor MySQL ejecutándose en el puerto `3309` (o modificar el `application.properties`).
* Servidor Redis ejecutándose localmente en el puerto por defecto `6379`.

### Pasos para ejecutar

1. **Clonar el repositorio:**
   ```bash
   git clone [https://github.com/Jhonatanisai8/app-intro-redis-springboot.git](https://github.com/Jhonatanisai8/app-intro-redis-springboot.git)
   cd app-redis-springboot
