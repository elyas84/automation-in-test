@smoke
Feature: Testing for login page

  Background:
    Given user on the login page
    Then login form would be present in screen

  Scenario: login without email
    When user login without any email
    Then user see the error message "Required data missing"

  Scenario: login without password
    When user enter an valid email as "imtesting@gmail.com" and password as ""
    Then user see the error message "This is a required field."

  Scenario: login with invalid email
    When user enter an invalid email as "imtestingnow@gmail.com"
    Then user see the error message "There is no account for the username or email you entered."


  Scenario: login with valid email bad password
    When user enter an valid email as "imtesting@gmail.com" and bad password as "123456"
    Then user see the error message "Incorrect password. You modified your password 3 days ago."

  Scenario: Successful login
    When user enter an valid email as "imtesting@gmail.com" and password as "123456A"
    Then note dashboard should displayed