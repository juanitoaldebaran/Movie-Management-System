package code;

public abstract class Movie implements MovieInterface{
    private int ID;
    private String title;
    private MovieGenre genre;
    private double rating;
    private double price;

    public Movie(int ID, String title, MovieGenre genre, double rating, double price) {
        this.ID = ID;
        this.title = title;
        this.genre = genre;
        this.rating = rating;
        this.price = price;
    }

    public abstract void movieDisplay();
    public abstract double movieTax();

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public MovieGenre getGenre() {
        return genre;
    }

    @Override
    public void setGenre(MovieGenre genre) {
        this.genre = genre;
    }

    @Override
    public double getRating() {
        return rating;
    }

    @Override
    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "ID=" + ID +
                ", title='" + title + '\'' +
                ", genre=" + genre +
                ", rating=" + rating +
                ", price=" + price +
                '}';
    }
}
