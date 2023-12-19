package Compare;

import java.io.Serializable;
import java.util.*;
import java.util.Map.Entry;
import Employee.*; 
import Student.*; 

public class CompareByRating implements Serializable{
	
	private static final long serialVersionUID = 1L;
	public static HashMap<Teacher, Integer> sortByValue(HashMap<Teacher, Integer> hm)
    {
        List<Map.Entry<Teacher, Integer> > list =
               new LinkedList<Map.Entry<Teacher, Integer> >(hm.entrySet());
 
        Collections.sort(list, new Comparator<Map.Entry<Teacher, Integer> >() {
            public int compare(Map.Entry<Teacher, Integer> o1,
                               Map.Entry<Teacher, Integer> o2)
            {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });
        HashMap<Teacher, Integer> temp = new LinkedHashMap<Teacher, Integer>();
        for (Entry<Teacher, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
	
	public static HashMap<Student, Double> sortByGPA(HashMap<Student, Double> ratingStudents)
    {
        List<Map.Entry<Student, Double> > list =
               new LinkedList<Map.Entry<Student, Double> >(ratingStudents.entrySet());
 
        Collections.sort(list, new Comparator<Map.Entry<Student, Double> >() {
            public int compare(Map.Entry<Student, Double> o1,
                               Map.Entry<Student, Double> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });
        HashMap<Student, Double> temp = new LinkedHashMap<Student, Double>();
        for (Entry<Student, Double> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
}