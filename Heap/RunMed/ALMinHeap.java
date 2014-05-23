// JENNY BARAN
// APCS2 pd 9
// HW43
// 2014-05-22

import java.util.ArrayList;

public class ALMinHeap {

    private ArrayList<Integer> _heap;

    public ALMinHeap() {
	_heap = new ArrayList<Integer>();
    }

    public String toString() {
	String lvlOrdTrav = "heap size: " + _heap.size() + "\n";
	
	if ( _heap.size() == 0 ) {
	    return lvlOrdTrav;
	}
	
	int h = 1; //init height to 1
	for ( int i = 0; i < _heap.size(); i++ ) {
	    lvlOrdTrav += i + ":" + _heap.get(i) + " ";
	    if ( i >= Math.pow(2,h) - 2 ) {
		lvlOrdTrav += "\n";
		h++;
	    }
	}
	return lvlOrdTrav;
    }//O(n)

    public boolean isEmpty() {
	return _heap.isEmpty();
    }//O(1)

    public Integer peekMin() {
	if ( _heap.size() < 1 ) {
	    return null;
	}
	else {
	    return _heap.get(0);
	}
    }//O(1)

    public void add( Integer addVal ) {
	_heap.add( addVal );
	
	int addValPos = _heap.size() - 1;
	int parentPos;

	while ( addValPos > 0 ) { //swap until reach root
	    parentPos = ( addValPos - 1 ) / 2;

	    if ( addVal.compareTo( _heap.get(parentPos) ) < 0 ) {
		swap( addValPos, parentPos );
		addValPos = parentPos;
	    }
	    else {
		break;
	    }
	}
    }//O(logn)

    public Integer removeMin() {
	if ( _heap.size() == 0 ) {
	    return null;
	}

	Integer retVal = peekMin();
	Integer foo = _heap.get( _heap.size() - 1 );

	swap( 0, _heap.size() - 1 );
	
	_heap.remove( _heap.size() - 1 );
	
	int pos = 0;
	int minChildPos;

	while ( pos < _heap.size() ) {
	    minChildPos = minChildPos(pos);

	    if ( minChildPos == -1 ) {
		break;
	    }
	    else if ( foo.compareTo( _heap.get(minChildPos) ) <= 0 ) {
		break;
	    }
	    else {
		swap( pos, minChildPos );
		pos = minChildPos;
	    }
	}
	return retVal;
    }//O(logn)

    private int minChildPos( int pos ) {
	int retVal;
	int left = 2*pos + 1;
	int right = 2*pos + 2;

	if ( pos < 0 || pos >= _heap.size() || left >= _heap.size() ) {
	    retVal = -1;
	}
	else if ( right >= _heap.size() ) {
	    retVal = left;
	}
	else if ( _heap.get(left).compareTo( _heap.get(right) ) < 0 ) {
	    retVal = left;
	}
	else {
	    retVal = right;
	}
	return retVal;
    }

    private Integer minOf( Integer a, Integer b ) {
	if ( a.compareTo(b) < 0 ) {
	    return a;
	}
	else {
	    return b;
	}
    }

    private void swap( int pos1, int pos2 ) {
	_heap.set( pos1, _heap.set( pos2, _heap.get(pos1) ) );
    }
    
    public int size() { 
	return _heap.size();
    }

}