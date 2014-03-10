// JENNY BARAN & MINDI CHO & SYDNEY CAPUTO
// APCS2 pd 9
// HW10
// 2014-03-06

import java.util.*;

/*================
  Mean execution time for arrays of size n with method sort:
  n = 10     0.143s     over 5 executions
  n = 20     0.126s     over 5 executions
  n = 100    0.140s     over 5 executions
  n = 1000   0.279s     over 5 executions  

  Mean execution time for arrays of size n with method sortV:
  n = 10     0.123s     over 5 executions
  n = 20     0.140s     over 5 executions
  n = 100    0.133s     over 5 executions
  n = 1000   0.180s     over 5 executions
  ================*/

public class MergeSort {

    public static ArrayList<Integer> merge ( ArrayList<Integer> a, ArrayList<Integer> b ) {
	
	ArrayList<Integer> retArray = new ArrayList<Integer> ( a.size()+b.size() ); //new sorted array
	
	int x = 0; //smallest card in a
	int y = 0; //smallest card in b
	int z = 0; //current location in retArray
	
	//while cards remain in both a and b (not in retArray)
	while ( x < a.size() && y < b.size() ) {
	    //if smallest card in a is smaller than smallest card in b
	    if ( a.get(x) < b.get(y) ) {
		//put current top card from a into next empty spot in retArray
		retArray.add( z, a.get(x) );
		x++; //look at next card in a
	    }
	    else {
		//put current top card from b into next empty spot in retArray
		retArray.add( z, b.get(y) );
		y++; //look at next card in b
	    }
	    z++; //prep next spot in retArray
	}

	//if cards still left in a
	if ( x != a.size() ) { 
	    while ( x < a.size() ) {
		//put current top card from a into next empty spot in retArray
		retArray.add( z, a.get(x) );
		x++; //look at next card in a
		z++; //prep next spot in retArray
	    }
	}
	
	//else if cards still left in b
	else if ( y != b.size() ) {
	    while ( y < b.size() ) {
		//put current top card from b into next empty spot in retArray
		retArray.add( z, b.get(y) );
		y++; //look at next card in b
		z++; //prep next spot in retArray
	    }
	}
	
	return retArray;
    }

    public static ArrayList<Integer> sort( ArrayList<Integer> a ) {
	
	if (a.size() > 1) { //if more than one card in a
	    ArrayList<Integer> oh = new ArrayList<Integer>( a.size() / 2 ); //half of cards in a
	    ArrayList<Integer> kay = new ArrayList<Integer>( a.size() - ( a.size() / 2 ) ); //other half
	    
	    for (int i = 0; i < a.size()/2; i++) { //fill oh
		oh.add( i, a.get(i) );
	    }

	    for (int h = 0 ; h < a.size() - (a.size()/2); h++) { //fill kay
		kay.add( h, a.get( h + (a.size() / 2) ) );
	    }
	    
	    //System.out.println(oh);
	    //System.out.println(kay);

	    return merge( sort(oh), sort(kay) );
	}
	
	else { //if only one card in a
	    return a;
	}
    }

    /* still feel like there must have been some way to make this
       work but giving up for now

    public static void sortV( ArrayList<Integer> a ) {
	sortV( a, 0, a.size()-1 );
    }
    
    public static void sortV( ArrayList<Integer> a, int start, int end ) {
	if (end > start) {
	    sortV(a, start, end/2);
	    sortV(a, end/2+1, end);
	    
	    int write = 0;
	    int startB = 0;
	    int startC = end/2+1;
	    
	    //while cards remain that have not been merged
	    while ( write < end ) {
		//if smallest card in B is smaller than smallest card in C
		if ( a.get(startB) < a.get(startC) ) {
		    startB++; //move to next smallest in B
		}
		
		//if smallest card in C is smaller than current card in B
		else {
		    //insert smallest card in C, bump all larger cards up a slot
		    a.add( write, a.remove(startC) );
		    startB++; //compensate for inserted card
		    startC++; //move to next smallest in C
		}
		
		write++; //move write marker 1 up
	    } //close while
	} //close if
    }
    */

    public static void sortV( ArrayList<Integer> a ) {
	ArrayList<Integer> one = new ArrayList<Integer>();
	ArrayList<Integer> two = new ArrayList<Integer>();
	
	one.add(0);
	two.add(0);
	
	for ( int i = 0; i < a.size()-1; i++ ) {
	    one.clear(); //get rid of the old values in one once merged
	    
	    for ( int j = 0; j <= i; j++ ) {
		one.add( a.remove(0) );
	    }
	    
	    two.set( 0, a.remove(0) );
	    a.addAll( 0, merge(one, two) );
	}
    }
    
    public static void main( String[] args ) {
	int len = 1000;
	ArrayList<Integer> foo = new ArrayList<Integer>(len);
	//ArrayList<Integer> boo = new ArrayList<Integer>(len);
	
	for ( int i = 0; i < len; i++ ) {
	    int temp = (int)(Math.random()*1000);
	    foo.add(i, temp);
	    //boo.add(i, temp*2);
	}
	
	System.out.println( foo );
	//System.out.println( boo );
	//System.out.println( merge(foo, boo) );
	System.out.println( sort(foo) );
	//System.out.println( foo );
       	//sortV( foo );
	System.out.println( foo );
    }
}
