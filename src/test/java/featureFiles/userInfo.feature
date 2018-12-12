Feature: Purpose of this feature is to verify the user details,create users and update exiting uset details

  Background:
    Given I have uri of the resource

  @Tag1
  Scenario Outline: Verify the name “George” Is appearing in get request response
    When I send a get request to resource
    Then I should get a response form the server and <nameToVerify> name should be present in the response received
    Examples:
      | nameToVerify |
      | George       |

  @Tag1
  Scenario Outline: Veriyf if new user is added to existing list of users
    When I send create request to users resource with <name> <job>
    Then New user should get created with <name> <job>
    Examples:
      | name     | job    |
      | morpheus | leader |

  @Tag1
  Scenario Outline: Veriyf if new user is able to update user details from existing list of users
    When I send update request to users resource with <firstName> <lastName> <userIdex>
    Then New user should get created with <firstName> <lastName>
    Examples:
      | firstName    | lastName    | userIdex |
      | newFirstName | newLastName | 2        |

  @Tag
  Scenario Outline: Veriyf if new user is able to delete the user details from existing list of users
    When I send delete request to users resource with <userIdex>

    Examples:
      | userIdex |
      | 1        |