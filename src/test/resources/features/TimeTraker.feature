Feature: TimeTraker

  Background:
    Given apiKey asignado igual a "YmUyM2EzOWMtOWU2MC00MjU5LWEzYTItNzg5YTNlOTMxYmU2"
    And workspaces asignado igual a "682f1ed9cbd5cc1e33afb613"
    And user asignado igual a "680fe3274909a95ea6e0ac8d"


  @TimeTraker @TimeTraker-get @Smoke
  Scenario Outline: Consultar horas registradas
    When '<operation>' a la API clockify, para entidad '<entity>', la uri '<jsonName>' y parametros ''
    Then validar que el status code sea 200
    And se muestra lista de horas registradas

    Examples:
      | operation | entity     | jsonName   |
      | GET       | TIMETRAKER | TimeTraker |

  @TimeTraker @TimeTraker-post @Smoke
  Scenario Outline: Agregar horas a un proyecto
    Given registro hora inicio "<start>", fin "<end>" y una descripcion "<description>"
    When '<operation>' a la API clockify, para entidad '<entity>', la uri '<jsonName>' y parametros ''
    Then validar que el status code sea 201
    And se registra la hora con inicio "<start>", fin "<end>" , "<description>" y duracion "<duration>"

    Examples:
      | operation | entity     | jsonName   | start                | end                  | description                         | duration |
      | POST      | TIMETRAKER | TimeTraker | 2025-06-25T10:00:00Z | 2025-06-25T11:00:00Z | Desarrollo de pruebas automatizadas | PT1H     |


  @TimeTraker @TimeTraker-put @Smoke
  Scenario Outline: Editar un campo de algún registro de hora
    Given registro hora inicio "2025-06-25T10:00:00Z", fin "2025-06-25T11:00:00Z" y una descripcion "Desarrollo de pruebas automatizadas"
    And 'POST' a la API clockify, para entidad 'TIMETRAKER', la uri 'TimeTraker' y parametros ''
    And se registra la hora cargada
    When registro hora inicio "<start>", fin "<end>" y una descripcion "<description>"
    And '<operation>' a la API clockify, para entidad '<entity>', la uri '<jsonName>' y parametros ''
    Then validar que el status code sea 200
    And se registra la hora con inicio "<start>", fin "<end>" , "<description>" y duracion "<duration>"

    Examples:
      | operation | entity      | jsonName    | start                | end                  | description                         | duration |
      | PUT       | TIMEENTRIES | TimeEntries | 2025-06-27T10:00:00Z | 2025-06-27T11:00:00Z | Desarrollo de pruebas automatizadas | PT1H     |


  @TimeTraker @TimeTraker-delete @Smoke
  Scenario Outline: Eliminar hora registrada
    Given registro hora inicio "2025-06-25T10:00:00Z", fin "2025-06-25T11:00:00Z" y una descripcion "Desarrollo de pruebas automatizadas"
    And 'POST' a la API clockify, para entidad 'TIMETRAKER', la uri 'TimeTraker' y parametros ''
    And se registra la hora cargada
    When '<operation>' a la API clockify, para entidad '<entity>', la uri '<jsonName>' y parametros ''
    Then validar que el status code sea 204

    Examples:
      | operation | entity      | jsonName    |
      | DELETE    | TIMEENTRIES | TimeEntries |
