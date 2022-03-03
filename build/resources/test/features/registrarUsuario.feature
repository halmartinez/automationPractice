Feature: Registrar usuario
  @registrarUsuarioExitosamente
  Scenario Outline: Registro de usuario exitoso
    Given El usuario ingresa a la página para registrarse
    When el usuario intruce los datos requeridos y hace clic en registrarse
      |<firstname>|<lastname>|<email>|<password>|<address>|<zipcode>|<country>|<state>|<city>|
    Then Aparece mensaje de registroso
    Examples:
    |firstname|lastname|email|password|address|zipcode|country|state|city|
    |hugo     |martinez|hugo001@hugo001.com|123456  |calle falsa 123|00000|Colombia|Bolivar|Cartagena|