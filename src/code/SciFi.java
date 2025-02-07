package code;

public class SciFi extends Movie{
    public SciFi(int ID, String title, double rating, double price) {
        super(ID, title, MovieGenre.SCIFI, rating, price);
    }

    @Override
    public void movieDisplay() {
        System.out.println("SciFi movies are usually has the best design and may contains visual images");
    }

    @Override
    public double movieTax() throws NumberFormatException{
        double taxSciFiPrice = 0.075;
        double finalPrice = taxSciFiPrice * getPrice();

        return finalPrice;
    }

}
