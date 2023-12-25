package Database;

public class Order {
	public String orderID; 
	public String orderText; 
	
	public Order() { 
	}

	public Order(String orderID, String orderText) {
		super();
		this.orderID = orderID;
		this.orderText = orderText;
	}

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public String getOrderText() {
		return orderText;
	}

	public void setOrderText(String orderText) {
		this.orderText = orderText;
	}
	
	
}
