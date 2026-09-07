# Guía Práctica 4

Enviar datos inválidos produce una respuesta con status 400 (BAD REQUEST) ya que se definió la clase
**GlobalExceptionHandler** con la anotación *@RestControllerAdvice*, la cual indica a Spring Boot que siempre
que un controller no defina el error a devolver como parte de su endpoint, debe usar el método implementado
por dicha clase, que en este caso, usa el status HTTP 400.

1. ¿Qué diferencia existe entre @Controller y @RestController?

@Controller le indica a Spring Boot que los endpoints del controller anotado devuelven vistas HTML o fragmentos
de las mismas, lo cual se emplea en proyectos ***MVC*** (Model-View-Controller). @RestController, en cambio, le
indica a Spring Boot que el controller devuelve respuestas en formato JSON o XML, por lo que se usa sobre todo en
***APIs REST*** (si bien existen otras arquitecturas populares como SOAP y GraphQL).

2. ¿Qué función cumple @RequestBody?

Indica a Spring Boot que la solicitud del endpoint incluya en su cuerpo un objeto cuyo tipo sea correspondiente al
del argumento anotado, asignándole un nombre y permitiendo su uso dentro del método del endpoint.

3. ¿Por qué se utiliza @Valid junto al DTO?

Para que se apliquen las validaciones establecidas dentro del DTO (así como realizar validación recursiva, en caso de
que el DTO contenga otros objetos con sus propias validaciones).

4. ¿Qué código HTTP debe devolver un registro creado correctamente?

201 (CREATED).

5. ¿Cómo interviene Jackson en las respuestas de la API?

Permite la serialización (conversión de objetos de Java a JSON) y deserialización (conversión de JSON a objetos de Java)
de modo que cada endpoint pueda manejar ambos formatos según sea necesario.