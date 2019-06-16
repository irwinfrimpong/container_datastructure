import java.util.*;

// ListIndexSet class
//
// CONSTRUCTION: with no parameters
//
// ******************PUBLIC OPERATIONS*********************
// boolean add( x )       --> Insert x to instance of ArrayList 
// AnyType getKth( k )    --> Return element at k-1 index
// int getSize( )         --> Return's size of ArrayList 
// ArrayList getArray()   --> Returns ArrayList

/**
 * ListIndexSet creates an instance of ArrayList and performs the add and getKth 
 * methods on that instacne of ArrayList 
 *
 * @author (Irwin Frimpong)
 * @version (11/19/18)
 */
public class ListIndexSet <E extends Comparable<? super E>> implements IndexSet<E> 
{
    // instance variables - 
    private ArrayList<E> listSet; // Empty Array List that will store values inserted in it

    /**
     * Constructor for objects of class ListIndexSet
     */
    public ListIndexSet()
    {
        // Constructor intializes empty arraylist 
        listSet= new ArrayList<E>() ; 
    }

    public static void main(String args[]) { 

        ListIndexSet<Integer> test = new ListIndexSet<Integer>();

        // // Adding to the arraylist
        // test.add(1); 
        // System.out.println (test.listSet); 
        // test.add(7); 
        // System.out.println (test.listSet); 
        // test.add(2); 
        // System.out.println (test.listSet); 
        // System.out.println ("Get kth: 2:  " + test.getKth(2));

        // test.add(0); 
        // System.out.println (test.listSet); 
        // test.add(4); 
        // System.out.println (test.listSet); 
        // test.add(5); 
        // System.out.println (test.listSet); 
        // System.out.println ("Get kth: 2: " + test.getKth(2));

        // System.out.println ("Adding 4 again " + test.add(4));
        // System.out.println (test.listSet);

        // System.out.println ("Adding 6 " + test.add(6));
        // System.out.println (test.listSet);
        // System.out.println ("Get kth: 4:  " + test.getKth(4));

        // // Printing out size 
        // System.out.println (test.getSize());

    }

    /**
     * add Method
     *
     * @param  Integer Element
     * @return boolean true / false depening on whether or not the value was added to the list
     */
    public boolean add (E e) { 

        // Using binary search implementation to add sorted 

        int index = Collections.binarySearch(listSet,e); 

        // If the index is negative means that the item does not exist in the arratlist

        if (index < 0 ) { 
            listSet.add(-index-1, e); 
            return true; 
        }
        else { 
            return false; 
        }

    }

    /**
     * getKth Method  
     *
     * @param  int k 
     * @return Integer Kth smallest element in the container  
     */
    public E getKth(int k){
        if( k > listSet.size()) {
            return null ;
        } 
        E kth = listSet.get(k-1);
        return kth; 

    }

    /**
     * size Method 
     *
     * @return the number of elements in the container 
     */
    public  int getSize() { 

        // Returning size of the arraylist 
        return listSet.size(); 

    } 

    /**
     * get  Array Method 
     *
     * @return the ArrayList  
     */
    public ArrayList getArray() { 
        return listSet ;
    } 

} 
