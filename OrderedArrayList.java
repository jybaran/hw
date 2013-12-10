// JENNY BARAN
// pd 8
// HW40
// 2013-12-09

/*============================================
   class OrderedArrayList
   Wrapper class for ArrayList.
   Imposes the restriction that stored items 
   must remain sorted in ascending order
   ============================================*/

//ArrayList's implementation is in the java.util package
import java.util.ArrayList;


public class OrderedArrayList {

    // instance of class ArrayList, holding objects of type Comparable 
    // (ie, instances of a class that implements interface Comparable)
    private ArrayList<Comparable> _data;


    // default constructor initializes instance variable _data
    public OrderedArrayList() {
	_data = new ArrayList();
    }


    public String toString() { 
	String foo = "[";
	for( int i = 0; i < this.size()-1; i++ ) {
	    foo += _data.get(i) + ",";
	}
	if ( foo.length() > 1 )
	    //shave off trailing comma
	    foo = foo.substring( 0, foo.length()-1 );
	foo += "]";
	return foo;
    }


    public Comparable remove( int index ) { 
	return _data.remove(index);
    }


    public int size() { 
	return _data.size();
    }

    
    public Comparable get( int index ) { 
	return _data.get(index);
    }


    // addLinear takes as input any comparable object 
    // (i.e., any object of a class implementing interface Comparable)
    // inserts newVal at the appropriate index
    // maintains ascending order of elements
    // uses a linear search to find appropriate index
    public void addLinear(Comparable newVal) { 
	if ( ( _data.size() > 0 ) && ( _data.get( _data.size()-1 ).compareTo( newVal ) > 0 ) ) {
	    for ( int i = 0; i < _data.size(); i++) {
		if ( _data.get(i).compareTo( newVal ) >= 0 ) {
		    _data.add(i, newVal);
		    break;
		}
	    }
	}
	else {
	    _data.add(newVal);
	}
    }


    // addBinary takes as input any comparable object 
    // (i.e., any object of a class implementing interface Comparable)
    // inserts newVal at the appropriate index
    // maintains ascending order of elements
    // uses a binary search to find appropriate index
    public void addBinary(Comparable newVal) { 
	int hi = _data.size() - 1;
	int lo = 0;
	int i = 0;

	while ( lo <= hi ) {
	    int mid = lo + ( hi - lo ) / 2;
	    
	    if ( _data.get(mid).compareTo(newVal) > 0 ) {
		hi = mid - 1;
	    }
	    else if ( _data.get(mid).compareTo(newVal) < 0 ) {
		lo = mid + 1;
	    }
	    else if ( _data.get(mid).compareTo(newVal) == 0 ) {
		i = mid;
		break;
	    }
	    i = lo;
	}

	_data.add(i, newVal);
    }	


    // main method solely for testing purposes
    public static void main( String[] args ) {

	OrderedArrayList Franz = new OrderedArrayList();

	// testing linear search
	for( int i = 0; i < 15; i++ )
	    Franz.addLinear( (int)( 50 * Math.random() ) );
	System.out.println( Franz );

	// testing binary search
	Franz = new OrderedArrayList();
	for( int i = 0; i < 15; i++ ) 
	    Franz.addBinary( (int)( 50 * Math.random() ) );
	System.out.println( Franz );

    }

}//end class OrderedArrayList
