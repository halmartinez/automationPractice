#language: es
Característica: Iniciar Sesión

  @LoginExitoso
Esquema del escenario: Iniciar sesión de forma exitosa
  Dado El usuario Hugo Alberto desea iniciar sesion en la aplicacion
  Cuando Ingresa el usuario <usuario> y contrasena <contrasena>
  Entonces Ingresa a pagina principal y valida el usuario <usuarioLogueado>
  Ejemplos:
  |usuario             |contrasena | usuarioLogueado |
  |"056.0@hotmail.com" |"123456"   | prueba automatizada |