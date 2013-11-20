// JENNY BARAN
// pd 8
// HW27
// 2013-11-18

public class Rational implements Comparable{

    private int _num;
    private int _denom;

    public Rational() {
	_num = 0;
	_denom = 1;
    }

    public Rational(int num, int denom) {
	this();
	if (denom != 0) {
	    _num = num;
	    _denom = denom;
	}
	else {
	    System.out.println("That is not a valid denominator. The number has been set to 0/1");
	}
    }

    public int getNum() {
	return _num;
    }
    
    public int getDenom() {
	return _denom;
    }

    public String toString() {
	String retStr = _num + "/" + _denom;
	return retStr;
    }

    public double floatValue() {
	return (double)_num / _denom;
    }

    public void multiply(Rational x) {
	_num *= x.getNum();
	_denom *= x.getDenom();
    }

    public void divide(Rational x) {
	if ( x._num != 0 ) {
	    _num = (int) _num / x.getNum();
	    _denom = (int) _denom / x.getDenom();
	}
	else {
	    System.out.println( "Div by 0 error. Values unchanged." );
	}
    }

    public void add(Rational x) {
	_num = (_num * x.getDenom()) + (x.getNum() * _denom);
	_denom = _denom * x.getDenom();
    }

    public void subtract(Rational x) {
	_num = (_num * x.getDenom()) - (x.getNum() * _denom);
	_denom = _denom * x.getDenom();
    }

    public int gcd() {

	int a, b, x;

	if ( _num > _denom ) {
	    a = _num;
	    b = _denom;
	}
	else {
	    a = _denom;
	    b = _num;
	}

	while( a % b != 0 ) {
	    x = a;
	    a = b;
	    b = x % b;
	}

	return b;
    }

    public void reduce() {
	int g = gcd();
	_num = _num / g;
	_denom = _denom / g;
    }

   public static int gcd( int n, int d ) {

	int a, b, x;

	if ( n > d ) {
	    a = n;
	    b = d;
	}
	else {
	    a = d;
	    b = n;
	}

	while( a % b != 0 ) {
	    x = a;
	    a = b;
	    b = x % b;
	}

	return b;
    }

    public int compareTo( Object x ) {

	int thisNum, xNum;

	thisNum = _num * ((Rational)x).getDenom();
	xNum = _denom * ((Rational)x).getNum();

	return thisNum - xNum;

    }

    public boolean equals(Rational x) {
	int thisGCD = this.gcd();
	int xGCD = x.gcd();
	return ( ( this._num/thisGCD == x.getNum()/xGCD ) && ( this._denom/thisGCD == x.getDenom()/xGCD ) );
    }

    public static void main( String[] args ) {
	Rational r = new Rational(2,3);
	Rational s = new Rational(1,2);
	Rational t = new Rational(4,18);
	Rational u = new Rational(2, 9);

	/*==========

	System.out.println(r);
	System.out.println(s);

	System.out.println( r.floatValue() );
	System.out.println( s.floatValue() );

	r.multiply(s);
	System.out.println(r);

	r.divide(s);
	System.out.println(r);

	r.add(s);
	System.out.println(r);

	t.reduce();
	System.out.println(t);
	
	r.reduce();
	r.subtract(s);
	System.out.println(r);

	System.out.println( r.compareTo(s) );
	System.out.println( s.compareTo(r) );
	System.out.println( t.compareTo(u) );

	System.out.println( t.equals(u) );

	==========*/

    }

}
