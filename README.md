Endpoints Disponibles
El controlador (pageController) expone varios endpoints para interactuar con la API de Rick and Morty:

Estos tienen una respuesta html: se puede notar su uso mejor con la interface hecho con Thymeleaf

/character/find: Formulario para buscar personajes por nombre.
/episode/find: Formulario para buscar episodios por nombre o número de episodio.
/location/find: Formulario para buscar ubicaciones por nombre o tipo o dimensión.

Tambien hay el controlador de character, location,episode que buscan por id y retornan solo un json:
GET /character/{id}
GET /location/{id}
GET /episode/{id}

Estos endpoint permite obtener detalles de un personaje específico mediante su ID.

Parámetros:

{id} (PathVariable): ID numérico único del personaje, localización o episodio.

Respuesta Exitosa:

Código de Estado: 200 OK
Cuerpo de Respuesta: Datos del personaje en formato JSON.
Ejemplo de Uso en Postman:

Configuración en Postman:

Método: GET
URL: http://localhost:8080/character/{id}
Donde {id} es el ID del personaje que deseas consultar.


Ejemplo de Uso con Postman
Para interactuar con estos endpoints usando Postman, sigue estos pasos:

Abrir Postman: Inicia la aplicación de Postman.

Seleccionar Método y URL: Selecciona el método HTTP (GET en la mayoría de los casos) y proporciona la URL base de tu aplicación Spring Boot seguida del endpoint específico.

Ejemplo de URL base local: http://localhost:8080

Enviar Consultas:

Buscar Personajes: Utiliza el endpoint /character/find/results con parámetros name y opcionalmente page.


URL: http://localhost:8080/character/find/results?name=Rick&page=1


Buscar Episodios: Utiliza el endpoint /episode/find/results con parámetros name o episode y opcionalmente page.


URL: http://localhost:8080/episode/find/results?name=Pilot&episode=S01E01&page=1


Buscar Ubicaciones: Utiliza el endpoint /location/find/results con parámetros name o type o dimension y opcionalmente page.

URL: http://localhost:8080/location/find/results?type=Planet

Detalles de Personaje, Episodio o Ubicación: Utiliza los endpoints /detail, /episode o /location con el parámetro id.

URL para detalle de personaje: http://localhost:8080/detail?id=1

URL para detalle de episodio: http://localhost:8080/episode?id=1

URL para detalle de ubicación: http://localhost:8080/location?id=1

Revisar Respuestas: Postman mostrará las respuestas de la API en formato JSON o HTML según cómo estén configuradas tus vistas en Spring Boot.

Consideraciones Adicionales
Asegúrate de que tu aplicación Spring Boot esté ejecutándose localmente en localhost en el puerto especificado (por defecto es 8080).
-Esta realizado con maven 
-version de openjdk 21 
