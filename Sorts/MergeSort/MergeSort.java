// JENNY BARAN & ALISA SU
// APCS2 pd 9
// HW09
// 2014-03-05

/*======================
  Mean execution time for arrays of size n
  n=5    0.140s    over 5 excecutions
  n=7    0.120s    over 5 excecutions
  n=9    0.124s    over 5 excecutions
  n=11   0.124s    over 5 excecutions
  ======================*/

public class MergeSort {

    public static int[] merge ( int[] a, int[] b ) {
	
	int[] retArray = new int[a.length+b.length]; //new sorted array
	
	int x = 0; //smallest card in a
	int y = 0; //smallest card in b
	int z = 0; //current location in retArray
	
	//while cards remain in both a and b (not in retArray)
	while (x < a.length && y < b.length) {
	    //if smallest card in a is smaller than smallest card in b
	    if (a[x] < b[y]) {
		//put current top card from a into next empty spot in retArray
		retArray[z] = a[x];
		x++; //look at next card in a
	    }
	    else {
		//put current top card from b into next empty spot in retArray
		retArray[z] = b[y];
		y++; //look at next card in b
	    }
	    z++; //prep next spot in retArray
	}

	//if cards still left in a
	if (x != a.length) { 
	    while (x < a.length) {
		//put current top card from a into next empty spot in retArray
		retArray[z] = a[x];
		x++; //look at next card in a
		z++; //prep next spot in retArray
	    }
	}
	
	//else if cards still left in b
	else if (y != b.length) {
	    while (y < b.length) {
		//put current top card from b into next empty spot in retArray
		retArray[z] = b[y];
		y++; //look at next card in b
		z++; //prep next spot in retArray
	    }
	}
	
	return retArray;
    }

    public static int[] sort ( int[] a ) {
	
	if (a.length != 1) { //if more than one card in a
	    int[] oh = new int[a.length / 2 ]; //half of cards in a
	    int[] kay = new int[a.length - ( a.length / 2 ) ]; //other half
	    
	    for (int i = 0; i < oh.length; i++) { //fill oh
		oh[i] = a[i];
	    }

	    for (int h = 0 ; h < kay.length; h++) { //fill kay
		kay[h] = a[h + (a.length / 2)];
	    }
	    
	    oh = sort(oh);
	    kay = sort(kay);
	    
	    return merge(oh,kay);
	}
	
	else { //if only one card in a
	    return a;
	}
    }

    public static String printArray ( int[] a ) {
	String retStr = "[ ";
	for (int x = 0; x < a.length; x++) {
	    retStr += a[x] + " ";
	}
	return retStr + "]";
    }

    public static void main( String[] args ) {
	//TESTING MERGE
	/*	
	int[] hi = {1,2,3};
	int[]hey = {1,2,4,5};
	System.out.println (printArray(merge(hi,hey)));
	 */

	//TESTING SORT
	//int[] five = { 1, 30, 19, 107, 30 };
	//System.out.println ( printArray( sort(five) ) );
	//int[] seven = { 46, 53, 992, 5, 2390, 0, 20 };
	//System.out.println ( printArray( sort(seven) ) );
	//int[] nine = { 12, 3, 86, 14, 2, 3, 788888, 79, 60 };
	//System.out.println ( printArray( sort(nine) ) );
	int[] eleven = { 1, 4, 39, 10, 42, 100, 21, 0, 330, 1000, 4 };
	System.out.println ( printArray( sort(eleven) ) );
    }
}
