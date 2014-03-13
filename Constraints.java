// JENNY BARAN
// APCS2 pd 9
// HW13
// 2014-03-12

public class Constraints {
    
    //walks through all possible trios checking if they sum to 0
    public static int trios( int[] arr ) {
	int count = 0;
	for ( int i = 0; i < arr.length-2; i++ ) { //find 1st num of trio
	    for ( int j = 1; j < arr.length-1; j++ ) { //find 2nd num of trio
		for ( int k = 2; k < arr.length; k++ ) { //find 3rd num of trio
		    int sum = arr[i] + arr[j] + arr[k]; //sum of trio
		    if ( sum == 0 ) { //is it 0?
			count++; //if yes, count it
		    }
		}
	    }
	}
	return count;
    } //end trios

    public static void main( String[] args ) {
	int[] foo = { 10, 20, 30, -10, -20, 0 };
	
	System.out.println( trios(foo) );

    }
    
} //end class Constraints