# financeBFF

The `financebff` (Backend For Frontend) service is a Spring Boot microservice that serves as an intermediary between the frontend application and various backend services such as the `customersService`, `accountsService`, and `transactionsService`. It aggregates data from these services and presents a unified API for frontend applications.

## Features

- Aggregates customer, account, and transaction information into a unified response.
- Provides endpoints for creating new accounts for existing customers.
- Fetches complete customer details, including accounts and transactions.
- Acts as a single point of communication between the frontend and other backend services.

### Prerequisites

Ensure you have the following installed:

- Java 17 or higher
- Maven 3.6+
- Docker (optional for running the service as a container)

### Installation

1. **Clone the repository**:
   ```bash
   git clone https://github.com/kaouther24/financeBFF.git
   cd financeBFF

2. **Build the project using Maven**:
   ```bash
   mvn clean install

3. **run the application**:
   ```bash
   mvn spring-boot:run

The service will be available at http://localhost:8080.

### Running with Docker

1. **Build with docker**:
   ```bash
   docker build -t financebff-service:latest .

2. **Run the docker container**:
   ```bash
   docker run -p 8084:8080 customers-service

### API Endpoints
The financebff exposes the following API endpoints:
1. **Create a new account for an existing customer**:
- Endpoint: POST /account/newAccount
- Request body:
  {
  "customerUuid": "string",
  "customerName": "string",
  "balance": 1000.1,
  }
2. **GET customer all customer details including accounts and their transactions**:
- Endpoint: GET /customer/details/{customerUuid}

### Technologies Used
- Spring Boot: Framework for building microservices.
- JUnit & Mockito: For unit and integration testing.
- Docker: To containerize the service.

### License
This project is licensed under the MIT License