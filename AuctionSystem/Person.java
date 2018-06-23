/**
 * Person
 */
import java.util.*;

public class Person {
    private String name;
    public Person(String name){
        if(name==null) throw new NullPointerException();
        if(name=="") throw new IllegalArgumentException();
        this.name=name;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return name;
    }
    
}