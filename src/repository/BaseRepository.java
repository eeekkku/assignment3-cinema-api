package repository;

import model.Movie;
import java.util.List;

public interface BaseRepository {
    Movie save(Movie movie);
    Movie findById(int id);
    List<Movie> findAll();
    void deleteById(int id);
}
