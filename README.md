# Firebase CRUD Operations API

![Firebase Logo](https://firebase.google.com/downloads/brand-guidelines/PNG/logo-vertical.png)

This repository contains a Spring Boot API for performing CRUD (Create, Read, Update, Delete) operations using Firebase as the NoSQL database. The API is built using Java and provides endpoints to interact with the Firebase database and perform operations on the data.

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Technologies](#technologies)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
- [Usage](#usage)
  - [API Endpoints](#api-endpoints)
- [Contributing](#contributing)
- [License](#license)

## Introduction

The Firebase CRUD Operations API is a simple and efficient solution for building RESTful APIs with basic CRUD functionality. It leverages the Firebase Realtime Database as the backend, which is a flexible and scalable NoSQL database provided by Google. This API can serve as a foundation for developing various types of applications that require data manipulation.

## Features

- Create new records in the database
- Retrieve existing records from the database
- Update existing records in the database
- Delete records from the database

## Technologies

The project is built using the following technologies:

- Java: Programming language used for developing the API
- Spring Boot: Framework for building Java applications
- Firebase: Backend NoSQL database for data storage

## Getting Started

To get started with the project, follow the instructions below.

### Prerequisites

- Java Development Kit (JDK) installed
- Maven build tool installed
- Firebase account and a project set up

### Installation

1. Clone the repository:

```bash
git clone https://github.com/CodeNebula07/FireBase-Crud-Operations.git
```

2. Navigate to the project directory:

```bash
cd firebase-crud-api
```

3. Configure Firebase credentials:
   
   - Visit the Firebase console and create a new project if you haven't already.
   - Obtain your Firebase service account credentials in JSON format.
   - Rename the downloaded file to `firebase-credentials.json` and place it in the `src/main/resources/` directory of the project.

4. Build the project using Maven:

```bash
mvn clean install
```

5. Run the API:

```bash
mvn spring-boot:run
```

The API will start running on `http://localhost:8080`.

## Usage

### API Endpoints

The API provides the following endpoints for performing CRUD operations on the Firebase database:

- `GET /firebase/ListData` - Retrieve all resources
- `POST /firebase/AddData` - Create a new resource
- `PUT /firebase/GetDataById/{id}` - Get an existing resource by ID
- `PUT /firebase/UpdateData/{id}` - Update an existing resource by ID
- `DELETE /firebase/DeleteData/{id}` - Delete a resource by ID

You can test these endpoints using tools like Postman or cURL. Make sure to include the necessary request payloads and headers as described in the API documentation.

## Contributing

Contributions to this project are welcome. If you find any issues or have suggestions for improvements, please feel free to submit a pull request or open an issue. Let's collaborate to make this project even better!

## License

This project is licensed under the [MIT License](LICENSE). You are free to modify and distribute the code as per the terms and conditions of the license.
