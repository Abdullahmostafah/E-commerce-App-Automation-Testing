@smoke
Feature: F03_ResetPassword

  Scenario: SC3- User could reset his/her password successfully

    Given user had an actual account
    And user goes to home page

    When user pressed on Log-in link in the header
    And user presses on forgot password link
    And user enters email address in login page
    And user presses on Recover button

    Then display message "Email with instructions has been sent to you."at the top for user