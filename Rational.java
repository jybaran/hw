// JENNY BARAN
// pd 8
// HW27
// 2013-11-18

public class Rational {

    int _num;
    int _denom;

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

    public String toString() {
	String retStr = _num + "/" + _denom;
	return retStr;
    }

    public double floatValue() {
	return (_num * 1.0) / (_denom * 1.0);
    }

    public void multiply(Rational x) {
	_num *= x._num;
	_denom *= x._denom;
    }

    public void divide(Rational x) {
	_num = (int) _num / x._num;
	_denom = (int) _denom / x._denom;
    }

    public void add(Rational x) {
	_num = (_num * x._denom) + (x._num * _denom);
	_denom = _denom * x._denom;
    }

    public void subtract(Rational x) {
	_num = (_num * x._denom) - (x._num * _denom);
	_denom = _denom * x._denom;
    }

    public int gcd() {
	int a = _num;
	int b = _denom;
	int r;
	while ( b != 0 ) {
	    r = a % b;
	    a = b;
	    b = r;
	}
	return a;
    }

    public void reduce() {
	_num = _num / this.gcd();
	_denom = _denom / this.gcd();
    }

    public static int gcd(int a, int b) {
	int r;
	while ( b != 0 ) {
	    r = a % b;
	    a = b;
	    b = r;
	}
	return a;
    } //not sure this is what it's supposed to be but it should work

    public int compareToThat(Rational x) {
	int retInt = 0;
	if ( this._denom != x._denom ) {
	    if ( (this._num*x._denom) > (x._num*this._denom) ) {
		retInt = 1;
	    }
	    else if ( (this._num*x._denom) < (x._num*this._denom) ) {
		retInt = -1;
	    }
	    else {
		retInt = 0;
	    }
	}
	else {
	    if ( this._num > x._num ) {
		retInt = 1;
	    }
	    else if ( this._num < x._num ) {
		retInt = -1;
	    }
	    else {
		retInt = 0;
	    }
	}
	return retInt;
    } //this is ugly but hopefully functional

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

	System.out.println( r.compareToThat(s) );
	System.out.println( s.compareToThat(r) );
	System.out.println( t.compareToThat(u) );

	==========*/

    }

}
