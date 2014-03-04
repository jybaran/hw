/*======================================
  class KnightTour
  ======================================*/

import java.io.*;
import java.util.*;

class TourFinder {

    private int[][] board;
    private int h, w;
    private boolean solved;

    public TourFinder() {
	constructionHelper(8);
    }
    public TourFinder( int sL ) {
	constructionHelper(sL);
    } //end constructors

    public void constructionHelper( int sL ) {
	h = sL + 4;
	w = h;

	board = new int[h][w];
	for ( int m = 0; m<w; m++ ) {
	    board[0][m] = -1;
	    board[1][m] = -1;
	    board[sL+2][m] = -1;
	    board[sL+3][m] = -1;
	}
	for ( int m = 0; m<w; m++ ) {
	    board[m][0] = -1;
	    board[m][1] = -1;
	    board[m][sL+2] = -1;
	    board[m][sL+3] = -1;
	}

	solved = false;

    }

    public int[][] getBoard() {
	return board;
    }
    
    public int getTile( int x, int y) {
	return board[x][y];
    }

    public String toString() {
	String retStr = "[0;0H";  

	int i, j;
	for( i=0; i<h; i++ ) {
	    for ( j=0; j<w; j++ ) {
		retStr = retStr + String.format("% 3d", board[i][j]);
	    }
	    retStr = retStr + "\n";
	}
	return retStr;
    }


    private void delay( int n ) {
	try {
	    Thread.sleep(n);
	}
	catch( InterruptedException e ) {
	    System.exit(0);
	}
    }


    /*********************************************
     * void solve(int x,int y,int moveCtr) -- recursively finds tour path (depth-first)
     * @param x starting x-coord, measured from left
     * @param y starting y-coord, measured from top
     * @param moveCtr carries over # of moves
     *********************************************/
    public void solve( int x, int y, int moveCtr ) {

	delay(50); //slow it down enough to be followable

	//primary base case: tour is solved
	if ( moveCtr >= h*w ) {
	    solved = true;
	    System.out.println( this ); //refresh screen
	    System.exit(0);
	}
	//other base cases
	else if ( board[x][y] != 0 ) {
	    return;
	}
	//otherwise, recursively solve tour from next pos over,
	//after marking current location
	else {
	    board[x][y] = moveCtr; //mark current location
	   
	    solve( x+2, y+1, moveCtr+1 );
	    solve( x+1, y+2, moveCtr+1 );
	    solve( x-2, y+1, moveCtr+1 );
	    solve( x-1, y+2, moveCtr+1 );
	    solve( x+2, y-1, moveCtr+1 );
	    solve( x+1, y-2, moveCtr+1 );
	    solve( x-2, y-1, moveCtr+1 );
	    solve( x-1, y-2, moveCtr+1 );

	    board[x][y] = 0;
	    System.out.println( this ); //refresh screen
	    return;
	}
    }
}//end class TourFinder


public class KnightTour {

    public static void main( String[] args ) {
	TourFinder tf;

	try {
	    int sideLength = Integer.parseInt(args[0]);
	    tf = new TourFinder(sideLength);
	}
	catch (Exception e) {
	    tf = new TourFinder();
	}

	//clear screen
	System.out.println( "[2J" ); 

	//display board 
	System.out.println( tf );

	//TASK: Randomize drop-in point.
	//      Ensure your randomly-selected coords are on the board.
	/*
	Random r = new Random();
	int startX = r.nextInt(w) + 2;
	int startY = r.nextInt(h) + 2;

	while ( tf.getTile(startX, startY) == 0 ) {
	    startX = r.nextInt(h) + 2;
	    startY = r.nextInt(h) + 2;
	}
	*/
	tf.solve( 3, 3, 1 );

    }

}//end class KnightTour
