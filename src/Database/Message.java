package Database;

import java.io.Serializable;

public class Message implements Serializable{
	private static final long serialVersionUID = 1L;

	public Message() {};
	
    public Message(String text, String dateTime) {
		this.text = text;
		this.dateTime = dateTime;
	}

	private String text;
    
    private String dateTime;
    
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
		return  "[ " + text + ", time=" + dateTime + " ]";
	}
}