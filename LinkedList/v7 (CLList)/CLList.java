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
    private DLLNode _head;
    private DLLNode _tail;
    private int _size;

    //constructor -- initializes instance vars
    public CLList() {
	_head = null; //when created, a list is empty
	_tail = null;
	_size = 0; //see last
    }

    public boolean add( T x ) {
	if ( size() == 0 ) {
	    DLLNode temp = new DLLNode( x, null, null );
	    _head = _tail = temp;
	}
	_tail = temp;
	if ( _tail.getPrev() != null ) {
	    _tail.getPrev().setNext( _tail );
	}
	_size++;
	return true;
    } 

    public void add( int i, T x ) {
	DLLNode temp = _head;
	for ( int pt = 0; pt < i; pt++ ) {
	    temp = temp.getNext();
	}
	DLLNode tmp1 = temp.getNext();
	temp.setNext( new DLLNode( x, tmp1, temp ) );
	tmp1.setPrev( temp.getNext() );
	_size++;
    }

    public T remove( int i ) {
	T retVal;
	DLLNode temp = _head;
	for ( int pt = 0; pt <= i; pt++ ) {
	    temp = temp.getNext();
	}
	retVal = (T)( temp.getCargo() );
	
	if ( temp.getNext() == null ) {
	    temp.getPrev().setNext( null );
	}
	else {
	    temp.getPrev().setNext( temp.getNext() );
	}
	
	if ( temp.getPrev() == null ) {
	    temp.getNext().setPrev( null );
	}
	else {
	    temp.getNext().setPrev( temp.getPrev() );
	}

	_size--;
	return retVal;
    }

    public T get( int i ) { 
	
	if ( i < 0 || i >= size() ) {
	    throw new IndexOutOfBoundsException();
	}

	T retVal;
	DLLNode temp = _head; //makes an alias to head

	//goes to the node at i
	for ( int j = 0; j < i; j++ ) {
	    temp = temp.getNext();
	}

	//check cargo at target node
	retVal = (T)( temp.getCargo() );
	return retVal;
	
    } 

    public T set( int i, T x ) {
	
	if ( i < 0 || i >= size() ) {
	    throw new IndexOutOfBoundsException();
	}
	
	DLLNode temp = _head; //makes an alias to head

	//goes to the node at i
	for ( int j = 0; j < i; j++ ) {
	    temp = temp.getNext();
	}

	//store target node's original cargo
	T oldVal = (T)( temp.getCargo() );

	//replace old cargo with new val
	temp.setCargo( x );
	
	return oldVal;
	
    } 

    public int size() { 
	return _size;
    } 
    
    public String toString() {
	String retStr = "HEAD->";
	DLLNode temp = _head;
	while ( temp != null ) {
	    retStr += temp.getCargo() + "->";
	    temp = temp.getNext();
	}
	retStr += "TAIL";
	return retStr;
    }

    public static void main( String[] args ) {
	
	LList james = new LList();

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
