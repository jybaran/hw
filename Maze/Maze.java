/*======================================
  class MazeSolver
  ======================================*/

import java.io.*;
import java.util.*;

//Note that this file is not named MazeSolver.java. 
//Q: What do you make of this?
//A: MazeSolver is a class that exists as part of the Maze package. When you compile and run Maze.java, Maze's main method gets looked at, not MazeSolver's. It will default to being protected.

class MazeSolver {

    private char[][] maze;
    private int h, w; //height, width of maze
    private boolean solved;


    //Q: Significance of keyword final here?
    //A: Guards against accidentally changing the chars.
    final private char HERO =         '@';
    final private char PATH =         '#';
    final private char WALL =         ' ';
    final private char EXIT =         '$';
    final private char VISITED_PATH = '.';


    public MazeSolver( String inputFile ) {

	//init 2D array to represent maze
	//Q: Significance of dimensions?
	//A: 80x24 is default Terminal window size.
	maze = new char[80][25];
	h = 0;
	w = 0;

	try {
	    Scanner sc = new Scanner( new File("maze09.dat") );

	    System.out.println( "reading in file..." );

	    int row = 0;

	    while( sc.hasNext() ) {

		String line = sc.nextLine();

		if ( w < line.length() ) 
		    w = line.length();

		for( int i=0; i<line.length(); i++ )
		    maze[i][row] = line.charAt( i );

		h++;
		row++;
	    } 

	    for( int i=0; i<w; i++ )
		maze[i][row] = WALL;
	    h++;
	    row++;

	} catch( Exception e ) { System.out.println( "Error reading file" ); }


	solved = false;
    }//end constructor


    public String toString() {
	//send ANSI code "ESC[0;0H" to place cursor in upper left
	String retStr = "[0;0H";  
	//emacs shortcut: C-q, then press ESC
	//emacs shortcut: M-x quoted-insert, then press ESC
	// (alternatively, just copy and paste from this file...)

	int i, j;
	for( i=0; i<h; i++ ) {
	    for( j=0; j<w; j++ )
		retStr = retStr + maze[j][i];
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


    public char getTile( int x, int y ) {
	return maze[x][y];
    }

    /*********************************************
     * void solve(int x,int y) -- recursively finds maze exit (depth-first)
     * @param x starting x-coord, measured from left
     * @param y starting y-coord, measured from top
     *********************************************/
    public void solve( int x, int y ) {

	delay(60); //slow it down enough to be followable

	//Note how the three options below differ before attempting to fill in.
	//Q: Why is no screen refresh necessary in the else-if block?
	//A: No screen refresh is needed because nothing is moved.

	//primary base case: maze is solved (hero standing on exit)
	if ( maze[x][y] == EXIT ) {
	    solved = true;
	    System.out.println( this ); //refresh screen
	    return;
	}
	//other base cases
	else if ( maze[x][y] == WALL ||
		  maze[x][y] == VISITED_PATH ||
		  maze[x][y] == HERO ) {
	    return;
	}
	//otherwise, recursively solve maze from next pos over,
	//after marking current location
	else {
	    maze[x][y] = HERO; //mark current location
	    System.out.println( this ); //refresh screen

	    for ( int i = -1; i < 2; i = i+2 ) {
		if ( solved == false ) {
		    this.solve(x+i, y);
		}
	    }

	    for ( int j = -1; j < 2; j = j+2 ) {
		if ( solved == false ) {
		    this.solve(x, y+j);
		}
	    }

	    maze[x][y] = VISITED_PATH;
	    System.out.println( this ); //refresh screen
	}
    }
}//end class MazeSolver


public class Maze {

    public static void main( String[] args ) {

	//TASK: Generate 3 mazes ( maze01.dat is simple, maze03.dat is crazy )
	//      Make sure there is trailing whitespace on each line
	//      and that there is an empty line at bottom.

	//TASK: Modify this class to allow input file specification via CLI
	//eg    $ java Maze maze09.dat

	MazeSolver ms = new MazeSolver( "maze09.dat" );

	//clear screen
	System.out.println( "[2J" ); 

	//display maze 
	System.out.println( ms );

	//drop our hero into the maze at pos known to be on path
	//ms.solve( 4, 3 ); 

	//TASK: Randomize drop-in point.
	//      Ensure your randomly-selected coords are on the path.
	//      Uncomment line below to test.

	Random r = new Random();
	int startX = r.nextInt(80);
	int startY = r.nextInt(25);

	while ( ms.getTile(startX, startY) != '#' ) {
	    startX = r.nextInt(80);
	    startY = r.nextInt(25);
	}

	ms.solve( startX, startY );

    }

}//end class Maze
