// JENNY BARAN
// APCS2 pd 9
// HW14
// 2014-03-17

import java.util.*;

public class QuickSelect {

    //start here
    public static int quickSelect( int[] arr, int k ) {
	return quickSelect( arr, k, 0, arr.length - 1 );
    }
    
    //once you start searching in subsets of array, use this
    private static int quickSelect( int[] arr, int k, int lo, int hi ) {
	if ( lo == hi ) {
	    return arr[lo];
	}

	int pivot = partition( arr, lo, hi );
	int sizeLeft = pivot - lo + 1;

	if ( sizeLeft == k ) {
	    return arr[pivot];
	}
	else if ( sizeLeft > k ) {
	    return quickSelect( arr, k, lo, pivot - 1 );
	}
	else {
	    return quickSelect( arr, k - sizeLeft, pivot + 1, hi );
	}
    }

    private static int partition( int[] arr, int lo, int hi ) {
	int pivot = lo + (int)( Math.random() * ( hi - lo + 1 ) );
	swap( arr, hi, pivot );
	for ( int i = lo; i < hi; i++ ) {
	    if ( arr[i] > arr[hi] ) {
		swap( arr, i, lo );
		lo++;
	    }
	}
	swap( arr, lo, hi );
	return lo;
    }

    private static void swap( int[] arr, int x, int y ) {
	int temp = arr[x];
	arr[x] = arr[y];
	arr[y] = temp;
    }
    
    public static void main( String[] args ) {
	int[] foo = { 400, 5, 1, 12, 3, 29, 84, 50, 90 };
	System.out.println( quickSelect( foo, 3 ) ); //should return 29
    }

}