@firstTag
Feature: verify login functionality


  Scenario: User logs in with valid credentials
    Given correct username "Aika"
    And correct password "Abc123"
    When  user clicks login button
    Then  user logs in


  Scenario: User logs in with invalid credentials
    Given incorrect username "Aikaaa"
    And incorrect password "123456"
    When  user clicks login button
    Then  user does not log in

    @firstOutline
  Scenario Outline:
    Given correct "<username>" username
    And correct "<password>" password
    When user is clicking login button
    Then verify user logs in
    Examples:
      | username     | password   |
      | Aika         | abc123     |
      | Harry Potter | xyz456     |
      | Barbie       | canHello1  |
      | B@rbie123    | Codewise1! |