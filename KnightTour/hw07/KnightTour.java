// JENNY BARAN
// APCS2 pd 9
// HW07
// 2014-03-03

/*======================================
  class KnightTour
  Animates a Knight's Tour of a square chess board.

  Mean execution times for boards of size n*n:
  n=5   3.733s    over 5 executions 
  n=6   89.344s   over 5 executions
  n=7   N/As      over N/A executions
  n=8   N/As      over N/A executions
  ======================================*/

// TIP: from a *nix prompt, use
// $ time java KnightTour 5
// to measure execution time of 
// $ java Knight 5

//Q1: From any starting position, can a tour always be found? Explain.
//A1: There is not necessarily a tour for every position on every board.
//Q2: How do you explain the increase in execution time as n increases?
//A2: As n increases linearly, the size of the board increases exponentially, meaning that it takes longer for the program to assess all of the steps for their ability to complete the tour.


import java.io.*;
import java.util.*;


class TourFinder {

    //instance vars
    private int[][] board;
    private int sideLength; //board has dimensions n x n
    private boolean solved = false;

    //constructor
    public TourFinder( int n ) {

	sideLength = n;

	//init 2D array to represent square board with moat
	board = new int[n+4][n+4];

	//SETUP BOARD --  0 on each cell to represent unvisited
	//               -1 on each border/buffer cell around edges
	//---------------------------------------------------------
	for( int i=0; i < n+4; i++ )
	    for( int j=0; j < n+4; j++ )
		board[i][j] = -1; //lay down initial blanket of -1's

	for( int i=2; i < n+2; i++ )
	    for( int j=2; j < n+2; j++ )
		board[i][j] = 0; //lay down 0's for actual board
	//---------------------------------------------------------

    }//end constructor


    public String toString() {
	//send ANSI code "ESC[0;0H" to place cursor in upper left
	String retStr = "[0;0H";  
	//emacs shortcut: C-q, then press ESC
	//emacs shortcut: M-x quoted-insert, then press ESC

	int i, j;
	for( i=0; i < sideLength+4; i++ ) {
	    for( j=0; j < sideLength+4; j++ )
		retStr = retStr + String.format( "%3d", board[j][i] );
	             //"%3d" allots 3 spaces for each number
	    retStr = retStr + "\n";
	}
	return retStr;
    }


    //helper method to keep try/catch clutter out of main flow
    private void delay( int n ) {
	try {
	    Thread.sleep(n);
	}
	catch( InterruptedException e ) {
	    System.exit(0);
	}
    }


    /*********************************************
     * void findTour(int x,int y,int moves) -- 
     *    use depth-first w/ backtracking algo to find valid knight's tour
     * @param x      starting x-coord
     * @param y      starting y-coord
     * @param moves  number of moves made so far
     *********************************************/
    public void findTour( int x, int y, int moves ) {

	//delay(50); //slow it down enough to be followable

	//if a tour has been completed, stop animation
	if ( solved ) System.exit(0);

	//primary base case: tour completed
	if ( moves > sideLength*sideLength ) {
	    solved = true;
	    System.out.println( this ); //refresh screen
	    return;
	}
	//other base case: stepped off board or onto visited cell
	if ( board[x][y] != 0 ) {
	    return;
	}
	//otherwise, mark current location
	//and recursively generate tour possibilities from current pos
	else {
	    board[x][y] = moves; //mark current cell with current move number
	    System.out.println( this ); //refresh screen

	    //delay(1000); //uncomment to slow down enough to view

	    /*======================================
	      Recursively try to solve (find tour) from 
	      each of knight's available moves.
	      . e . d .
	      f . . . c
	      . . @ . .
	      g . . . b
	      . h . a .
	      ======================================*/
	    findTour( x+1, y+2, moves+1 ); // a
	    findTour( x+2, y+1, moves+1 ); // b
	    findTour( x+2, y-1, moves+1 ); // c
	    findTour( x+1, y-2, moves+1 ); // d
	    findTour( x-1, y-2, moves+1 ); // e
	    findTour( x-2, y-1, moves+1 ); // f
	    findTour( x-2, y+1, moves+1 ); // g
	    findTour( x-1, y+2, moves+1 ); // h

	    //If made it this far, path did not lead to tour, so back up.
	    // (Overwrite number at this cell with a 0.)
	    board[x][y] = 0;

	    System.out.println( this ); //refresh screen
	}
    }
}//end class TourFinder


public class KnightTour {

    public static void main( String[] args ) {

	int n = 8;

	try { 
	    n = Integer.parseInt( args[0] );
	}catch( Exception e ) { 
	    System.out.println( "Invalid input. Using board size " 
				+ n + "..." );
	}

	TourFinder tf = new TourFinder( n );

	//clear screen using ANSI control code
	System.out.println( "[2J" ); 

	//display board 
	System.out.println( tf );

	//for random starting location, use lines below:
	int startX = 2 + (int)( n * Math.random() );
	int startY = 2 + (int)( n * Math.random() );
	tf.findTour( startX, startY, 1 );   // 1 or 0 ?

	//for fixed starting location, use line below:
	//tf.findTour( 2, 2, 1 );

    }

}//end class KnightTour
