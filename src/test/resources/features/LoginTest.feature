Feature: test login

  Background:



  @newTag
  Scenario Outline:
    Given the user is on the login page
    When the user enters correct "<username>" username
    And there is correct "<password>" password
    And the user click the login button
    Then verify the user logs in successfully

    Examples:
      | username     | password   |
      | Aika         | abc123     |
      | Harry Potter | xyz456     |
      | Barbie       | canHello1  |
      | B@rbie123    | Codewise1! |