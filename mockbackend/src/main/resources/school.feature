Feature: Manage the lifecycle of a teacher profile

  Background:
    * configure cors = true
    * configure responseDelay = 300

  Scenario: methodIs('get') && pathMatches('/teacher/{id}')
    * def response = read('teacher.json')

  Scenario: methodIs('get') && pathMatches('/teacher')
    * def response = 401

  Scenario: methodIs('post') && pathMatches('/teacher')
    * def response = {'message': 'Teacher created'}

  Scenario: methodIs('put') && pathMatches('/teacher')
    * def response = {'message': 'Teacher updated'}

  Scenario: methodIs('delete') && pathMatches('/teacher/{id}')
    * def response = {'message': 'Teacher deleted'}
