package Database;
import Employee.*; 
import java.io.Serializable;

public class Message implements Serializable{
	private static final long serialVersionUID = 1L;
	private String messageID; 
	private String text;
    private Employee senderID ; 
    private Employee recieverID; 
    private String dateTime;
    
	public Message() {};

    public Message(String messageID, String text, Employee senderID, Employee recieverID, String dateTime) {
		super();
		this.messageID= messageID; 
		this.text = text;
		this.senderID = senderID;
		this.recieverID = recieverID;
		this.dateTime = dateTime;
	}

    

	public String getMessageID() {
		return messageID;
	}

	public void setMessageID(String messageID) {
		this.messageID = messageID;
	}

	public Employee getSenderID() {
		return senderID;
	}

	public void setSenderID(Employee senderID) {
		this.senderID = senderID;
	}

	public Employee getRecieverID() {
		return recieverID;
	}

	public void setRecieverID(Employee recieverID) {
		this.recieverID = recieverID;
	}

	public String getText() {
        return this.text;
    }
    
    public void setText(String text) {
        this.text = text;
    }
    
    public String getDateTime() {
        return this.dateTime;
    }
    
    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

	@Override
	public String toString() {
		return "Message [messageID=" + messageID + ", text=" + text + ", senderID=" + senderID + ", recieverID="
				+ recieverID + ", dateTime=" + dateTime + "]";
	}

    
}