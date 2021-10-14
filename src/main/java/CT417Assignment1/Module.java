/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CT417Assignment1;
import java.util.ArrayList;

/**
 *
 * @author Anna Hunt (18484674)
 */
public class Module {
    
    private String moduleName;
    private String moduleId;
    private ArrayList<Student> enrolledStudents;
    private ArrayList<CourseProgramme> associatedCourses;
    
    // exception messages
    public static final String STUDENT_ALREADY_REGISTERED_DESC = "Student is already registered for this module!";
    public static final String STUDENT_ALREADY_REMOVED_DESC = "Student is already not registered for this module!";
    public static final String COURSE_ALREADY_REGISTERED_DESC = "Module is already part of course!";
    public static final String COURSE_ALREADY_REMOVED_DESC = "Module is already not part of course!";
    
    public Module(String inputName, String inputId){
        this.moduleName = inputName;
        this.moduleId = inputId;
        this.enrolledStudents = new ArrayList<>();
        this.associatedCourses = new ArrayList<>();
    }
    
    // Getters and Setters
    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }
    
    // get list of enrolled students
    public ArrayList<Student> getEnrolledStudents(){
        return enrolledStudents;
    }
    
    // add Student to enrolled list
    public void addStudent(Student input) throws IllegalArgumentException{
        if (input.getStudentModules().contains(this) && enrolledStudents.contains(input)){
            throw new IllegalArgumentException(Module.STUDENT_ALREADY_REGISTERED_DESC);
        }
        else{
            input.getStudentModules().add(this);
            enrolledStudents.add(input);
        }
    }
    
    // remove Student from enrolled list
    public void removeStudent(Student input) throws IllegalArgumentException{
        if (!(input.getStudentModules().contains(this) && enrolledStudents.contains(input))){
            throw new IllegalArgumentException(Module.STUDENT_ALREADY_REMOVED_DESC);
        }
        else{
            input.getStudentModules().remove(this);
            enrolledStudents.remove(input);
        }
    }
    
    // get list of associated courses
    public ArrayList<CourseProgramme> getAssociatedCourses(){
        return associatedCourses;
    }
    
    // associate course with module
    public void associateCourseWithModule(CourseProgramme input) throws IllegalArgumentException{
        if (input.getCourseModules().contains(this) && associatedCourses.contains(input)){
            throw new IllegalArgumentException(Module.COURSE_ALREADY_REGISTERED_DESC);
        }
        else{
            input.getCourseModules().add(this);
            associatedCourses.add(input);
        }
    }
    
    // remove course from module
    public void removeCourseFromModule(CourseProgramme input) throws IllegalArgumentException{
       if (!(input.getCourseModules().contains(this) && associatedCourses.contains(input))){
           throw new IllegalArgumentException(Module.COURSE_ALREADY_REMOVED_DESC);
       }
       else{
           input.getCourseModules().remove(this);
           associatedCourses.remove(input);
       }
    }
}
