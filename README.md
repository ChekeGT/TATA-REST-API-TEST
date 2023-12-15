# Spring Boot REST API Exercise

---
## Description
> This exercise involves creating a Spring Boot application that offers a REST API to manage a task list. The API should support the following operations:
- List all tasks.
- Get a task by its ID.
- Create a new task.
- Update an existing task.
- Delete a task by its ID.

---
## Requirements
- Use Spring Boot to create the application.
- Use an in-memory database (for example, H2) to store the tasks.
- Define a "Task" entity with at least the following fields: ID, title, description, creation date, and status (pending or completed).
- Implement REST controllers to manage the operations mentioned above.
- Use decorators like @RestController, @GetMapping, @PostMapping, @PutMapping, and @DeleteMapping to define the API routes.
- Implement services to handle logic and access the database.
- Use input data validation to ensure that the required fields are present.
- Document the API using Swagger to generate the documentation automatically.

## Note
This exercise does not require complex authentication or a user interface. It focuses on creating a simple REST API with basic CRUD operations and managing a data entity.