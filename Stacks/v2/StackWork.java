// JENNY BARAN
// APCS2 pd 9
// HW25
// 2014-04-07

/*****************************************************
 * class StackWork
 * Driver class for Latkes.
 * Uses a stack to reverse a text string, check for sets of matching parens.
 *****************************************************/

public class StackWork {

    /**********************************************************
     * precondition:  input string has length > 0
     * postcondition: returns reversed string s
     *                flip("desserts") -> "stressed"
     **********************************************************/
    public static String flip( String s ) { 
	/* RECURSIVELY:
	String retStr = "";
	for ( int i = s.length() - 1; i > -1; i-- ) {
	    retStr += s.substring( i, i+1 );
	}
	return retStr;
	*/
	int size = s.length();
	String retStr = "";
	Latkes L  = new Latkes(size);

	for ( int i = 0; i < size; i++ ) { //adding letters to stack
	    L.push( "" + s.charAt(i) );
	}
	for ( int j = 0; j < size; j++ ) {
	    retStr = retStr + L.pop();
	}

	return retStr;
    }

    /**********************************************************
     * precondition:  s contains only the characters {,},(,),[,]
     * postcondition: allMatched( "( {} [()] )" ) -> true
     *                allMatched( "([)]" )        -> false
     *                allMatched( "" )            -> true
     **********************************************************/
    public static boolean allMatched( String s ) {
	//finished with help from Rebecca
	int size = s.length();
	if ( size == 0 ) {
	    return true;
	}
	Latkes L = new Latkes(size);
	
	for ( int i = 0; i < size; i++ ) {
	    char c = s.charAt(i);
	    if ( c == '{' || c == '[' || c == '(' ) { // if c is open bracket
		L.push( "" + c );
	    }
	    else { // if c is closed bracket
		char next = ("" + L.peek()).charAt(0);
		if ( ( c == ']' && next == '{' ) ||
		     ( c == ']' && next == '(' ) ||
		     ( c == '}' && next == '(' ) ||
		     ( c == '}' && next == '[' ) ||
		     ( c == ')' && next == '[' ) ||
		     ( c == ')' && next == '{' ) ) { //if next is open bracket of another type
		    return false;
		} //end if
		L.push( "" + c );
	    } //end else
	} //end for
	return true;
    } //end allMatched

    public static void main( String[] args ) {
	System.out.println( flip("x") ); //x
	System.out.println( flip("no") ); //on
	System.out.println( flip("mad") ); //dam
	System.out.println( flip("sick") ); //kcis
	
	System.out.println( allMatched( "" ) ); //true
	System.out.println( allMatched( "()" ) ); //true
	System.out.println( allMatched( "([])" ) ); //true
	System.out.println( allMatched( "([)]" ) ); //false
	System.out.println( allMatched( "({}[()])" ) ); //true
	
    } //end main

} //end class StackWork
