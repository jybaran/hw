/*****************************************************
 * class LList
 * Implements a linked list.
 *****************************************************/

public class LList<T> implements List<T> { //your List.java must be in same dir

    //instance vars
    private LLNode _head;
    private int _size;

    //constructor -- initializes instance vars
    public LList() {
	_head = null; //when created, a list is empty
	_size = 0; //see last
    }

    public boolean add( T x ) { 
	LLNode temp = new LLNode( x, _head );
	_head = temp;
	_size++;
	return true;
    } 

    public void add( int i, T x ) {
	LLNode temp = _head;
	for ( int pt = 0; pt < i - 1; pt++ ) {
	    temp = temp.getNext();
	}
	temp.getNext().setNext( new LLNode( x, temp.getNext().getNext() ) );
	_size++;
    }

    public T remove( int i ) {
	T retVal;
	LLNode temp = _head;
	for ( int pt = 0; pt < i - 1; pt++ ) {
	    temp = temp.getNext();
	}
	retVal = (T)( temp.getNext().getCargo() );
	temp.setNext( temp.getNext().getNext() );
	_size--;
	return retVal;
    }

    public T get( int i ) { 
	
	if ( i < 0 || i >= size() ) {
	    throw new IndexOutOfBoundsException();
	}

	T retVal;
	LLNode temp = _head; //makes an alias to head

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
	
	LLNode temp = _head; //makes an alias to head

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
	LLNode temp = _head;
	while ( temp != null ) {
	    retStr += temp.getCargo() + "->";
	    temp = temp.getNext();
	}
	retStr += "NULL";
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
