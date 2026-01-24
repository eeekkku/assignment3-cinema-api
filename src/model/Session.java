package model;

public class Session {
    private int id;
    private Movie movie;
    private Hall hall;


    public Session(int id, Movie movie, Hall hall) {
        this.id = id;
        this.movie = movie;
        this.hall = hall;
    }

    public int getId() { return id; }
    public Movie getMovie() { return movie; }
    public Hall getHall() { return hall; }

    public void setId(int id) { this.id = id; }
    public void setMovie(Movie movie) { this.movie = movie; }
    public void setHall(Hall hall) { this.hall = hall; }

}
