
public class Food extends Product{


    public Food(int itemId, String name,String description,String imageName, float price, int amountInStock) {
        super(itemId, name, description, imageName, price, amountInStock, "Food");
    }

    @Override
    public String toString() {
        return itemId + "#" + name + "#" +description + "#" + imageName+ "#" + price + "#" + amountInStock + "#"  +category;
    }
}
