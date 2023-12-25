package Student;
import enums.*; 
import java.util.*;
import java.util.Map.Entry;
import java.io.*;
import Database.*; 
import user.*; 
import Employee.*; 

public class Student extends User implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	private double gpa;
	private Organizations organizationOfStudent;
	private Faculties faculty;
	private StudentDegree degree;
	private int year;

	public Student() {
	};

	public Student(String userId, String userName, String email, String address, String password, Faculties faculty,
			int year, StudentDegree studentDegree) {
		super();
		this.faculty = faculty;
		this.year = year;
		this.degree = studentDegree;
	}
	
	public FinancialCabinet financialCabinet = new FinancialCabinet(this);

	public HashMap<Course, Marks> attestations = new HashMap<Course, Marks>();
	public HashMap<Course, Marks> marks = new HashMap<Course, Marks>();
	public Vector<Course> studentCourses = new Vector<Course>();
	public Vector<RequestsForStudent> studentsRequests = new Vector<RequestsForStudent>();
	public Vector<Lesson> studentSchedule = new Vector<Lesson>();
	
	public void viewFinancialCabinet(DataBase db) {
		calculateBalance(db);
		System.out.println(this.financialCabinet);
	}
	
	public void calculateBalance(DataBase db) {
		int cnt = 0;
		if(db.failOfStudents.containsKey(this) && db.failOfStudents.get(this) != cnt){
			cnt = db.failOfStudents.get(this);
			int balance = this.financialCabinet.getStudentBalance();
			balance -= cnt * 150000;
			this.financialCabinet.setStudentBalance(balance);
		}
		
	}
	
	public String getOrganization() {
		return organizationOfStudent.toString();
	}

	public Faculties getFaculty() {
		return this.faculty;
	}

	public void setFaculty(Faculties faculty) {
		this.faculty = faculty;
	}

	public int getYearOfStudy() {
		return year;
	}

	public void setYearOfStudy(Integer yearOfStudy) {
		this.year = yearOfStudy;
	}

	public StudentDegree getDegree() {
		return this.degree;
	}

	public void setDegree(StudentDegree degree) {
		this.degree = degree;
	}

	public void enterOrganization(String nameOfOrganisation) {
		for (Organizations organisation : Organizations.values()) {
			if (organisation.toString().equals(nameOfOrganisation)) {
				organizationOfStudent = organisation;
			}
		}
	}

	public void setMark(Marks mark_, Course course) {
		marks.put(course, mark_);

	}
	


	public void getStudentSchedule() {
		for (Lesson l : studentSchedule) {
			System.out.println(l);
		}
	}

	public void setAttectation(Marks mark_, Course course) {

		attestations.put(course, mark_);
	}

	public void viewAttestation() {
		for (Entry<Course, Marks> entry : attestations.entrySet()) {
			System.out.println(entry);
		}
	}

	public Vector<RequestsForStudent> getRequests() {
		return studentsRequests;
	}

	public void makeRequests(RequestsForStudent requests, DataBase db) {
		studentsRequests.add(requests);
		db.requestsForStudent.add(requests);
	}

	public Vector<Course> getCourse() {
		return this.studentCourses;
	}

//	public boolean registrateCourse(String nameCourse, DataBase db) {
//		for (Course i : db.courses) {
//			if (i.getTitle().equals(nameCourse) && i.getYearOfStudentCanGet() == this.yearOfStudy) {
//				studentCourses.add(i);
//				return true;
//			}
//		}
//		return false;
//	}

//	public void viewStudentCourse(DataBase db) {
//		for (int i = 0; i < studentCourses.size(); ++i) {
//			System.err.print(studentCourses.get(i) + " <- " + db.preRequisite.get(studentCourses.get(i)));
//			System.out.println();
//		}
//
//	}

	public Teacher viewTeacher() {
		return null;
	}

	public void viewMarks() {
		for (Entry<Course, Marks> entry : marks.entrySet()) {
			System.err.println(entry);
		}
	}
//
//	public void rateTeacher(DataBase db) {
//		for (User u : db.users) {
//			if (u.getClass() == Teacher.class) {
//				System.out.println(u.getUserName());
//
//			}
//		}
//	}

	public HashMap<Course, Marks> getMark(Course course) {
		HashMap<Course, Marks> markTemp = new HashMap<Course, Marks>();
		for (Course j : marks.keySet()) {
			if (j.getCode().equals(course.getCode())) {
				markTemp = marks;
			}
		}

		return markTemp;
	}

	public double calculateGpaTotal() {
		double totalGPA = 0;
		double sum = 0;
		double sumCredits = 0;
		for (Entry<Course, Marks> entry : attestations.entrySet()) {
			sumCredits += entry.getKey().getCredits();
			sum += (this.calculateGpa(attestations, entry.getKey()) * entry.getKey().getCredits());
		}
		totalGPA = sum / sumCredits;
		return totalGPA;
	}
//
//	public void viewTranscript() {
//		System.out.println("---------------------");
//		for (Entry<Course, Marks> entry : attestations.entrySet()) {
//			System.out.println(entry.getKey().getTitle() + '|' + entry.getKey().getCredits() + '|'
//					+ entry.getValue().getAllPoints(this, entry.getKey()) + '|' + entry.getValue().getLiteralMark()
//					+ '|' + this.calculateGpa(attestations, entry.getKey()));
//		}
//		System.out.println("---------------------");
//		System.out.println("Total GPA = " + calculateGpaTotal());
//
//	}

	public void viewRequests() {
		for (RequestsForStudent requests : studentsRequests) {
			System.err.println(requests);
		}
	}

	public double calculateGpa(HashMap<Course, Marks> marks, Course course) {
		double a = marks.get(course).getAllPoints(this, course);
		if (a >= 95 && a <= 100) {
			return 4;
		} else if (a >= 90 && a <= 94) {
			return 3.67;
		} else if (a >= 85 && a <= 89) {
			return 3.33;
		} else if (a >= 80 && a <= 84) {
			return 3;
		} else if (a >= 75 && a <= 79) {
			return 2.67;
		} else if (a >= 70 && a <= 74) {
			return 2.33;
		} else if (a >= 65 && a <= 69) {
			return 2;
		} else if (a >= 60 && a <= 64) {
			return 1.67;
		} else if (a >= 55 && a <= 59) {
			return 1.33;
		} else if (a >= 50 && a <= 54) {
			return 1;
		} else {
		
			return 1;
		}
	}
//    public void markAttendance(DataBase db,String lessonName) {
//    	for(Entry<Lesson, Boolean> entry : db.openedAttendances.entrySet()) {
//    		System.out.println(entry.getKey().getCourse().getTitle() + "Status: " + entry.getValue());
//    	}
//    
//    	for(Entry<Lesson, Boolean> entry : db.openedAttendances.entrySet()) {
//    		if(entry.getKey().getCourse().getTitle().equals(lessonName) && entry.getValue().toString().equals("false")) {
//    			db.openedAttendances.replace(entry.getKey(), true);
//    		}
//    	}
//    	
//    }

	public String toString() {
		return super.toString() + " Student info: [gpa=" + this.calculateGpaTotal() + ", faculty=" + faculty
				+ ", yearOfStudy=" + year + " Organization: " + organizationOfStudent + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(degree, faculty, organizationOfStudent, year);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return degree == other.degree && faculty == other.faculty
				&& organizationOfStudent == other.organizationOfStudent && year == other.year;
	}

	public void doResearch(String ResearshName) {
		if (degree.equals(StudentDegree.PHD)) {
			System.out.println("Student can do this " + ResearshName);
		} else {
			System.out.println("Student can not do this " + ResearshName);
		}
	}

	
}