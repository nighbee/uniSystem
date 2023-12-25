package Student;

import java.util.*;
import java.io.*;

public class Marks implements Serializable {
    
	private int markTotal;
    
    private int points;
    
    public Marks(int points, String date, boolean attendance) {
		this.points = points;
		this.attendance = attendance;
		this.date = date;
    }
    public Marks(int firstAttestationMark, int secondAttestationMark, int markForFinal) {
		this.firstAttestationMark = firstAttestationMark;
		this.secondAttestationMark = secondAttestationMark;
		this.markForFinal = markForFinal;
    }
    
	private String date;
	private String literalMark;
    
    private int firstAttestationMark;
    
    private int secondAttestationMark;
    
    private int markForFinal;
    
    private double gpa;
    
    private String reportStatistics;
    
    private boolean attendance;
    
    public int getAllPoints(Student s, Course course) {
    	markTotal = s.getMark(course).get(course).points + firstAttestationMark + secondAttestationMark + markForFinal;
    	return markTotal;
    }
    
    public void setPoints(Integer points) {
        this.points = points;
    }
    
    public String getLiteralMark() {
	      int a =  markTotal;
		  if(a>100){String t="ERROR";return t;}
		  else if(a>=95 && a<=100){String t="A";return t;}
		  else if(a>=90 && a<=94){String t="A-";return t;}
		  else if(a>=85 && a<=89){String t="B+";return t;}
		  else if(a>=80 && a<=84){String t="B";return t;}
		  else if(a>=75 && a<=79){String t="B-";return t;}
		  else if(a>=70 && a<=74){String t="C+";return t;}
		  else if(a>=65 && a<=69){String t="C";return t;}
		  else if(a>=60 && a<=64){String t="C-";return t;}
		  else if(a>=55 && a<=59){String t="D+";return t;}
		  else if(a>=50 && a<=54){String t="D";return t;}
		  else {String t="F";return t;}
    }
    
    public void setLiteralMark(String literalMark) {
        this.literalMark = literalMark;
    }
    
    public int getMarkForMidterm() {
        return this.firstAttestationMark;
    }
    
    public void setMarkForMidterm(Integer markForMidterm) {
        this.firstAttestationMark = markForMidterm;
    }
    
    public int getMarkForEndterm() {
        return this.secondAttestationMark;
    }
    
    public void setMarkForEndterm(Integer markForEndterm) {
        this.secondAttestationMark = markForEndterm;
    }
    
    public int getMarkForFinal() {
        return this.markForFinal;
    }
    
    public void setMarkForFinal(Integer markForFinal) {
        this.markForFinal = markForFinal;
    }
    
    public double getGpa() {
        return this.gpa;
    }
    
    public void setGpa(Double gpa) {
        this.gpa = gpa;
    }
    public String getDate() {
        return this.date;
    }
    
    public void setGpa(String date) {
        this.date = date;
    }
    
    public String getReportStatistics() {
        return this.reportStatistics;
    }
    
    public void setReportStatistics(String reportStatistics) {
        this.reportStatistics = reportStatistics;
    }
    
    public boolean getAttendance() {
        return this.attendance;
    }
    
    public void setAttendance(Boolean attendance) {
        this.attendance = attendance;
    }
    

	public String toString() {
		return "Mark [points=" + points + ", date=" + date + ", attendance=" + attendance + "]";
	}
	public String attestations() {
		return "Mark [first attestation=" + firstAttestationMark + ", second attestation =" + secondAttestationMark + ", final=" + markForFinal + "]";
	}
    
    
    
}