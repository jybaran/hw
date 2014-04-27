// JENNY BARAN
// APCS2 pd 9
// HW32a
// 2014-04-25

/*************************************************************
 * class Deque
 * uses a doubly-linked list to implement a double-ended QUEUE
 * (a collection with FIFO property)
 *
 *       -------------------------------
 *   left | < --->   Q U E U E  < --->    | right
 *       -------------------------------
 *
 *************************************************************/

public class Deque<T> {

    private DLLNode<T> _right, _left;

    // default constructor creates an empty queue
    public Deque() { 
	_right = _left = null;
    }

    // means of adding a thing to the collection on the right end
    public void enqueueR( T enQVal ) {
	if ( isEmpty() ) {
	    _right = _left  = new DLLNode<T>( enQVal, null, null );
	}
	else {
	    DLLNode<T> temp = new DLLNode<T>( enQVal, _right, null );
	    _right.setNext( temp );
	    _right = temp;
	}
    }//O(1)

    // means of adding a thing to the collection on the left end
    public void enqueueL( T enQVal ) {
	if ( isEmpty() ) {
	    _right = _left = new DLLNode<T>( enQVal, null, null );
	}
	else {
	    DLLNode<T> temp = new DLLNode<T>( enQVal, null, _left );
	    _left.setPrev( temp );
	    _left = temp;
	}
    }//O(1)
    
    // means of removing a thing from the collection
    // Remove and return thing at left of queue.
    // Assume _queue ! empty./
    public T dequeueL() {
	T retVal = _left.getCargo();
	_left = _left.getNext();
	if ( _left != null ) {
	    _left.setPrev( null );
	}
	return retVal;
    }//O(1)

    // means of removing a thing from the collection
    // Remove and return thing at right of queue.
    // Assume _queue ! empty.
    public T dequeueR() {
	T retVal = _right.getCargo();
	_right = _right.getPrev();
	if ( _right != null ) {
	    _right.setNext(null);
	}
	return retVal;
    }//O(1)

    // means of peeking at thing next in line for removal on right
    public T peekR() {
	T retVal = _right.getCargo();
	return retVal;
    }//O(1)

    // means of peeking at thing next in line for removal on left
    public T peekL() {
	T retVal = _left.getCargo();
	return retVal;
    }//O(1)


    public boolean isEmpty() {
	return ( _right == null ) && ( _left == null );
    }//O(1)


    // print each node, separated by spaces
    public String toString() { 
	String foo = "";
	DLLNode<T> tmp = _left;
	while ( tmp != null ) {
	    foo += tmp.getCargo() + " ";
	    tmp = tmp.getNext();
	}
	return foo;
    }//O(n)



    public static void main( String[] args ) {

	Deque<String> deck = new Deque<String>();

	System.out.println("\nnow enqueuing thrice..."); 
	deck.enqueueR("James");
	deck.enqueueR("Todd");
	deck.enqueueR("Smith");
	deck.enqueueL("BOB");

	System.out.println("\nnow testing toString()..."); 
	System.out.println( deck ); //for testing toString()...

	System.out.println("\nnow dequeuing thrice..."); 
	System.out.println( deck.dequeueR() );
	System.out.println( deck.dequeueL() );
	System.out.println( deck.dequeueR() );
	System.out.println( deck.dequeueR() );

	System.out.println("\nDequeuing from empty queue should yield error..."); 
	System.out.println( deck.dequeueR() );

    }//end main

}//end class Deque
