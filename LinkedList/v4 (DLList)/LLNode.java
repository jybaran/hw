// JENNY BARAN
// APCS2 pd 9
// HW21
// 2014-03-26

/*****************************************************
 * class LLNode
 * Implements a node, for use in lists and other container classes.
 *****************************************************/

public class LLNode<T> {

    private T _cargo; //cargo is a generic
    private LLNode _nextNode; //points to LLNode

    //constructor -- initialized instance vars
    public LLNode( T value, LLNode next ) {
	_cargo = value;
	_nextNode = next;
    }

    public T getCargo() {
	return _cargo;
    }

    public LLNode getNext() {
	return _nextNode;
    }

    public T setCargo( T newCargo ) {
	T oldCargo = getCargo();
	_cargo = newCargo;
	return oldCargo;
    }

    public LLNode setNext( LLNode newNext ) {
	LLNode oldNext = getNext();
	_nextNode = newNext;
	return oldNext;
    }

    public static void main( String[] args ) {
	//create a node
	LLNode first = new LLNode( "cat", null );

	//add another node
	first.setNext( new LLNode( "dog", null ) );
	
	//add a third node after the second
	first.getNext().setNext( new LLNode( "cow", null ) );

	/*A naive list traversal, has side effect of destroying list
	while( first != null ) {
	    System.out.println( first );
	    first = first.getNext();
	}
	*/

	//Q: when head pointer moves to next node in list, what happens to node it left?
	//A: memory is reclaimed (deletes the node)

	//so the better way to traverse the list (w/o moving head pointer):
	LLNode temp = first; //create pointer to first so memory isn't reclaimed
	while ( temp != null ) {
	    System.out.println( temp );
	    temp = temp.getNext();
	}
    
    } //end main

} //end class LLNode