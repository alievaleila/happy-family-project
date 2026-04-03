## Happy Family - OOP Management System

Description
Happy Family is a Java-based application designed to demonstrate advanced Object-Oriented Programming (OOP) concepts through a family management simulation. The project solves the complexity of managing hierarchical relationships and entity life cycles by implementing strict encapsulation, inheritance, and polymorphism. It features a robust DAO (Data Access Object) pattern to abstract and encapsulate all access to the data source.

## Tech Stack
Language: Java 17+

Architecture: DAO Pattern (Data Access Object)

Core Concepts: OOP (Inheritance, Polymorphism, Encapsulation, Abstraction)

Build Tool: Maven / Native Java

Data Handling: Collection API (Lists, Sets, Maps)

## Setup instructions
Clone the repository:

Navigate to the project directory:

Compile the application:

Run the application:

## Key OOP Features
Encapsulation: All domain models use private fields with controlled access via getters and setters.

Inheritance & Polymorphism: Implementation of various family member types and pet behaviors using class hierarchies.

Abstraction: Defined interfaces and abstract classes for service and data access layers to ensure a decoupled architecture.

Exception Handling: Custom exception classes to manage business logic errors (e.g., family member limits or invalid data).

## Project Structure
controller/: Manages the flow of the application and user interaction.

dao/: Contains data access logic and interface definitions for persistence.

service/: Implements business logic and coordinates data between the controller and DAO.

model/: Defines core entities (Family, Human, Pet, etc.).

exception/: Custom exception handling for robust execution.

## Usage examples
Family Creation: Programmatically build family units with specific attributes and relationships.

Data Persistence: Utilize the DAO layer to perform CRUD operations on the in-memory family database.

Life Cycle Simulation: Simulate events within the family structure, demonstrating dynamic object interactions
