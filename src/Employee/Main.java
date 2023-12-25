package Employee;
import Employee.*; 
public class Main {
    public static void main(String[] args) {
        TechSupport techSupport = new TechSupport();

        // Creating sample orders
        techSupport.orders.put("123", techSupport.new Order());
        techSupport.orders.put("456", techSupport.new Order());

        // Viewing order status
        System.out.println("Order 123 status: " + techSupport.viewOrderStatus("123"));
        System.out.println("Order 456 status: " + techSupport.viewOrderStatus("456"));
        System.out.println("Order 789 status: " + techSupport.viewOrderStatus("789"));

        // Accepting an order
        techSupport.acceptOrder("123");
        System.out.println("Order 123 status after acceptance: " + techSupport.viewOrderStatus("123"));

        // Rejecting an order
        techSupport.rejectOrder("456");
        System.out.println("Order 456 status after rejection: " + techSupport.viewOrderStatus("456"));
    }
}