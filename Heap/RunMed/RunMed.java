// JENNY BARAN
// APCS2 pd 9
// HW43
// 2014-05-22

/*****************************************************
 * as elements are added, they are sorted relative to the median
 * into a heap of numbers higher or lower than it. these heaps
 * maintain balance (one cannot have more than one more than the other).
 * to find median, you either average the two roots (if the sizes of the
 * heaps are equal) or take the root of the larger heap.
 *****************************************************/

/*****************************************************
 * class RunMed
 * Implements an online algorithm to track the median of a growing dataset
 * Maintains 2 heaps: minheap for upper half of dataset, maxheap for lower half
 * Median will always be one of these:
 *  - max of left heap  (lower range)
 *  - min of right heap (upper range)
 *  - mean of top of each heap
 *****************************************************/

public class RunMed {

    //instance vars
    private ALMaxHeap leftHeap;
    private ALMinHeap rightHeap;


    /*****************************************************
     * default constructor  ---  inits empty heap
     *****************************************************/
    public RunMed() { 
	leftHeap = new ALMaxHeap();
	rightHeap = new ALMinHeap();
    }//O(?)



    /*****************************************************
     * int getMedian()  ---  returns median of dataset
     *****************************************************/
    public int getMedian() {
	int retVal;
	if ( leftHeap.size() > 0 && rightHeap.size() > 0 ) {
	    if ( leftHeap.size() == rightHeap.size() ) {
		retVal = ( rightHeap.peekMin() + leftHeap.peekMax() ) / 2;
	    }
	    else if ( leftHeap.size() > rightHeap.size() ) {
		retVal = rightHeap.peekMin();
	    }
	    else {
		retVal = leftHeap.peekMax();
	    }
	}
	else if ( leftHeap.size() > 0 ) {
	    retVal = leftHeap.peekMax();
	}
	else if ( rightHeap.size() > 0 ) {
	    retVal = rightHeap.peekMin();
	}
	else {
	    retVal = 0;
	}
	return retVal;
    }//O(1)



    /*****************************************************
     * insert(int)  ---  adds a new element to the dataset
     * postcondition: dataset is maintained such that 
     *                getMedian() can run in constant time
     *****************************************************/
    public void insert( int addVal ) {
     	int med = getMedian();
	if ( addVal > med ) {
	    leftHeap.add( addVal );
	}
	else {
	    rightHeap.add( addVal );
	}
	if ( ( leftHeap.size() - rightHeap.size() ) > 1 ) {
	    rightHeap.add( leftHeap.removeMax() );
	}
	else if ( ( rightHeap.size() - leftHeap.size() ) > 1 ) {
	    leftHeap.add( rightHeap.removeMin() );
	}
     }//O(logn)



    /*****************************************************
     * boolean isEmpty()  ---  tells whether a median may be calculated
     * postcondition: dataset structure unchanged
     *****************************************************/
    public boolean isEmpty() {
     	return leftHeap.isEmpty() && rightHeap.isEmpty();
    }//O(1)



    //main method for testing
    public static void main( String[] args ) {

        RunMed med = new RunMed();

        med.insert(1);
	System.out.println( med.getMedian() ); //1

        med.insert(3);
	System.out.println( med.getMedian() ); //2

        med.insert(5);
	System.out.println( med.getMedian() ); //3

        med.insert(7);
	System.out.println( med.getMedian() ); //4

        med.insert(9);
	System.out.println( med.getMedian() ); //5

	/*~~~~~~~~~~~~move~me~down~~~~~~~~~~~~~~~~

	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    }//end main()

}//end class RunMed



    /*****************************************************
     * 
     *****************************************************/
    // (  )
    // {
    // 	/*** YOUR IMPLEMENTATION HERE ***/
    // }//O(?)

