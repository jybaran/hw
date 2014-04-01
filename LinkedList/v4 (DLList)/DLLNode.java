// JENNY BARAN
// APCS2 pd 9
// HW21
// 2014-03-26

/*****************************************************
 * class DLLNode
 * Implements a node, for use in lists and other container classes.
 *****************************************************/

public class DLLNode<T> {

    private T _cargo; //cargo is a generic
    private DLLNode _nextNode; //points to DLLNode
    private DLLNode _prevNode; //points to DLLNode

    //constructor -- initialized instance vars
    public DLLNode( T value, DLLNode next, DLLNode prev ) {
	_cargo = value;
	_nextNode = next;
	_prevNode = prev;
    }

    public T getCargo() {
	return _cargo;
    }

    public DLLNode getNext() {
	return _nextNode;
    }

    public DLLNode getPrev() {
	return _prevNode;
    }

    public T setCargo( T newCargo ) {
	T oldCargo = getCargo();
	_cargo = newCargo;
	return oldCargo;
    }

    public DLLNode setNext( DLLNode newNext ) {
	DLLNode oldNext = getNext();
	_nextNode = newNext;
	return oldNext;
    }

    public DLLNode setPrev( DLLNode newPrev ) {
	DLLNode oldPrev = getPrev();
	_prevNode = newPrev;
	return oldPrev;
    }

    public static void main( String[] args ) {
	//create a node
	DLLNode first = new DLLNode( "cat", null, null );

	//add another node
	first.setNext( new DLLNode( "dog", null, first ) );
	
	//add a third node after the second
	first.getNext().setNext( new DLLNode( "cow", null, first.getNext() ) );

	/*A naive list traversal, has side effect of destroying list
	while( first != null ) {
	    System.out.println( first );
	    first = first.getNext();
	}
	*/

	//Q: when head pointer moves to next node in list, what happens to node it left?
	//A: memory is reclaimed (deletes the node)

	//so the better way to traverse the list (w/o moving head pointer):
	DLLNode temp = first; //create pointer to first so memory isn't reclaimed
	while ( temp != null ) {
	    System.out.println( temp );
	    temp = temp.getNext();
	}
    
    } //end main

} //end class DLLNode
