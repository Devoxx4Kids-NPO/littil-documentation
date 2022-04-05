Feature: Management of the teacher profile
  This feature contains registration, updating and deletion of a user account for teachers, including all profile data

  Scenario: A new user registers on the platform with only mandatory data
    Given user Iris is new to the platform
    When Iris indicates they want to register as a teacher
    Then they are presented with a registration form
    When they give their first name as Iris
    And their surname as de Bruin
    And their email as iris.de.bruin@outlook.com
    And their password as superSecret
    And their country as the Netherlands
    And indicates that they agree with the privacy statement
    And they confirm the registration
    Then they receive an email at iris.de.bruin@outlook.com asking to activate their account
    When they follow the activation instructions in the email
    Then their account is activated

  Scenario: A new user registers on the platform, completing their full profile
    Given user Jeffrey is new to the platform
    When Jeffrey indicates they want to register as a teacher
    Then they are presented with a registration form
    When they give their first name as Jeffrey
    And their surname as de Bruin
    And their email as jeffrey.wang@outlook.com
    And their password as superSecret
    And their post code as 3081
    And their country as the Netherlands
    And their available days as Monday,Wednesday,Friday
    And their preferences as Liefst alleen groep acht.
    And indicates that they agree with the privacy statement
    And they confirm the registration
    Then they receive an email at iris.de.bruin@outlook.com asking to activate their account
    When they follow the activation instructions in the email
    Then their account is activated

  Scenario: A user updates their profile data
    Given a user with email iris.de.bruin@outlook.com is known to the platform
    When this user logs into the system
    And indicates they want to change their profile
    Then they can update their first name to h and surname to u
    And update their password to super
    And update their post code to 5511
    And they receive a confirmation that the changes have been made

  Scenario: A user deletes their account
    Given a user with email iris.de.bruin@outlook.com is known to the platform
    When this user logs into the system
    And indicates that they want to delete their account
    And confirms their decision
    Then they receive email confirmation that the account has been deleted
    And they can no longer log in





