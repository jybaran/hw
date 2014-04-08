// JENNY BARAN
// APCS2 pd 9
// HW26
// 2014-04-08

// class Latkes
// (actually: a class to implement a stack of Strings)
// uses an array as underlying data structure

public class Latkes<P> implements Stack<P> {

    private P[] _stack;
    private int _stackSize;

    //constructor
    public Latkes( int size ) {
	_stack = (P[])new Object[size];
	_stackSize = 0;
    }

    //means of insertion
    public void push( P x ) {
	if ( isFull() ) { //makes new storage space if necessary
	    P[] _temp = (P[])new Object[_stack.length*2];
	    for ( int i = 0; i < _stack.length; i++ ) {
		_temp[i] = _stack[i];
	    }
	    _stack = _temp;
	}
	_stack[_stackSize] = x;
	_stackSize++;
    }

    //means of removal
    public P pop( ) {
	P retVal;
	if ( isEmpty() ) {
	    return null;
	}
	retVal = _stack[ --_stackSize ];
	return retVal;
    }

    public P peek( ) {
	P retVal;
	if ( isEmpty() ) {
	    return null;
	}
	retVal = _stack[ _stackSize - 1 ];
	return retVal;
    }

    //chk for emptiness
    public boolean isEmpty() {
	return _stackSize == 0;
    }

    //chk for fullness
    public boolean isFull() {
	return _stackSize >= _stack.length;
    }

    public static void main( String[] args ) {

	Latkes tastyStack = new Latkes(10);

	tastyStack.push("avocado (cubed)");
	tastyStack.push("buttons (shiny)");
	tastyStack.push("coffee (iced)");
	tastyStack.push("drops (rain)");
	tastyStack.push("envelope (first class)");
	tastyStack.push("feethats (matching)");
	tastyStack.push("github (awesome)");
	tastyStack.push("heights (in the)");
	tastyStack.push("island (caribbean)");
	tastyStack.push("juice (cherry)");
	tastyStack.push("kitten (tiny)");
	tastyStack.push("lizards (fire)");
	tastyStack.push("music (loud)");

	//music
	System.out.println( tastyStack.pop() );
	//lizards
	System.out.println( tastyStack.pop() );
	//kitten
	System.out.println( tastyStack.pop() );
	//juice
	System.out.println( tastyStack.pop() );
	//island
	System.out.println( tastyStack.pop() );
	//heights
	System.out.println( tastyStack.pop() );
	//github
	System.out.println( tastyStack.pop() );
	//feethats
	System.out.println( tastyStack.pop() );
	//envelope
	System.out.println( tastyStack.pop() );
	//drops
	System.out.println( tastyStack.pop() );
	//coffee
	System.out.println( tastyStack.pop() );
	//buttons
	System.out.println( tastyStack.pop() );
	//avocado
	System.out.println( tastyStack.pop() );
	//null (stack empty)
	System.out.println( tastyStack.pop() );
    }

} //end class Latkes
