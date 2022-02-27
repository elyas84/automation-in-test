@smoke
Feature: Create new note
  Background:
    Given user on the login page
    Then login form would be present in screen
    When user enter an valid email as "imtesting@gmail.com" and password as "123456A"
    Then note dashboard should displayed
    And user click on the plus icon


  Scenario: creates a new note
    And user types "React" in the title input and "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat." in the content area and click the done button
    Then created note should be displayed in list
    And user click on the account button
    When user click the logout button
    Then user should redirected to home page and url should be same with "https://evernote.com/logged-out/?logout&uid=232944305"

  Scenario: create a new note after logout
    When user types "React and Node.js" in the title input and "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat." in the content area and click the done button
    Then latest note should be present first place in the note list

