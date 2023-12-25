package Student;
import java.util.*;
import java.io.Serializable;

public class Course {
	
	private String title;

	private int credits;

	private String code;

	private String teacherID;

	private int yearOfStudentCanGet;

	public Course(String title, int credits, String code, String teacherID, int yearOfStudentCanGet) {
		this.title = title;
		this.credits = credits;
		this.code = code;
		this.teacherID = teacherID;
		this.yearOfStudentCanGet = yearOfStudentCanGet;
	}

	public Course() {
	}

	public String getTitle() {
		return this.title;
	}

	public int getYearOfStudentCanGet() {
		return this.yearOfStudentCanGet;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Course [title=" + title + ", credits=" + credits + ", code=" + code + ", teacherID=" + teacherID + "]";
	}

	public int getCredits() {
		return this.credits;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTeachersById() {
		return this.teacherID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(code, credits, teacherID, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return Objects.equals(code, other.code) && credits == other.credits
				&& Objects.equals(teacherID, other.teacherID) && Objects.equals(title, other.title);
	}
	
	

}