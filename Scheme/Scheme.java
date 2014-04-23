// JENNY BARAN
// APCS2 pd 9
// HW29
// 2014-04-22

import java.util.*;

/***********************************************
 * ALGORITHM FOR EVALUATING A SCHEME EXPRESSION:
 * First, the constructor takes the String and 
 * splits it on whitespace, feeding it into a Stack
 * from right to left so it pops back in order (instead
 * of reversed). The first element in the Stack (the 
 * first open paren) is popped, getting it out of the
 * way. The evaluate() method then pops next element off
 * of the stack and sets it to a variable called operator.
 * The first element following an open paren will always
 * be the operator, and evaluate() is only called after popping
 * off a open paren. Next, one of the helper methods, 
 * add(), mult(), and sub() is called, based on what operator is.
 * The add() method pops the top element in _stack, which is either
 * a number or an open paren. If it's a number, it adds the value
 * to retVal, and if it's an open paren, it calls evaluate() and
 * then adds that. Then add() loops until it hits a closing paren.
 * The mult() and sub() methods work in essentially the same way.
 * At the end of running these, retVal is returned to evaluate(),
 * and that returns the final answer.
 *
 * STACK OF CHOICE: LLStack because the size of
 * the stack needed is unknown and also I like LLStack.
 ***********************************************/

public class Scheme {
    
    LLStack<String> _stack = new LLStack<String>();

    public Scheme( String s ) {
	String[] temp = s.split(" ");
	for ( int i =  temp.length; i > 0; i-- ) {
	    _stack.push( temp[ i - 1 ] );
	}
	_stack.pop(); //clears the first ( out of the way
    }

    public int evaluate() {
	String operator = _stack.pop(); //gets operator ( +, *, - )
	int retVal = 0;
	
	if ( ( _stack.peek() ).equals( null ) ) {  
	    return retVal;
	}
	if ( operator.equals( "+" ) ) { //if adding
	    retVal = add();
	}
	else if ( operator.equals( "*" ) ) {
	    retVal = mult();
	}
	else {
	    retVal = sub();
	}

	return retVal;
    }
    
    public int add() {
	int retVal = 0;
	String temp = _stack.pop();
	while (! temp.equals( ")" ) ) {
	    if ( temp.equals( "(" ) ) {
		retVal = retVal + evaluate();
		temp = _stack.pop();
	    }
	    else {
		int tempI = Integer.parseInt(temp);
		retVal = retVal + tempI;
		temp = _stack.pop();
	    }
	}
	return retVal;
    }
    
    public int mult() {
	int retVal = 1;
	String temp = _stack.pop();
	while (! temp.equals( ")" ) ) {
	    if ( temp.equals( "(" ) ) {
		retVal = retVal * evaluate();
		temp = _stack.pop();
	    }
	    else {
		int tempI = Integer.parseInt(temp);
		retVal = retVal * tempI;
		temp = _stack.pop();
	    }
	}
	return retVal;
    }

    public int sub() {int retVal;
	String temp = _stack.pop();
	if (! temp.equals( "(" ) ) {
	    retVal = Integer.parseInt(temp);
	    temp = _stack.pop();
	}
	else {
	    retVal = evaluate();
	    temp = _stack.pop();
	}
	while (! temp.equals( ")" ) ) {
	    if ( temp.equals( "(" ) ) {
		retVal = retVal - evaluate();
		temp = _stack.pop();
	    }
	    else {
		int tempI = Integer.parseInt(temp);
		retVal = retVal - tempI;
		temp = _stack.pop();
	    }
	}
	return retVal;
    }

    public static void main( String[] args ) {
	/****************
	Scheme test1 = new Scheme( "( * 32 6 )" );
	for ( int i = 0; i < 4; i++ ) {
	    System.out.println( (test1._stack).pop() );
	}
	****************/

	Scheme test2 = new Scheme( "( + 4 3 )" ); //7
	System.out.println( test2.evaluate() );

	Scheme test3 = new Scheme( "( * 4 3 )" ); //12
	System.out.println( test3.evaluate() );

	Scheme test4 = new Scheme( "( - 4 3 )" ); //1
	System.out.println( test4.evaluate() );

	Scheme test5 = new Scheme( "( + 4 ( * 3 4 ) 3 )" ); //19
	System.out.println( test5.evaluate() );

    }

} //end class Scheme