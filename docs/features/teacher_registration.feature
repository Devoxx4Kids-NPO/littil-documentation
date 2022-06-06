Feature: Management of the teacher profile
  This feature contains registration, updating and deletion of a user account for teachers, including all profile data

  Scenario: A new user registers on the platform with only mandatory data
    Given user Iris is new to the platform
    When Iris indicates she wants to register as a teacher
    Then she is presented with a registration form
    When she gives her first name as Iris
    And her surname as de Bruin
    And her email as iris.de.bruin@outlook.com
    And her password as superSecret
    And her country as the Netherlands
    And indicates that she agrees with the privacy statement
    And she confirms the registration
    Then she receives an email at iris.de.bruin@outlook.com asking to activate her account
    When she follows the activation instructions in the email
    Then her account is activated
    And she can log in with email iris.de.bruin@outlook.com and password superSecret

  Scenario: A new user registers on the platform, completing her full profile
    Given user Jeffrey is new to the platform
    When Jeffrey indicates he wants to register as a teacher
    Then he is presented with a registration form
    When he gives his first name as Jeffrey
    And his surname as Wang
    And his email as jeffrey.wang@outlook.com
    And his password as superSecret
    And his post code as 3081
    And his country as the Netherlands
    And his available days as Monday,Wednesday,Friday
    And his profile text as Liefst alleen groep acht.
    And indicates that he agrees with the privacy statement
    And he confirms the registration
    Then he receives an email at jeffrey.wang@outlook.com asking to activate his account
    When he follows the activation instructions in the email
    Then his account is activated



