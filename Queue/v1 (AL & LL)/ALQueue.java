// JENNY BARAN
// APCS2 pd 9
// HW30
// 2014-04-23

/*****************************************************
 * class ALQueue
 * uses an ArrayList to implement abstract data type QUEUE
 * (a collection with FIFO property)
 *
 *       -------------------------------
 *   end |  --->   Q U E U E   --->    | front
 *       -------------------------------
 *
 ******************************************************/

import java.util.*;

public class ALQueue<T> implements Queue<T> {
    private ArrayList<T> _queue;

    // default constructor
    public ALQueue( int size ) {
	_queue = new ArrayList<T>(size);
    }

    // means of adding an item to collection
    public void enqueue( T x ) {
	_queue.add( x );
    }//O(1)

    // means of removing an item from collection
    public T dequeue() {
	T retVal = null;
	if ( isEmpty() ) {
	    return null;
	}
	retVal = _queue.remove( 0 );
	return retVal;
    }//O(n)
    
    // means of "peeking" at the front item
    public T peekFront() { 
	T retVal = null;
	if ( isEmpty() ) {
	    return null;
	}
	retVal = _queue.get( 0 );
	return retVal;
    }//O(1)

    // means of checking to see if collection is empty
    public boolean isEmpty() {
	return _queue.size() == 0;
    }//O(1)

    public static void main( String[] args ) {

	Queue tastyQueue = new ALQueue(10);

	tastyQueue.enqueue("avocado (cubed)");
	tastyQueue.enqueue("buttons (shiny)");
	tastyQueue.enqueue("coffee (iced)");
	tastyQueue.enqueue("drops (rain)");
	tastyQueue.enqueue("envelope (first class)");
	tastyQueue.enqueue("feethats (matching)");
	tastyQueue.enqueue("github (awesome)");
	tastyQueue.enqueue("heights (in the)");
	tastyQueue.enqueue("island (caribbean)");
	tastyQueue.enqueue("juice (cherry)");
	tastyQueue.enqueue("kitten (tiny)");
	tastyQueue.enqueue("lizards (fire)");
	tastyQueue.enqueue("music (loud)");

	//avocado
	System.out.println( tastyQueue.dequeue() );
	//buttons
	System.out.println( tastyQueue.dequeue() );
	//coffee
	System.out.println( tastyQueue.dequeue() );
	//drops
	System.out.println( tastyQueue.dequeue() );
	//envelope
	System.out.println( tastyQueue.dequeue() );
	//feethats
	System.out.println( tastyQueue.dequeue() );
	//github
	System.out.println( tastyQueue.dequeue() );
	//heights
	System.out.println( tastyQueue.dequeue() );
	//island
	System.out.println( tastyQueue.dequeue() );
	//juice
	System.out.println( tastyQueue.dequeue() );
	//kitten
	System.out.println( tastyQueue.dequeue() );
	//lizards
	System.out.println( tastyQueue.dequeue() );
	//music
	System.out.println( tastyQueue.dequeue() );
	//null (stack empty)
	System.out.println( tastyQueue.dequeue() );
    } //end main

} //end class ALQueue
