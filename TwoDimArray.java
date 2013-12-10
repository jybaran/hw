// JENNY BARAN
// pd 8
// HW41
// 2013-12-10


public class TwoDimArray {

    //postcond: prints each row of 2D integer array a on its own line
    //          uses a FOR loop
    public static void print1( int[][] a ) { 
	for (int i = 0; i < a.length; i++) {
	    String row = "";
	    for (int j = 0; j < a[i].length; j++) {
		row += a[i][j] + ",";
	    }
	    if ( row.length() > 0 ) {
		row = row.substring( 0, row.length() - 1 );
	    }
	    System.out.println(row);
	}
    }

    //postcond: prints each row of 2D integer array a on its own line
    //          uses a FOREACH loop
    public static void print2( int[][] a ) { 
	for ( int[] i : a ) {
	    String row = "";
	    for ( int j : i ) {
		row += j + ",";
	    }
	    if ( row.length() > 0 ) {
		row = row.substring( 0, row.length() - 1 );
	    }
	    System.out.println(row);
	}
    }

    //postcond: returns sum of all items in 2D integer array a
    public static int sum1( int[][] a ) { 
	int sum = 0;
	for (int i = 0; i < a.length; i++) {
	    for (int j = 0; j < a[i].length; j++) {
		sum += a[i][j];
	    }
	}
	return sum;
    }

    //postcond: returns sum of all items in 2D integer array a
    //          * uses helper fxn sumRow
    public static int sum2( int [][] a ) { 
	int sum = 0;
	for (int r = 0; r < a.length; r++) {
	    sum += sumRow(r, a);
	}
	return sum;
    }

    //postcond: returns sum of all items on row r of 2D integer array a
    //          uses a FOR loop
    public static int sumRow( int r, int[][] a ) { 
	int sum = 0;
	for (int i = 0; i < a[r].length; i++) {
	    sum += a[r][i];
	}
	return sum;
    }

    //postcond: returns sum of all items on row r of 2D integer array a
    //          uses a FOREACH loop
    public static int sumRow2(int r, int[][] m){ 
	int sum = 0;
	for ( int i : m[r] ) {
	    sum += i;
	}
	return sum;
    }


    public static void main(String [] args) {
	
	int [][] m1 = new int[4][2];
	int [][] m2 = { {2,4,6}, {3,5,7} };
	int [][] m3 = { {2}, {4,6}, {1,3,5} };
	
	System.out.println("\ntesting print1 on m1");
	print1(m1);
	System.out.println("\ntesting print1 on m2");
	print1(m2);
	System.out.println("\ntesting print1 on m3");
	print1(m3);
	
	System.out.println("\ntesting print2 on m1");
	print2(m1);
	System.out.println("\ntesting print2 on m2");
	print2(m2);
	System.out.println("\ntesting print2 on m3");
	print2(m3);

	System.out.print("testing sum1...\n");
	System.out.println("sum m1 : " + sum1(m1));
	System.out.println("sum m2 : " + sum1(m2));
	System.out.println("sum m3 : " + sum1(m3));

	System.out.print("testing sum2...\n");
	System.out.println("sum m1 : " + sum2(m1));
	System.out.println("sum m2 : " + sum2(m2));
	System.out.println("sum m3 : " + sum2(m3));
    }

}//end class TwoDimArray
