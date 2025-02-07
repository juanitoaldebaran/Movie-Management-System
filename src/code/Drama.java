package code;

public class Drama extends Movie{
    public Drama(int ID, String title, double rating, double price) {
        super(ID, title, MovieGenre.DRAMA, rating, price);
    }

    @Override
    public void movieDisplay() {
        System.out.println("Drama movies has the most watch movies in the year of 2025");
    }

    @Override
    public double movieTax() throws NumberFormatException{
        double taxDramaPrice = 0.10;
        double finalPrice = taxDramaPrice * getPrice();

        return finalPrice;
    }

}
