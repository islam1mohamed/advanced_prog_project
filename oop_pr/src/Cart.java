import java.time.LocalDateTime;
import java.util.Random;

public class Cart {

    float total;

    public void initialize() {
        for (Quantifiable q : App.manager.cart) {
            System.out.println(q.product.name);
            total += q.product.price * q.quantity;
        }

        System.out.println("Total: " + total + "$");
    }

    public void onCheckClick() {
        Random rand = new Random();
        Order order = new Order(rand.nextInt(10000), LocalDateTime.now().toString(), total);
        order.register();
        recalculateTotal();
    }

    private void recalculateTotal() {
        total = 0;
        for (Quantifiable q : App.manager.cart) {
            total += q.product.price * q.quantity;
        }

        System.out.println("Total: " + total);
    }
}
