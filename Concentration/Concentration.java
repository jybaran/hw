// JENNY BARAN
// pd 8
// HW44
// 2013-12-16

/*========================================
class Concentration
Facilitates playing game of Concentration,
aka Memory.
========================================*/

import java.util.ArrayList;
import java.util.Arrays;
import cs1.Keyboard;

public class Concentration {

    //instance variables
    //storage for 4x4 grid of Tiles. _board.size() == 16	
    private ArrayList<Tile> _board; 

    //count of Tiles with faces visible
    private int _numberFaceUp;  

    //list of Strings used for Tile vals
    private WordList _list;

    private static int _numRows = 4;

    public Concentration() {
	String[] array = { "dog", "cat", "fish", "fox", "moose", "whale", "pony", "squirrel" };
	ArrayList<String> stuff = new ArrayList<String>( Arrays.asList(array) );
	_list = new WordList( stuff );
	_board = new ArrayList<Tile>();
	
	for ( String i : _list.getList() ) {
	    _board.add( new Tile(i) );
	    _board.add( new Tile(i) );
	}
	
	randomize();
    }

    public String toString() {
	String s = new String("Board: \n");
	
	for ( int i = 0; i < _board.size(); i++ ) {
	    if ( ( (i + 1) % _numRows == 0 ) && (i != 0) ) {
		s += _board.get(i) + "\n";
	    }
	    else {
		s += _board.get(i) + "\t";
	    }
	}
	return s;
    }

    private void swap( int i, int j ) {
	ArrayList<Tile> temp = new ArrayList<Tile>();
	for ( int z = 0; z < _board.size(); z++ ) {
	    temp.add( new Tile("") );
	}

	for ( int a = 0; a < _board.size() ; a++ ) {
	    if ( a == i ) {
		temp.set( a, _board.get(j) );
	    }
	    else if ( a == j ) {
		temp.set( a, _board.get(i) );
	    }
	    else {
		temp.set( a, _board.get(a) );
	    }
	}	
	_board = temp;
    }

    private void randomize() {
	int a = 0;
	int b = 0;
	
	for ( int i = 0; i < 1000; i++ ) {
	    a = (int) ( Math.random() * _board.size() );
	    b = (int) ( Math.random() * _board.size() );
	    swap(a, b);
	}
    }

    private boolean isNull() {
	boolean r = false;
	
	for ( Tile i : _board ) {
	    if ( i == null ) {
		r = true;
	    }
	    else {
		r = false;
		break;
	    }
	}
	return r;
    }

    public void play() {
	while (! isNull() ) {
	    if ( _numberFaceUp == 2 ) {
		int t1 = -1;
		int t2 = -1;

		for ( int i = 0; i < _board.size(); i++ ) {
		    if ( _board.get(i) == null ) {
			continue;
		    }
		    else if ( (t1 == -1) && ( _board.get(i).isFaceUp() ) ) {
			t1 = i;
		    }
		    else if ( (t2 == -1) && ( _board.get(i).isFaceUp() ) ) {
			t2 = i;
		    }
		}

		if ( _board.get(t1).equals( _board.get(t2) ) ) {
		    _board.set(t1, null);
		    _board.set(t2, null);
		}
		else {
		    _board.get(t1).flip();
		    _board.get(t2).flip();
		}
		
		_numberFaceUp = 0;
		
	    }

	    System.out.println("Pick a number of Tile to flip from 0-15, inclusive.\n");
	    System.out.println("Spaces labeled 'null' have been cleared.\n");
	    System.out.println( this.toString() );
	    System.out.print("Choice: ");
	    int choice = Keyboard.readInt();

	    if ( (choice < 0) || ( choice > _board.size() ) ) {
		System.out.println("Invalid choice.\n");
	    }
	    else if ( _board.get(choice) == null ) {
		System.out.println("Already cleared.\n");
	    }
	    else if ( _board.get(choice).isFaceUp() ) {
		System.out.println("Already face up.\n");
	    }
	    else {
		_board.get(choice).flip();
		_numberFaceUp++;
	    }
	}
	System.out.println("Congratulations! You won!");
    }
		

    //DO NOT MODIFY main()
    public static void main( String[] args ) {
	Concentration game = new Concentration();
	game.play();
    }

}//end class Concentration

