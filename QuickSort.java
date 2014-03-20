// JENNY BARAN
// APCS2 pd 9
// HW16
// 2014-03-19

/*****************************************************
 * class QuickSort
 * Implements quicksort algo to sort an array of ints in-place
 * 1. Summary of QuickSort algorithm:
 * Pick a pivot point, sort array so larger values are on one
 * side of the pivot and vice versa. Then tackle the areas of the
 * array on either side of pivot in the same way (repeat recursively).
 *
 * 2a. Worst pivot choice and associated runtime: 
 * The worst pivot would be the largest or smallest value, which would give a runtime
 * of O(n^2).
 * 2b. Best pivot choice and associated runtime:
 * The best pivot would be the median value, and would give a runtime of O(nlogn).
 *
 * 3. Approach to handling duplicate values in array:
 * If the duplicate is the pivot, swap the lower/higher of the two with the val one
 * higher/lower than it.
 *****************************************************/

public class QuickSort {

    //--------------v  HELPER METHODS  v--------------
    public static void swap( int x, int y, int[] o ) {
	int tmp = o[x];
	o[x] = o[y];
	o[y] = tmp;
    }

    public static void printArr( int[] a ) {
	for ( int o : a )
	    System.out.print( o + " " );
	System.out.println();
    }

    public static void shuffle( int[] d ) {
	int tmp;
	int swapPos;
	for( int i = 0; i < d.length; i++ ) {
	    tmp = d[i];
	    swapPos = i + (int)( (d.length - i) * Math.random() );
	    swap( i, swapPos, d );
	}
    }

    public static int[] buildArray( int size, int numVals ) {
	int[] retArr = new int[size];
	for( int i = 0; i < retArr.length; i++ )
	    retArr[i] = (int)( numVals * Math.random() );
	return retArr;
    }
    //--------------^  HELPER METHODS  ^--------------



    /*****************************************************
     * void qsort(int[])
     * @param d -- array of ints to be sorted in place
     *****************************************************/
    public static void qsort( int[] d ) { 
	qsHelp( 0, d.length - 1, d );
    }
    public static void qsHelp( int lo, int hi, int[] d ) { 
	if ( lo >= hi ) {
	    return;
	}

	int tempLo = lo;
	int tempHi = hi;
	int pivot = d[lo];

	while ( tempLo < tempHi ) {
	    while ( d[tempLo] <= pivot ) {
		tempLo++;
	    }
	    while ( d[tempHi] > pivot ) {
		tempHi--;
	    }
	    swap( tempLo, tempHi, d );
	    printArr(d);
	}

	d[tempLo] = pivot;
	
	qsHelp( lo, tempLo - 1, d );
	qsHelp( tempLo + 1, hi, d );
    }//end qsHelp


    //main method for testing
    public static void main( String[] args ) {

	/*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-kk,C-y) 
	//get-it-up-and-running, static test case:
	int [] arr1 = {7,1,5,12,3};
	System.out.println("\narr1 init'd to: " );
	printArr(arr1);

	qsort( arr1 );	
       	System.out.println("arr1 after qsort: " );
	printArr(arr1);


	// randomly-generated arrays of n distinct vals
	int[] arrN = new int[10];
	for( int i = 0; i < arrN.length; i++ )
	    arrN[i] = i;
       
	System.out.println("\narrN init'd to: " );
	printArr(arrN);

       	shuffle(arrN);
       	System.out.println("arrN post-shuffle: " );
	printArr(arrN);

	qsort( arrN );
	System.out.println("arrN after partitionNVals: " );
	printArr(arrN);
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

	//get-it-up-and-running, static test case w/ dupes:
	int [] arr2 = {7,1,5,12,3,7};
	System.out.println("\narr2 init'd to: " );
	printArr(arr2);

	qsort( arr2 );	
       	System.out.println("arr2 after qsort: " );
	printArr(arr2);

	// arrays of randomly generated ints
	int[] arrMatey = new int[20];
	for( int i = 0; i < arrMatey.length; i++ )
	    arrMatey[i] = (int)( 48 * Math.random() );
       
	System.out.println("\narrMatey init'd to: " );
	printArr(arrMatey);

       	shuffle(arrMatey);
       	System.out.println("arrMatey post-shuffle: " );
	printArr(arrMatey);

	qsort( arrMatey );
	System.out.println("arrMatey after partitionNVals: " );
	printArr(arrMatey);

    }//end main

}//end class QuickSort
