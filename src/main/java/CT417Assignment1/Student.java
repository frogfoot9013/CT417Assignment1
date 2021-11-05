/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CT417Assignment1;
import org.joda.time.DateTime;
import java.util.ArrayList;
import org.joda.time.IllegalFieldValueException;

/**
 *
 * @author Anna Hunt (18484674)
 */
public class Student {
    
    private String name;
    private int age;
    private DateTime dob;
    private String username;
    private int studentId;
    private ArrayList<CourseModule> studentModules;
    private ArrayList<CourseProgramme> registeredCourses;
    
    // exception messages
    public static final String FUTURE_DOB_ERR = "Date of birth cannot be in the future!";
    public static final String MODULE_ALREADY_REGISTERED_ERR = "Student is already registered for this module!";
    public static final String MODULE_ALREADY_REMOVED_ERR = "Student is already not registered for this course!";
    public static final String COURSE_ALREADY_REGISTERED_ERR = "Student already registered for this course!";
    public static final String COURSE_ALREADY_REMOVED_ERR = "Student is already not registered for this course!";
    
    public Student(String inputName, int inputBirthYear, int inputBirthMonth, int inputBirthDay, int inputId) throws IllegalFieldValueException, IllegalArgumentException{
        this.name = inputName;
        this.dob = new DateTime(inputBirthYear, inputBirthMonth, inputBirthDay, 0, 0);
        // setting a correct age
        DateTime currTime = new DateTime();
        if (dob.isAfter(currTime)){
            throw new IllegalArgumentException(Student.FUTURE_DOB_ERR);
        }
        else{
            this.age = currTime.getYear() - dob.getYear();
            this.username = name + age;
            this.studentId = inputId;
            this.studentModules = new ArrayList<>();
            this.registeredCourses = new ArrayList<>();
        }
    }
    
    // getters and setters
    // name
    public String getName(){
        return name;
    }
    
    public void setName(String input){
        name = input;
    }
    
    // age
    public int getAge(){
        return age;
    }
    
    public void setAge(){
        DateTime currTime = new DateTime();
        age = currTime.getYear() - dob.getYear();
        username = getUsername();
    }
    
    // dob
    public DateTime getDob(){
        return dob;
    }
    
    public void setDob(DateTime input) throws IllegalArgumentException, IllegalFieldValueException{
        try{
            DateTime currTime = new DateTime();
            if (input.isAfter(currTime)){
                throw new IllegalArgumentException(Student.FUTURE_DOB_ERR);
            }
            else{
                dob = input;
                setAge();
            }
        }catch(IllegalFieldValueException e){
            e.getMessage();
        }
    }
    
    // studentId
    public int getStudentId(){
        return studentId;
    }
    
    public void setStudentId(int input){
        studentId = input;
    }


    // getUsername() method as outlined in the assignment brief
    public String getUsername(){
        username = name + age;
        return username;
    }
    
    // studentModules
    public ArrayList<CourseModule> getStudentModules(){
        return studentModules;
    }
    
    // add Student to module
    public void addModule(CourseModule input) throws IllegalArgumentException{
        if (input.getEnrolledStudents().contains(this) && this.studentModules.contains(input)){// student already registered
            throw new IllegalArgumentException(Student.MODULE_ALREADY_REGISTERED_ERR);
        }
        else{
            input.getEnrolledStudents().add(this);
            studentModules.add(input);
        }
    }
    
    // remove Student from module
    public void removeModule(CourseModule input) throws IllegalArgumentException{
        if (!(input.getEnrolledStudents().contains(this) && studentModules.contains(input))){// student already not registered
            throw new IllegalArgumentException(Student.MODULE_ALREADY_REMOVED_ERR);
        }
        else{
            input.getEnrolledStudents().remove(this);
            this.studentModules.remove(input);
        }
    }
    
    // registeredCourses
    public ArrayList<CourseProgramme> getRegisteredCourses(){
        return registeredCourses;
    }
    
    // add Student to CourseProgramme
    public void addStudentToCourse(CourseProgramme input) throws IllegalArgumentException{
        if (input.getCourseStudents().contains(this) && registeredCourses.contains(input)){// student already registered for course
            throw new IllegalArgumentException(Student.COURSE_ALREADY_REGISTERED_ERR);
        }
        else{
            input.getCourseStudents().add(this);
            registeredCourses.add(input);
        }
    }
    
    // remove Student from CourseProgramme
    public void removeStudentFromCourse(CourseProgramme input) throws IllegalArgumentException{
        if (!(input.getCourseStudents().contains(this) && registeredCourses.contains(input))){// student already not registered for course
            throw new IllegalArgumentException(Student.COURSE_ALREADY_REMOVED_ERR);
        }
        else{
            input.getCourseStudents().remove(this);
            registeredCourses.remove(input);
        }
    }
}
