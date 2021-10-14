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
public class CourseProgramme {
    
    private String courseName;
    private String courseId;
    private ArrayList<Module> courseModules;
    private ArrayList<Student> courseStudents;
    private DateTime startDate;
    private DateTime endDate;
    
    // Exception messages
    public static final String START_DATE_FIRST_DESC = "Start date must be before end date!";
    public static final String END_DATE_LAST_DESC = "End date must be after start date!";
    public static final String IDENTICAL_DATES_DESC = "Start and end dates must not be identical.";
    public static final String MODULE_ALREADY_REGISTERED_DESC = "Module is already part of course!";
    public static final String MODULE_ALREADY_REMOVED_DESC = "Module is already not part of course!";
    public static final String STUDENT_ALREADY_REGISTERED_DESC = "Student is already registered for course!";
    public static final String STUDENT_ALREADY_REMOVED_DESC = "Student is already not registered for course!";
    
    public CourseProgramme(String inputName, String inputId, int inputStartYear, int inputStartMonth, int inputStartDay, int inputEndYear, int inputEndMonth, int inputEndDay) throws IllegalFieldValueException, IllegalArgumentException{
        this.courseName = inputName;
        this.courseId = inputId;
        this.courseModules = new ArrayList<>();
        this.courseStudents = new ArrayList<>();
        DateTime inputStartDate = new DateTime(inputStartYear, inputStartMonth, inputStartDay, 0, 0);
        DateTime inputEndDate = new DateTime(inputEndYear, inputEndMonth, inputEndDay, 0, 0);
        
        if (inputStartDate.isAfter(inputEndDate)) throw new IllegalArgumentException(CourseProgramme.START_DATE_FIRST_DESC);
        else if (inputStartDate.equals(inputEndDate)) throw new IllegalArgumentException(CourseProgramme.IDENTICAL_DATES_DESC);
        
        else{
            this.startDate = inputStartDate;
            this.endDate = inputEndDate;
        }
    }
    
    // getters and setters
    // courseName
    public String getCourseName(){
        return courseName;
    }

    public void setCourseName(String input){
        courseName = input;
    }
    
    // courseId
    public String getCourseId(){
        return courseId;
    }

    public void setCourseId(String input){
        courseId = input;
    }
    
    // startDate
    public DateTime getStartDate(){
        return startDate;
    }
    
    public void setStartDate(DateTime input) throws IllegalFieldValueException, IllegalArgumentException{
        if (input.isAfter(endDate)) throw new IllegalArgumentException(CourseProgramme.START_DATE_FIRST_DESC);
        else if (input.equals(endDate)) throw new IllegalArgumentException(CourseProgramme.IDENTICAL_DATES_DESC);
        else startDate = new DateTime(input.getYear(), input.getMonthOfYear(), input.getDayOfMonth(), 0, 0);
    }
    
    // endDate
    public DateTime getEndDate(){
        return endDate;
    }
    
    public void setEndDate(DateTime input) throws IllegalFieldValueException, IllegalArgumentException{
        if (input.isBefore(startDate)) throw new IllegalArgumentException(CourseProgramme.END_DATE_LAST_DESC);
        else if (input.equals(startDate)) throw new IllegalArgumentException(CourseProgramme.IDENTICAL_DATES_DESC);
        else endDate = new DateTime(input.getYear(), input.getMonthOfYear(), input.getDayOfMonth(), 0, 0);
    }
    
    
    // get course modules
    public ArrayList<Module> getCourseModules(){
        return courseModules;
    }
    
    public void addModuleToCourse(Module input) throws IllegalArgumentException{
        if (input.getAssociatedCourses().contains(this) && courseModules.contains(input)){
            throw new IllegalArgumentException(CourseProgramme.MODULE_ALREADY_REGISTERED_DESC);
        }
        else{
            input.getAssociatedCourses().add(this);
            courseModules.add(input);
        }
    }
    
    public void removeModuleFromCourse(Module input) throws IllegalArgumentException{
        if (!(input.getAssociatedCourses().contains(this) && courseModules.contains(input))){
            throw new IllegalArgumentException(CourseProgramme.MODULE_ALREADY_REMOVED_DESC);
        }
        else{
            input.getAssociatedCourses().remove(this);
            courseModules.remove(input);
        }
    }
    
    // get course students
    public ArrayList<Student> getCourseStudents(){
        return courseStudents;
    }
    
    // add student to course
    public void addStudentToCourse(Student input) throws IllegalArgumentException{
        if (input.getRegisteredCourses().contains(this) && courseStudents.contains(input)){
            throw new IllegalArgumentException(CourseProgramme.STUDENT_ALREADY_REGISTERED_DESC);
        }
        else{
            input.getRegisteredCourses().add(this);
            courseStudents.add(input);
        }
    }
    
    // remove student from course
    public void removeStudentFromCourse(Student input) throws IllegalArgumentException{
        if (!(input.getRegisteredCourses().contains(this) && courseStudents.contains(input))){
            throw new IllegalArgumentException(CourseProgramme.STUDENT_ALREADY_REMOVED_DESC);
        }
        else{
            input.getRegisteredCourses().remove(this);
            courseStudents.remove(input);
        }
    }
}
