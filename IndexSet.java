
// IndexSet Interface 
//
// ******************PUBLIC OPERATIONS*********************
// abstract boolean  add( x )      
// abstract E getKth( k )   
// abstract int getSize( )  

/**
 * IndexSet Interface  is implemented by both the TreeIndexSet and ListIndexSet class
 *
 * @author (Irwin Frimpong )
 * @version (11/19/18)
 */
public interface IndexSet<E extends Comparable < ? super E>>
{
    /**
     * add Method 
     *
     * @param  E element
     * @return  boolean which will return true if item is succesfully added and false if otherwise 
     */
    public abstract boolean add(E e) ; 

    /**
     * getKth Method  
     *
     * @param  int k 
     * @return E Kth value
     */
    public abstract E getKth(int k); 

    /**
     * size Method 
     *
     * @return the number of elements in the container 
     */
    public abstract int getSize(); 

}
