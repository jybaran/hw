// JENNY BARAN
// pd 8
// HW49
// 2014-01-08

/*====================================
  class Matrix -- models a square matrix

  TASK: Implement methods below, categorize runtime of each. 
        Test in your main method.
  ====================================*/ 

public class Matrix {

    //constant for default matrix size
    private final static int DEFAULT_SIZE = 2;

    private Object[][] _matrix;

    //default constructor intializes a DEFAULT_SIZE*DEFAULT_SIZE matrix
    public Matrix() {
	_matrix = new Object[DEFAULT_SIZE][DEFAULT_SIZE];
    } // O(1)


    //constructor intializes an a*a matrix
    public Matrix( int a ) {
	_matrix = new Object[a][a];
    } // O(n^2)


    //return size of this matrix, where size is 1 dimension
    private int size() {
	return _matrix.length;
    } // O(1)


    //return the item at the specified row & column   
    private Object get( int r, int c ) {
	return _matrix[r][c];
    } // O(1)


    //return true if this location is empty, false otherwise
    private boolean isEmpty( int r, int c ) {
	if ( this.get(r,c).equals(null) ) {
	    return true;
	}
	else {
	    return false;
	}
    } // O(1)


    //overwrite item at specified row and column with newVal
    //return old value
    private Object set( int r, int c, Object newVal ) {
	Object oldVal = this.get(r,c);
	_matrix[r][c] = newVal;
	return oldVal;
    } // O(1)


    //return String representation of this matrix
    // (make it look like a matrix)
    public String toString() {
	String retStr = "";
	for ( int i = 0; i < this.size(); i++ ) {
	    for ( int j = 0; j < this.size(); j++ ) {
		retStr += _matrix[i][j] + " ";
	    }
	    retStr = retStr.substring( 0, retStr.length() - 1 ) + "\n";
	}
	return retStr;
    } // O(n)


    //override inherited equals method
    //criteria for equality: matrices have identical dimensions,
    // and identical values in each slot
    public boolean equals( Object rightSide ) {
	boolean retBoo = false;
	boolean sameVals = true;

	for ( Object o : ((Matrix)rightSide)._matrix ) {
	    if (! ( this.isFound(o) ) ) {
		sameVals = false;
	    }
	}

	if ( ( this.size() == ((Matrix)rightSide).size() ) && sameVals ) {
	    retBoo = true;
	}

	return retBoo;
    } // O(n^2)


    //return true if target is in this matrix; false otherwise
    public boolean isFound( Object target ) {
	boolean retBoo = false;

	for ( Object o : _matrix ) {
	    if ( o.equals(target) ) {
		retBoo = true;
	    }
	}

	return retBoo;
    } // O(n^2)


    //swap two columns of this matrix 
    //(1,1) is top left corner of matrix
    //row values increase going down
    //column value increase L-to-R
    public void swapColumns( int c1, int c2  ) {
	for ( int i = 0; i < this.size(); i++ ) {
	    this.set( i, c1, this.set( i, c2, this.get(i, c1) ) );
	}
    } // O(n)


    //swap two rows of this matrix 
    //(1,1) is top left corner of matrix
    //row values increase going down
    //column value increase L-to-R
    public void swapRows( int r1, int r2  ) {
	for ( int i = 0; i < this.size(); i++ ) {
	    this.set( r1, i, this.set( r2, i, this.get(r1, i) ) );
	}
    } // O(n)


    //main method for testing
    public static void main( String[] args ) {
	Matrix m1 = new Matrix();
	//Matrix m2 = new Matrix(5);
	
	System.out.println( m1.size() );
	System.out.println(m1);

	//System.out.println( m2.size() );
	//System.out.println(m2);

	m1.set(0, 0, 1);
	m1.set(0, 1, 2);
	m1.set(1, 0, 3);
	m1.set(1, 1, 4);
	System.out.println(m1);

	m1.swapRows(0, 1);
	System.out.println(m1);
	m1.swapColumns(0, 1);
	System.out.println(m1);
    }

}//end class Matrix
