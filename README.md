# container_datastructure
------------------------------------------------------------------------
Project 2 - Purpose to find the most effeicent data strcuture out 
of the two : ArrayList / Red-Black-Tree
------------------------------------------------------------------------

PROJECT TITLE: Project 2 Irwin Frimpong

PURPOSE OF PROJECT: 
Finding the most efficient data structure to implement for the container 

Managing large amounts of data is an inevitable aspect of modern-day computing. Therefore, it is imperative to find ways in which these large sets of data can not only managed but managed in the most efficient way possible. In this project, one was tasked with implementing a container data structure that made use of an ArrayList and a Red Black Tree to store the elements. This was done in means of determining which of the two data structures would be more efficient in carrying out operations involving adding and search for elements. 

Considering the constraint of not having duplicates in the Array List as well as maintaining a sorted Array List after each insertion, the Array List would have to be shifted after each insertion, depending on the index of the Array List that it is inserted in. This will cause its insertion operation to take on an O(N) for worst case runtime if elements are to be added to the front or middle of the Array List. For finding the Kth smallest element, because of indexing, the computer can linearly retrieve elements in an Array List when giving a specific index of an element to retrieve; giving the FindKth operation on the ArrayList a runtime of O(1). 

On the other hand, since, a Red Black Tree is a balanced binary search tree, this balance is ensured by the rules of insertions involving rotations and recoloring to ensure that the number of black nodes on each path to a null node is consistent. As a result of such, all the operation performed (ie: Insertion and FindKth) will have an O(lgN).

VERSION or DATE: 11/19/18

HOW TO START THIS PROJECT: Compile and Run Experiment Controller 

AUTHORS: Irwin Frimpong 

USER INSTRUCTIONS:

To test my program on your sample input file, simple uncomment the line "test.readingFile()" in experiment 
controller's main method and insert the file name of the input file you would want to the program to examine . The output
files are generated in the project folder with name "output_list" and "output_tree".  

The random generation of values are done in methods so they can be called in the main method with an int parameter
values signify the number of operations to be generated for that input file .

