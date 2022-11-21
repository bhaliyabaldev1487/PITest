Feature: Filter by tag name & get the relative count & bountied 

  Scenario Outline: Get relative count & bountied count by tag name
    Given Visit Stackoverflow
    And Click on Side Top Menu Bar
    And Select Tags option
    When Search for tagname in filter section
    And Select exact match tag
    And List down all related tags
    Examples:
      | tagName |
      | python  |

