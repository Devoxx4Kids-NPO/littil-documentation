Feature: Management of the teacher profile

  Background:
    # This feature contains registration, updating and deletion of a user account for teachers, including all profile data

  Scenario: A new user registers themselves on the platform
    Given user Jane is new to the platform
    When Jane indicates she wants to register as a teacher
    Then she is presented with a registration form
    When she gives her first name as Jane
    And her surname as Doe
    And her password as superSecret
    And again as superSecret
    And her postcode as 5591
    And her country as the Netherlands
    And indicates that she agrees with the privacy statement
    And she confirms the registration
    Then she receives a confirmation email
    When she follows the instructions in the email
    Then her account is activated


  Scenario: A user updates their profile data


  Scenario: A user deletes their account




