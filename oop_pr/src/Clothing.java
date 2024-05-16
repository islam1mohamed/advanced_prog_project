
public class Clothing extends Product {

    public Clothing(int itemId, String name, String description, String imageName, float price, int amountInStock) {
        super(itemId, name, description, imageName, price, amountInStock, "Clothing");

    }


    @Override
    public String toString() {
        return itemId + "#" + name + "#" +description + "#" + imageName+ "#" + price + "#" + amountInStock + "#"  +"Clothing";
    }
}
