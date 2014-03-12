// JENNY BARAN
// APCS2 pd 9
// HW12
// 2014-03-11

/*===============
  Binary search looks at the middle number in an ordered set and compares it
  to the target number. After determining whether the midpoint is higher or lower
  than the target, it looks at the half that would contain the target and tries
  again in the same manner, continuing until it finds the target or determines
  that it is not contained in the set.
  Binary search runs in O(log n).
  ===============*/

public class BinSearch {


    /*==================================================
      int binSearch(int[],int) -- searches an array of ints for target int
      pre:  input array is sorted in ascending order
      post: returns index of target, or returns -1 if target not found
      ==================================================*/
    public static int binSearch ( int[] a, int target ) {
	//uncomment exactly 1 of the 2 stmts below:
	//return binSearchIter( a, target, 0, a.length-1 );
	return binSearchRec( a, target, 0, a.length-1 );
    }


    public static int binSearchRec( int[] a, int target, int lo, int hi ) {
	int mid = (lo + hi)/2;
	int retInt = -1;
	if ( lo > hi ) {
	    return -1;
	}
	if ( a[mid] == target ) {
	    return mid;
	}
	else if ( a[mid] > target ) {
	    return binSearchRec( a, target, lo, mid-1 );
	}
	else if ( a[mid] < target ) {
	    return binSearchRec( a, target, mid+1, hi );
	}
	return retInt;
    }


    public static int binSearchIter( int[] a, int target, int lo, int hi ) {
	while ( lo <= hi ) {
	    int mid = lo + ( hi - lo ) / 2;
	    
	    if ( target < a[mid] ) {
		hi = mid - 1;
	    }
	    else if ( target > a[mid] ) {
		lo = mid + 1;
	    }
	    else {
		return mid;
	    }
	}

	return -1;
    }



    //tell whether an array is sorted in ascending order
    private static boolean isSorted( int[] arr ) {
	int i = 0;
	boolean retBoo = true;
	for ( ; i < arr.length - 1; i++ ) {
	    if ( arr[i] > arr[i+1] ) {
		return false;
	    }
	}
	return retBoo;
    }


    // utility/helper fxn to display contents of an array of Objects
    private static void printArray( int[] arr ) {
	String output = "[ "; 

	for( int i : arr )
	    output += i + ", ";

	output = output.substring( 0, output.length()-2 ) + " ]";

	System.out.println( output );
    }


    //main method for testing
    public static void main ( String[] args ) {

	System.out.println("\nNow testing binSearch on int array...");

	//Declare and initialize array of ints
	int[] iArr = { 2, 4, 6, 8, 5, 42, 60 };
	printArray( iArr );
	System.out.println( "sorted? -- " + isSorted(iArr) );

	int[] iArr2 = { 2, 4, 6, 8, 13, 42 };
	printArray( iArr2 );
	System.out.println( "sorted? -- " + isSorted(iArr2) );

	//search for 6 in array 
	System.out.println( binSearch(iArr2,2) );

	//search for 43 in array 
	System.out.println( binSearch(iArr2,43) );

	//search for 13 in array
	System.out.println( binSearch(iArr2, 13) );
	
    }//end main()

}//end class BinSearch