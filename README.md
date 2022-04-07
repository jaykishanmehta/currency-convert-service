
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
- Spring doc: API documentation

## Available profiles: 
- [DEV] Dev Environment 
- [PROD] Stage Environment 
- [TEST] Test cases

## Swagger URLs:
- ```/api/currency-convert-service-api ```
- ```/api/swagger-ui.html ```

## Steps to run with Docker
Pull repository in docker environment
```
git clone https://github.com/jaykishanmehta/currency-convert-service.git -b main
```
Go inside project directory
```
cd currency-convert-service
```
Build project and run application
```
docker-compose up [Optional: --build]
```
You can start validating **POSTMAN** collection test cases just after above step. <br/>
> Refer below images to run [postman collection test cases.](https://github.com/jaykishanmehta/currency-convert-service/tree/main/PostmanTests)

![tempsnip](https://user-images.githubusercontent.com/5708437/162206418-c5bf1e60-a03a-40c1-8c76-cfea3f5f7607.png)


![image](https://user-images.githubusercontent.com/5708437/162205922-ab832726-dfc0-4fe2-89ad-60174a061cc4.png)


## Authors

- [@jaykishanmehta](https://www.github.com/jaykishanmehta)

