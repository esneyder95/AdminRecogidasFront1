@Funcional_CVS
Feature: Crear Recogidas + Crear preenvio archivos CVS

  @Formulario_CVS_POS
  Scenario: Crear preenvios para pruebas POS
    Given Usuario ingresa a tus recogidas
    When  Ingreso los diferentes preenvios
    Then  Creo data pruebas POS

  @Formulario_CVS_APP
 Scenario Outline: Crear preenvios para pruebas de APP
    Given Ingreso a la pagina de recogidas. <Cedula> <Celular>
    When  Ingreso diferentes preenvios <Cedula> <Celular>
    Then  Creo data de formularios exitosos

    Examples:
      |    Cedula|   Celular|
      |1024567308|3105761988|
      |1024567208|3105761928|
      | 900456789|3105761988|