// JENNY BARAN
// pd 8
// HW32
// 2013-11-25


/*==================================================
  class GuessNumber -- fun fun fun!

  eg, sample interaction with end user:
  Guess a # fr 1-100: 50
  Too high
  Guess a # fr 1-49: 25
  Too low
  Guess a # fr 26-49: 38
  Correct! It took 3 guesses
  ==================================================*/

/*==================================================
  the Breakdown:
  The fastest way to guess a random number is to reduce the range by half with each guess. The range keeps getting divided by 2 until you reach a range where there is only one value between _lo and _hi. Number of times n can be halved before it reduces to 1.
  
  between 1 and 100, the max # of guesses is 7.
  between 1 and 200, the max # of guesses is 8.
  between 1 and 400, the max # of guesses is 9.
  between 1 and 1000, the max # of guesses is 10.
  between 1 and n, the max # of guesses is the exponent of the lowest power of 2 that is greater than n
  ==================================================*/


import cs1.Keyboard; /* must have cs1 dir in same dir as this file 
			for this to work */

public class GuessNumber {

    //instance vars
    private int _lo, _hi, _guessCtr, _target;



    /*==================================================
      constructor -- initializes a guess-a-number game
      pre:  
      post: _lo is lower bound, _hi is upper bound,
            _guessCtr is 1, _target is random int on range [_lo,_hi]
      ==================================================*/
    public GuessNumber( int a, int b ) {
	_lo = a;
	_hi = b;
	_guessCtr = 1;
	_target = (int)( Math.random()*(_hi-_lo) + _lo );
    }


    /*==================================================
      void playIter() -- Prompts a user to guess until guess is correct.
                         Uses iteration.
      pre:  
      post: 
      ==================================================*/
    public void playIter() {
	
	int guess = _hi + 1;

	while (guess != _target) {
	  
	    System.out.print("Guess a number between " + _lo + " and " + _hi + ": ");
	    guess = Keyboard.readInt();
	    
	    if ( guess > _target ) {
		System.out.println("Too high.");
		_hi = guess;
	    }
	    else if ( guess < _target ) {
		System.out.println("Too low.");
		_lo = guess;
	    }
	    else {
		System.out.println("You got it in " + _guessCtr + " tries, nice job!");
	    }
	    _guessCtr++;
	}
	
    }


    /*==================================================
      void playRec() -- Prompts a user to guess until guess is correct.
                        Uses recursion.
      pre:  
      post: 
      ==================================================*/
    public void playRec() {
	int guess;
	System.out.print("Guess a number between " + _lo + " and " + _hi + ": ");
	guess = Keyboard.readInt();
	_guessCtr++;

	if (guess == _target) {
	    System.out.println("You got it in " + _guessCtr + " tries, nice job!");
	}
	else {

	    if ( guess > _target ) {
		System.out.println("Too high.");
		_hi = guess;
	    }
	    else if ( guess < _target ) {
		System.out.println("Too low.");
		_lo = guess;
	    }
	    playRec();
	}
    }


    //wrapper for playRec/playIter to simplify calling
    public void play() { 
	//use one or the other below:
	playRec();
	//playIter();
    }


    //main method to run it all
    public static void main( String[] args ) {

	//instantiate a new game
	GuessNumber g = new GuessNumber(1,100);

	//start the game
	g.play();
    }


    /*==================================================
      _ _(_) -- 
      pre:  
      post: 
      ==================================================*/
}//end class
