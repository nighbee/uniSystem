package Employee;

public class Rector extends Teacher {

	private static final long serialVersionUID = 1L;

	public void viewComplaint(String complaintId) {
        Complaint complaint = findComplaintById(complaintId);
        if (complaint != null) {
            System.out.println("Complaint ID: " + complaint.getId());
            System.out.println("Complaint Text: " + complaint.getDescription());
        } else {
            System.out.println("Complaint not found");
        }
    }

    public void signComplaint(String complaintId) {
        Complaint complaint = findComplaintById(complaintId);
        if (complaint != null) {
            complaint.setSigned(true);
            System.out.println("Complaint signed");
        } else {
            System.out.println("Complaint not found");
        }
    }


    private Complaint findComplaintById(String complaintId) {
        for (Complaint complaint : complaints) {
            if (complaint.getId().equals(complaintId)) {
                return complaint;
            }
        }
        return null;
    }
}

