public class BinSearch2 {

    public static int binSearch ( Comparable[] a, Comparable target ) {
	//uncomment exactly 1 of the 2 stmts below:
	//return binSearchIter( a, target, 0, a.length-1 );
	return binSearchRec( a, target, 0, a.length-1 );
    }


    public static int binSearchRec( Comparable[] a, Comparable target, int lo, int hi ) {
	int mid = (lo + hi)/2;
	int retInt = -1;
	if ( lo > hi ) {
	    return -1;
	}
	if ( a[mid].compareTo(target) == 0 ) {
	    return mid;
	}
	else if ( a[mid].compareTo(target) > 0 ) {
	    return binSearchRec( a, target, lo, mid-1 );
	}
	else if ( a[mid].compareTo(target) < 0 ) {
	    return binSearchRec( a, target, mid+1, hi );
	}
	return retInt;
    }


    public static int binSearchIter( Comparable[] a, Comparable target, int lo, int hi ) {
	while ( lo <= hi ) {
	    int mid = lo + ( hi - lo ) / 2;
	    
	    if ( a[mid].compareTo(target) > 0 ) {
		hi = mid - 1;
	    }
	    else if ( a[mid].compareTo(target) < 0 ) {
		lo = mid + 1;
	    }
	    else {
		return mid;
	    }
	}

	return -1;
    }

    private static boolean isSorted( Comparable[] arr ) {
	int i = 0;
	boolean retBoo = true;
	for ( ; i < arr.length - 1; i++ ) {
	    if ( arr[i].compareTo( arr[i+1] ) > 0 ) {
	    return false;
	    }
	}
	return retBoo;
    }

    // utility/helper fxn to display contents of an array of Objects
    private static void printArray( Comparable[] arr ) {
	String output = "[ "; 

	for( Comparable c : arr )
	    output += c + ", ";

	output = output.substring( 0, output.length()-2 ) + " ]";

	System.out.println( output );
    }


    //main method for testing
    public static void main ( String[] args ) {

	System.out.println("\nNow testing binSearch on int array...");

	//Declare and initialize array of ints
	Integer[] iArr = { 2, 4, 6, 8, 5, 42, 60 };
	printArray( iArr );
	System.out.println( "sorted? -- " + isSorted(iArr) );

	Integer[] iArr2 = { 2, 4, 6, 8, 13, 42 };
	printArray( iArr2 );
	System.out.println( "sorted? -- " + isSorted(iArr2) );

	//search for 6 in array 
	System.out.println( binSearch(iArr2,2) );

	//search for 43 in array 
	System.out.println( binSearch(iArr2,43) );

	//search for 13 in array
	System.out.println( binSearch(iArr2, 13) );
	
    }//end main()

}