@Web
Feature: BlazeDemo
  Scenario: select a samsung phone
    Given user is on the BlazeDemo page
    When user select a phone samsung galaxy
    Then user should see the samsung description
    And user add to chart
    And user should see message "Product added"

  Scenario: Sign Up
    Given user is on the BlazeDemo page
    When user click on Sign Up
    And user fill the username "nadif"
    And user fill the password "1234"
    And user click on SignupForm
    Then user should see Sign Up message "Sign up successful."

  Scenario: Log In
    Given user is on the BlazeDemo page
    When user click on Log In
    And user fill the loginusername "nadif"
    And user fill the loginpassword "1234"
    And user click on LoginForm
    Then user should see Log In message "Thanks for the message!!"

  Scenario: Log in Invalid
    Given user is on the BlazeDemo page
    When user click on Log In
    And user fill the loginusername "nadif"
    And user fill the loginpassword "invalid"
    And user click on LoginForm
    Then user should see Log In message "Wrong password."

  Scenario: Check categories
    Given user is on the BlazeDemo page
    When user click on phones
    Then user should see phone option
    When user click on laptops
    Then user should see laptop option