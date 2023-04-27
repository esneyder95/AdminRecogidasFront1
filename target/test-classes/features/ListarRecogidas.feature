@ListarRecogidas
Feature: Usuario valida funcionalidades de listar recogidas:

  @ListarRecogidas @PruebasRegresion
 Scenario Outline: Cliente filtra recogida por ID
    Given Un listado de recogidas <Cedula> <Celular>
    When Filtro por ID de recogida
    Then La tabla filtra la recogida escogida

    Examples:
      |    Cedula|   Celular|
      |  41778013|3133160298|
      |1024567308|3005761988|

  @ListarRecogidas @PruebasRegresion
  Scenario Outline: Cliente filtra recogida por activas
    Given Un listado de recogidas <Cedula> <Celular>
    When Filtro por recogidas activas
    Then La tabla filtra por recogidas activas

    Examples:
      |    Cedula|   Celular|
      |  41778013|3133160298|
      |1024567308|3005761988|

  @ListarRecogidas @PruebasRegresion
  Scenario Outline: Cliente filtra recogida por finalizadas
    Given Un listado de recogidas <Cedula> <Celular>
    When Filtro por recogidas finalizadas
    Then La tabla filtra por recogidas finalizadas

    Examples:
      |    Cedula|   Celular|
      |  41778013|3133160298|
      |1024567308|3005761988|

  @ListarRecogidas @PruebasRegresion
  Scenario Outline: Cliente cancela recogida desde el listado
    Given Un listado de recogidas <Cedula> <Celular>
    When Cancelo la recogida
    Then Se cancela la recogida exitosamente

    Examples:
      |    Cedula|   Celular|
      |  41778013|3133160298|
      |1024567308|3005761988|
      |NuevoCance|NuevoCance|