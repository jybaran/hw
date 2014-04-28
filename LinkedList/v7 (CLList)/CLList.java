// JENNY BARAN
// APCS2 pd 9
// HW31
// 2014-04-25

/*****************************************************
 * class CLList
 * Implements a circularly linked list.
 *****************************************************/

public class CLList<T> implements List<T> { //your List.java must be in same dir

    //instance vars
    private DLLNode<T> _head;
    private int _size;

    //constructor -- initializes instance vars
    public CLList() {
	_head = null;
	_size = 0; //see last
    }

    public boolean addFront( T x ) {
	DLLNode<T> newNode = new DLLNode<T>( x, null, null );
	if ( size() == 0 ) {
	    newNode.setNext( newNode );
	    newNode.setPrev( newNode );
	    _head = newNode;
	}
	else {
	    DLLNode<T> temp = _head.getPrev();
	    temp.setNext( newNode );
	    newNode.setPrev( temp );
	    newNode.setNext( _head );
	    _head.setPrev( newNode );
	    _head = newNode;
	}
	_size++;
	return true;
    }

    public boolean addEnd( T x ) {
	DLLNode<T> newNode = new DLLNode<T>( x, null, null );
	if ( size() == 0 ) {
	    newNode.setNext( newNode );
	    newNode.setPrev( newNode );
	    _head = newNode;
	}
	else {
	    DLLNode<T> temp = _head.getPrev();
	    temp.setNext( newNode );
	    newNode.setNext( _head );
	    _head.setPrev( newNode );
	    newNode.setPrev( temp );
	}
	_size++;
	return true;
    }

    public boolean add( T x ) {
	return addEnd( x );
    }

    public void add( int i, T x ) {
	if ( i == 0 ) {
	    addFront( x );
	}
	else if ( i >= size() ) {
	    addEnd( x );
	}
	else {
	    DLLNode<T> temp = _head;
	    DLLNode<T> newNode = new DLLNode<T>( x, null, null );
	    for ( int j = 0; j < i; j++ ) {
		temp = temp.getNext();
	    }
	    newNode.setNext( temp.getNext() );
	    temp.getNext().setPrev( newNode );
	    temp.setNext( newNode );
	    newNode.setPrev( temp );
	}
	_size++;
    }

    public T removeFront() {
	T retVal = null;
	if ( size() <= 1 ) {
	    _head = null;
	}
	else {
	    DLLNode<T> temp = _head.getNext();
	    _head.getPrev().setNext( temp );
	    temp.setPrev( _head.getPrev() );
	    retVal = (T)( _head.getValue() );
	    _head = temp;
	}
	_size--;
	return retVal;
    }

    public T removeEnd() {
	T retVal = null;
	if ( size() <= 1 ) {
	    _head = null;
	}
	else {
	    DLLNode<T> temp = _head.getPrev();
	    temp.getPrev().setNext( _head );
	    _head.setPrev( temp.getPrev() );
	    retVal = (T)( temp.getValue() );
	    temp = null;
	}
	_size--;
	return retVal;
    }

    public T remove( int i ) {
	T retVal = null;
	if ( i == 0 ) {
	    retVal = removeFront();
	}
	else if ( i == size() - 1 ) {
	    retVal = removeEnd();
	}
	else {
	    DLLNode<T> temp = _head;
	    for ( int pt = 0; pt <= i; pt++ ) {
		temp = temp.getNext();
	    }
	    retVal = (T)( temp.getValue() );
	    DLLNode<T> node = temp.getNext();
	    node.setPrev( temp.getPrev() );
	    temp.getPrev().setNext( node );
	    temp = null;
	}
	_size--;
	return retVal;
    }

    public T get( int i ) { 
	
	if ( i < 0 || i > size() ) {
	    throw new IndexOutOfBoundsException();
	}

	T retVal;
	DLLNode temp = _head; //makes an alias to head

	//goes to the node at i
	for ( int j = 0; j < i; j++ ) {
	    temp = temp.getNext();
	}

	//check cargo at target node
	retVal = (T)( temp.getValue() );
	return retVal;
	
    } 

    public T set( int i, T x ) {
	
	if ( i < 0 ) {
	    throw new IndexOutOfBoundsException();
	}
	
	DLLNode temp = _head; //makes an alias to head

	//goes to the node at i
	for ( int j = 0; j < i; j++ ) {
	    temp = temp.getNext();
	}

	//store target node's original cargo
	T oldVal = (T)( temp.getValue() );

	//replace old cargo with new val
	temp.setValue( x );
	
	return oldVal;
	
    } 

    public int size() { 
	return _size;
    } 
    
    public String toString() {
	String retStr = "HEAD->";
	DLLNode temp = _head;
	while ( temp != null ) {
	    retStr += temp.getValue() + "->";
	    temp = temp.getNext();
	}
	retStr += "TAIL";
	return retStr;
    }

    public static void main( String[] args ) {
	
	CLList<String> james = new CLList<String>();

	System.out.println( james );
	System.out.println( "size:" + james.size() );
	
	james.add( "beat" );
	System.out.println( james );
	System.out.println( "size:" + james.size() );

	james.add( "a" );
	System.out.println( james );
	System.out.println( "size:" + james.size() );

	james.add( "need" );
	System.out.println( james );
	System.out.println( "size:" + james.size() );

	james.add( "I" );
	System.out.println( james );
	System.out.println( "size:" + james.size() );

	System.out.println( "2nd item is: " + james.get(1) );

	james.set( 1, "got" );
	System.out.println( "...and now 2nd item is: " + james.set(1, "got") );

	System.out.println( james );

	james.add( 2, "sick" );
	System.out.println( "...after adding " + james.get(2) 
			    + " to 3rd spot:" );
	System.out.println( james );
	
	System.out.println( "...after removing " + james.remove( 3 ) + ":" );
	System.out.println( james );

    } //end main

} //end class LList
