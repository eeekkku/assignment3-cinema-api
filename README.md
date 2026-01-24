# assignment3-cinema-api
## project overview

My project is about managing cinema sessions and tickets. 
It demonstrates OOP principles, multi-layer architecture and JDBC database operations.

Entities:

Movie linked to Session
Hall linked to Session
Session composes Movie and Hall
Ticket (abstract): subclasses StudentTicket and RegularTicket

## OOP Design Documentation

Ticket (abstract)
Fields: sessionId, seatNumber, customerName
Methods:
calculatePrice() (abstract)
getTicketType() (abstract)
printTicketInfo() (concrete method)
Subclasses:
RegularTicket — price 2200
StudentTicket — price 1800

Interfaces
Validatable — method validate() to check data correctness
PricedItem — method getPrice() to retrieve ticket cost


Session contains Movie and Hall objects.
Each session aggregates a movie and a hall

Polymorphism Examples
Method printTicket(Ticket ticket) uses the abstract Ticket type to handle different ticket types.
Example in Main.java:
Ticket t1 = new RegularTicket(1, 5, "Yerkezhan");
Ticket t2 = new StudentTicket(1, 2, "Valeriya");
printTicket(t1); 
printTicket(t2);

## Database Description
Schema in resources: schema.sql

sample sql inserts

INSERT INTO halls(capacity) VALUES (120);
INSERT INTO movies(title, duration, genre) VALUES ('The Housemaid', 133, 'Thriller');
INSERT INTO sessions(movie_id, hall_id) VALUES (1, 1);
INSERT INTO tickets(session_id, seat_number, customer_name, ticket_type)
VALUES (1, 5, 'Aiman', 'REGULAR');

## Controller

CRUD Operations (CLI Example)
Create Movie:
Movie movie = new Movie(0, "Avatar", 162, "Sci-Fi");
movieService.addMovie(movie);
Read Movies:
List<Movie> movies = movieService.getAllMovies();
Update Movie:
movie.setTitle("Avatar 2");
movieService.updateMovie(movie.getId(), movie);
Delete Movie:
movieService.deleteMovie(movie.getId());

## Instructions to Compile and Run
Compile Java files:
javac -d out src/model/*.java src/service/*.java src/repository/*.java src/utils/*.java src/exception/*.java src/Main.java
Run application:
java -cp out Main

## reflection 

I learned implementing abstract classes and polymorphism,
exceptions.

It was challenging to understand principles

Benefits of JDBC and multi-layer design are clear separation of business logic and database access.