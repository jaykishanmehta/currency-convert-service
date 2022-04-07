
# currency-convert-service

This is a currency converter service drafted as a demo to convert money between two currency.




## API Reference

#### Get available currencies

```http
  GET /api/available-currencies
```
#### Get available conversions

```http
  GET /api/available-conversions
```

#### Convet currency

```http
  POST /api/convert-currency
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `from`      | `string` | **Required**. From currency |
| `to`      | `string` | **Required**. To currency |
| `amount`      | `double` | **Required**. Amount to convert |



## Features

- Spring Boot: application framework
- Flyway: Database migration
- Postgres: Database engine with flyway setup
- JPA: Persistance access
- JUnit: test runner
- Hamcrest Matchers: assertions
- Lombok: Avoid Boilerplate code
- Mockito: Mocking tests
- MockMVC: testing Spring MVC controllers
- Docker: Containerization
- Postman: Run test cases collection

## Available profiles: [DEV] Dev Environment [PROD] Stage Environment [TEST] Test cases

## Authors

- [@jaykishanmehta](https://www.github.com/jaykishanmehta)

