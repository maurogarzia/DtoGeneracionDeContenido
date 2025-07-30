# 🧪 Proyecto Spring Boot DTO Practice

Este proyecto es una práctica de cómo implementar correctamente **DTOs (Data Transfer Objects)** en una arquitectura por capas usando **Spring Boot**, **JPA**, y **MySQL**.

---

## 🛠️ Tecnologías / Dependencias

El proyecto fue generado con Spring Initializr y utiliza las siguientes dependencias:

- ✅ Spring Web
- ✅ Spring Data JPA
- ✅ MySQL Driver
- ✅ Lombok 
- ✅ Jakarta Persistence 

---

## 📁 Estructura del Proyecto
```bash
src/
└── main/
├── java/
│ └── com.DtoGenereacionContenido.Dto/
│ ├── Controllers/
│ ├── dtos/ 
│ ├── Entities/
│ ├── Repositories/
│ └── Services/
└── resources/
├── application.properties
```
---

## 🧑‍💻 Explicación del Proyecto

El sistema permite **crear, leer, actualizar y eliminar**:

- Usuarios (`Users`)
- Posteos (`Posts`)

Cada entidad tiene:

- DTO de salida (ej: `UserDTO`)
- DTO de entrada (ej: `UserCreateDTO`)
- Mapper para transformar entre entidades y DTOs
- Controlador REST con endpoints para CRUD
- Servicio que contiene la lógica de negocio

---

## 🧰 ¿Cómo clonar y correr?

### 1. Clona el repositorio

```bash
git clone https://github.com/maurogarzia/DtoGeneracionDeContenido
```
 ###2.Configura la base de datos
Asegurate de tener MySQL corriendo. En application.properties poné esto:
spring.application.name=Dto

# Configuracion MySQL
spring.datasource.url=jdbc:mysql://localhost:3306/DtoContenido
spring.datasource.username=admin
spring.datasource.password=1234

# Configuracion de JPA/HIbernate
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect

# Configuracion del servidor
server.port=9000

# Asegurate de crear la base de datos:
```bash
CREATE DATABASE DtoContenido;
```
### 3.Ejecuta el pryecto en IntelliJ en el DtoAplication

🔗 Endpoints disponibles
📌 Usuarios
GET	/users	Obtener todos los usuarios
GET	/users/{id}	Obtener un usuario
POST	/users	Crear usuario
PUT	/users/{id}	Actualizar usuario
DELETE	/users/{id}	Eliminar usuario

📌 Posteos
GET	/posts	Obtener todos los posteos
GET	/posts/{id}	Obtener un post
POST	/posts	Crear post
PUT	/posts/{id}	Actualizar post
DELETE	/posts/{id}	Eliminar post

📫 Ejemplos para Postman
✅ Crear usuario (POST /users)
```bash
{
  "name": "Juan Pérez",
  "email": "juan@example.com"
}
```
✅ Crear post (POST /posts)
```bash
{
  "title": "Primer post",
  "content": "Este es un post de prueba",
  "userId": 1
}
```
📌 Notas
El proyecto sigue el patrón de arquitectura por capas.

Se usan DTOs separados para entrada y salida para proteger la estructura interna.
