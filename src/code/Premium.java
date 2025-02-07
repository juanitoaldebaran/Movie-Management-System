package code;

public class Premium extends User{

    public Premium(int userID, String userName, String password, String email) {
        super(userID, userName, password, email, UserType.PREMIUM);
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
        double userRegulerDiscount = 0.5;
        double originalPrice = movie.getPrice();
        double discountedPrice = originalPrice - (originalPrice * userRegulerDiscount);
        double calculateTax = movie.movieTax();
        double finalPrice = discountedPrice + calculateTax;

        return finalPrice;
    }
}
