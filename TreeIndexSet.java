// TreeIndexSet class
//
// CONSTRUCTION: with no parameters
//
// ******************PUBLIC OPERATIONS*********************
// boolean add( x )       --> Insert x to instance of RBT 
// AnyType getKth( k )    --> Return k's smallest element
// int getSize( )         --> Return's size of instance of RBT

/**
 * TreeIndexSet class creates an instance of IndexedRedBlackTree
 * and performs add and getKth functions on that instance of RBT
 *
 * @author (Irwin Frimpong)
 * @version (11/19/18)
 */
public class TreeIndexSet <AnyType extends Comparable<? super AnyType>> implements IndexSet<AnyType>
{
    //Creating an instance of Indexed Red Black Tree 
     private IndexedRedBlackTree<AnyType> treeSet ;    

    /**
     * Constructor for objects of class TreeIndexSet
     */
    public TreeIndexSet()
    {
        // initialise instance variables
        treeSet = new IndexedRedBlackTree<AnyType>();
    }

    /**
     * add Method
     *
     * @param  Integer Element
     * @return boolean true / false depening on whether or not the value was added to the list
     */
    public boolean add (AnyType e) { 
        return treeSet.add(e); 

    }
    
    /**
     * getKth Method  
     *
     * @param  int k 
     * @return Integer Kth smallest element in the container  
     */
    public AnyType getKth(int k){ 
       return treeSet.findKth(k) ; 
        
    }
    
    /**
     * size Method 
     *
     * @return the number of elements in the container 
     */
    public  int getSize() { 
        return treeSet.getSize(treeSet.getRight(treeSet.getHeader()));
    }
    
   
}
    
    
    
    
    
    
