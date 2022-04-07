Feature: Registrar usuario

  @registrarUsuarioExitosamente
  Scenario Outline: Registro de usuario exitoso
    Given El usuario ingresa a la página para registrarse
    When el usuario digita su correo electrónico "<email>" y hace clic en crear cuenta
    Then Diligencia el formulario de registro y hace clic en el botón registrarse
      |<firstname>|<lastname>|<email>|<password>|<address>|<zipcode>|<country>|<state>|<city>|<celular>|
    And  Se visualiza el nombre de usuario exitosamente "<usuarioLogueado>"
    Examples:
      | firstname | lastname   | email                 | password | address           | zipcode | country         | state          | city          | celular      | usuarioLogueado |
      | hugo      | martinez   | hugo002@hugo002.com   | 123456   | calle falsa 123   | 00000   | United States   | North Dakota   | Grand Forks   | 3003003003   | hugo martinez    |

  @registrarUsuarioExitosamenteConExcelFile
  Scenario: Registro de usuario exitoso
    Given El usuario ingresa a la página para registrarse
    When el usuario ingresa los datos de registro desde Excel
    Then  Se visualiza el nombre de usuario exitosamente