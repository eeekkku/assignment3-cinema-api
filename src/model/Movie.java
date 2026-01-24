package model;

public class Movie {
    private int id;
    private String title;
    private int duration;
    private String genre;

    public Movie(String title, int duration, String genre) {
        this.title = title;
        this.duration = duration;
        this.genre = genre;
    }

    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public int getDuration() {
        return duration;
    }
    public String getGenre() {
        return genre;
    }


    public void setId(int id) {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }

}
