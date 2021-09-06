Feature: Shopping on Amazon Australia
  Scenario: User goes to Amazon Australia site and process shopping products
    Given I am on Amazon Australia site
    When I go to Home menu
    And I go to deal tab
    And I sort the Deals on Home Products by “Discount: High to Low”
    And I view Deal for second item
    And I click the link "click here to see current deals."
    Then I should be on Today's Deals
    When I sort the Today's Deals by “Discount: High to Low”
    And I click View second item
    And I add 5 items into the cart
    And I go back to Home page
    And I search for "AAA Batteries"
    And I sort the items by “Newest Arrivals”
    And I click on Newest Arrivals item
    And I add 2 items into the cart
    And I go to shopping cart
    Then I should see quantities of first item is 5 and second item is 2
    Then I should see prices of individual items is displayed
    Then I see total prices of 5 first item and 2 second item are calculated correctly
    And I edit the first item quantity to 3
    And I edit the second item quantity to 1
    And I delete the first item
    And I click “Proceed to Checkout”
    Then I have been navigated to Sign-In screen
