import java.util.ArrayList;
import java.util.Arrays;

public class Students 
{
    
    //Students 
    private ArrayList<Student> students;
    
    
    public Students(){
        
        students = new ArrayList<Student>(); 
        
    }
    
    //Add student to the list
    public void add(Student s){
        students.add(s);
        System.out.println("Student added to the list");
    }
    
    
    public String toString(){
        
        String out = "\nList of students\n";
        
        for(Student s: students) {   
            out+= s.toString() + "\n\n";
        }  
        
        
        return out;
    }
    
    
    
    
}
