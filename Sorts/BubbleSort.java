// JENNY BARAN
// pd 8
// HW45
// 2013-12-18

/*======================================
  class BubbleSort -- implements bubblesort algorithm
  ======================================*/

import java.util.ArrayList;

public class BubbleSort {

    //precond: lo < hi && size > 0
    //postcond: returns an ArrayList of random integers
    //          from lo to hi, inclusive
    public static ArrayList populate( int size, int lo, int hi ) {
	ArrayList<Integer> retAL = new ArrayList<Integer>();

	for ( int i = 0; i < size; i++ ) {
	    int j = (int)( Math.random() * (hi - lo) ) + lo;
	    retAL.add( j );
	}

	return retAL;
    }


    //randomly rearrange elements of an ArrayList
    public static void shuffle( ArrayList al ) {
	for ( int i = 0; i < 1000; i++ ) {
	    int from = (int)( Math.random() * al.size() );
	    int to = (int)( Math.random() * al.size() );
	    Object temp = al.get(to);
	    al.set(to, al.get(from));
	    al.set(from, temp);
	}
    }

    // VOID version of bubbleSort
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
    public static void bubbleSortV( ArrayList<Comparable> data ) {
	int passes = 0;
	int swaps = 0;
	
	while ( (passes == 0) || (swaps != 0) ) {
	    swaps = 0;
	    for ( int i = 0; i < data.size() - 1; i++ ) {
		if ( data.get(i).compareTo( data.get(i+1) ) > 0 ) {
		    Comparable temp = data.get(i);
		    data.set(i, data.get(i+1));
		    data.set(i+1, temp);
		    swaps++;
		}
	    }
	    passes++;
	}

    }//end bubbleSortV -- O(n*n) (can be lower, because of possible early break)


    // ArrayList-returning bubbleSort
    // postcondition: order of data's elements unchanged
    //                Returns sorted copy of data.
    public static ArrayList<Comparable> bubbleSort( ArrayList<Comparable> input ) {
	//declare and initialize empty ArrayList for copying
	ArrayList<Comparable> data = new ArrayList<Comparable>();
	for ( Comparable c : input ) {
	    data.add(c);
	}

	bubbleSortV(data);
	    
	return data;
    }//end bubbleSort -- O(?)


    public static void main(String [] args){

	/*===============for VOID methods=============

	ArrayList glen = new ArrayList<Integer>();
	glen.add(7);
	glen.add(1);
	glen.add(5);
	glen.add(12);
	glen.add(3);
	System.out.println( "ArrayList glen before sorting:\n" + glen );
	bubbleSortV(glen);
	System.out.println( "ArrayList glen after sorting:\n" + glen );

	ArrayList coco = populate( 10, 1, 1000 );
	System.out.println( "ArrayList coco before sorting:\n" + coco );
	bubbleSortV(coco);
	System.out.println( "ArrayList coco after sorting:\n" + coco );

	============================================*/


	/*==========for AL-returning methods==========

    	ArrayList glen = new ArrayList<Integer>();
	glen.add(7);
	glen.add(1);
	glen.add(5);
	glen.add(12);
	glen.add(3);
	System.out.println( "ArrayList glen before sorting:\n" + glen );
	ArrayList glenSorted = bubbleSort( glen );
	System.out.println( "sorted version of ArrayLi st glen:\n" 
			    + glenSorted );
	System.out.println( "ArrayList glen after sorting:\n" + glen );

      	ArrayList coco = populate( 10, 1, 1000 );
	System.out.println( "ArrayList coco before sorting:\n" + coco );
	ArrayList cocoSorted = bubbleSort( coco );
	System.out.println( "sorted version of ArrayList coco:\n" 
			    + cocoSorted );
	System.out.println( "ArrayList coco after sorting:\n" + coco );

	============================================*/

    }//end main

}//end class BubbleSort