package Employee;
import java.io.Serializable;
import java.util.Timer;
import java.util.Vector;
import Database.*; 
import enums.*; 
import Student.* ; 
public class Teacher extends Employee implements CanDoResearch ,Serializable{

	private static final long serialVersionUID = 1L;

	public Teacher() {

	}

	private TeacherDegree degree;

	public Teacher(String userId, String userName, String email, String address, String password, int salary,
			TeacherDegree degree) {
		super(userId, userName, email, address, password, salary);
		this.degree = degree;
	}

	public Vector<Lesson> teacherSchedule = new Vector<Lesson>();
	public Vector<Course> teacherCourses = new Vector<Course>();
	public Vector<RequestsForTeacher> teacherRequests = new Vector<RequestsForTeacher>();

	public TeacherDegree getDegree() {
		return this.degree;
	}

	public void setDegree(TeacherDegree degree) {
		this.degree = degree;
	}

	public void putMarks(Course course, Student student, Marks mark) {
		student.setMark(mark, course);
	}

	public void putAttectation(Course course, Student student, Marks mark) {
		student.setAttectation(mark, course);
	}

	public void makeRequests(RequestsForTeacher requests, DataBase db) {
		teacherRequests.add(requests);
		db.requestsForTeacher.add(requests);
	}

	public void viewTeacherCourse() {
		for (Course c : teacherCourses) {
			System.err.println(c);
		}
	}

	public void viewRequests() {
		for (RequestsForTeacher requests : teacherRequests) {
			System.err.println(requests);
		}
	}

    public void openAttendance(DataBase db,String lessonName) {
    	for(Lesson l : this.teacherSchedule) {
    		if(l.getCourse().getTitle().equals(lessonName)) {
    			db.openedAttendances.put(l, false);
    		}
    	}
    }
    
    public void closeAttendance(DataBase db,String lessonName) {
    	for(Lesson l : this.teacherSchedule) {
    		if(l.getCourse().getTitle().equals(lessonName)) {
    			db.openedAttendances.remove(l);
    		}
    	}
    }
    
    

	public void viewTeacherSchedule() {
		for (Lesson l : teacherSchedule) {
			System.err.println(l);
		}
	}

	public String toString() {
		return super.toString() + "Teacher [degree=" + degree + "]";
	}

	public void doResearch(String ResearshName) {
		if (degree.equals(TeacherDegree.PROFESSOR)) {
			System.err.println("Teacher can do this " + ResearshName);
		} else {
			System.err.println("Teacher can not do this " + ResearshName);
		}
	}

}