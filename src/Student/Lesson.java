 package Student;
import java.io.Serializable;
import java.util.Objects;
import enums.*; 

public class Lesson {
	private Classroom classroom;
	
	private Course course;
    
    private LessonType type;
    
    private LessonFormat format;
    
    private String time;
    
    private Day day;
    
    Lesson(Day day,Course course,String time,LessonType type,LessonFormat format,Classroom classroom){
    	this.day = day;
    	this.course = course;
    	this.time = time;
    	this.type = type;
    	this.format = format;
    	this.classroom = classroom;
    }
    
    public LessonType getType() {
        return this.type;
    }
    
    public String getTime() {
        return this.time;
    }
    
    public void setTime(String time) {
        this.time = time;
    }
    
    public Day getDay() {
        return this.day;
    }
    
    public Course getCourse() {
    	return this.course;
    }
    
    public void setDay(Day day) {
        this.day = day;
    }
    
    public String toString() {
    	return "[ Day: " + day + " | Subject: " + course.getTitle() + " | LessonType: " + type + " | Time: " + time + " | Classroom: " + classroom.cabinetNumber + " ]";
    }

	@Override
	public int hashCode() {
		return Objects.hash(classroom, course, day, format, time, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lesson other = (Lesson) obj;
		return Objects.equals(classroom, other.classroom) && Objects.equals(course, other.course) && day == other.day
				&& format == other.format && Objects.equals(time, other.time) && type == other.type;
	}
}