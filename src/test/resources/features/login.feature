Feature: Iniciar Sesión

  @LoginExitoso
Scenario Outline: Iniciar sesión de forma exitosa
  Given El usuario Hugo Alberto desea iniciar sesion en la aplicacion
  When Ingresa el usuario <usuario> y contrasena <contrasena>
  Then Ingresa a pagina principal y valida el usuario <usuarioLogueado>
  Examples:
  |usuario             |contrasena | usuarioLogueado     |
  |"056.0@hotmail.com" |"123456"   | prueba automatizada |