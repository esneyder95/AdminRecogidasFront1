@FuncionalidadEditar
  Feature: Usuarios edita recogida

    @FuncionalidadEditar @PruebasRegresion
    Scenario Outline: Cliente edita recogida
      Given Dado un listado de recogidas <Cedula> <Celular>
      When Edito una recogida
      Then La recogida se edita exitosamente <Cedula>

      Examples:
        |    Cedula|   Celular|
        |  41778013|3133160298|
        |1024567308|3005761988|
        |NuevoEdita|NuevoEdita|

    @FuncionalidadEditar @PruebasRegresion
    Scenario Outline: Cliente Agrega un preenvio
      Given Dado un listado de recogidas <Cedula> <Celular>
      When Agrego un preenvio
      Then la solicitud del preenvio es creada exitosamente <Cedula> <Cliente Agrega un preenvio>

      Examples:
        |    Cedula|   Celular|
        |  41778013|3133160298|
        |1024567308|3005761988|
        |NuevoAgreg|NuevoAgreg|

    @FuncionalidadEditar @PruebasRegresion
    Scenario Outline: Cliente borra un preenvio
      Given Dado un listado de recogidas <Cedula> <Celular>
      When Borro un preenvio
      Then El preenvio se borra exitosamente <Cedula>

      Examples:
        |    Cedula|   Celular|
        |  41778013|3133160298|
        |1024567308|3005761988|
        |NuevoBorra|NuevoBorra|

    @FuncionalidadEditar @PruebasRegresion
    Scenario Outline: Cliente desasocia un preenvio
      Given Dado un listado de recogidas <Cedula> <Celular>
      When Desasocio un preenvio
      Then El preenvio se desasocia exitosamente <Cedula>

      Examples:
        |    Cedula|   Celular|
        |  41778013|3133160298|
        |1024567308|3005761988|
        |NuevoDesas|NuevoDesas|

    @FuncionalidadEditar @PruebasRegresion
    Scenario Outline: Cliente cancela recogida
      Given Dado un listado de recogidas <Cedula> <Celular>
      When Cancelo una recogida
      Then Se cancela la recogida exitosamente <Cedula>

      Examples:
        |    Cedula|   Celular|
        |  41778013|3133160298|
        |1024567308|3005761988|
        |NuevoCance|NuevoCance|
