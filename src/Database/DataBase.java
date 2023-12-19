package Database;
import user.*;
import Employee.*;
import java.util.*;
import java.util.Map.Entry;
import java.io.*;
import Student.*; 
import enums.*; 
import user.*; 
import Compare.*; 
public class DataBase implements Serializable {
	
	
  
	private static final long serialVersionUID = 1L;
	public Vector<Course> courses = new Vector<Course>();
    Course c1 = new Course("Database", 5, "DB456", "21T7KMAL791",2);
	Course c2 = new Course("DiscreteMath", 5, "DM789", "21T4FITL656",1);
	Course c3 = new Course("IKT", 4, "IK789", "21T9ISEL478",2);
	public HashMap<Course,Course> preRequisite = new HashMap<Course,Course>();

	Course c4 = new Course("PP1",43,"PP123","21T4FITL656",1);
    {
    	preRequisite.put(c1, c4);
    	preRequisite.put(c3, c4);
    	courses.add(c1);
    	courses.add(c2);
    	courses.add(c3);
    }
	DataBase(){
			
	}
	
	public HashMap <Student,Integer> failOfStudents = new HashMap<Student,Integer>();
	public HashMap<Lesson,Boolean> openedAttendances = new HashMap<Lesson,Boolean>();
	public HashMap<Teacher,Integer> ratingTeachers = new HashMap<Teacher,Integer>();
    public HashMap<Student,Double> ratingStudents = new HashMap<Student,Double>();
    
    public static DataBase instance = new DataBase();
    
    public Vector<User> users = new Vector<User>();
    
    public Vector<Employee> employees = new Vector<Employee>();
    public Vector<Student> students = new Vector<Student>();
   
    public Vector<News> news = new Vector<News>();
    
    public Vector<RequestsForStudent> requestsForStudent = new Vector<RequestsForStudent>();
    public Vector<RequestsForTeacher> requestsForTeacher = new Vector<RequestsForTeacher>();

    public void fill() {
    	if(users.size() != 0) {
			for(User u : users) {
	    		if(u.getClass() == Teacher.class) {
	    			ratingTeachers.put((Teacher)u, 0);
	    		}
	    	}
			for(User u : users) {
	    		if(u.getClass() == Student.class) {
	    			ratingStudents.put((Student)u, 0.0);
	    		}
	    	}
			for(Student st : students) {
				failOfStudents.put(st, 0);
	    	}
    	}
		
	}
    
    
    public static DataBase read1() throws IOException, ClassNotFoundException{
		FileInputStream fis = new FileInputStream("/Users/endurance/eclipse-workspace/University System/src/Databaza.ser");
		ObjectInputStream oin = new ObjectInputStream(fis);
		return (DataBase) oin.readObject();
	}
	public static void write()throws IOException{
		FileOutputStream fos = new FileOutputStream("/Users/endurance/eclipse-workspace/University System/src/Databaza.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(instance);
		oos.flush();
		oos.close();
	}
    
	public static final DataBase getDatabase() {
	    if(new File("/Users/endurance/eclipse-workspace/University System/src/Databaza.ser").exists()) {
	      try {
	        instance = read1();
	      } catch (Exception e) {
	        e.printStackTrace();
	      }
	    
	    }
	    else {instance = new DataBase();}
	    return instance;
	  }

    public Course findCourse(String name) {
    	Course temp = null;
    	for(Course c : this.courses) {
    		if(c.getTitle().equals(name)) {
    			temp = c;
    		}
    	}
		return temp;
    }
    public void checkForRatingStudent(User u) {
    	if(this.ratingStudents.containsKey(u) == false) {
    		ratingStudents.put((Student) u, 0.0);
    	}
    }
    public void checkForRatingTeacher(User u) {
    	if(this.ratingTeachers.containsKey(u) == false) {
    		ratingTeachers.put((Teacher) u, 0);
    	}
    }
    public void addUsers(User user) {
    	users.add(user);
    	if(user.getUserID().charAt(2)=='M' || user.getUserID().charAt(2)=='T') {
    		employees.add((Employee)user);
    	}else if(user.getUserID().charAt(2)=='S') {
    		students.add((Student)user);
    	}
    }
    public void getAllRequests() {
    	for(RequestsForStudent requests1 : requestsForStudent) {
    		System.err.println(requests1.toString());
    	}
    	for(RequestsForTeacher requests2 : requestsForTeacher) {
    		System.err.println(requests2.toString());
    	}
    }
    
    public void viewTeacherOfSpecificCourse(String title) {
    	for(Course c : courses) {
    		if(c.getTitle().equals(title)) {
    			for(User u : users) {
    				if(u.getUserID().equals(c.getTeachersById())){
    					System.err.println(u);
    				}
    			}
    		}
    	}
    }
    
    
    public Vector<User> getUsers() {
        return users;
    }
    
    public User getUser(String idName) {
    	for(User u : users) {
    		if(u.getUserName().equals(idName) || u.getUserID().equals(idName)) {
    			return u;
    		}
    	}
		return null;
    	
    }
   
    public void getStudent() {
        for(User u : users) {
        	if(u.getClass() == Student.class) {
        		System.err.println(u);
        	}
        }
    }
    
    public void viewEmployeeSortBySalaty() {
    	Collections.sort(employees, new compareBySalary());
    	for(Employee e : employees) {
        	System.err.println(e);
        }
    }
    public void viewEmployees() {
    	for(Employee e : employees) {
        	System.err.println(e);
        }
    }
    
	public void viewStudentSortedByName() {
		Collections.sort(users, new CompareByName()); 
		for(User u : users) {
        	if(u.getClass() == Student.class) {
        		System.err.println(u);
        	}
        }
	}
    
    public void deleteUser(String id) {
    	for(User u : users) {
    		if(u.getUserID().equals(id)) {
    			users.remove(u);
    		}
    	}
    }
    public void changePassword(String id,String password) {
    	for(User u : users) {
    		if(u.getUserID().equals(id)) {
    			u.setPassword(password);
    		}
    	}
    }
    
    public void changeEmail(String id,String email) {
    	for(User u : users) {
    		if(u.getUserID().equals(id)) {
    			u.setEmail(email);
    		}
    	}
    }
    
    public HashMap<Teacher,Integer> getRatingTeacher() {
    	HashMap<Teacher,Integer> temp = CompareByRating.sortByValue(ratingTeachers);
    	return temp;
    }
    
    
    public HashMap<Student,Double> getRatingStudent() {
    	for(Student s: this.students) {
    		this.ratingStudents.put(s, s.calculateGpaTotal());
    	}
    	HashMap<Student,Double> temp = CompareByRating.sortByGPA(ratingStudents);
    	return temp;
    }
    public void findStudent(String name) {
    	String z = "^(" + name + ").*$";
    	for(Student st : this.students) {
    		if(st.getUserName().matches(z)) {
    			System.err.println(st);
    		}
    	}
    }
    
    public User getUsetByLogin(String login) {
    	for(User u: users) {
    		if(u.getUserID().equals(login)) {
    			return u;
    		}
    		else {
    			continue;
    		}
    	}
    	return null;
    }

}