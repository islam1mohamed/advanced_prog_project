public class Furniture extends Product {
    public Furniture(int itemId, String name, String description, String imageName, float price, int amountInStock) {
        super(itemId, name, description, imageName, price, amountInStock, "Furniture");
    }

    @Override
    public String toString() {
        return itemId + "#" + name + "#" + description + "#" + imageName + "#" + price + "#" + amountInStock + "#" + category;
    }
}
