Feature: Carrito de Compras

  @simularCarritoDeCompras
  Scenario: Hacer una compra y hacer el checkin
    Given El usuario ingresa al portal para comprar productos
    When  Ingresa el nombre del producto
    And   Avanzar hasta el checkin de la compra
    Then  Aparece mensaje de compra exitosa