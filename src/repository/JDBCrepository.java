package repository;

import model.Movie;
import utils.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCrepository implements BaseRepository {

    @Override
    public Movie save(Movie movie) {
        String sql = "INSERT INTO movies(title, duration, genre) VALUES (?, ?, ?) RETURNING id";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, movie.getTitle());
            stmt.setInt(2, movie.getDuration());
            stmt.setString(3, movie.getGenre());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                movie.setId(rs.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return movie;
    }
    @Override
    public Movie findById(int id) {
        return null;
    }

    @Override
    public List<Movie> findAll() {
        return new ArrayList<>();
    }

    @Override
    public void deleteById(int id) {
    }
}
