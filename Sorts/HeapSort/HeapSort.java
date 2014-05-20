// JENNY BARAN
// APCS2 pd 9
// HW41
// 2014-05-19

/**********
 best case: sorted already, O(nlogn)
 worst case: reverse order, O(nlogn)
 unclear on memory consumption, google-fu led to more confusion
 (how can it be O(1) if every element in data needs a slot in the heap??)
 (/additional/ mem consumption?? what is)
 *********/

import java.util.ArrayList;

public class HeapSort {

    private static ALHeap _heap = new ALHeap();

    //returns a sorted version of data, data unchanged
    public static Integer[] sort( Integer[] data ) {
	Integer[]  retArr = new Integer[ data.length ];
	for ( Integer i : data ) { //O(n)
	    _heap.add( i );
	}
	for ( int i = 0; i < data.length; i++ ) { //O(n)
	    retArr[i] = _heap.removeMin(); //O(logn)
	}
	return retArr;
    } //O(nlogn)

    public static void main( String[] args ) {

	Integer[] yo = { 1, 7, 8, 3, 4, 9, 10, 13, 6 };
	System.out.println( "orig: " + java.util.Arrays.toString(yo) );
	System.out.println( "sorted: " + java.util.Arrays.toString(sort( yo )) );
	System.out.println( "orig: " + java.util.Arrays.toString(yo) );

    }//end main

}//end class HeapSort