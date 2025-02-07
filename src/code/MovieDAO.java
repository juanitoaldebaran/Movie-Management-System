package code;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieDAO implements MovieDAOInterface {
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/movie_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "aldebaran1711";

    private Connection connection;

    public MovieDAO(Connection connection) {
        this.connection = connection;
    }


    @Override
    public void insertMovie(Movie movie) throws SQLException {
            String insertQuery = "INSERT INTO movie_table (title, genre, rating, price) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(insertQuery)) {
                statement.setString(1, movie.getTitle());
                statement.setString(2, String.valueOf(movie.getGenre()));
                statement.setDouble(3, movie.getRating());
                statement.setDouble(4, movie.getPrice());

                statement.executeUpdate();
            }
        }


    @Override
    public void deleteMovie(int ID) throws SQLException {
        String deleteMovieQuery = "DELETE FROM movie_table WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(deleteMovieQuery)) {
            statement.setInt(1, ID);

            statement.executeUpdate();
        }
    }

    @Override
    public void updateMovie(Movie movie) throws SQLException {
        String updateMovieQuery = "UPDATE movie_table SET title = ?, genre = ?, rating = ?, price = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(updateMovieQuery)) {
            statement.setString(1, movie.getTitle());
            statement.setString(2, String.valueOf(movie.getGenre()));
            statement.setDouble(3, movie.getRating());
            statement.setDouble(4, movie.getPrice());
            statement.setInt(5, movie.getID());

            statement.executeUpdate();
        }
    }

    @Override
    public List<Movie> listMovie() throws SQLException {

        List<Movie> movieList = new ArrayList<>();
        String listQuery = "SELECT * FROM movie_table";
        try (PreparedStatement statement = connection.prepareStatement(listQuery)) {
            try (ResultSet rs = statement.executeQuery()) {

                while(rs.next()) {
                    MovieGenre movieGenre = MovieGenre.valueOf(rs.getString("type"));
                    if (movieGenre == MovieGenre.ACTION) {
                        Action actionMovie = new Action(
                                rs.getInt("id"),
                                rs.getString("title"),
                                rs.getDouble("rating"),
                                rs.getDouble("price")
                        );
                        movieList.add(actionMovie);
                    }
                    else if (movieGenre == MovieGenre.COMEDY) {
                        Comedy comedyGenre = new Comedy(
                                rs.getInt("id"),
                                rs.getString("title"),
                                rs.getDouble("rating"),
                                rs.getDouble("price")
                        );
                        movieList.add(comedyGenre);
                    }
                    else if (movieGenre == MovieGenre.DRAMA) {
                        Drama dramaGenre = new Drama(
                                rs.getInt("id"),
                                rs.getString("title"),
                                rs.getDouble("rating"),
                                rs.getDouble("price")
                        );
                        movieList.add(dramaGenre);
                    }
                    else if (movieGenre == MovieGenre.THRILLER) {
                        Thriller thrillerGenre = new Thriller(
                                rs.getInt("id"),
                                rs.getString("title"),
                                rs.getDouble("rating"),
                                rs.getDouble("price")
                        );
                        movieList.add(thrillerGenre);
                    }
                    else if (movieGenre == MovieGenre.HORROR) {
                        Horror horrorGenre = new Horror(
                                rs.getInt("id"),
                                rs.getString("title"),
                                rs.getDouble("rating"),
                                rs.getDouble("price")
                        );
                        movieList.add(horrorGenre);
                    }
                    else if (movieGenre == MovieGenre.SCIFI) {
                        SciFi scifiGenre = new SciFi(
                                rs.getInt("id"),
                                rs.getString("title"),
                                rs.getDouble("rating"),
                                rs.getDouble("price")
                        );
                        movieList.add(scifiGenre);
                    }
                }
            }
        }

        return movieList;
    }
}
