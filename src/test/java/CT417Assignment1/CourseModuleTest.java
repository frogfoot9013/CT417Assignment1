/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package CT417Assignment1;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Anna Hunt (18484674)
 */
public class CourseModuleTest {
    
    public CourseModuleTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    /**
     * Test of Constructor method, of class CourseModule
     */
    @Test
    public void testCourseModuleConstructor(){
        System.out.println("Test CourseModule Class Constructor");
        try{
            CourseModule instance = new CourseModule("Programming", "C100");
        }catch(IllegalArgumentException e){
            fail("This should not be reached");
        }
    }

    /**
     * Test of getModuleName method, of class CourseModule.
     */
    @Test
    public void testGetModuleName() {
        System.out.println("Test CourseModule class method getModuleName");
        CourseModule instance = new CourseModule("Programming", "C100");
        String expResult = "Programming";
        String result = instance.getModuleName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setModuleName method, of class CourseModule.
     */
    @Test
    public void testSetModuleName() {
        System.out.println("Test CourseModule class method setModuleName");
        String moduleName = "Functional Programming";
        CourseModule instance = new CourseModule("Programming", "C100");
        instance.setModuleName(moduleName);
        assertEquals(moduleName, instance.getModuleName());
    }

    /**
     * Test of getModuleId method, of class CourseModule.
     */
    @Test
    public void testGetModuleId() {
        System.out.println("Test CourseModule class method getModuleId");
        CourseModule instance = new CourseModule("Programming", "C100");
        String expResult = "C100";
        String result = instance.getModuleId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setModuleId method, of class CourseModule.
     */
    @Test
    public void testSetModuleId() {
        System.out.println("Test CourseModule class method setModuleId");
        String moduleId = "C101";
        CourseModule instance = new CourseModule("Programming", "C100");
        instance.setModuleId(moduleId);
        assertEquals(moduleId, instance.getModuleId());
    }

    /**
     * Test of getEnrolledStudents method, of class CourseModule.
     */
    @Test
    public void testGetEnrolledStudents() {
        System.out.println("Test CourseModule class method getEnrolledStudents");
        CourseModule instance = new CourseModule("Programming", "C100");
        ArrayList<Student> expResult = new ArrayList<>();
        ArrayList<Student> result = instance.getEnrolledStudents();
        assertEquals(expResult, result);
    }

    /**
     * Test of addStudent method, of class CourseModule.
     */
    @Test
    public void testAddStudent() {
        System.out.println("Test CourseModule class method addStudent");
        Student input = new Student("Joe Smith", 2000, 2, 29, 19323);
        CourseModule instance = new CourseModule("Programming", "C100");
        instance.addStudent(input);
        assertTrue(instance.getEnrolledStudents().contains(input));
    }
    
    /**
     * Test of addStudent method, of class CourseModule, trying to add a Student already registered
     */
    @Test
    public void testAddStudentFail(){
        System.out.println("Test CourseModule class method addStudent with invalid argument");
        Student input = new Student("Joe Smith", 2000, 2, 29, 19323);
        CourseModule instance = new CourseModule("Programming", "C100");
        instance.addStudent(input);
        try{
            instance.addStudent(input);
            fail("This should not be reached");
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            assertEquals(CourseModule.STUDENT_ALREADY_REGISTERED_ERR, e.getMessage());
        }
    }

    /**
     * Test of removeStudent method, of class CourseModule.
     */
    @Test
    public void testRemoveStudent() {
        System.out.println("Test CourseModule class method removeStudent");
        Student input = new Student("Joe Smith", 2000, 2, 29, 19323);
        CourseModule instance = new CourseModule("Programming", "C100");
        instance.addStudent(input);
        instance.removeStudent(input);
        assertTrue(!instance.getEnrolledStudents().contains(input));
    }
    
    /**
     * Test of removeStudent method, of class CourseModule, trying to remove a Student not registered for the CourseModule.
     */
    @Test
    public void testRemoveStudentFail(){
        System.out.println("Test CourseModule class method removeStudent with invalid argument");
        Student input = new Student("Joe Smith", 2000, 2, 29, 19323);
        CourseModule instance = new CourseModule("Programming", "C100");
        try{
            instance.removeStudent(input);
            fail("This should not be reached.");
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            assertEquals(CourseModule.STUDENT_ALREADY_REMOVED_ERR, e.getMessage());
        }
    }

    /**
     * Test of getAssociatedCourses method, of class CourseModule.
     */
    @Test
    public void testGetAssociatedCourses() {
        System.out.println("Test CourseModule class method getAssociatedCourses");
        CourseModule instance = new CourseModule("Programming", "C100");
        ArrayList<CourseProgramme> expResult = new ArrayList<>();
        ArrayList<CourseProgramme> result = instance.getAssociatedCourses();
        assertEquals(expResult, result);
    }

    /**
     * Test of associateCourseWithModule method, of class CourseModule.
     */
    @Test
    public void testAssociateCourseWithModule() {
        System.out.println("Test CourseModule class method associateCourseWithModule");
        CourseProgramme input = new CourseProgramme("Computer Science", "CS", 2021, 9, 5, 2022, 5, 15);
        CourseModule instance = new CourseModule("Programming", "C100");
        instance.associateCourseWithModule(input);
        assertTrue(instance.getAssociatedCourses().contains(input));
    }
    
    /**
     * Test of associateCourseWithModuleMethod, of class CourseModule, by adding a course already associated with the CourseModule
     */
    @Test
    public void testAssociateCourseWithModuleFail(){
        System.out.println("Test CourseModule class method associateCourseWithModule with invalid input");
        CourseProgramme input = new CourseProgramme("Computer Science", "CS", 2021, 9, 5, 2022, 5, 15);
        CourseModule instance = new CourseModule("Programming", "C100");
        instance.associateCourseWithModule(input);
        try{
            instance.associateCourseWithModule(input);
            fail("This should not be reached.");
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            assertEquals(CourseModule.COURSE_ALREADY_REGISTERED_ERR, e.getMessage());
        }
        
    }

    /**
     * Test of deassociateCourseFromModule method, of class CourseModule.
     */
    @Test
    public void testRemoveCourseFromModule() {
        System.out.println("Test CourseModule class method deassociateCourseFromModule");
        try{ // valid removal
            CourseProgramme input = new CourseProgramme("Computer Science", "CS", 2021, 9, 5, 2022, 5, 15);
            CourseModule instance = new CourseModule("Programming", "C100");
            instance.associateCourseWithModule(input);
            instance.removeCourseFromModule(input);
            assertTrue(!instance.getAssociatedCourses().contains(input));            
        }catch(IllegalArgumentException e){
            fail("This should not be reached, this should be valid.");
        }

    }
    
    /**
     * Test of deassociateCourseFromModule method, of class CourseModule, by removing a course with which the CourseModule is not associated
     */
    @Test
    public void testRemoveCourseFromModuleFail(){
        System.out.println("Test CourseModule class method deassociateCourseFromModule with invalid input");
        CourseProgramme input = new CourseProgramme("Computer Science", "CS", 2021, 9, 5, 2022, 5, 15);
        CourseModule instance = new CourseModule("Programming", "C100");
        try{
            instance.removeCourseFromModule(input);
            fail("This should not be reached, this should be invalid");
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            assertEquals(CourseModule.COURSE_ALREADY_REMOVED_ERR, e.getMessage());
        }
    }
    
}
