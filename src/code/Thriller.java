package code;

public class Thriller extends Movie {
    public Thriller(int ID, String title, double rating, double price) {
        super(ID, title, MovieGenre.THRILLER, rating, price);
    }

    @Override
    public void movieDisplay() {
        System.out.println("Thriller movies may contains lot of plot twist");
    }

    @Override
    public double movieTax() throws NumberFormatException{
        double taxThrillerPrice = 0.15;
        double finalPrice = taxThrillerPrice * getPrice();

        return finalPrice;
    }

}
