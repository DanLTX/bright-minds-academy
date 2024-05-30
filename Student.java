import java.util.*;
import java.text.DecimalFormat;
public class Student
{
    private int studentId;
    private String name;
    private String phone;
    private double cgpa;
    private int subAmt;
    private String[] subName;
    private double fee ;
    
    DecimalFormat df = new DecimalFormat("0.00");
    public Student(int s,String n,String p,double c,int sAmt,String[] sName,double f)
    {
        studentId = s;
        name = n;
        phone = p;
        cgpa = c;
        subAmt = sAmt;
        subName = sName;
        fee = f;
    }
    
    public int getId(){return studentId;}
    public String getName(){return name;}
    public String getPhone(){return phone;}
    public double getCgpa(){return cgpa;}
    public int getSubAmt(){return subAmt;}
    public String[] getSubName(){return subName;}
    public double getFee(){return fee;}
    
    public void setId(int newId){studentId = newId;}
    public void setName(String newName){name = newName;}
    public void setPhone(String newPhone){phone = newPhone;}
    public void setCgpa(double newCgpa){cgpa = newCgpa;}
    public void setSubAmt(int newSubAmt){subAmt = newSubAmt;}
    public void setSubName(String[] newSubName){subName = newSubName;}
    public void setStudentFee(double newFee){fee = newFee;}
    
    public double calculateSubjectFee(String subName) {
        switch (subName) {
            case "ICT200":
                return 114.90; 
            case "MAT210":
                return 122.30; 
            case "CSC248":
                return 190.10; 
            case "CSC301":
                return 177.21; 
            case "CSC207":
                return 136.70; 
            default:
                return 0.0; // Default fee if subject not found or other handling needed
        }
    }
    
    public String toString()
    {
        StringBuilder subjects = new StringBuilder();
        for (int i = 0; i < subAmt; i++) {
            subjects.append(subName[i]);
            if (i < subAmt - 1) {
                subjects.append(", ");
            }
        }
        return (String.format("|%-12s|%-17s|%-14s|%-6s|%-16s|%-39s|%-11s|",studentId,name,phone,
            df.format(cgpa),subAmt,subjects.toString()," RM"+ df.format(fee)));
    }
}
