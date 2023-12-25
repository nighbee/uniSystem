package Student;

public class Request {
	public String requestID; 
	public String requestText; 
	public String requestTitle; 
	
	public Request(String requestID, String requestText, String requestTitle) {
		super();
		this.requestID = requestID;
		this.requestText = requestText;
		this.requestTitle = requestTitle;
	}

	public String getRequestID() {
		return requestID;
	}

	public void setRequestID(String requestID) {
		this.requestID = requestID;
	}

	public String getRequestText() {
		return requestText;
	}

	public void setRequestText(String requestText) {
		this.requestText = requestText;
	}

	public String getRequestTitle() {
		return requestTitle;
	}

	public void setRequestTitle(String requestTitle) {
		this.requestTitle = requestTitle;
	}

	@Override
	public String toString() {
		return "Request [requestID=" + requestID + ", requestText=" + requestText + ", requestTitle=" + requestTitle
				+ "]";
	}
	
	
}
