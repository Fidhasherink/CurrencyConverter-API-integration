##crrency converter
## Introduction
This Spring Boot application provides real-time currency conversion functionality by integrating with a public API.

## Prerequisites
- JDK 8 or above
- Maven 3.6+ (for building the project)
- Git (for cloning the repository)

## Installation

1. Clone the repository:
2. Build the application 
   (mvn clean install)
3. Run the application(i was using eclipse so right click the main method file and run as springboot application)
   mvn spring-boot:run
4.The application will run on http://localhost:8080.
## API Endpoints
(use postman )
1.GET /api/rates?base=USD
Fetches the exchange rates for the given base currency (default: USD).
use postman or run
"curl -X GET "http://localhost:8080/api/rates?base=USD"
2.POST /api/convert
Converts an amount from one currency to another using the fetched exchange rates.
Request Body:
{
  "from": "USD",
  "to": "EUR",
  "amount": 100
}
on postman or run 
"curl -X POST "http://localhost:8080/api/convert" -H "Content-Type: application/json" -d '{"from": "USD", "to": "EUR", "amount": 100}'"

## Error Handling
If the external API is unavailable, the system will return a 503 status code with an error message.
If invalid currency codes are provided, the system will return a 400 status code with a relevant error message.
## Unittest
Make sure to run the tests to verify that your service layer works correctly, especially for currency conversion logic and error handling.
for testing "mvn test"
right click and run as junit test
This setup will make it easy to run and test your currency converter application.
## API Documentation
https://exchangeratesapi.io/documentation/
Base url http://localhost:8080
1. GET /api/rates
This endpoint fetches the exchange rates for a given base currency (default is USD).

Request
Method: GET
URL: /api/rates?base={currency}
Query Parameters
base: (optional) The base currency (default is USD if not provided). Example: USD, EUR.
Example response (when base is USD):

{
    "base": "USD",
    "date": "2025-02-09",
    "rates": {
        "EUR": 0.85,
        "GBP": 0.75,
        "INR": 74.45,
        "JPY": 110.15
    }
}
Error Handling
Status: Error connecting to external API: 404 Not Found on GET request for "https://api.exchangerate-api.com/v4/latest/xyz": "{"result":"error","error_type":"unsupported_code"}"

2. POST /api/convert
This endpoint converts an amount from one currency to another using the fetched exchange rates.

Request
Method: POST
URL: /api/convert
Content-Type: application/json
Request Body

{
    "from": "USD",
    "to": "EUR",
    "amount": 100
}
from: The base currency to convert from (e.g., USD, EUR).
to: The target currency to convert to (e.g., USD, EUR).
amount: The amount to convert.

