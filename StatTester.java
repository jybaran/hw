// JENNY BARAN
// pd 8
// HW43
// 2013-12-15

import java.util.ArrayList;

public class StatTester {

    public static void main( String[] args ) {
	
	ArrayList<Integer> al = new ArrayList<Integer>(100);
	for ( int i = 0; i < 15; i++ ) {
	    int j = (int)(Math.random() * 10);
	    al.add( i, j );
	}

	//System.out.println(al);
	
	StatPrinter sp = new StatPrinter(al);

	System.out.println(sp);

	//System.out.println( sp.isLocalMode(3) );
	//System.out.println( sp.isLocalMode(5) );
	//System.out.println( sp.getLocalModes() );

	sp.printHistogram(10);

    }

}