// JENNY BARAN & ALISA SU
// APCS2 pd 9
// HW09
// 2014-03-05

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
		retArray.set( z, a.get(x) );
		x++; //look at next card in a
	    }
	    else {
		//put current top card from b into next empty spot in retArray
		retArray.set( z, b.get(y) );
		y++; //look at next card in b
	    }
	    z++; //prep next spot in retArray
	}

	//if cards still left in a
	if ( x != a.size() ) { 
	    while ( x < a.size() ) {
		//put current top card from a into next empty spot in retArray
		retArray.set( z, a.get(x) );
		x++; //look at next card in a
		z++; //prep next spot in retArray
	    }
	}
	
	//else if cards still left in b
	else if ( y != b.size() ) {
	    while ( y < b.size() ) {
		//put current top card from b into next empty spot in retArray
		retArray.set( z, b.get(y) );
		y++; //look at next card in b
		z++; //prep next spot in retArray
	    }
	}
	
	return retArray;
    }

    public static ArrayList<Integer> sort( ArrayList<Integer> a ) {
	
	if (a.size() != 1) { //if more than one card in a
	    ArrayList<Integer> oh = new ArrayList<Integer> ( a.size() / 2 ); //half of cards in a
	    ArrayList<Integer> kay = new ArrayList<Integer> ( a.size() - ( a.size() / 2 ) ); //other half
	    
	    for (int i = 0; i < oh.size(); i++) { //fill oh
		oh.set( i, a.get(i) );
	    }

	    for (int h = 0 ; h < kay.size(); h++) { //fill kay
		kay.set( h, a.get( h + (a.size() / 2) ) );
	    }
	    
	    oh = sort(oh);
	    kay = sort(kay);
	    
	    return merge(oh,kay);
	}
	
	else { //if only one card in a
	    return a;
	}
    }

    public static void sortV( ArrayList<Integer> a ) {
	a = sort(a);
    }

    public static void main( String[] args ) {
	Random r = new Random();
	ArrayList<Integer> foo = new ArrayList<Integer> (70);

	for ( int i = 0; i < foo.size(); i++ ) {
	    foo.set(i, r.nextInt(1000));
	}

	System.out.println ( sort(eleven) );
    }
}
