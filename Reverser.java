// JENNY BARAN
// APCS2 pd 9
// HW03
// 2014-02-11

//should be linear/O(n) run time. one for loop, interates through String n times (n being number of letters in the string)

import java.io.*;
import java.util.*;

public class Reverser {

    static Scanner scan = new Scanner( System.in );
    
    public static String reverse( String s ) {
	String retStr = "";
	if ( s.length() <= 1 ) {
	    return s;
	}
	else {
	    for( int i = s.length() - 1; i > -1; i-- ) {
	    retStr += s.substring( i, i+1 );
	    }
	    return retStr;
	}
    }

    public static void main( String[] args ) {
        String input = "";
	input = scan.next();
	
	System.out.println( reverse(input) );
    }

}