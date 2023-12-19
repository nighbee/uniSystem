package Student;
import enums.*; 
import java.io.Serializable;
import java.util.Vector;

public class Classroom implements Serializable{
	
	private static final long serialVersionUID = 1L;	public int cabinetNumber;
	
	public ClassRoomType classRoomType;
	
	public Vector <String> equipment = new Vector<String>();
	
	public Classroom(int cabinetNumber,ClassRoomType classRoomType) {
		this.cabinetNumber = cabinetNumber;
		this.classRoomType = classRoomType;
	}
	
	public String toString() {
		String t = null;
		for(String s : equipment) {
			t += s;
			t += ",";
		}
		t = t.substring(0, t.length()-1);
		return "[ Classroom number: " + cabinetNumber + " | Classroom type: " + classRoomType + " | " + t; 
				 
	}
}