//package weiss.nonstandard;

// RedBlackTree class
//
// CONSTRUCTION: with no parameters
//
// ******************PUBLIC OPERATIONS*********************
// void add( x )       --> Insert x
// void remove( x )       --> Remove x (unimplemented)
// Comparable find( x )   --> Return item that matches x
// Comparable findMin( )  --> Return smallest item
// Comparable findMax( )  --> Return largest item
// boolean isEmpty( )     --> Return true if empty; else false
// void makeEmpty( )      --> Remove all items
// void printTree( )      --> Print all items
// int getSize()          --> Returns the size of the tree
// RedBlackNode<AnyType> getHeader() --> Returns the header's node 
// RedBlackNode<AnyType> getRight(node)  --> Returns node's right node
// RedBlackNode<AnyType> getLeft(node)  --> Returns node's left node
// AnyType getElement(node) --> Returns the node's elements 
// ******************ERRORS********************************
// Exceptions are thrown by insert if warranted and remove.

/**
 * Implements a red-black tree.
 * Note that all "matching" is based on the compareTo method.
 * @author Mark Allen Weiss
 */
public class IndexedRedBlackTree<AnyType extends Comparable<? super AnyType>>
{
    private RedBlackNode<AnyType> header;
    private RedBlackNode<AnyType> nullNode;

    private static final int BLACK = 1;    // BLACK must be 1
    private static final int RED   = 0;

    // Used in insert routine and its helpers
    private RedBlackNode<AnyType> current;
    private RedBlackNode<AnyType> parent;
    private RedBlackNode<AnyType> grand;
    private RedBlackNode<AnyType> great;

    /**
     * Construct the tree.
     */
    public IndexedRedBlackTree( )
    {
        nullNode = new RedBlackNode<AnyType>( null );
        nullNode.left = nullNode.right = nullNode;
        header = new RedBlackNode<AnyType>( null );
        header.left = header.right = nullNode;
    }

    public static void main(String args[]) { 

        IndexedRedBlackTree<Integer> test= new IndexedRedBlackTree<Integer>(); 
        
        
        
        //test.add(14); 
        //test.add(16); 
        //test.add(17); 
        //test.add(18); 
        //test.add(13); 
        
        //System.out.println( "Finding Kth: 0 " + test.findKth(0)); 
        //test.add(10); 
        //test.add(9);

        // test.add(16);
        // test.add(17);
        // test.add(18);
        // test.add(10); 
        // test.add(9);

        // //Printing Tree 
        // test.printTree(); 

        // System.out.println ("Header Size: " + test.header.right.size + " Current Item: " + test.current.element) ;
        // System.out.println ("Current Item Size: " + test.current.size ); 
        // System.out.println ("Header's Item: " + test.header.right.element); 
        // //Testing find kth 
        //System.out.println( "Finding Kth: 5 " + test.findKth(5)); 

        // System.out.println("Size of 16: " + test.header.right.left.size ); 

    }

    /**
     * Compare item and t.element, using compareTo, with
     * caveat that if t is header, then item is always larger.
     * This routine is called if is possible that t is header.
     * If it is not possible for t to be header, use compareTo directly.
     */
    private final int compare( AnyType item, RedBlackNode<AnyType> t )
    {
        if( t == header )
            return 1;
        else
            return item.compareTo( t.element );    
    }

    /**
     * Add an element into the tree, same as insert but with size change
     * @param item the item to insert.
     * @return true if item is inserted, false if item is already present.
     */
    public boolean add( AnyType item )
    {
        current = parent = grand = header;

        // null node takes the item passed into method 
        nullNode.element = item;

        while( compare( item, current ) != 0 ) // While the item isnt the same as te one in the current node
        {
            great = grand; 
            grand = parent; 
            parent = current;

            // Conditional statement to determine where the new element goes
            // based on the comparison
            current = compare( item, current ) < 0 ?
                current.left : current.right;

            // Check if two red children; fix if so
            if( current.left.color == RED && current.right.color == RED )
                handleReorient( item );
        }

        // Insertion fails if already present
        if( current != nullNode ){
            return false;
        }

        // Creating the current node with the item 
        current = new RedBlackNode<AnyType>( item, nullNode, nullNode );

        // Attach to parent
        if( compare( item, parent ) < 0 ){
            //Items is less than parent insert on left side of parent 
            parent.left = current;
        }
        else{
            parent.right = current;
        }

        //System.out.println("Current Element in Add: " + current.element); 
        //System.out.println("Size of Current In Add: " + current.size );

        //Traverse through the tree to find the element, increase every node visited by one 

        //Creating a new node and using it to traverse through the tree 
        RedBlackNode<AnyType> itr = header.right;

        //Print Current Element
        // System.out.println("Current Element in Add: " + current.element); 

        while(itr != current) 
        {
            if( current.element.compareTo( itr.element ) < 0 ) {

                //System.out.println("Itr Element in Add: " + itr.element + "Itr Size: " + itr.size); 
                itr.size = itr.size + 1 ;
                //System.out.println("Itr Element in Add: " + itr.element + "Itr Size: " + itr.size);
                itr = itr.left;
            }
            else if(current.element.compareTo( itr.element ) > 0 ){

                //System.out.println("Itr Element in Add: " + itr.element + "Itr Size: " + itr.size); 
                itr.size = itr.size + 1 ;
                //System.out.println("Itr Element in Add: " + itr.element + "Itr Size: " + itr.size); 
                itr = itr.right;
            }
        }

        // Setting size of the current node  
        current.setSize(current);

        //Printing the size of the current element 
        // System.out.println("Current: " + current.element +" Size of Current  " + current.size);

        //Set the null node back to null      
        nullNode.element = null; 

        handleReorient( item );
        return true;
    }

    /**
     * Find the kth smallest item in the tree.
     * @param k the desired rank (1 is the smallest item).
     * @return the kth smallest item in the tree.
     */
    public AnyType findKth( int k )
    {
        if( k > header.right.size) {
            return null ;
        }
        return findKth( k, header.right ).element;
    }

    protected RedBlackNode<AnyType> findKth( int k, RedBlackNode<AnyType> t )
    {
        if( t == null)
            throw new IllegalArgumentException(); 

        //If the tree rooted at t has a left subtree then we set the variable equal to the
        // size of the left 
        int leftSize = (t.left != null ) ? t.left.size : 0 ; 
        
        
        // If k is smaller than the size of left subtree then we know that 
        // the kth smallest element is in the left subtree 
        if (k <= leftSize) { 
            return findKth(k,t.left); 
        } 

        // The kth smallest element is t since it has no left tree
        if (k == leftSize + 1 ) { 
            return t; 
        }

        // Case where k is greater than the size 
        return findKth( k - leftSize -1, t.right); 
    }

    /**
     * Get size of the tree
     * 
     * @return size of the tree 
     */
    public int getSize(RedBlackNode<AnyType> node)
    {
        return node.size ; 
    }

    /**
     * Get header's node
     * 
     * @return Headers Node
     */
    public RedBlackNode<AnyType> getHeader() { 
        return header;
    }

    /**
     * Get right node
     * 
     * @return Node right Node
     */

    public RedBlackNode<AnyType> getRight(RedBlackNode<AnyType> node){ 
        return node.right; 
    }

    /**
     * Get left node
     * 
     * @return Headers Node
     */
    public RedBlackNode<AnyType> getLeft(RedBlackNode<AnyType> node){ 
        return node.left ; 

    }

    /**
     * Get node's element
     * 
     * @return node element
     */
    public AnyType getElement(RedBlackNode<AnyType> node) { 
        return node.element ; 
    }

    /**
     * Remove from the tree.
     * @param x the item to remove.
     * @throws UnsupportedOperationException if called.
     */
    public void remove( AnyType x )
    {
        throw new UnsupportedOperationException( );
    }

    /**
     * Find the smallest item  the tree.
     * @return the smallest item or null if empty.
     */
    public AnyType findMin( )
    {
        if( isEmpty( ) )
            return null;

        RedBlackNode<AnyType> itr = header.right;

        while( itr.left != nullNode )
            itr = itr.left;

        return itr.element;
    }

    /**
     * Find the largest item in the tree.
     * @return the largest item or null if empty.
     */
    public AnyType findMax( )
    {
        if( isEmpty( ))
            return null;

        RedBlackNode<AnyType> itr = header.right;

        while( itr.right != nullNode ) {
            itr = itr.right;
        }

        return itr.element;
    }

    /**
     * Find an item in the tree.
     * @param x the item to search for.
     * @return the matching item or null if not found.
     */
    public AnyType find( AnyType x )
    {
        nullNode.element = x;
        current = header.right;

        for( ; ; )
        {
            if( x.compareTo( current.element ) < 0 )
                current = current.left;
            else if( x.compareTo( current.element ) > 0 ) 
                current = current.right;
            else if( current != nullNode )
                return current.element;
            else
                return null;
        }
    }

    /**
     * Make the tree logically empty.
     */
    public void makeEmpty( )
    {
        header.right = nullNode;
    }

    /**
     * Print all items.
     */
    public void printTree( )
    {
        printTree( header.right );
    }

    /**
     * Internal method to print a subtree in sorted order.
     * @param t the node that roots the tree.
     */
    private void printTree( RedBlackNode<AnyType> t )
    {
        if( t != nullNode )
        {
            printTree( t.left );
            System.out.println( t.element );
            printTree( t.right );
        }
    }

    /**
     * Test if the tree is logically empty.
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty( )
    {
        return header.right == nullNode;
    }

    /**
     * Internal routine that is called during an insertion
     * if a node has two red children. Performs flip and rotations.
     * @param item the item being inserted.
     */
    private void handleReorient( AnyType item )
    {
        // Do the color flip
        current.color = RED;
        current.left.color = BLACK;
        current.right.color = BLACK;

        if( parent.color == RED )   // Have to rotate
        {
            grand.color = RED;
            if( ( compare( item, grand ) < 0 ) !=
            ( compare( item, parent ) < 0 ) )
                parent = rotate( item, grand );  // Start dbl rotate
            current = rotate( item, great );
            current.color = BLACK;
        }
        header.right.color = BLACK; // Make root black
    }

    /**
     * Internal routine that performs a single or double rotation.
     * Because the result is attached to the parent, there are four cases.
     * Called by handleReorient.
     * @param item the item in handleReorient.
     * @param parent the parent of the root of the rotated subtree.
     * @return the root of the rotated subtree.
     */
    private RedBlackNode<AnyType> rotate( AnyType item, RedBlackNode<AnyType> parent )
    {
        if( compare( item, parent ) < 0 )
            return parent.left = compare( item, parent.left ) < 0 ?
                rotateWithLeftChild( parent.left )  :  // LL
            rotateWithRightChild( parent.left ) ;  // LR
        else
            return parent.right = compare( item, parent.right ) < 0 ?
                rotateWithLeftChild( parent.right ) :  // RL
            rotateWithRightChild( parent.right );  // RR
    }

    /**
     * Rotate binary tree node with left child.
     */
    private static <AnyType> RedBlackNode<AnyType> rotateWithLeftChild( RedBlackNode<AnyType> k2 )
    {

        //System.out.println("K2: " + k2.element) ; 
        RedBlackNode<AnyType> k1 = k2.left;
        //System.out.println("K1: " + k1.element) ; 
        k2.left = k1.right;
        //System.out.println("K2 Left: " + k2.left.element) ;
        k1.right = k2;
        //System.out.println("K1 Right: " + k1.right.element) ;

        //Setting sizes for k2 and k1 

        k2.setSize(k2); 
        k1.setSize(k1); 

        return k1;
    }

    /**
     * Rotate binary tree node with right child.
     */
    private static <AnyType> RedBlackNode<AnyType> rotateWithRightChild( RedBlackNode<AnyType> k1 )
    {   
        //System.out.println("\nK1: " + k1.element + "K1 Size: " + k1.size) ; 
        RedBlackNode<AnyType> k2 = k1.right;
        //System.out.println("K2: " + k2.element) ; 
        k1.right = k2.left;

        //System.out.println("K1 Right: " + k1.right.element) ; 
        k2.left = k1;
        //System.out.println("K2 Left: " + k2.left.element + "\n") ; 

        //Setting size for k2 and k1        
        k1.setSize(k1); 
        k2.setSize(k2); 
        return k2;
    }

    private static class RedBlackNode<AnyType>
    {
        AnyType               element;    // The data in the node
        RedBlackNode<AnyType> left;       // Left child
        RedBlackNode<AnyType> right;      // Right child
        int                   color;      // Color
        int                   size;       // number of items in the subtree rooted at the node, including self

        // Constructors
        RedBlackNode( AnyType theElement )
        {
            this( theElement, null, null );
        }

        RedBlackNode( AnyType theElement, RedBlackNode<AnyType> lt, RedBlackNode<AnyType> rt )
        {
            element  = theElement;
            left     = lt;
            right    = rt;
            color    = IndexedRedBlackTree.BLACK;
        }

        // set the size of the node 
        void setSize(RedBlackNode<AnyType> current) {

            //Setting the node of the current node equal to size of the right child of current and the left size of current
            // plus itself 
            current.size = current.left.size + current.right.size + 1 ;

        }
    }

    private static class DuplicateItemException extends RuntimeException
    {
        /**
         * Construct this exception object.
         */
        public DuplicateItemException( )
        {
            super( );
        }

        /**
         * Construct this exception object.
         * @param message the error message.
         */
        public DuplicateItemException( String message )
        {
            super( message );
        }
    }

}
