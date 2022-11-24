@FuncionalidadEditar
  Feature: Usuarios edita recogida

    @FuncionalidadEditar @PruebasRegresion
    Scenario Outline: Cliente edita recogida
      Given Dado un listado de recogidas <Cedula> <Celular>
      When Edito una recogida
      Then La recogida se edita exitosamente <Cedula>

      Examples:
        |    Cedula|   Celular|
        |1024567308|3105761988|
        |1024567208|3105761928|
        |NuevoEdita|NuevoEdita|

    @FuncionalidadEditar @PruebasRegresion
    Scenario Outline: Cliente Agrega un preenvio
      Given Dado un listado de recogidas <Cedula> <Celular>
      When Agrego un preenvio
      Then la solicitud del preenvio es creada exitosamente <Cedula>

      Examples:
        |    Cedula|   Celular|
        |1024567308|3105761988|
        |1024567208|3105761928|
        |NuevoAgreg|NuevoAgreg|

    @FuncionalidadEditar @PruebasRegresion
    Scenario Outline: Cliente borra un preenvio
      Given Dado un listado de recogidas <Cedula> <Celular>
      When Borro un preenvio
      Then El preenvio se borra exitosamente <Cedula>

      Examples:
        |    Cedula|   Celular|
        |1024567308|3105761988|
        |1024567208|3105761928|
        |NuevoBorra|NuevoBorra|

    @FuncionalidadEditar @PruebasRegresion
    Scenario Outline: Cliente desasocia un preenvio
      Given Dado un listado de recogidas <Cedula> <Celular>
      When Desasocio un preenvio
      Then El preenvio se desasocia exitosamente <Cedula>

      Examples:
        |    Cedula|   Celular|
        |1024567308|3105761988|
        |1024567208|3105761928|
        |NuevoDesas|NuevoDesas|

    @FuncionalidadEditar @PruebasRegresion
    Scenario Outline: Cliente cancela recogida
      Given Dado un listado de recogidas <Cedula> <Celular>
      When Cancelo una recogida
      Then Se cancela la recogida exitosamente <Cedula>

      Examples:
        |    Cedula|   Celular|
        |1024567308|3105761988|
        |1024567208|3105761928|
        |NuevoCance|NuevoCance|
