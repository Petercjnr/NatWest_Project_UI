Feature: Filtering UI and extracting data for comparison

  Scenario: As a user can filter and extract data for comparison
    Given Browser is open
    Then Enter URl
    Then Click on show rows by 20
    Then capture page contents - price, name, market cap
    Then filter by Algorithm - "PoW", followed by "+ Add Filter" and toggle "Mineable"
    Then select "All Cryptocurrencies" and select "Coins"
    Then select price and set minimum value to 100 and maximum to 10,000
    Then compare page content to the content in step 3