// JENNY BARAN
// APCS2 pd 9
// HW04
// 2014-02-12

/*======================================
  class Recursinator -- an refresher exercise in Java recursion
  ======================================*/


public class Recursinator {

    /*******************************************************
     * int fact(int n)
     * @param n number whose factorial is to be computed
     * precond: n >= 0
     * eg: fact(5) -> 120
     *******************************************************/
    public static int fact( int n ) {
	if ( n <= 1 ) { //base case
	    return 1;
	}
	else {
	    return n*fact(n-1);
	}
    }


    /*******************************************************
     * int fibRec(int n) returns nth term of Fibonacci sequence
     *     Uses recursion.
     * @param n specifies position of term in sequence.
     * precond: 0th, 1st, 2nd terms are 0,1,1
     * eg: fibRec(3) -> 2
     *******************************************************/
    public static int fibRec(int n) { 
	if ( n == 0 ) { //base case 0
	    return 0;
	}
	else if ( n == 1 ) { //base case 1
	    return 1;
	}
	else {
	    return fibRec( n - 1 ) + fibRec( n - 2 );
	}
    }


    /*******************************************************
     * int fibIt(int n) returns nth term of Fibonacci sequence
     *     Uses iteratiion.
     * @param n specifies position of term in sequence.
     * precond: 0th, 1st, 2nd terms are 0,1,1
     * eg: fibIt(3) -> 2
     *******************************************************/
    public static int fibIt(int n) { 
	int retInt = 0;
	if ( n == 0 ) {
	    return 0;
	}
	else {
	    int a = 0;
	    int b = 1;
	    for ( int i = 1; i < n; i++ ) {
		retInt = a + b;
		a = b;
		b = retInt;
	    }
	}
	return retInt;
    }


    /*******************************************************
     * String fenceIt(int n) builds a fence with n fenceposts
     * @param n number of |'s in return String
     * precond: n >= 1
     * eg: fenceIt(1) -> "|"
     * eg: fenceIt(2) -> "|---|"
     * eg: fenceIt(3) -> "|---|---|"
     *******************************************************/
    public static String fenceIt( int n ) { 
	String fence = "|";
	for ( ; n > 1; n-- ) {
	    fence += "--|";
	}
	return fence;
    }


    /*******************************************************
     * String fenceRec(int n) builds a fence with n fenceposts
     * @param n number of |'s in return String
     * precond: n >= 1
     * eg: fenceRec(1) -> "|"
     * eg: fenceRec(2) -> "|---|"
     * eg: fenceRec(3) -> "|---|---|"
     *******************************************************/
    public static String fenceRec( int n ) { 
	int i = n;
	if ( i == 1 ) { //base case
	    String fence = "|";
	    return fence;
	}
	else {
	    return fenceRec(i-1) + "--|";
	}
    }


    /*******************************************************
     * String commafyIt(int n) returns a String representation of
     *        n with commas inserted where appropriate
     * @param n number in need of commas
     * precond: n >= 0
     * eg: commafyIt(100) -> 100
     * eg: commafyIt(1000) -> 1,000
     * eg: commafyIt(10,000,000) -> 10,000,000
     *******************************************************/
    public static String commafyIt( int n ) { 
	String retStr = "" + n;
	int len = retStr.length();
	for ( ; len >= 4; len -= 3 ) {
	    retStr = retStr.substring(0, len-3) + "," + retStr.substring(len-3);
	}
	return retStr;
    }


    /*******************************************************
     * String commafyRec(int n) returns a String representation of
     *        n with commas inserted where appropriate
     * @param n number in need of commas
     * precond: n >= 0
     * eg: commafyRec(100) -> 100
     * eg: commafyRec(1000) -> 1,000
     * eg: commafyRec(10,000,000) -> 10,000,000
     *******************************************************/
    public static String commafyRec( int n ) { 
	String retStr = "" + n;
	int len = retStr.length();
	if ( len < 4 ) {
	    return retStr;
	}
	else {
	    return commafyRec ( n / 1000 ) + "," + retStr.substring(len-3);
	}
    }


    public static void main( String [] args ) {

	/*============================================
	  Main method for testing. Suggested use:
	  Set up a list of test cases for each function 
	  BEFORE you begin writing each method.
	  Move top comment bar (----) down one line at a time
	  when you're ready to test each line.
	  ============================================*/

	/*----FACTORIAL-------------------------------
	  System.out.println( "fact(0) -> " + fact(0) ); // 1
	  System.out.println( "fact(1) -> " + fact(1) ); // 1
	  System.out.println( "fact(2) -> " + fact(2) ); // 2
	  System.out.println( "fact(3) -> " + fact(3) ); // 6
	  System.out.println( "fact(4) -> " + fact(4) ); // 24
	  System.out.println( "fact(5) -> " + fact(5) ); // 120
	  System.out.println( "fact(13) -> " + fact(13) ); // ?
	  System.out.println( "fact(14) -> " + fact(14) ); // ?
	  System.out.println( "fact(15) -> " + fact(15) ); // ??? 
	  //...Q: What do the results of these last calls tell you?
	  //...A: The results get cut off, since they've expanded past what an int can represent.
	  --------------------------------------------*/

	/*----FIBREC----------------------------------
	  System.out.println( "fibRec(0) -> " + fibRec(0) ); // 0
	  System.out.println( "fibRec(1) -> " + fibRec(1) ); // 1
	  System.out.println( "fibRec(2) -> " + fibRec(2) ); // 1
	  System.out.println( "fibRec(3) -> " + fibRec(3) ); // 2
	  System.out.println( "fibRec(4) -> " + fibRec(4) ); // 3
	  System.out.println( "fibRec(5) -> " + fibRec(5) ); // 5
	  System.out.println( "fibRec(6) -> " + fibRec(6) ); // 8
	  System.out.println( "fibRec(7) -> " + fibRec(7) ); // 13
	  --------------------------------------------*/

	/*----FIBIT-----------------------------------
	  System.out.println( "fibIt(0) -> " + fibIt(0) ); // 0
	  System.out.println( "fibIt(1) -> " + fibIt(1) ); // 1
	  System.out.println( "fibIt(2) -> " + fibIt(2) ); // 1
	  System.out.println( "fibIt(3) -> " + fibIt(3) ); // 2
	  System.out.println( "fibIt(4) -> " + fibIt(4) ); // 3
	  System.out.println( "fibIt(5) -> " + fibIt(5) ); // 5
	  System.out.println( "fibIt(6) -> " + fibIt(6) ); // 8
	  System.out.println( "fibIt(7) -> " + fibIt(7) ); // 13
	  --------------------------------------------*/

	/*----FENCEIT---------------------------------
	  System.out.println( "fenceIt(1) -> " + fenceIt(1) ); // |
	  System.out.println( "fenceIt(2) -> " + fenceIt(2) ); // |--|
	  System.out.println( "fenceIt(3) -> " + fenceIt(3) ); // |--|--|
	  System.out.println( "fenceIt(4) -> " + fenceIt(4) ); // |--|--|--|
	  --------------------------------------------*/

	/*----FENCEREC---------------------------------
	  System.out.println( "fenceRec(1) -> " + fenceRec(1) ); // |
	  System.out.println( "fenceRec(2) -> " + fenceRec(2) ); // |--|
	  System.out.println( "fenceRec(3) -> " + fenceRec(3) ); // |--|--|
	  System.out.println( "fenceRec(4) -> " + fenceRec(4) ); // |--|--|--|
	  --------------------------------------------*/
 
    }//end main

}//end class Recursinator
