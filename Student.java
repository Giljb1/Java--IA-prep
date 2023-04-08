
import java.io.Serializable;

public class Student implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String name;
    private String lastName;
    private String ssn;

    
    Student(String name, String lastName, String ssn) {
        this.name = name;
        this.lastName = lastName;
        this.ssn = ssn;
    }
    
    public String getName(){
        return this.name;
    }
    
    public String getLastName(){
        return this.lastName;
    }
    
    public String ssn(){
        return this.ssn;
    }

    
    @Override
    public String toString() {
        return "Name:" + this.name + "\nLast Name: " + this.lastName + "\nSSN: " + this.ssn;
    }
    
}
