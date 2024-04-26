Project Management System
The Project Management System is a web application developed using Spring Boot and H2 database, designed to handle various operations related to project management. It provides endpoints for CRUD operations (Create, Read, Update, Delete) and utilizes Swagger for API documentation.

Features
CRUD Operations: Allows users to perform Create, Read, Update, and Delete operations on project data.
Swagger Documentation: Provides detailed documentation of the API endpoints using Swagger.
Global Exception Handling: Implements global exception handling to ensure smooth error management.
Setup Instructions
To set up the Project Management System on your local machine, follow these steps:

Download the Code:
Clone the repository using the GitHub link provided.
bash
Copy code
git clone https://github.com/raushan725707/Project-Management-System
Open in IDE:
Import the project into an Integrated Development Environment (IDE) such as Eclipse or Spring Tool Suite (STS) as an existing Maven project.
Update Dependencies:
Ensure that all dependencies are resolved by updating the project using Maven.
Run the Application:
Run the application within your IDE. This will start the Spring Boot application on your local server.
Access Swagger Documentation:
Once the application is running, access the Swagger documentation to explore the available endpoints.
Open a web browser and navigate to http://localhost:8080/swagger-ui/index.html#/.
Usage
Create Project:
Use the appropriate endpoint to create a new project by providing necessary details.
Read All Projects:
Retrieve a list of all projects using the respective endpoint.
Read Project by ID:
Fetch a specific project by its unique identifier.
Update Project:
Update an existing project with new information.
Delete Project:
Delete a project from the system using its ID.
