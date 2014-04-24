// JENNY BARAN
// APCS2 pd 9
// HW30
// 2014-04-23

/*****************************************************
 * class LLQueue
 * uses a linked list to implement a QUEUE
 * (a collection with FIFO property)
 *
 *       -------------------------------
 *   end |  --->   Q U E U E   --->    | front
 *       -------------------------------
 *
 ******************************************************/

public class LLQueue<T> implements Queue<T> {

    private LLNode<T> _front, _end;

    // default constructor creates an empty queue
    public LLQueue() { 
	_front = _end = null;
    }

    // means of adding a thing to the collection
    public void enqueue( T enQVal ) {
	if ( isEmpty() ) {
	    LLNode<T> temp = new LLNode<T>( enQVal, null );
	    _front = temp;
	    _end = temp;
	}
	else {
	    LLNode<T> temp = new LLNode<T>( enQVal, null );
	    _end.setNext( temp );
	    _end = temp;
	}
    }//O(1)


    // means of removing a thing from the collection
    // Remove and return thing at front of queue.
    // Assume _queue ! empty.
    public T dequeue() {
	T retVal = _front.getValue();
	_front = _front.getNext();
	return retVal;
    }//O(1)


    // means of peeking at thing next in line for removal
    public T peekFront() {
	T retVal = _front.getValue();
	return retVal;
    }//O(1)


    public boolean isEmpty() {
	return ( _front == null ) && ( _end == null );
    }//O(1)


    // print each node, separated by spaces
    public String toString() { 
	String foo = "";
	LLNode<T> tmp = _front;
	while ( tmp != null ) {
	    foo += tmp.getValue() + " ";
	    tmp = tmp.getNext();
	}
	return foo;
    }//O(n)



    public static void main( String[] args ) {

	Queue<String> LLQueuelJ = new LLQueue<String>();

	System.out.println("\nnow enqueuing thrice..."); 
	LLQueuelJ.enqueue("James");
	LLQueuelJ.enqueue("Todd");
	LLQueuelJ.enqueue("Smith");

	System.out.println("\nnow testing toString()..."); 
	System.out.println( LLQueuelJ ); //for testing toString()...

	System.out.println("\nnow dequeuing thrice..."); 
	System.out.println( LLQueuelJ.dequeue() );
	System.out.println( LLQueuelJ.dequeue() );
	System.out.println( LLQueuelJ.dequeue() );

	System.out.println("\nDequeuing from empty queue should yield error..."); 
	System.out.println( LLQueuelJ.dequeue() );

    }//end main

}//end class LLQueue
