// JENNY BARAN
// pd 8
// HW34
// 2013-11-27

import java.util.Arrays;

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
	    else if ( a[mid].compareTo(target) == 0 ){
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

	//--------INTEGER ARRAY--------

	System.out.println("\nNow testing binSearch on int array...");

	//Declare and initialize array of ints
	Integer[] iArr = { 2, 4, 6, 8, 13, 42, 60 };
	printArray( iArr );
	System.out.println( "sorted? -- " + isSorted(iArr) );

	//search for 6 in array 
	System.out.println( binSearch(iArr,6) );

	//search for 43 in array 
	System.out.println( binSearch(iArr,43) );

	//search for 13 in array
	System.out.println( binSearch(iArr, 13) );

	//search for 2 in array
	System.out.println( binSearch(iArr, 2) );

	//--------BINARY ARRAY--------

	System.out.println("\nNow testing binSearch on Binary array...");

	//Declare and initialize array of Binarys
	Binary[] bArr = new Binary[10];
	for( int i = 0; i < bArr.length; i++ ) {
	    bArr[i] = new Binary( (int)(100 * Math.random()) );
	}

	Arrays.sort(bArr);

	printArray( bArr );
	System.out.println( "sorted? -- " + isSorted(bArr) );

	//search for the value in slot 3 in array 
	System.out.println( binSearch(bArr,bArr[3]) );

	//search for 101 in array 
	System.out.println( binSearch(bArr, new Binary(5)) );

	//search for 100000000 in array
	System.out.println( binSearch(bArr, new Binary(256)) );

	//--------HEXADECIMAL ARRAY--------
	
	System.out.println("\nNow testing binSearch on Hexadecimal array...");

	//Declare and initialize array of Hexadecimals
	Hexadecimal[] hArr = new Hexadecimal[10];
	for( int i = 0; i < hArr.length; i++ ) {
	    hArr[i] = new Hexadecimal( (int)(100 * Math.random()) );
	}

	Arrays.sort(hArr);

	printArray( hArr );
	System.out.println( "sorted? -- " + isSorted(hArr) );

	//search for the value in slot 3 in array 
	System.out.println( binSearch(hArr,hArr[3]) );

	//search for 5 in array 
	System.out.println( binSearch(hArr,new Hexadecimal(5)) );

	//search for 100 in array
	System.out.println( binSearch(hArr, new Hexadecimal(256)) );

	//--------RATIONAL ARRAY--------

	System.out.println("\nNow testing binSearch on Rational array...");

	//Declare and initialize array of Rationals
	Rational[] rArr = new Rational[10];
	for( int i = 0; i < rArr.length; i++ ) {
	    rArr[i] = new Rational( (int)(10 * Math.random()), ((int)(10 * Math.random() ) + 1) );
	}

	Arrays.sort(rArr);

	printArray( rArr );
	System.out.println( "sorted? -- " + isSorted(rArr) );

	//search for the value in slot 3 in array
	System.out.println( binSearch(rArr, rArr[3]) );

	//search for 11 in array
	System.out.println( binSearch(rArr, new Rational(11, 1) ) );

	//--------STRING ARRAY--------

	System.out.println("\nNow testing binSearch on String array...");

	//Declare and initialize array of Strings
	String[] sArr = { "kiwi", "watermelon", "orange", "apple", "peach" };
	
	Arrays.sort(sArr);

	printArray( sArr );
	System.out.println( "sorted? -- " + isSorted(sArr) );
	
	//search for "watermelon" in array
	System.out.println( binSearch(sArr, "watermelon") );

	//search for "lychee" in array
	System.out.println( binSearch(sArr, "lychee") );
	
    }//end main()

}
