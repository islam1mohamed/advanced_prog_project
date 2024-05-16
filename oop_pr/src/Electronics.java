
public class Electronics extends Product {

    public Electronics(int itemId, String name, String description, String imageName, float price, int amountInStock) {
        super(itemId, name, description, imageName, price, amountInStock, "Electronics");
    }

    @Override
    public String toString() {
        return itemId + "#" + name + "#" +description + "#" + imageName+ "#" + price + "#" + amountInStock + "#"  +category;
    }
}
