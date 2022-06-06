Feature: Management of the teacher profile
  This feature contains registration, updating and deletion of a user account for teachers, including all profile data

  Background:
    Given a user with email iris.de.bruin@outlook.com is known to the platform
  
  Scenario: Iris updates her account data
    When Iris logs into the system
    And indicates she wants to change her profile
    Then she can update her first name to Irina and surname to de Zwart
    And her password to Bienvenu123
    And her post code to 5511
    And her profile text to Liefst alleen groep drie en vier
    And her available days as Tuesday,Thursday
    Then her account details are updated

  Scenario: Iris updates her email
    When Iris logs into the system
    And indicates she wants to change her email
    Then she can update her email to iris.de.bruin@gmail.com
    And she receives an email at iris.de.bruin@gmail.com confirming the change

   Scenario: Iris has forgotten her password
     When Iris indicates she has forgotten her password
     Then she can enter her email as iris.de.bruin@gmail.com
     And she receives an email at iris.de.bruin@gmail.com with a link to a password page
     When she follows the link to the password reset page
     Then she can enter a new password as updatedPwd
     And she can log in with email iris.de.bruin@outlook.com and password updatedPwd

  Scenario: Iris wants to delete her account
    When Iris logs into the system
    And indicates that she wants to delete her account
    And confirms her decision to delete
    Then she receives email confirmation that the account has been deleted
    And she can no longer log in





