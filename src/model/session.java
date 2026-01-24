package model;

public class session {
    private int id;
    private movie movie;
    private hall hall;

    public session(int id, movie movie, hall hall) {
        this.id = id;
        this.movie = movie;
        this.hall = hall;
    }

}
