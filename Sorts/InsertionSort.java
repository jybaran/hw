// JENNY BARAN
// pd 8
// HW47
// 2014-01-02

/*=====QUESTIONS=====

Q1: More work is done towards the end, as the value being sorted needs
    to be compared against more values in the sorted region.
Q2: For n items, it should take n-1 passes to sort.
Q3: After pass p, we know that the first p+1 values in the AL are in order,
    relative to each other, because they have been placed in the correct spot
    in the sorted region.
Q4: The runtime classification of this sort is O(n^2).

====================*/

/*======================================
  class insertionSort -- implements insertionSort algorithm
  ======================================*/

import java.util.ArrayList;

public class InsertionSort {

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

    // VOID version of insertionSort
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
    public static void insertionSortV( ArrayList<Comparable> data ) {
	
	for ( int pos = 1; pos < data.size(); pos++ ) {
	    for ( int j = 0; j < pos; j++ ) {
		if ( data.get(pos).compareTo( data.get(j) ) < 0 ) {
		    data.add(j, data.get(pos));
		    data.remove(pos+1);
		    System.out.println(data);
		}
	    }
	}

    }//end insertionSortV -- O(n*n) (can be lower, because of possible early break)


    // ArrayList-returning insertionSort
    // postcondition: order of data's elements unchanged
    //                Returns sorted copy of data.
    public static ArrayList<Comparable> insertionSort( ArrayList<Comparable> input ) {
	//declare and initialize empty ArrayList for copying
	ArrayList<Comparable> data = new ArrayList<Comparable>();
	for ( Comparable c : input ) {
	    data.add(c);
	}

	insertionSortV(data);
	    
	return data;
    }//end insertionSort -- O(?)


    public static void main(String [] args){

	/*===============for VOID methods=============

	ArrayList glen = new ArrayList<Integer>();
	glen.add(7);
	glen.add(1);
	glen.add(5);
	glen.add(12);
	glen.add(3);
	System.out.println( "ArrayList glen before sorting:\n" + glen );
	insertionSortV(glen);
	System.out.println( "ArrayList glen after sorting:\n" + glen );

	ArrayList coco = populate( 10, 1, 1000 );
	System.out.println( "ArrayList coco before sorting:\n" + coco );
	insertionSortV(coco);
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
	ArrayList glenSorted = insertionSort( glen );
	System.out.println( "sorted version of ArrayLi st glen:\n" 
			    + glenSorted );
	System.out.println( "ArrayList glen after sorting:\n" + glen );

      	ArrayList coco = populate( 10, 1, 1000 );
	System.out.println( "ArrayList coco before sorting:\n" + coco );
	ArrayList cocoSorted = insertionSort( coco );
	System.out.println( "sorted version of ArrayList coco:\n" 
			    + cocoSorted );
	System.out.println( "ArrayList coco after sorting:\n" + coco );
	
	============================================*/

    }//end main

}//end class insertionSort
