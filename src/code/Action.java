package code;

public class Action extends Movie{
    public Action(int ID, String title, double rating, double price) {
        super(ID, title, MovieGenre.ACTION, rating, price);
    }

    @Override
    public void movieDisplay() {
        System.out.println("Action movies are usually rated for PG-13 or 13 for intense action");
    }

    @Override
    public double movieTax() throws NumberFormatException{
        double taxActionPrice = 0.15;
        double finalPrice =  taxActionPrice * getPrice();

        return finalPrice;
    }

}
