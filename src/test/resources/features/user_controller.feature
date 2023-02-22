#language: es
#author: @AbelGuAr
#encoding: utf-8

@PruebaBE
Característica: Realizar una regresion para el proceso de User Controller

  Escenario: Consultar la lista de usuarios en el servicio
    Dado que Abel quiere acceder al servicio
    Cuando realiza la penticion get para la lista de usuarios
    Entonces verifica que el codigo HTTP sea 200
    Y el esquema de respuesta

  Escenario: Consultar un usuario por ID en el servicio
    Dado que Abel quiere acceder al servicio
    Cuando realiza la penticion get para la lista de usuarios
    Entonces verifica que el codigo HTTP sea 200
    Y el esquema de respuesta

  Escenario: Crear un usuario en el servicio
    Dado que Abel quiere acceder al servicio
    Cuando realiza la penticion get para la lista de usuarios
    Entonces verifica que el codigo HTTP sea 200
    Y el esquema de respuesta

  Escenario: Actualizar un usuario por ID en el servicio
    Dado que Abel quiere acceder al servicio
    Cuando realiza la penticion get para la lista de usuarios
    Entonces verifica que el codigo HTTP sea 200
    Y el esquema de respuesta

  Escenario: Eliminar un usuario en el servicio
    Dado que Abel quiere acceder al servicio
    Cuando realiza la penticion get para la lista de usuarios
    Entonces verifica que el codigo HTTP sea 200
    Y el esquema de respuesta