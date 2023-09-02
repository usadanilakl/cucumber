Feature: Search for stock with good financial statistics
  Background:
    Given user is on yahoo finance page
    @yahoo
    Scenario: get to equaty screener
      When user clicks on "Screeners" and selects equaty screener
      Then user is on the new screener page with title Free Stock Screener
