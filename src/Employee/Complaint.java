package Employee;

public class Complaint {
    private String id;
    private String description;
    private boolean signed;
  
    public Complaint(String id, String description) {
        this.id = id;
        this.description = description;
        this.signed = false;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public boolean isSigned() {
        return signed;
    }

    public void setSigned(boolean signed) {
        this.signed = signed;
    }
}