@Funcional_CrearPreenvios
Feature: Usuarios crea nueva recogidas y preenvios

  @Funcional_CrearPreenvios @PruebasRegresion
  Scenario Outline: Usuario diligencia formulario de recogida.
    Given Ingreso a la pagina de recogidas. <Cedula> <Celular>
    When Usuario crea una Nueva recogida.
    Then La recogida se crea exitosa con su numero de solicitud. <Cedula>

    Examples:
      |    Cedula|   Celular|
      |1024567308|3105761988|
      |1024567208|3105761928|
      |ClienteNue|ClienteNue|

  @Funcional_CrearPreenvios @PruebasRegresion
  Scenario Outline: Usuario diligencia formulario de preenvio.
    Given Ingreso a la opcion de Agregar Preenvios de una nueva recogida. <Cedula> <Celular>
    When Ingreso la informacion solicitada
    Then la solicitud del preenvio es creada exitosamente <Cedula>

    Examples:
      |    Cedula|   Celular|
      |1024567308|3105761988|
      |1024567208|3105761928|
      |ClienteNue|ClienteNue|

  @Funcional_CrearPreenvios @PruebasRegresion
  Scenario Outline: Usuario Agrega otro preenvio.
    Given Ingreso a la opcion de Agregar otro preenvio de una nueva recogida. <Cedula> <Celular>
    When Ingreso la informacion solicitada
    Then la solicitud del preenvio es creada exitosamente <Cedula>

    Examples:
      |    Cedula|   Celular|
      |1024567308|3105761988|
      |1024567208|3105761928|
      |ClienteNue|ClienteNue|