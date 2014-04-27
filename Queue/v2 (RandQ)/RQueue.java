// JENNY BARAN
// APCS2 pd 9
// HW31
// 2014-04-24

/*****************************************************
 * class RQueue
 * A linked-list-based, randomized queue
 * (a collection with FIIDKO property)
 *
 *       -------------------------------
 *   end |  --->   Q U E U E   --->    | front
 *       -------------------------------
 *
 *  linked list points opposite direction. Q: Why?
 *            N <- N <- ... <- N <- N
 *      _end -^                     ^- _front
 *
 ******************************************************/


public class RQueue<T> implements Queue<T> {

    private LLNode<T> _front, _end;
    private int _size;

    // default constructor
    // creates an empty queue
    public RQueue() { 
	_front = _end = null;
	_size = 0;
    }//O(1)

    public void enqueue( T enQVal ) {
	//for empty list, _front && _end point to same node
	if ( isEmpty() ) {
	    _front = _end = new LLNode<T>( enQVal, null );
	}
	else { 
	    _end.setNext( new LLNode<T>( enQVal, null ) );
	    _end = _end.getNext();
	}
	_size++;
    }//O(1)

    // remove and return thing at front of queue
    // then reorder elements
    // assume _queue ! empty
    public T dequeue() { 
	T retVal = _front.getValue();
	_front = _front.getNext();

	if ( _front == null ) { //just moved past last node
	    _end = null; //update end to reflect emptiness
	}

	_size--;
	
	if ( _size > 1 ) {
	    sample();
	}

	return retVal;
    }//O(?)

    public T peekFront() {
	return _front.getValue();
    }//O(1)

    private void sample () {
	int cycles = (int)( _size * Math.random() );
	for ( int i = 0; i < cycles; i++ ) {
	    enqueue( dequeue() );
	}
    }//O(?)

    public boolean isEmpty() { 
	return _size == 0;
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
    }


    public static void main( String[] args ) {

	Queue<String> PirateQueue = new RQueue<String>();

	System.out.println("\nnow enqueuing..."); 
	PirateQueue.enqueue("Dread");
	PirateQueue.enqueue("Pirate");
	PirateQueue.enqueue("Robert");
	PirateQueue.enqueue("Blackbeard");
	PirateQueue.enqueue("Peter");
	PirateQueue.enqueue("Stuyvesant");

	System.out.println("\nnow testing toString()..."); 
	System.out.println( PirateQueue ); //for testing toString()...

	System.out.println("\nnow dequeuing..."); 
	System.out.println( PirateQueue.dequeue() );
	System.out.println( PirateQueue.dequeue() );
	System.out.println( PirateQueue.dequeue() );
	System.out.println( PirateQueue.dequeue() );
	System.out.println( PirateQueue.dequeue() );
	System.out.println( PirateQueue.dequeue() );

	System.out.println("\nnow dequeuing from empty queue..."); 
	System.out.println( PirateQueue.dequeue() );

    }//end main

}//end class RQueue
