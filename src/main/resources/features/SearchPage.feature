@search
Feature: Amazon Search
  As a User on Amazon website
  I want to be able to search products using the search functionality
  So that I can see the list of valid results

  Background: Pre-requisite
    Given User navigates to Amazon
    Then User should be Amazon page

  Scenario: User searches for valid item
    Given User search for "iPhone"
    Then search results should contains "iPhone"

  Scenario: User searches for an invalid item
    Given User search for "adsfsfd"
    Then No results should returned
    And Message "did not match any products" should be displayed

  Scenario: User Search for an item and filters results
    Given User search for "iPhone"
    Then search results should contains "iPhone"
    When User Applies Category Filter "Mobile Phones & Smartphones"
    Then Results Should be Filtered with "Mobile Phones & Smartphones"

  Scenario Outline: User Search Results Sorting
    Given User search for "<SearchKeyword>"
    And Sort By "<SortBy>"
    Then Result should be Sorted By "<SortBy>"

    Examples: Results Sorting
      | SearchKeyword  | SortBy               |
      | Samsung Galaxy | Relevance            |
      | iPad 2         | Featured             |
      | iPhone 7       | Price: Low to High   |
      | Nokia Lumia    | Newest Arrivals      |
      | Apple Watch 2  | Relevance            |
      | Xbox one       | Avg. Customer Review |
      | PS4            | Release Date         |