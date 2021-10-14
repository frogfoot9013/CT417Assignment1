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
public class ModuleTest {
    
    public ModuleTest() {
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
     * Test of Constructor method, of class Module
     */
    @Test
    public void testModuleConstructor(){
        System.out.println("Test Module Class Constructor");
        try{
            Module instance = new Module("Programming", "C100");
        }catch(IllegalArgumentException e){
            fail("This should not be reached");
        }
    }

    /**
     * Test of getModuleName method, of class Module.
     */
    @Test
    public void testGetModuleName() {
        System.out.println("Test Module class method getModuleName");
        Module instance = new Module("Programming", "C100");
        String expResult = "Programming";
        String result = instance.getModuleName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setModuleName method, of class Module.
     */
    @Test
    public void testSetModuleName() {
        System.out.println("Test Module class method setModuleName");
        String moduleName = "Functional Programming";
        Module instance = new Module("Programming", "C100");
        instance.setModuleName(moduleName);
        assertEquals(moduleName, instance.getModuleName());
    }

    /**
     * Test of getModuleId method, of class Module.
     */
    @Test
    public void testGetModuleId() {
        System.out.println("Test Module class method getModuleId");
        Module instance = new Module("Programming", "C100");
        String expResult = "C100";
        String result = instance.getModuleId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setModuleId method, of class Module.
     */
    @Test
    public void testSetModuleId() {
        System.out.println("Test Module class method setModuleId");
        String moduleId = "C101";
        Module instance = new Module("Programming", "C100");
        instance.setModuleId(moduleId);
        assertEquals(moduleId, instance.getModuleId());
    }

    /**
     * Test of getEnrolledStudents method, of class Module.
     */
    @Test
    public void testGetEnrolledStudents() {
        System.out.println("Test Module class method getEnrolledStudents");
        Module instance = new Module("Programming", "C100");
        ArrayList<Student> expResult = new ArrayList<>();
        ArrayList<Student> result = instance.getEnrolledStudents();
        assertEquals(expResult, result);
    }

    /**
     * Test of addStudent method, of class Module.
     */
    @Test
    public void testAddStudent() {
        System.out.println("Test Module class method addStudent");
        Student input = new Student("Joe Smith", 2000, 2, 29, 19323);
        Module instance = new Module("Programming", "C100");
        instance.addStudent(input);
        assertTrue(instance.getEnrolledStudents().contains(input));
    }
    
    /**
     * Test of addStudent method, of class Module, trying to add a Student already registered
     */
    @Test
    public void testAddStudentFail(){
        System.out.println("Test Module class method addStudent with invalid argument");
        Student input = new Student("Joe Smith", 2000, 2, 29, 19323);
        Module instance = new Module("Programming", "C100");
        instance.addStudent(input);
        try{
            instance.addStudent(input);
            fail("This should not be reached");
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            assertEquals(Module.STUDENT_ALREADY_REGISTERED_DESC, e.getMessage());
        }
    }

    /**
     * Test of removeStudent method, of class Module.
     */
    @Test
    public void testRemoveStudent() {
        System.out.println("Test Module class method removeStudent");
        Student input = new Student("Joe Smith", 2000, 2, 29, 19323);
        Module instance = new Module("Programming", "C100");
        instance.addStudent(input);
        instance.removeStudent(input);
        assertTrue(!instance.getEnrolledStudents().contains(input));
    }
    
    /**
     * Test of removeStudent method, of class Module, trying to remove a Student not registered for the Module.
     */
    @Test
    public void testRemoveStudentFail(){
        System.out.println("Test Module class method removeStudent with invalid argument");
        Student input = new Student("Joe Smith", 2000, 2, 29, 19323);
        Module instance = new Module("Programming", "C100");
        try{
            instance.removeStudent(input);
            fail("This should not be reached.");
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            assertEquals(Module.STUDENT_ALREADY_REMOVED_DESC, e.getMessage());
        }
    }

    /**
     * Test of getAssociatedCourses method, of class Module.
     */
    @Test
    public void testGetAssociatedCourses() {
        System.out.println("Test Module class method getAssociatedCourses");
        Module instance = new Module("Programming", "C100");
        ArrayList<CourseProgramme> expResult = new ArrayList<>();
        ArrayList<CourseProgramme> result = instance.getAssociatedCourses();
        assertEquals(expResult, result);
    }

    /**
     * Test of associateCourseWithModule method, of class Module.
     */
    @Test
    public void testAssociateCourseWithModule() {
        System.out.println("Test Module class method associateCourseWithModule");
        CourseProgramme input = new CourseProgramme("Computer Science", "CS", 2021, 9, 5, 2022, 5, 15);
        Module instance = new Module("Programming", "C100");
        instance.associateCourseWithModule(input);
        assertTrue(instance.getAssociatedCourses().contains(input));
    }
    
    /**
     * Test of associateCourseWithModuleMethod, of class Module, by adding a course already associated with the Module
     */
    @Test
    public void testAssociateCourseWithModuleFail(){
        System.out.println("Test Module class method associateCourseWithModule with invalid input");
        CourseProgramme input = new CourseProgramme("Computer Science", "CS", 2021, 9, 5, 2022, 5, 15);
        Module instance = new Module("Programming", "C100");
        instance.associateCourseWithModule(input);
        try{
            instance.associateCourseWithModule(input);
            fail("This should not be reached.");
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            assertEquals(Module.COURSE_ALREADY_REGISTERED_DESC, e.getMessage());
        }
        
    }

    /**
     * Test of deassociateCourseFromModule method, of class Module.
     */
    @Test
    public void testRemoveCourseFromModule() {
        System.out.println("Test Module class method deassociateCourseFromModule");
        try{ // valid removal
            CourseProgramme input = new CourseProgramme("Computer Science", "CS", 2021, 9, 5, 2022, 5, 15);
            Module instance = new Module("Programming", "C100");
            instance.associateCourseWithModule(input);
            instance.removeCourseFromModule(input);
            assertTrue(!instance.getAssociatedCourses().contains(input));            
        }catch(IllegalArgumentException e){
            fail("This should not be reached, this should be valid.");
        }

    }
    
    /**
     * Test of deassociateCourseFromModule method, of class Module, by removing a course with which the Module is not associated
     */
    @Test
    public void testRemoveCourseFromModuleFail(){
        System.out.println("Test Module class method deassociateCourseFromModule with invalid input");
        CourseProgramme input = new CourseProgramme("Computer Science", "CS", 2021, 9, 5, 2022, 5, 15);
        Module instance = new Module("Programming", "C100");
        try{
            instance.removeCourseFromModule(input);
            fail("This should not be reached, this should be invalid");
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            assertEquals(Module.COURSE_ALREADY_REMOVED_DESC, e.getMessage());
        }
    }
    
}
