# Reto 7 - Sistema de Autenticación JWT

## Descripción
Sistema de gestión universitaria con autenticación JWT implementado en Spring Boot.

## Configuración de Base de Datos
- **Base de datos**: PostgreSQL
- **Nombre de la BD**: university
- **Usuario**: postgres
- **Contraseña**: admin
- **Puerto**: 5432

## Endpoints de Autenticación

### 1. Registrar Usuario
```http
POST http://localhost:8080/register?rol=ROLE_ADMIN
Content-Type: application/json

{
    "username": "pablo",
    "password": "admin123"
}
```

### 2. Autenticar Usuario
```http
POST http://localhost:8080/authenticate
Content-Type: application/json

{
    "username": "pablo",
    "password": "admin123"
}
```

**Respuesta esperada:**
```json
{
    "token": "eyJhbGciOiJIUzI1NiJ9..."
}
```

### 3. Usar Token en Requests Protegidos
```http
GET http://localhost:8080/test
Authorization: Bearer eyJhbGciOiJIUzI1NiJ9...
```

## Roles Disponibles
- `ROLE_ADMIN` - Administrador
- `ROLE_STUDENT` - Estudiante
- `ROLE_PROFESSOR` - Profesor

## Cómo Probar

### Opción 1: Usando el archivo Authentication.http
1. Abre el archivo `http/Authentication.http` en tu IDE
2. Ejecuta las requests en orden:
   - Primero registra un usuario
   - Luego autentica para obtener el token
   - Usa el token en requests protegidos

### Opción 2: Usando curl
```bash
# Registrar usuario
curl -X POST http://localhost:8080/register?rol=ROLE_ADMIN \
  -H "Content-Type: application/json" \
  -d '{"username":"pablo","password":"admin123"}'

# Autenticar
curl -X POST http://localhost:8080/authenticate \
  -H "Content-Type: application/json" \
  -d '{"username":"pablo","password":"admin123"}'

# Usar token (reemplazar TOKEN_AQUI con el token obtenido)
curl -X GET http://localhost:8080/test \
  -H "Authorization: Bearer TOKEN_AQUI"
```

### Opción 3: Usando Postman
1. Importa las requests del archivo `Authentication.http`
2. Ejecuta en orden
3. Copia el token de la respuesta de autenticación
4. Usa el token en el header `Authorization: Bearer <token>`

## Solución de Problemas

### Error: "El usuario no existe"
- Asegúrate de haber registrado el usuario antes de intentar autenticarlo
- Verifica que el username sea exactamente el mismo

### Error: "Token inválido"
- Verifica que el token esté completo y no tenga espacios extra
- Asegúrate de incluir "Bearer " antes del token

### Error de conexión a base de datos
- Verifica que PostgreSQL esté ejecutándose
- Confirma las credenciales en `application.properties`

## Estructura del Proyecto
```
src/main/java/com/devsenior/pablo/reto7/
├── config/           # Configuración de seguridad y JWT
├── controller/       # Controladores REST
├── model/           # Entidades y DTOs
├── repository/      # Repositorios JPA
├── service/         # Lógica de negocio
└── util/           # Utilidades (JWT, etc.)
``` 