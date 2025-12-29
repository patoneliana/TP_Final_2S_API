Feature: TimeTraker

  Background:
    Given apiKey asignado igual a "NWIxNWRmNDUtMDMzNS00NDcwLWI1NjktY2I2MjcxNzdkZjQz"
    And workspaces asignado igual a "694ea2a3b7eb812c95e4f2af"
    And user asignado igual a "694ea2a3b7eb812c95e4f2b5"


  @TimeTraker @TimeTraker-obtieneHoras
  Scenario Outline: Consultar horas registradas
    When '<operation>' en clockify, para entidad '<entity>', la uri '<jsonName>' y parametros ''
    Then validar que el status code sea 200
    And se lista las horas que estan registradas

    Examples:
      | operation | entity     | jsonName   |
      | GET       | TIMETRAKER | TimeTraker |

  @TimeTraker @TimeTraker-agregaHoras
  Scenario Outline: Agregar horas a un proyecto
    Given registro hora inicio "<start>", fin "<end>" y una descripcion "<description>"
    When '<operation>' en clockify, para entidad '<entity>', la uri '<jsonName>' y parametros ''
    Then validar que el status code sea 201
    And se registra la hora con inicio "<start>", fin "<end>" , "<description>" y duracion "<duration>"

    Examples:
      | operation | entity     | jsonName   | start                | end                  | description        | duration |
      | POST      | TIMETRAKER | TimeTraker | 2025-12-25T10:00:00Z | 2025-12-25T11:00:00Z | Horas EBPG TP Final 2S  | PT1H     |


  @TimeTraker @TimeTraker-editHoras
  Scenario Outline: Editar un registro de hora
    Given registro hora inicio "2025-12-25T10:00:00Z", fin "2025-12-25T11:00:00Z" y una descripcion "Horas EBPG TP Final 2S"
    And 'POST' en clockify, para entidad 'TIMETRAKER', la uri 'TimeTraker' y parametros ''
    And se registra la hora cargada
    When registro hora inicio "<start>", fin "<end>" y una descripcion "<description>"
    And '<operation>' en clockify, para entidad '<entity>', la uri '<jsonName>' y parametros ''
    Then validar que el status code sea 200
    And se registra la hora con inicio "<start>", fin "<end>" , "<description>" y duracion "<duration>"

    Examples:
      | operation | entity      | jsonName    | start                | end                  | description            | duration |
      | PUT       | TIMEENTRIES | TimeEntries | 2025-12-25T10:00:00Z | 2025-12-25T11:00:00Z | Horas EBPG TP Final 2S | PT1H     |


  @TimeTraker @TimeTraker-eliminaHoras
  Scenario Outline: Eliminar hora registrada
    Given registro hora inicio "2025-12-25T10:00:00Z", fin "2025-12-25T11:00:00Z" y una descripcion "Horas EBPG TP Final 2S"
    And 'POST' en clockify, para entidad 'TIMETRAKER', la uri 'TimeTraker' y parametros ''
    And se registra la hora cargada
    When '<operation>' en clockify, para entidad '<entity>', la uri '<jsonName>' y parametros ''
    Then validar que el status code sea 204

    Examples:
      | operation | entity      | jsonName    |
      | DELETE    | TIMEENTRIES | TimeEntries |
