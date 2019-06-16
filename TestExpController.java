
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.Scanner; 
import java.io.FileReader; 

/**
 * The test class TestExpController.
 *
 * @author  (Irwin Frimpong)
 * @version (11/19/18)
 */
public class TestExpController
{
    /**
     * Default constructor for test class TestExpController
     */
    public TestExpController()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    // Tesiting the 25% Generation of Adds 
    @Test 
    public void testGenerate25() { 

        ExperimentController irwin = new ExperimentController() ; 

         //Generate File with all the add and getKth function 
         irwin.generate25(20) ; 
        
        int num_add = 5 ; 
        
        int add_count =0 ; // Keep track of the number of adds 

        //Want to Scann to count the number of adds using a scanner 
        try{  
            // Setting up the scanner 
            Scanner sc = new Scanner( new FileReader("input_25.txt")); 
            int line_count = 0 ; 
            while(sc.hasNextLine() ) {
                if (line_count > 0) {
                    //String holds the contents of the scanner 
                    String content = sc.nextLine(); 

                    //Storing the split values of the contents string 
                    String content_s [] = content.split(" ") ; 

                    // content_s[0] stores the function
                    if (content_s[0].equals("add")) { 

                        add_count ++ ; 
                        //System.out.println("Add Count: " + add_count); 
                    }
                    
                }
                line_count ++ ;
            } 
        }catch (Exception e) {
            System.out.println ("Exception occured " + e); 

        }
        
        assertEquals(num_add, add_count);
    }
    
    // Testing 50% Add 
    @Test 
    public void testGenerate50(){ 
       
        ExperimentController irwin = new ExperimentController() ; 

         //Generate File with all the add and getKth function 
         irwin.generate50(20) ; 
        
        int num_add = 10 ; 
        
        int add_count =0 ; // Keep track of the number of adds 

        //Want to Scann to count the number of adds using a scanner 
        try{  
            // Setting up the scanner 
            Scanner sc = new Scanner( new FileReader("input_50.txt")); 
            int line_count = 0 ; 
            while(sc.hasNextLine() ) {
                if (line_count > 0) {
                    //String holds the contents of the scanner 
                    String content = sc.nextLine(); 

                    //Storing the split values of the contents string 
                    String content_s [] = content.split(" ") ; 

                    // content_s[0] stores the function
                    if (content_s[0].equals("add")) { 

                        add_count ++ ; 
                        //System.out.println("Add Count: " + add_count); 
                    }
                    
                }
                line_count ++ ;
            } 
        }catch (Exception e) {
            System.out.println ("Exception occured " + e); 

        }
        
        assertEquals(num_add, add_count);
                
    } 
    
    //Testing 75% Add
    @Test
    public void testGenerate75() { 
        
     ExperimentController irwin = new ExperimentController() ; 

         //Generate File with all the add and getKth function 
         irwin.generate75(100) ; 
        
        int num_add = 75 ; 
        
        int add_count =0 ; // Keep track of the number of adds 

        //Want to Scann to count the number of adds using a scanner 
        try{  
            // Setting up the scanner 
            Scanner sc = new Scanner( new FileReader("input_75.txt")); 
            int line_count = 0 ; 
            while(sc.hasNextLine() ) {
                if (line_count > 0) {
                    //String holds the contents of the scanner 
                    String content = sc.nextLine(); 

                    //Storing the split values of the contents string 
                    String content_s [] = content.split(" ") ; 

                    // content_s[0] stores the function
                    if (content_s[0].equals("add")) { 

                        add_count ++ ; 
                        //System.out.println("Add Count: " + add_count); 
                    }
                    
                }
                line_count ++ ;
            } 
        }catch (Exception e) {
            System.out.println ("Exception occured " + e); 

        }
        
        assertEquals(num_add, add_count);
                   
        
    }
    

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
}
