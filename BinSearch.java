// JENNY BARAN
// pd 8
// HW33
// 2013-11-26

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
	int center = (lo + hi)/2;
	if ( center == target ) {
	    return center;
	}
	else if (center > target) {
	    hi = center;
	    return binSearchRec( a, target, lo, hi );
	}
	else {
	    lo = center;
	    return binSearchRec( a, target, lo, hi );
	}
    }


    public static int binSearchIter( int[] a, int target, int lo, int hi ) {
	/*retInt = -1;
	n = n;
	
	if ( target > a[a.length/2] ) {
	    
	}
	else 

	return retInt;*/
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

	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	System.out.println("\nNow testing binSearch on int array...");

	//Declare and initialize array of ints
	int[] iArr = { 2, 4, 6, 8, 6, 42 };
	printArray( iArr );
	System.out.println( "sorted? -- " + isSorted(iArr) );

	int[] iArr2 = { 2, 4, 6, 8, 13, 42 };
	printArray( iArr2 );
	System.out.println( "sorted? -- " + isSorted(iArr2) );

	/*==================================================

	//search for 6 in array 
	System.out.println( binSearch(iArr,6) );

	//search for 43 in array 
	System.out.println( binSearch(iArr,43) );
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	==================================================*/

	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    }//end main()

}//end class BinSearch
