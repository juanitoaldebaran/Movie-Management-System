package code;

public interface MovieInterface<T> {
    int getID();
    void setID(int ID);
    String getTitle();
    void setTitle(String title);

    MovieGenre getGenre();

    void setGenre(MovieGenre genre);

    double getRating();
    void setRating(double rating);

    double getPrice();
    void setPrice(double price);
}
