
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TestTreeIndexSet.
 *
 * @author  (Irwin Frimpong)
 * @version (11/19/18)
 */
public class TestTreeIndexSet
{
    /**
     * Default constructor for test class TestTreeIndexSet
     */
    public TestTreeIndexSet()
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

    //Testing the Add Method 
    @Test 
    public void testAdd() { 

        TreeIndexSet<Integer> test = new TreeIndexSet<Integer>(); 

        boolean the_ans = test.add(5); 
        boolean tru_ans = true; 

        assertEquals(the_ans, tru_ans);

    } 

    //Testing the GetKth Method 
    @Test
    public void testGetKth() { 
        TreeIndexSet<Integer> test = new TreeIndexSet<Integer>(); 

        test.add(16); 
        test.add(15); 
        test.add(17); 

        int the_ans = test.getKth(1) ; 
        int tru_ans = 15; 

        assertEquals(the_ans, tru_ans);

    } 

    //Testing the get Size Method 
    @Test 
    public void testgetSize() { 
       TreeIndexSet<Integer> test = new TreeIndexSet<Integer>(); 

        test.add(16); 
        test.add(15); 
        test.add(17); 
        
        int the_ans = test.getSize(); 
        int tru_ans = 3 ; 
        
        assertEquals(the_ans, tru_ans);
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
