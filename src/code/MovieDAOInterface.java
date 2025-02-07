package code;

import java.sql.SQLException;
import java.util.List;

public interface MovieDAOInterface<T> {

    List<Movie> listMovie() throws SQLException;
    void insertMovie(Movie movie) throws SQLException;
    void deleteMovie(int ID) throws SQLException;
    void updateMovie(Movie movie) throws SQLException;
}
