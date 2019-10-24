@Objects
  Feature: User - First name
    Scenario: User - First name : Alphanumeric and special characters
      Given I navigate to "registration" page
      When I type First name "abc123"
      And I type Last name "qwerty"
      And  I type group code "123"
      And I type email "email@gmail.com" on "registration" page
      And I type password "12345" on "registration" page
      And I type confirm password "12345"
      And I click Register me button
      Then message "You have been Registered."


    Scenario: User - First name : Field is required
      Given I navigate to "registration" page
      When I type Last name "qwerty"
      And  I type group code "123"
      And I type email "email@gmail.com" on "registration" page
      And I type password "12345" on "registration" page
      And I type confirm password "12345"
      And I click Register me button
      Then message "This field is required"