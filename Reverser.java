// JENNY BARAN
// APCS2 pd 9
// HW13
// 2014-03-12

import java.io.*;
import java.util.*;

public class Reverser {

    //still not comfortable with Scanner
    //public static Scanner scan = new Scanner( System.in );
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    public static String makeString( int len ) {
	String str = "";
	
	for (int i = 0; i < len; i++) {
	    int randLetter = (int)( Math.random() * 26 );
	    str = str + ALPHABET.substring(randLetter, randLetter+1);
	}
	return str;
    }
    
    public static String reverse( String s ) { //O(n)
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
    }//O(n)

    public static String reverse2( String s ) { //O(logn)
	if ( s.length() == 1 ) {
	    return s;
	}
	else {
	    return reverse2( s.substring( s.length()/2, s.length() ) ) +
		reverse2( s.substring(0, s.length()/2) );
	}
    }
    
    public static String reverseLog( String s ) {
	String retStr = s;
	int midLo = s.length()/2;
	int midHi = s.length() - midLo;

	return "";
    }

    public static void main( String[] args ) {
        String input = "";
	//index = scan.next();
	int len;
	//len = scan.nextInt();
	try {
	    len = Integer.parseInt(args[0]);
	}
	catch (Exception e) {
	    len = 10;
	}
	input = makeString(len);

	System.out.println(input);
	System.out.println( reverse2(input) );
	System.out.println(input);
    }

}