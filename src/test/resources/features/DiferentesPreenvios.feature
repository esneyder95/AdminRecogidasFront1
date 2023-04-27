@Formulario_Prenvios
Feature:  Usuario crea prenvios diferentes modos de pago

  @PruebasAfectacion @PruebasRegresion
  Scenario Outline: Crear preenvio de contado
    Given Usuario frecuente ingresa a tus recogidas <Cedula> <Celular>
    When Ingreso datos de preenvio de contado
    Then El preenvio se crea exitosamente

    Examples:
    |    Cedula|   Celular|
    |1024567308|3005761988|

  @PruebasAfectacion @PruebasRegresion
  Scenario Outline: Crear preenvio pago en casa
    Given Usuario frecuente ingresa a tus recogidas <Cedula> <Celular>
    When Ingreso datos de preenvio pago en casa
    Then El preenvio se crea exitosamente

    Examples:
      |    Cedula|   Celular|
      |1024567308|3005761988|

  @PruebasAfectacion @PruebasRegresion
  Scenario Outline: Crear preenvio al cobro
    Given Usuario frecuente ingresa a tus recogidas <Cedula> <Celular>
    When Ingreso datos de preenvio al cobro
    Then El preenvio se crea exitosamente

    Examples:
      |    Cedula|   Celular|
      |1024567308|3005761988|

  @PruebasAfectacion @PruebasRegresion
  Scenario Outline: Crear preenvio con convenio
    Given Usuario frecuente ingresa a tus recogidas <Cedula> <Celular>
    When Ingreso datos de preenvio con convenio
    Then El preenvio se crea exitosamente

    Examples:
      |    Cedula|   Celular|
      |1024567308|3005761988|
