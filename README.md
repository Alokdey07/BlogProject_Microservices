
# Microservices-based Spring Boot Blog Backend

This is a microservices-based Spring Boot backend for a blog application. It is built using Java and provides a set of microservices for managing blog posts and comments.

## Features

- Create, read, update, and delete blog posts in a dedicated microservice.
- Create, read, update, and delete comments on blog posts in a separate microservice.
- Authentication and authorization using JWT tokens.
- Pagination and sorting of blog posts and comments.
- Modular and scalable microservices architecture.

## Requirements

- Java 17+
- Maven

## Getting Started

To get started with the microservices-based blog backend, follow the steps below:

1. Clone the repository:

   ```bash
   git clone [https://github.com/Alokdey07/BlogProjectBackend/tree/main]
   ```

2. Build the microservices:

   ```bash
   mvn clean install
   ```

3. Start the microservices:

   ```bash
   mvn spring-boot:run
   ```

## Microservices Overview

The microservices in this setup are divided based on their functionalities. Here's an overview:

### Blog Post Microservice

- **Endpoint**: http://localhost:8080/api/posts
- **Available Endpoints**:
  - GET: Get all blog posts
  - GET (by ID): Get a single blog post by ID
  - POST: Create a new blog post
  - PUT (by ID): Update an existing blog post
  - DELETE (by ID): Delete a blog post

### Comment Microservice

- **Endpoint**: http://localhost:8080/api/blogs/{id}/comments
- **Available Endpoints**:
  - GET: Get all comments on a blog post
  - POST: Create a new comment on a blog post
  - GET (by Comment ID): Get a single comment on a blog post by ID
  - PUT (by Comment ID): Update an existing comment on a blog post
  - DELETE (by Comment ID): Delete a comment on a blog post

## Authentication

To authenticate with the blog backend, you need to send a JWT token in the Authorization header of your requests. You can generate a JWT token using the /auth/login endpoint.

**Example**:

```http
POST /auth/login HTTP/1.1
Host: localhost:8080
Content-Type: application/json

{ "username": "admin", "password": "password" }
```

**Response**:

```http
HTTP/1.1 200 OK
Content-Type: application/json

{ "token": "YOUR_JWT_TOKEN_HERE" }
```

Once you have a JWT token, you can use it to authenticate with the blog backend by sending it in the Authorization header of your requests.

**Example**:

```http
GET /blogs HTTP/1.1
Host: localhost:8080
Authorization: Bearer YOUR_JWT_TOKEN_HERE
```

## Testing

The microservices have a suite of unit and integration tests that can be run using the following command:

```bash
mvn test
```

## Deployment

The microservices can be deployed to any Java application server. To deploy each microservice as a JAR file, you can use the following command:

```bash
mvn package
```

This will create a JAR file in the target directory. You can then deploy the JAR file to your application server.

## Contributing

If you would like to contribute to the microservices-based blog backend, please feel free to fork the repository and create a pull request. We welcome contributions to enhance the project's functionality and maintainability.

Please replace the placeholders with your actual setup and information where needed.
