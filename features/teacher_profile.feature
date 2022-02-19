Feature: Management of the teacher profile
  This feature contains registration, updating and deletion of a user account for teachers, including all profile data

  Scenario: A new user registers themselves on the platform
    Given user Iris is new to the platform
    When Iris indicates she wants to register as a teacher
    Then she is presented with a registration form
    When she gives her first name as Iris
    And her surname as de Bruin
    And her email as iris.de.bruin@outlook.com
    And her password as superSecret
    And her post code as 5591
    And her country as the Netherlands
    And indicates that she agrees with the privacy statement
    And she confirms the registration
    Then she receives an email at iris.de.bruin@outlook.com asking to activate her account
    When she follows the activation instructions in the email
    Then her account is activated


  Scenario: A user updates their profile data
    Given a user with email iris.de.bruin@outlook.com is known to the platform
    When this user logs into the system
    And indicates she wants to change her profile
    Then she can update her first name and surname
    And update her password
    And update her post code
    And she receives a confirmation that the changes have been made



  Scenario: A user deletes their account
    Given a user with email iris.de.bruin@outlook.com is known to the platform
    When this user logs into the system
    And indicates that they want to delete their account
    And confirm their decision
    Then they receive email confirmation that the account has been deleted
    And they can no longer log in





