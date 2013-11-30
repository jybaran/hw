// JENNY BARAN
// pd 8
// HW35
// 2013-11-29

/* linSearch took about twice as long as binSearch to find 846 in the array, and about 18 times as long to confirm that 845 was not in the array. However, linSearch found 2 in the array twice as fast as binSearch did. The speed will presumably vary slightly based on where in the array the target is located, but binSearch is usually more efficent than linSearch. */

public class SearchTrials {

    public static void main( String[] args ) {

	Comparable[] cArr = new Comparable[1000];
	for ( int i = 0; i < cArr.length; i++ ) {
	    cArr[i] = new Integer(i * 2);
	}

	//--------TIMING LINSEARCH--------

	//searching for 846
	long startTime = System.nanoTime();
	LinSearch.linSearch(cArr, 846);
	long endTime = System.nanoTime() - startTime;

	System.out.println("linSearch took " + endTime + " nanoseconds");

	//searching for 845
	startTime = System.nanoTime();
	LinSearch.linSearch(cArr, 845);
	endTime = System.nanoTime() - startTime;

	System.out.println("linSearch took " + endTime + " nanoseconds");

	//searching for 2
	startTime = System.nanoTime();
	LinSearch.linSearch(cArr, 2);
	endTime = System.nanoTime() - startTime;

	System.out.println("linSearch took " + endTime + " nanoseconds");

	//--------TIMING BINSEARCH--------

	//searching for 846
	startTime = System.nanoTime();
	BinSearch2.binSearch(cArr, 846);
	endTime = System.nanoTime() - startTime;

	System.out.println("binSeach took " + endTime + " nanoseconds");

	//searching for 845
	startTime = System.nanoTime();
	BinSearch2.binSearch(cArr, 845);
	endTime = System.nanoTime() - startTime;

	System.out.println("binSearch took " + endTime + " nanoseconds");

	//searching for 2
	startTime = System.nanoTime();
	BinSearch2.binSearch(cArr, 2);
	endTime = System.nanoTime() - startTime;

	System.out.println("binSearch took " + endTime + " nanoseconds");

    }//end main()

}//end class