Feature: Manage the lifecycle of a teacher profile

  Background:
    * configure cors = true
    * configure responseDelay = 300

  Scenario: methodIs('get') && pathMatches('/api/v1/teacher/{id}')
    * def response = read('teacher.json')

  Scenario: methodIs('get') && pathMatches('/api/v1/teacher')
    * def response = 401

  Scenario: methodIs('post') && pathMatches('/api/v1/teacher')
    * def response = {'message': 'Teacher created'}

  Scenario: methodIs('put') && pathMatches('/api/v1/teacher')
    * def response = {'message': 'Teacher updated'}

  Scenario: methodIs('delete') && pathMatches('/api/v1/teacher/{id}')
    * def response = {'message': 'Teacher deleted'}
