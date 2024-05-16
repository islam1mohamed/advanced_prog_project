
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Order implements StoreItem{

    String date;
    float total;
    int itemId;
    public Order(int itemId, String date, float total) {
        this.itemId = itemId;
        this.date  = date;
        this.total = total;
    }

    @Override
    public String toString() {
        return itemId + "#" + date + "#" + total;
    }

    public static  Order fromString(String string) {
        String[] data = string.split("#");
        return new Order(Integer.parseInt(data[0]) , data[1] , Float.parseFloat(data[2]));
    }

    @Override
    public void display() {
        try {
 
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public void register(){

        try {
            File file = new File(App.manager.currentUser.id + "_orders.txt");
            if (!file.createNewFile()) {
                System.out.println("File Already CreatedS");
            }
            FileWriter fileWriter = new FileWriter(App.manager.currentUser.id + "_orders.txt", true);
            fileWriter.write(toString() + '\n');
            fileWriter.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
