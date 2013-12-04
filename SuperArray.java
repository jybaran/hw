// JENNY BARAN
// pd 8
// HW36
// 2013-12-02

/*==================================================
  class SuperArray
  Wrapper class for array. Facilitates resizing, 
  getting and setting element values.
  ==================================================*/

public class SuperArray {

    private int[] _data;
    private int _lastPos;
    private int _size;


    //default constructor
    //initializes 10-item array
    public SuperArray() { 
	_data = new int[10];
	_size = 0;
	_lastPos = 0;
    }


    //output array in [a,b,c] format
    //eg, for int[] a = {1,2,3} ...
    //toString() -> "[1,2,3]"
    public String toString() { 
	String output = "[";

	for ( int x : _data ) {
	    output += x + ",";
	}
	
	output = output.substring( 0, output.length()-1 ) + "]";

	return output;
    }


    //double capacity of this instance of SuperArray 
    private void expand() { 
	int[] nData = new int[ _data.length * 2 ];
	for ( int i = 0; i < _data.length; i++ ) {
	    nData[i] = _data[i];
	}
	_data = nData;
    }


    //accessor method -- return value at specified index
    public int get( int index ) {
	return _data[index];
    }


    //mutator method -- set index to newVal, return old value at index
    public int set( int index, int newVal ) {
	int retInt = _data[index];
	_data[index] = newVal;
	return retInt; 
    }

    //main method for testing
    public static void main( String[] args ) {

	SuperArray curtis = new SuperArray();
	System.out.println( "Printing empty SuperArray curtis..." );
	System.out.println( curtis );

	for( int i = 0; i < curtis._data.length; i++ ) {
	    curtis.set( i, i * 2 );
	    curtis._size++;
	}

	System.out.println("\nPrinting populated SuperArray curtis...");
	System.out.println(curtis);

	curtis.expand();

	for ( int i = curtis._size; i < curtis._data.length; i++ ) {
	    curtis.set( i, i * 2 );
	    curtis._size++;
	}

	System.out.println("\nPrinting expanded & populated SuperArray curtis...");
	System.out.println(curtis);

	System.out.println("\nPrinting value at index 5 in SuperArray curtis...");
	System.out.println( curtis.get(5) ); //should return 10

    }

}//end class SuperArray