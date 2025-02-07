package code;

import java.util.List;

public class Payment {
    private int userID;
    private List<Movie> movies;
    private double totalAmount;

    public Payment(int userID, List<Movie> movies, double totalAmount) {
        this.userID = userID;
        this.movies = movies;
        this.totalAmount = totalAmount;
    }

    public int getUserID() { return userID; }
    public List<Movie> getMovies() { return movies; }
    public double getTotalAmount() { return totalAmount; }
}
