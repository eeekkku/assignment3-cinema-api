# assignment4-cinema-api
## project overview

This project is a refactored version of my previous assignment 3
which is about managing cinema sessions and tickets. 
It demonstrates SOLID principles, layered architecture and advanced Java OOP features.

## SOLID Documentation 
SRP:
TicketController handles user interaction and delegates requests to the service layer;
TicketService contains business logic(validation, selling);
TicketRepository handles persistence logic using JDBC;
Ticket, RegularTicket and StudentTicket represent domain entities;
SortingUtils,ReflectionUtils have utility responsibilities.  

OCP:
The abstract class Ticket is open for extension but closed for modification.
We can add new ticket types by extending Ticket without changing existing logic

LCP:
RegularTicket, StudentTicket extend Ticket. They override calculatePrice(),
do not break system behavior when substituted

ISP:
Interfaces are small and focused:
PricedItem has pricing responsibility,
Validatable<T> has validation responsibility,
CrudRepository<T> — persistence contract,
No class is forced to implement unused methods.

DIP:
High-level modules depend on abstractions, not implementations.
For example, TicketService depends on CrudRepository<Ticket>,
TicketController depends on TicketService

## Advanced OOP Features

Generics
I used it in:
CrudRepository<T>, SortingUtils.sort(List<T>, Comparator<T>), Validatable<T>.

Lambda expressions are used for sorting tickets.

ReflectionUtils inspects objects at runtime: class name, fields, methods

Interface Default & Static Methods
Validatable<T> includes default method for null checks, static method for validation rules


## OOP Documentation

Abstract Class and Subclasses
Ticket is abstract. RegularTicket, StudentTicket are subclasses.
Ticket defines shared state and behavior, while subclasses implement pricing logic.

Composition Relationships
Session is composed of Movie and Hall

Polymorphism Example:
Ticket ticket = new StudentTicket(_);
ticket.calculatePrice(); 
The correct implementation is resolved at runtime.


## Database Section

Schema
The database uses PostgreSQL and includes movies, halls, sessions, tickets.
Constraints
Primary keys on all tables
Foreign keys: sessions.movie_id - movies.id; sessions.hall_id - halls.id;
tickets.session_id - sessions.id
Sample Inserts
Example:
INSERT INTO movies(title, duration, genre)
VALUES ('Qyzym', 101, 'Dramedy');

INSERT INTO halls (capacity)
VALUES (200);

## Architecture Explanation
Response Flow Example
Main calls TicketController.sell(ticket)
Controller delegates to TicketService
Service validates business rules
Repository persists data via JDBC
Result is returned back up the stack

## Execution Instructions
Requirements: Java 17+, PostgreSQL, JDBC Driver
How to Run
Create database cinema,execute schema.sql, update DB credentials in DatabaseConnection
Compile: javac -d out src/**/*.java
Run: java -cp out Main

## Screenshots
in docs

ReflectionUtils uses Java RTTI to inspect runtime class data such as methods.
Different Ticket subclasses override calculatePrice(), which is called through the base Ticket reference.
SortingUtils.sort() accepts a generic list and a lambda-based Comparator.


## reflection 

I learned applying SOLID principles.

It was challenging to refactor existing code without breaking functionality

SOLID principles make the system maintainable and easier to understand.