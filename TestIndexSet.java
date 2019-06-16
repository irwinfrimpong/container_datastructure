

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

/**
 * The test class TestIndexSet.
 *
 * @author  (Irwin Frimpong)
 * @version (11/19/18)
 */
public class TestIndexSet
{
    /**
     * Default constructor for test class TestIndexSet
     */
    public TestIndexSet()
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
    
    //Testing the add method 
    @Test 
    public void testAdd() { 
       ListIndexSet<Integer> test = new ListIndexSet<Integer>();
       ArrayList<Integer> tru_ans = new ArrayList<Integer>(); 
       
       // Addiing to ArrayList in ListIndexSet instance 
       test.add(9); 
       test.add(1); 
       test.add(0); 
       test.add(8);
       test.add(5); 
       
       //Creating an arraylist 
       tru_ans.add(0); 
       tru_ans.add(1); 
       tru_ans.add(5); 
       tru_ans.add(8); 
       tru_ans.add(9); 
      
      assertEquals(test.getArray(), tru_ans);   
    } 
    
    //Testing the getKth method 
     @Test
     public void testGetKth(){
     ListIndexSet<Integer> test = new ListIndexSet<Integer>();
     
     // Addiing to ArrayList in ListIndexSet instance 
       test.add(9); 
       test.add(1); 
       test.add(0); 
       test.add(8);
       test.add(5); 
      
       int getKth = test.getKth(3); 
       int tru_ans = 5 ; 
     
       assertEquals(getKth, tru_ans);
    }       
    
    //Testing the Size Method 
    @Test 
    public void testGetSize() { 
    
      ListIndexSet<Integer> test = new ListIndexSet<Integer>();
     
     // Addiing to ArrayList in ListIndexSet instance 
       test.add(9); 
       test.add(1); 
       test.add(0); 
       test.add(8);
       test.add(5); 
       
       int getSize= test.getSize(); 
       int tru_ans = 5 ; 
              
      assertEquals(getSize,tru_ans);
    } 
       
     //Testing the Getting Array Method  
     @Test 
     public void testGetArray() { 
     ListIndexSet<Integer> test = new ListIndexSet<Integer>();
     ArrayList<Integer> tru_ans = new ArrayList<Integer>();
      
     // Addiing to ArrayList in ListIndexSet instance 
       test.add(9); 
       test.add(1); 
       test.add(0); 
       test.add(8);
       test.add(5); 
       
      // Adding to tru_ans arraylist 
      //Creating an arraylist 
       tru_ans.add(0); 
       tru_ans.add(1); 
       tru_ans.add(5); 
       tru_ans.add(8); 
       tru_ans.add(9); 
       
       ArrayList<Integer> the_ans = test.getArray(); 
       
       assertEquals(the_ans,tru_ans);
       
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
