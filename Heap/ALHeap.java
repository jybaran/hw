// JENNY BARAN
// APCS2 pd 9
// HW40
// 2014-05-16

/*****************************************************
 * class ALHeap
 * Implements a min heap using an ArrayList as underlying container
 * 
 * TASK:
 * Implement all methods
 * Add helpers as necessary
 * Classify runtime of each method
 *****************************************************/

import java.util.ArrayList;


public class ALHeap {

    //instance vars
    private ArrayList<Integer> _heap; //underlying container
    

    /*****************************************************
     * default constructor  ---  inits empty heap
     *****************************************************/
    public ALHeap() {
	_heap = new ArrayList<Integer>();
    }//O(1)



    /*****************************************************
     * boolean isEmpty()
     * Returns true if no meaningful elements in heap, false otherwise
     *****************************************************/
    public boolean isEmpty() {
	return _heap.size() == 0;
    }//O(1)


    /*****************************************************
     * add(Integer) 
     * Inserts an element in the heap
     * Postcondition: Tree maintains heap property.
     *****************************************************/
    public void add( Integer addVal ) {
	_heap.add(addVal);
	if ( _heap.size() != 1 ) {
	    int newLoc = _heap.size() - 1;
	    check( newLoc );
	}
    }//O(?)
    
    private void check( int loc ) {
	if ( loc != 0 ) {
	    int parentLoc = ( loc - 1 ) / 2;
	    Integer parentVal = _heap.get( parentLoc );
	    Integer myVal = _heap.get(loc);
	    if ( parentVal > myVal ) {
		swap( parentLoc, loc );
		check( parentLoc );
	    }
	}
    }


    /*****************************************************
      * Integer peekMin()
      * Returns min value in heap
      * Postcondition: Heap remains unchanged.
      *****************************************************/
    public Integer peekMin() {
	return _heap.get(0);
    }//O(1)



    /*****************************************************
     * removeMin()  ---  means of removing an element from heap
     * Removes and returns least element in heap.
     * Postcondition: Tree maintains heap property.
     *****************************************************/
    public Integer removeMin() { //NOT DONE
	if ( _heap.size() == 0 ) {
	    return null;
	}
	
	//store root val for return at end of fxn
	Integer retInt = peekMin();
	
	//store val about to be swapped into root
	Integer foo = _heap.get( _heap.size() - 1 );

	//swap last leaf with root
	swap( 0, _heap.size() - 1 );
	
	//lop off last leaf
	_heap.remove( _heap.size() - 1 );

	//walk the now out of place root down the tree
	int pos = 0;
	int minChildPos;

	while ( pos < _heap.size() ) {
	    //choose child w/ min val, or check for child
	    minChildPos = minChildPos( pos );

	    //if no children, walked far enough
	    if ( minChildPos == -1 ) {
		break;
	    }
	    //if i am less than my least child, walked far enough
	    else if ( foo.compareTo( _heap.get( minChildPos ) ) <= 0 ) {
		break;
	    }
	    //if i am > least child, swap
	    else {
		swap( pos, minChildPos );
		pos = minChildPos;
	    }
	}
	return retInt;
    }//O(?)
    

    /*****************************************************
     * minChildPos(int)  ---  helper fxn for removeMin()
     * Returns index of least child, or 
     * -1 if no children, or if input pos is not in ArrayList
     * Postcondition: Tree unchanged
     *****************************************************/
    private int minChildPos( int pos ) {
	int left = ( 2 * pos ) + 1;
	int right = ( 2 * pos ) + 2;
	if ( ( left < _heap.size() ) && ( right < _heap.size() ) ) { 
	    if ( minOf( _heap.get(left), _heap.get(right) )  == _heap.get(left) ) {
		return left;
	    }
	    else {
		return right;
	    }
	}
	else if ( left < _heap.size() ) {
	    return left;
	}
	else if ( right < _heap.size() ) {
	    return right;
	}
	else {
	    return -1;
	}
    }//O(1)
    
    
    
    //~~~~~~~~~~~~~~~v~  MISC HELPERS ~v~~~~~~~~~~~~~~~
    
    private void swap( int loc1, int loc2 ) {
	Integer temp = _heap.get( loc2 );
	_heap.set( loc2, _heap.get( loc1 ) );
	_heap.set( loc1, temp );
    }
    
    private Integer minOf( Integer a, Integer b ) {
	if ( a <= b ) {
	    return a;
	}
	else {
	    return b;
	}
    }//O(n)

    //~~~~~~~~~~~~~~~^~  MISC HELPERS ~^~~~~~~~~~~~~~~~



    /*****************************************************
     * toString()  ---  overrides inherited method
     * Returns either 
     * a) a level-order traversal of the tree (simple version)
     * b) ASCII representation of the tree (bit more complicated, much more fun)
     *****************************************************/
    public String toString() {
	String retStr = "heap size: " + _heap.size() + "\n";
	int count = 0;
	int numPerLine = 1;
	while ( count < _heap.size() ) {
	    for ( int i = 0; i < numPerLine; i++ ) {
		if ( count == _heap.size() ) { 
		    return retStr + "\n";
		}
		retStr +=  _heap.get( count ) + " ";
		count++;
	    }
	    retStr += "\n";
	    numPerLine = numPerLine * 2;
	}
	return retStr;
    }//O(n)






    //main method for testing
    public static void main( String[] args ) {

	ALHeap pile = new ALHeap();

	pile.add(2);
	System.out.println(pile);
	pile.add(4);
	System.out.println(pile);
	pile.add(6);
	System.out.println(pile);
	pile.add(8);
	System.out.println(pile);
	pile.add(10);
	System.out.println(pile);
	pile.add(1);
	System.out.println(pile);
	pile.add(3);
	System.out.println(pile);
	pile.add(5);
	System.out.println(pile);
	pile.add(7);
	System.out.println(pile);
	pile.add(9);
	System.out.println(pile);

	System.out.println("removing " + pile.removeMin() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMin() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMin() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMin() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMin() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMin() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMin() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMin() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMin() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMin() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMin() + "...");
	System.out.println(pile);

    }//end main()

}//end class ALHeap
