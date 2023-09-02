@smoke
Feature: Google search functionality
  User Story: As a user, when I am on the google page
  I should be able to search whatever I want and see relevant information

  Background:
    Given user is on the google page


  @orange @googlesearch
  Scenario: Google search testing orange
    #Given user is on the google page
    When user types orange in th google search box and clicks enter
    Then user sees orange in the page title

  @smoke @apple @googlesearch @db
  Scenario: Google search testing apple
    #Given user is on the google page
    When user types apple in th google search box and clicks enter
    Then user sees apple in the page title


      #parameterization eliminates hardcoding
  @param
  Scenario: Google search testing param
    #Given user is on the google page
    When user types "java" in th google search box and clicks enter
    Then user sees "java" in the page title

  @dataTable
  Scenario: Google search testing data table
    Then user should be able to search for following:
      | Java     |
      | Selenium |
      | Cucumber |
      | SDET     |
      | QA       |