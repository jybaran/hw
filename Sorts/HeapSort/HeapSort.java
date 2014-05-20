// JENNY BARAN
// APCS2 pd 9
// HW41
// 2014-05-19

import java.util.ArrayList;

public class HeapSort {

    Heap _heap = new Heap();

    //returns a sorted version of data, data unchanged
    public static ArrayList<Integer> heapSort( ArrayList<Integer> data ) {
	ArrayList<Integer> retArr = new ArrayList<Integer>;
	for ( Integer i : data ) {
	    _heap.add( i );
	}
	for ( int i = 0; i < data.size(); i++ ) {
	    retArr.add( _heap.removeMin() );
	}
    }

    //makes ArrayList with randomized contents
    public static ArrayList populate( int size, int lo, int hi ) {
	ArrayList<Integer> retAL = new ArrayList<Integer>();

	for ( int i = 0; i < size; i++ ) {
	    int j = (int)( Math.random() * (hi - lo) ) + lo;
	    retAL.add( j );
	}

	return retAL;
    }

    public static void main( String[] args ) {

	ArrayList yo = populate( 20, 1, 10 );
	System.out.println( yo );

    }//end main

}//end class HeapSort