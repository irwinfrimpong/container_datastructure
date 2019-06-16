
import java.util.Scanner ; 
import java.io.PrintWriter;
import java.io.File; 
import java.io.FileReader;
import java.util.*;

// Experiment Controller class
//
// CONSTRUCTION: with no parameters
//
// ******************PUBLIC OPERATIONS*********************
// void run               --> Insert x to instance of RBT 
// void readingFile(y)    --> Reads the the input file with the name of String y
// void generate25(num )  --> Generates 25% add random file 
// void generate50(num )  --> Generates 50% add random file 
// void generate75(num )  --> Generates 75% add random file 

/**
 * Experiment Controller generates the results for the trails 
 *
 * @author (Irwin Frimpong)
 * @version (11/19/18)
 */
public class ExperimentController
{
    //Instance Variables 
    private int time_250K_arr = 0;
    private int time_250K_tree = 0 ; 
    private int time_500K_arr = 0;
    private int time_500K_tree = 0; 
    private int time_750K_arr = 0; 
    private int time_750K_tree= 0;
    private int time_1M_arr = 0; 
    private int time_1M_tree = 0; 

    private int time_arr=0; // Holds time for the arraylist
    private int time_tree = 0; // Holds the time for the Tree 

    /**
     * Constructor for objects of class ExperimentController
     */
    public ExperimentController()
    {
    }

    public static void main(String[] args) {
        ExperimentController test = new ExperimentController() ;
        //test.generate25(10); 
        //test.generate50(1000000); 
        //test.generate75(1000000);
        //test.run();

        test.readingFile("frank_in.txt"); 

    }

    public void run() {
        for(int j = 0; j < 4; j++){ 
            for (int k = 0 ; k<5; k++){

                // If j ==1 , we want to process the data and 
                // acquire the runtime for 250K 

                if (j == 0 ) { 
                    // Generating data set with 250K elements 
                    generate25(250000);// 25% add
                    //generate50(250000); // 50% add
                    //generate75(250000); // 75% add

                    readingFile("input_25.txt");
                    //readingFile("input_50.txt");
                    //readingFile("input_75.txt");
                    time_250K_arr += time_arr; 
                    //System.out.println("Value of Time 250K: " + time_arr); 

                    time_arr = 0; //Setting time_arr = 0  for the next run 
                    time_250K_tree += time_tree; 
                    //System.out.println("Value of Tree Time 250K: " + time_tree); 
                    time_tree = 0; 
                }
                else if (j == 1){ 
                    //Generating data set with 500k elements
                    generate25(500000); // 25% add
                    //generate50(500000); // 50% add
                    //generate75(500000); // 75% add

                    readingFile("input_25.txt");
                    //readingFile("input_50.txt");
                    //readingFile("input_75.txt");
                    time_500K_arr += time_arr;
                    //System.out.println("Value of Time 500K: " + time_arr); 
                    time_arr=0; //Setting time_arr = 0  for the next run 
                    time_500K_tree += time_tree; 
                    //System.out.println("Value of Tree Time 500K: " + time_tree); 
                    time_tree=0;

                }
                else if ( j == 2){ 
                    //Generating data set with 750K elements 
                    generate25(750000); // 25% add
                    //generate50(750000); // 50% add
                    //generate75(750000); // 75% add

                    readingFile("input_25.txt");
                    //readingFile("input_50.txt");
                    //readingFile("input_75.txt");

                    time_750K_arr += time_arr; 
                    //System.out.println("Value of Time 750K: " + time_arr); 
                    time_arr = 0; //Setting time_arr = 0  for the next run 
                    time_750K_tree += time_tree; 
                    //System.out.println("Value of Tree Time 750K: " + time_tree); 
                    time_tree = 0; 

                }
                else if (j == 3) { 
                    //Generating data set with 750K elements 
                    generate25(1000000); // 25% add
                    //generate50(1000000); // 50% add
                    //generate75(1000000); // 75% add

                    readingFile("input_25.txt");
                    //readingFile("input_50.txt");
                    //readingFile("input_75.txt");

                    time_1M_arr += time_arr; 
                    //System.out.println("Value of Time 1M: " + time_arr); 
                    time_arr = 0; //Setting time_arr = 0  for the next run 
                    time_1M_tree += time_tree; 
                    //System.out.println("Value of Tree Time 1M: " + time_tree); 
                    time_tree = 0 ; 
                }
            }
        }

        System.out.println("Time 250K Arraylist: " + time_250K_arr); 
        System.out.println("Time 250K Tree: " + time_250K_tree); 
        System.out.println("Time 500K Arraylist: " + time_500K_arr); 
        System.out.println("Time 500K Tree: " + time_500K_tree); 
        System.out.println("Time 750K Arraylist: " + time_750K_arr); 
        System.out.println("Time 750K Tree: " + time_750K_tree);
        System.out.println("Time 1M Arraylist: " + time_1M_arr); 
        System.out.println("Time 1M Tree: " + time_1M_tree); 

    }

    /**
     *Method to read/scann an input file 
     *@param number of operations 
     */
    public void readingFile(String y){ 
        // Creating Instance of List Set and Tree Set 
        ListIndexSet<Long>list = new ListIndexSet<Long>() ; 
        TreeIndexSet<Long> tree = new TreeIndexSet<Long>();

        try{  
            // Setting up the scanner 
            Scanner sc = new Scanner( new FileReader(y));  

            //Setting up Print Writers 

            File output_list = new File("output_list.txt"); //Creating Output file for list  
            File output_tree = new File("output_tree.txt"); // Creating output flie for tree

            PrintWriter arr_list = new PrintWriter(output_list); 
            PrintWriter rb_tree = new PrintWriter(output_tree); 

            int line_count = 0 ; 
            while(sc.hasNextLine() ) {
                if (line_count > 0) {
                    //String holds the contents of the scanner 
                    String content = sc.nextLine(); 

                    //Storing the split values of the contents string 
                    String content_s [] = content.split(" ") ; 

                    // content_s[0] stores the function
                    if (content_s[0].equals("add")) { 

                        //Add to arraylst 
                        long t0 = System.currentTimeMillis();
                        arr_list.println(list.add(Long.parseLong(content_s[1]))); 
                        long t1 = System.currentTimeMillis();
                        time_arr += (t1-t0) ; 

                        // Add to the Red Black Tree 

                        long t2 = System.currentTimeMillis();
                        rb_tree.println(tree.add(Long.parseLong(content_s[1]))); 
                        long t3 = System.currentTimeMillis(); 
                        time_tree += (t3-t2) ; 

                    }
                    else if (content_s[0].equals("getKth")) { 
                        // Get Kth Element in ArrayList 
                        long t4 = System.currentTimeMillis();
                        arr_list.println(list.getKth(Integer.parseInt(content_s[1]))); 
                        long t5 = System.currentTimeMillis();
                        time_arr += (t5-t4) ; 

                        //Get Kth Element in Red Black Tree 
                        long t6 = System.currentTimeMillis();
                        rb_tree.println(tree.getKth(Integer.parseInt(content_s[1])));
                        long t7 = System.currentTimeMillis();
                        time_tree += (t7-t6); 
                    }
                }

                //System.out.println( "Line Count: " + line_count); 
                // Increment Line Count
                line_count ++ ; 
            }

            //Print the times at the end
            arr_list.println("Time: " + time_arr); 
            rb_tree.println("Time: " + time_tree);
            //System.out.println("Time: " + time_arr); 
            //System.out.println("Time: " + time_tree);

            //Closing Print Writer 
            arr_list.close(); 
            rb_tree.close(); 

        }
        catch (Exception e) {
            System.out.println ("Exception occured " + e + " " + e.getStackTrace()[0].getLineNumber()); 

        }

    }

    /**
     *Method to generate the random 25 % add 
     *@param number of operations 
     */
    public void generate25(int num )
    {  
        try{

            //Creating File that will hold the random generated add values 
            File input_25 = new File("input_25.txt"); // Creating Output file for tree 25 % add

            // Print Writer 
            PrintWriter random_25 = new PrintWriter(input_25); 

            double num_add = num * 0.25 ; // Number of adds to be done 
            double num_kth = num * 0.75 ; // Number of getKth to be done

            //Print Number of Items 
            random_25.println(num); 

            Random random = new Random () ; // Random for Selecting Between Add / Get Kth 
            int current_size = 0; // Keeps Track of Number of Adds Done 
            int add = 1 ; 
            int getKth = 2; 

            for( int i=0; i < num ; i++) { 
                int sel = random.nextInt((getKth-add)+1)+ add ; 
                if (i < 5 ) { 
                    random_25.println("add " + Math.abs(random.nextInt()) ); 
                    num_add -- ; 
                    current_size ++ ;
                }
                else {               

                    if ( sel == add && num_add != 0) { 
                        random_25.println("add " + Math.abs(random.nextInt()) ); 
                        num_add -- ; 
                        current_size ++ ;
                    }
                    else if (sel == getKth && num_kth != 0 ) { 
                        int random_k= (random.nextInt((current_size-1))+1); 
                        random_25.println("getKth " + random_k ) ;
                        //System.out.println("Get k : " + random_k);

                        num_kth -- ; 

                    }
                    else if (sel == add && num_add == 0 && num_kth!= 0) { 
                        int random_k1 = (random.nextInt((current_size-1))+1);
                        random_25.println("getKth " + random_k1);
                        //System.out.println("Get k : " + random_k1);
                        num_kth -- ;
                    }
                    else if (sel == getKth && num_kth ==0 && num_add != 0) { 
                        random_25.println("add " + Math.abs(random.nextInt()) ); 
                        num_add -- ; 
                        current_size ++ ;
                    }

                    // System.out.println("Current Size: " + current_size);
                }
            }
            //Closing Print Writer 
            random_25.close(); 
            System.out.println("Random 25 is done generating values"); 

        }

        catch (Exception e) {
            System.out.println ("Exception occured " + e); 

        }
    }

    /**
     *Method to generate the random 50 % add 
     *@param number of operations 
     */
    public void generate50(int num )
    {  
        try{

            //Creating File that will hold the random generated add values 
            File input_50 = new File("input_50.txt"); // Creating Output file for tree 25 % add

            // Print Writer 
            PrintWriter random_50 = new PrintWriter(input_50); 

            double num_add = num * 0.5 ; // Number of adds to be done 
            double num_kth = num * 0.5 ; // Number of getKth to be done

            //Print Number of Items 
            random_50.println(num); 

            Random random = new Random () ; // Random for Selecting Between Add / Get Kth 
            int current_size = 0; // Keeps Track of Number of Adds Done 
            int add = 1 ; 
            int getKth = 2; 

            for( int i=0; i < num ; i++) { 
                int sel = random.nextInt((getKth-add)+1)+ add ; 
                if (i < 5 ) { 
                    random_50.println("add " + Math.abs(random.nextInt()) ); 
                    num_add -- ; 
                    current_size ++ ;
                }
                else {               

                    if ( sel == add && num_add != 0) { 
                        random_50.println("add " + Math.abs(random.nextInt()) ); 
                        num_add -- ; 
                        current_size ++ ;
                    }
                    else if (sel == getKth && num_kth != 0 ) { 
                        random_50.println("getKth " + (random.nextInt((current_size-1))+1));
                        num_kth -- ; 

                    }
                    else if (sel == add && num_add == 0 && num_kth!= 0) { 
                        random_50.println("getKth " + (random.nextInt((current_size-1))+1));
                        num_kth -- ;
                    }
                    else if (sel == getKth && num_kth ==0 && num_add != 0) { 
                        random_50.println("add " + Math.abs(random.nextInt()) ); 
                        num_add -- ; 
                        current_size ++ ;
                    }
                }
            }
            //Closing Print Writer 
            random_50.close(); 
            System.out.println("Random 50 is done generating values"); 

        }

        catch (Exception e) {
            System.out.println ("Exception occured " + e); 

        }
    }

    /**
     *Method to generate the random 75 % add 
     *@param number of operations 
     */
    public void generate75(int num )
    {  
        try{

            //Creating File that will hold the random generated add values 
            File input_75 = new File("input_75.txt"); // Creating Output file for tree 25 % add

            // Print Writer 
            PrintWriter random_75 = new PrintWriter(input_75); 

            double num_add = num * 0.75 ; // Number of adds to be done 
            double num_kth = num * 0.25 ; // Number of getKth to be done

            //Print Number of Items 
            random_75.println(num); 

            Random random = new Random () ; // Random for Selecting Between Add / Get Kth 
            int current_size = 0; // Keeps Track of Number of Adds Done 
            int add = 1 ; 
            int getKth = 2; 

            for( int i=0; i < num ; i++) { 
                int sel = random.nextInt((getKth-add)+1)+ add ; 
                if (i < 5 ) { 
                    random_75.println("add " + Math.abs(random.nextInt()) ); 
                    num_add -- ; 
                    current_size ++ ;
                }
                else {               

                    if ( sel == add && num_add != 0) { 
                        random_75.println("add " + Math.abs(random.nextInt()) ); 
                        num_add -- ; 
                        current_size ++ ;
                    }
                    else if (sel == getKth && num_kth != 0 ) { 
                        random_75.println("getKth " + (random.nextInt((current_size-1))+1));
                        num_kth -- ; 

                    }
                    else if (sel == add && num_add == 0 && num_kth!= 0) { 
                        random_75.println("getKth " + (random.nextInt((current_size-1))+1));
                        num_kth -- ;
                    }
                    else if (sel == getKth && num_kth ==0 && num_add != 0) { 
                        random_75.println("add " + Math.abs(random.nextInt()) ); 
                        num_add -- ; 
                        current_size ++ ;
                    }
                }
            }
            //Closing Print Writer 
            random_75.close(); 
            System.out.println("Random 75 is done generating values"); 

        }

        catch (Exception e) {
            System.out.println ("Exception occured " + e); 

        }
    }
}
