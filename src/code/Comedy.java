package code;

public class Comedy extends Movie{

    public Comedy(int ID, String title, double rating, double price) {
        super(ID, title, MovieGenre.COMEDY, rating, price);
    }

    @Override
    public void movieDisplay() {
        System.out.println("Comedy movies are really fun to watch with your family");
    }

    @Override
    public double movieTax() throws NumberFormatException{
        double taxComedyPrice = 0.25;
        double finalPrice = taxComedyPrice * getPrice();

        return finalPrice;
    }

}
