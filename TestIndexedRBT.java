
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TestIndexedRBT.
 *
 * @author  (Irwin Frimpong)
 * @version (11/19/18)
 */
public class TestIndexedRBT
{
    /**
     * Default constructor for test class TestIndexedRBT
     */
    public TestIndexedRBT()
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

    //Testing Add Method W/ Rotation With Right Child 
    @Test 
    public void testadd1() { 

        IndexedRedBlackTree<Integer> test= new IndexedRedBlackTree<Integer>(); 

        test.add(14); 
        test.add(16); 
        test.add(17); 
        test.add(18); 

        //Testing to see if the size of the header updated to reflect the addition of the nodes

        int the_ans= test.getSize(test.getRight(test.getHeader()));
        int tru_ans = 4 ; 

        assertEquals(the_ans,tru_ans);    

    } 

    @Test 
    public void testadd2() { 

        IndexedRedBlackTree<Integer> test= new IndexedRedBlackTree<Integer>(); 

        test.add(14); 
        test.add(16); 
        test.add(17); 
        test.add(18); 

        //Testing to see if the size of the header updated to reflect the addition of the nodes
        //Checking size of the right subtree 

        int header_right= test.getSize(test.getRight(test.getRight(test.getHeader()))); 
        int tru_size = 2 ; 

        assertEquals(header_right,tru_size);    

    }

    @Test 
    public void testadd3() { 

        IndexedRedBlackTree<Integer> test= new IndexedRedBlackTree<Integer>(); 

        test.add(14); 
        test.add(16); 
        test.add(17); 
        test.add(18); 

        //Testing to see if the size of the header updated to reflect the addition of the nodes
        //Checking size of the left subtree 

        int header_left= test.getSize(test.getLeft(test.getRight(test.getHeader()))); 
        int tru_size = 1 ; 

        assertEquals(header_left,tru_size);    

    }

    //Testing add with Rotation W/ Left Child
    @Test
    public void testadd4(){ 

        IndexedRedBlackTree<Integer> test= new IndexedRedBlackTree<Integer>();

        test.add(14); 
        test.add(13); 
        test.add(12); 

        //Testing to see if the sizes update correctly after the rotation 
        int the_ans = test.getSize(test.getRight(test.getHeader())); 
        int tru_ans = 3; 

        assertEquals(the_ans,tru_ans);       

    } 

    // Testing Get Kth 

    @Test 
    public void testGetKth1() { 
        IndexedRedBlackTree<Integer> test= new IndexedRedBlackTree<Integer>(); 

        test.add(14); 
        test.add(16); 
        test.add(17); 
        test.add(18); 
        test.add(13);

        int the_ans = test.findKth(1); 
        int tru_ans = 13; 

        assertEquals(the_ans,tru_ans);    

    } 

    @Test 
    public void testGetKth2() { 

        IndexedRedBlackTree<Integer> test= new IndexedRedBlackTree<Integer>(); 

        test.add(14); 
        test.add(16);

        int the_ans = test.findKth(1); 
        int tru_ans = 14 ; 

        assertEquals(the_ans,tru_ans);    
    }

    @Test 
    public void testGetKth3 () { 

        IndexedRedBlackTree<Integer> test= new IndexedRedBlackTree<Integer>(); 

        test.add(14); 
        test.add(16); 
        test.add(17); 
        test.add(18); 
        test.add(13);

        int the_ans = test.findKth(4); 
        int tru_ans = 17 ; 

        assertEquals(the_ans,tru_ans);    
    }

    // Testing Size Getter 
    @Test 
    public void testgetSize() { 

        IndexedRedBlackTree<Integer> test= new IndexedRedBlackTree<Integer>(); 

        test.add(14); 
        test.add(16); 
        test.add(17); 
        test.add(18); 
        test.add(13);

        int the_ans = test.getSize(test.getRight(test.getHeader()));
        int tru_ans = 5 ; 

        assertEquals(the_ans,tru_ans);

    }

    // Testing Header's Getter & Get Right Method Along With Get Element 
    @Test 
    public void testgetHeader() { 
        IndexedRedBlackTree<Integer> test= new IndexedRedBlackTree<Integer>(); 

        test.add(14);

        // Using the getHeader method to access its right element. If this test succeeds,
        // we know that the getter method for the header is functioning as it should 

        int the_ans = test.getElement(test.getRight(test.getHeader())) ; 

        int tru_ans = 14; 

        assertEquals(the_ans,tru_ans);

    } 

    //Testing the getLeft method 
    @Test 
    public void testGetLeft() { 
        IndexedRedBlackTree<Integer> test= new IndexedRedBlackTree<Integer>();

        test.add(14); 
        test.add(16);
        test.add(13); 

        int the_ans = test.getElement(test.getLeft(test.getRight(test.getHeader()))) ; 
        int tru_ans = 13; 

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
