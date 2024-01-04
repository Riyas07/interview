@pet
  Feature: To handle the pet requests
    Scenario Outline: To send the Pet Post request
      Given wite payload with following details
      |id       |name    |status   |
      | <ids> |<name>|<status>|
      When add the category
      |id|name  |
      |0 |string|
      Then add the photoUrls
      |photoUrls|
      |String   |
      Then add the tags
        |id|name  |
        |0 |string|
      Then generate payload
      Then trigger the request and validate the responses
      Examples:
      |ids| name|status|
      |1  |riyas|available|
      |2 | sam | notavailable|
      |3 |jack |available    |
