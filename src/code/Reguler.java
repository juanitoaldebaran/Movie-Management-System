package code;

public class Reguler extends User{

    public Reguler(int userID, String userName, String password, String email) {
        super(userID, userName, password, email, UserType.REGULER);
    }


    @Override
    public void displayUser() {
        System.out.println("User ID: " + getUserID());
        System.out.println("User Name: " + getUserName());
        System.out.println("Password: " + getPassword());
        System.out.println("Email: " + getEmail());
        System.out.println("User Type: " + getUserType());
    }

    @Override
    public double userDiscount(Movie movie) throws NumberFormatException {
        double userRegulerDiscount = 0.1;
        double originalPrice = movie.getPrice();
        double discountedPrice = originalPrice - (originalPrice * userRegulerDiscount);
        double calculateTax = movie.movieTax();
        double finalPrice = discountedPrice + calculateTax;

        return finalPrice;
    }
}
