package code;

public class Horror extends Movie{

    public Horror(int ID, String title, double rating, double price) {
        super(ID, title, MovieGenre.HORROR, rating, price);
    }

    @Override
    public void movieDisplay() {
        System.out.println("Horror movies are really scary, and lots of jumpscares");
    }

    @Override
    public double movieTax() throws NumberFormatException{
        double taxHorrorPrice = 0.5;
        double finalPrice = taxHorrorPrice * getPrice();

        return finalPrice;
    }

}
