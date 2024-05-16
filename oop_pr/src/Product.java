import java.util.ArrayList;
import java.util.List;

public class Product {
    protected int itemId;
    protected String name;
    protected String description;
    protected String imageName;
    protected float price;
    protected int amountInStock;
    protected String category;

    public Product(int itemId, String name, String description, String imageName, float price, int amountInStock, String category) {
        this.itemId = itemId;
        this.name = name;
        this.description = description;
        this.imageName = imageName;
        this.price = price;
        this.amountInStock = amountInStock;
        this.category = category;
    }

    // Getter and setter methods for the attributes (omitted for brevity)

    @Override
    public String toString() {
        return itemId + "#" + name + "#" + description + "#" + imageName + "#" + price + "#" + amountInStock + "#" + category;
    }

    public static  Product fromString(String string) throws  Exception{
        String[] data = string.split("#");
        return switch (data[6]) {
            case "Clothing" ->
                    new Clothing(Integer.parseInt(data[0]), data[1], data[2], data[3], Float.parseFloat(data[4]), Integer.parseInt(data[5]));
            case "Electronics" ->
                    new Electronics(Integer.parseInt(data[0]), data[1], data[2], data[3], Float.parseFloat(data[4]), Integer.parseInt(data[5]));
            case "Food" ->
                    new Food(Integer.parseInt(data[0]), data[1], data[2], data[3], Float.parseFloat(data[4]), Integer.parseInt(data[5]));
            case "Furniture" ->
                    new Furniture(Integer.parseInt(data[0]), data[1], data[2], data[3], Float.parseFloat(data[4]), Integer.parseInt(data[5]));
            default -> throw new Exception();
        };
    }


    public static List<Product> fromStringList(List<String> stringList) throws Exception {
        List<Product> productList = new ArrayList<>();
        for (String string : stringList) {
            productList.add(fromString(string));
        }
        return productList;
    }
}
