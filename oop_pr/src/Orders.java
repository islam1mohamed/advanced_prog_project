public class Orders {
    public void displayOrders() {
        for (Order order : App.manager.orders) {
            System.out.println(order.toString());
        }
    }
}
