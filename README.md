# E-Commerce with Spring Boot and MongoDB

This is a simple Spring Boot application for an e-commerce system with MongoDB as the database. The system allows customers to add products to their cart, place orders, and track past prices for products based on historical orders. It supports stock management for products and calculates the total price for the cart on each update.

## Features

- **Customer Management**: Add and manage customers.
- **Product Management**: Add, update, delete, and get products. 
- **Cart Management**: Get and update cart, add/remove products, empty cart, and calculate the total.
- **Order Management**: Place orders and retrieve past orders. Products in an order retain their price at the time of the purchase.
- **Stock Management**: Track the stock of each product, and prevent ordering when out of stock.

## Technologies Used

- **Spring Boot**: Backend framework.
- **MongoDB**: NoSQL database for storing data.
- **Swagger UI**: API documentation and testing.
- **Lombok**: Reduce boilerplate code with annotations.
  
## Application Properties

The application uses the following settings in `application.properties`:

```properties
server.port=8081
spring.data.mongodb.uri=mongodb://localhost:27017/springmongo

# Swagger UI Path (Optional)
springdoc.api-docs.path=/api-docs
springdoc.swagger-ui.path=/swagger-ui.html

# Swagger UI URL: http://localhost:8081/swagger-ui/index.html
