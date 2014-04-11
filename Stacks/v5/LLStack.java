// JENNY BARAN
// APCS2 pd 9
// HW28
// 2014-04-10

// class LLStack
// (actually: a class to implement a stack of generics)
// uses a LinkedList as underlying data structure

import java.util.LinkedList;

public class LLStack<P> implements Stack<P> {

    private LinkedList<P> _stack;

    //constructor
    public LLStack() {
	_stack = new LinkedList<P>();
    }

    //means of insertion
    public void push( P x ) {
	_stack.add( x );
    }

    //means of removal
    public P pop( ) {
	P retVal = null;
	if ( _stack.size() == 0 ) {
	    return null;
	}
	retVal = _stack.removeLast();
	return retVal;
    }

    public P peek( ) {
	P retVal = null;
	if ( _stack.size() == 0 ) {
	    return null;
	}
	retVal = _stack.get( _stack.size()-1 );
	return retVal;
    }

    public boolean isEmpty() {
	return _stack.size() == 0;
    }

    public static void main( String[] args ) {

	Stack tastyStack = new LLStack();

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
