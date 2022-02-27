@smoke
Feature: Login link

  Scenario: login link is present and clickable on the home page
    Given user launch the browser
    When user navigates to the home page
    Then login link should be displayed

