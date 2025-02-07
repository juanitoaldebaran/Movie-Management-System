package code;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/movie_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "aldebaran1711";


    public static void main(String[] args) throws SQLException {
        try (Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD)){

            MovieDAO movieDAO = new MovieDAO(connection);
            UserDAO userDAO = new UserDAO(connection);
            PaymentDAO paymentDAO = new PaymentDAO(connection);

            System.out.println("WELCOME TO CINEMA 21");
            System.out.println("--------------------");
            System.out.println("Enjoy the latest blockbusters in stunning high definition and immersive surround sound.");
            System.out.println("Book your tickets now and experience the magic of cinema like never before!");;
            System.out.println("--------------------");
            System.out.println("Please enter your name: ");
            String name = scanner.nextLine();
            System.out.println("Hi " + name + "! Welcome to CINEMA 21!");
            System.out.println("---------------------");

            User currentUser = userLoginCredentials(connection, userDAO);

            while (true) {
                System.out.println("---------------------");
                displayMovie();
                System.out.println("---------------------");
                displayOption();
            }

        }
    }

    private static User userLoginCredentials(Connection connection, UserDAO userDAO)  {
        System.out.println("Enter your username: ");
        String username = scanner.nextLine();
        System.out.println("Enter your password: ");
        String password = scanner.nextLine();
        System.out.println("Enter your email: ");
        String email = scanner.nextLine();
        System.out.println("Enter your user type (REGULER or PREMIUM): ");
        String userTypeString = scanner.nextLine();
        UserType userType = UserType.valueOf(userTypeString.toUpperCase());

        User user
    }

    public static void displayMovie() {
        System.out.println("Available Movies");
        System.out.println("---------------------");
        List<Movie> movieList = new ArrayList<>();

        movieList.add(new Action(1, "John Wick: Chapter 4", 9.0, 30));
        movieList.add(new Comedy(2, "Deadpool", 8.7, 28));
        movieList.add(new Drama(3, "Oppenheimer", 9.1, 32));
        movieList.add(new Thriller(4, "Inception", 9.4, 35));
        movieList.add(new Horror(5, "The Conjuring", 8.6, 33));
        movieList.add(new SciFi(6, "Avatar: The Way of Water", 9.2, 40));

        movieList.stream()
                .forEach(movie -> System.out.println(
                        "ID: " + movie.getID() + "\nTitle: " + movie.getTitle() + "\nGenre: " + movie.getGenre() +
                                "\nRating: " + movie.getRating() + "\nPrice: " + movie.getPrice()
                ));
    }

    public static void displayOption() {
        System.out.println("1) Add movies to your list");
        System.out.println("2) List movies to your list");
        System.out.println("3) List movies to your list");
        System.out.println("4) Delete movies to your list");
    }


}
