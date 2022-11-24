@Funcionalidad_basicas
Feature: Usuario mapea funciones basicas

  @Funcionalidad_basicas @PruebasRegresion
  Scenario: Cliente Regresa a tus recogidas antes de cotizar un preenvio
    Given Usuario frecuente ingresa a tus recogidas
    When Regreso de cotiza tu envio
    Then El regreso es exitoso

  @Funcionalidad_basicas @PruebasRegresion
  Scenario: Cliente Regresa a tus recogidas antes de ingresar datos destinatario
    Given Usuario frecuente ingresa a tus recogidas
    When Regreso de datos destinatario
    Then El regreso es exitoso

  @Funcionalidad_basicas @PruebasRegresion
  Scenario: Cliente Regresa a tus recogidas antes de ingresar nueva recogida
    Given Usuario frecuente ingresa a tus recogidas
    When Regreso de nueva recogida
    Then El regreso es exitoso

  @Funcionalidad_basicas @PruebasRegresion
  Scenario: Cliente nuevo Regresa a home antes ingresar la recogida
    Given Usuario nuevo ingresa a tus recogidas
    When Regreso a home
    Then El regreso a home es exitoso

  @Funcionalidad_basicas @PruebasRegresion
  Scenario: Cliente frecuente Regresa a home antes ingresar la recogida
    Given Usuario frecuente ingresa a tus recogidas
    When Usuario frecuente regresa a home
    Then El regreso a home es exitoso

  @Funcionalidad_basicas @PruebasRegresion
  Scenario: Cliente verifica cargue datos destinatario frecuente
    Given Un preenvio cotizado
    When Ingreso nombre destinatario
    Then Se carga informacion del destinatario

  @Funcionalidad_basicas @PruebasRegresion
  Scenario: Cliente valida link de actualizar cuenta
    Given Un preenvio cotizado pago en casa
    When Ingeso link actualizar cuenta
    Then El link responde exitosamente

  @Funcionalidad_basicas @PruebasRegresion
  Scenario Outline: Cliente agrega preenvio
    Given Ingreso a la pagina de recogidas. <Cedula> <Celular>
    When Ingreso la informacion solicitada.
    Then la solicitud del preenvio es creada exitosamente <Cedula>

    Examples:
      |    Cedula|   Celular|
      |1024567308|3105761988|
      |1024567208|3105761928|
      |ClienteNue|ClienteNue|

  @Funcionalidad_basicas @PruebasRegresion
  Scenario Outline: Cliente asocia un preenvio
    Given Dado un listado de recogidas <Cedula> <Celular>
    When asocio un preenvio
    Then El preenvio se asocia exitosamente <Cedula>

    Examples:
      |    Cedula|   Celular|
      |1024567308|3105761988|
      |1024567208|3105761928|
      |NuevoAsoci|NuevoAsoci|