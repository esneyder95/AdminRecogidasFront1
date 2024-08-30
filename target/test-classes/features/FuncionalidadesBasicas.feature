@Funcionalidad_basicas
Feature: Usuario mapea funciones basicas

  @Funcionalidad_basicas @PruebasRegresion
  Scenario Outline: Cliente Regresa a tus recogidas antes de cotizar un preenvio
    Given Usuario frecuente ingresa a tus recogidas <Cedula> <Celular>
    When Regreso de cotiza tu envio
    Then El regreso es exitoso

    Examples:
      |    Cedula|   Celular|
      |1024567308|3005761988|

  @Funcionalidad_basicas @PruebasRegresion
  Scenario Outline: Cliente Regresa a tus recogidas antes de ingresar datos destinatario
    Given Usuario frecuente ingresa a tus recogidas <Cedula> <Celular>
    When Regreso de datos destinatario
    Then El regreso es exitoso

    Examples:
      |    Cedula|   Celular|
      |1024567308|3005761988|

  @Funcionalidad_basicas @PruebasRegresion
  Scenario Outline: Cliente Regresa a tus recogidas antes de ingresar nueva recogida
    Given Usuario frecuente ingresa a tus recogidas <Cedula> <Celular>
    When Regreso de nueva recogida
    Then El regreso es exitoso

    Examples:
      |    Cedula|   Celular|
      |1024567308|3005761988|

  @Funcionalidad_basicas @PruebasRegresion
  Scenario: Cliente nuevo Regresa a home antes ingresar la recogida
    Given Usuario nuevo ingresa a tus recogidas
    When Regreso a home
    Then El regreso a home es exitoso

  @Funcionalidad_basicas @PruebasRegresion
  Scenario Outline: Cliente frecuente Regresa a home antes ingresar la recogida
    Given Usuario frecuente ingresa a tus recogidas <Cedula> <Celular>
    When Usuario frecuente regresa a home
    Then El regreso a home es exitoso

    Examples:
      |    Cedula|   Celular|
      |1024567308|3005761988|

  @Funcionalidad_basicas @PruebasRegresion
  Scenario Outline: Cliente verifica cargue datos destinatario frecuente
    Given Un preenvio cotizado <Cedula> <Celular>
    When Ingreso nombre destinatario
    Then Se carga informacion del destinatario

    Examples:
      |    Cedula|   Celular|
      |1024567308|3005761988|

  @Funcionalidad_basicas @PruebasRegresion
  Scenario Outline: Cliente valida link de actualizar cuenta
    Given Preenvio cotizado pago en casa <Cedula> <Celular>
    When Ingeso link actualizar cuenta
    Then El link responde exitosamente

    Examples:
      |    Cedula|   Celular|
      |1024567308|3005761988|

  @Funcionalidad_basicas @PruebasRegresion
  Scenario Outline: Cliente agrega preenvio con geo
    Given Ingreso a la pagina de recogidas. <Cedula> <Celular> <Cliente agrega preenvio con geo>
    When Ingreso la informacion solicitada.
    Then la solicitud del preenvio es creada exitosamente <Cedula> <Cliente agrega preenvio con geo>

    Examples:
      |    Cedula|   Celular|
      |  41778013|3133160298|
      |1024567308|3005761988|
      |ClienteNue|ClienteNue|

  @Funcionalidad_basicas @PruebasRegresion
  Scenario Outline: Cliente asocia un preenvio
    Given Dado un listado de recogidas. <Cedula> <Celular>
    When asocio un preenvio
    Then El preenvio se asocia exitosamente <Cedula>

    Examples:
      |    Cedula|   Celular|
      |  41778013|3133160298|
      |1024567308|3005761988|
      |NuevoAsoci|NuevoAsoci|

  @Funcionalidad_basicas @PruebasRegresion
  Scenario Outline: Cliente agrega preenvio sin geo
    Given Ingreso a la pagina de recogidas. <Cedula> <Celular> <Cliente agrega preenvio sin geo>
    When Solicito la informacion solicitada.
    Then la solicitud del preenvio es creada exitosamente <Cedula> <Cliente agrega preenvio sin geo>

    Examples:
      |    Cedula|   Celular|
      |  41778013|3133160298|
      |1024567308|3005761988|
      |ClienteNue|ClienteNue|

  @Funcionalidad_basicas @PruebasRegresion
  Scenario: Cliente valida direccionamiento logo interrapidisimo
    Given Pagina principal de recogidas
    When  Selecciono logo de interrapidisimo
    Then  Direccionamineto pagina oficial interrapidismo exitosa

  @Funcionalidad_basicas @PruebasRegresion
  Scenario: Cliente valida direccionamiento politica tratamiento datos
    Given Usuario nuevo ingresa a tus recogidas
    When  Selecciono link tratamiento de politica datos
    Then  Direccionamineto politica datos exitosa

  @Funcionalidad_basicas @PruebasRegresion
  Scenario: Cliente valida direccionamiento terminos y condiciones
    Given Usuario nuevo ingresa a tus recogidas
    When  Selecciono link terminos y condiciones
    Then  Direccionamineto terminos y condiciones exitosa