package Employee;

import java.util.HashMap;
import java.util.Map;

public class TechSupport {
    
	
	public Map<String, Order> orders = new HashMap<>();


    public String viewOrderStatus(String orderId) {
        if (orders.containsKey(orderId)) {
            Order order = orders.get(orderId);
            if (order.isAccepted()) {
                return "Accepted";
            } else if (order.isRejected()) {
                return "Rejected";
            } else {
                return "Pending";
            }
        } else {
            return "Order not found";
        }
    }

    public void acceptOrder(String orderId) {
        if (orders.containsKey(orderId)) {
            Order order = orders.get(orderId);
            order.setAccepted(true);
            order.setRejected(false);
        } else {
            System.out.println("Order not found");
        }
    }

    public void rejectOrder(String orderId) {
        if (orders.containsKey(orderId)) {
            Order order = orders.get(orderId);
            order.setAccepted(false);
            order.setRejected(true);
        } else {
            System.out.println("Order not found");
        }
    }
    
    public class Order {
        private boolean accepted;
        private boolean rejected;
        
        public boolean isAccepted() {
            return accepted;
        }

        public void setAccepted(boolean accepted) {
            this.accepted = accepted;
        }

        public boolean isRejected() {
            return rejected;
        }

        public void setRejected(boolean rejected) {
            this.rejected = rejected;
        }
    }

} 