// JENNY BARAN
// pd 8
// HW44
// 2013-12-16

/*========================================
Another sample AP question. 1 of 4 free-response questions, 
for which you will have about 1hr45min.
Note that for today's work, you will have to implement a constructor 
and a main method yourself for testing...

The following class WordList is designed to store and manipulate a 
list of words. The incomplete class declaration is shown below. 
You will be asked to implement two methods.
========================================*/

import java.util.ArrayList;

public class WordList {

    private ArrayList myList; // contains Strings made up of letters

    //postcond: returns the number of words in this WordList that are 
    //          exactly len letters long
    public int numWordsOfLength(int len) { 
	int count = 0;
	for ( String x : myList ) {
	    if ( x.length() == len) {
		count++;
	    }
	}
	return count;
    }

    //postcond: all words that are exactly len letters long have been removed 
    //          from this WordList, with order of remaining words unchanged
    public void removeWordsOfLength(int len) { 
	ArrayList<String> temp = new ArrayList<String>( myList.length 
						   - numWordsOfLength(len) );
	for ( int i = 0; i < myList.length; i++ ) {
	    if ( myList.get(i).length() != len ) {
		temp.add( myList.get(i) );
		i--;
	    }
	}
	myList = temp;
    }

    //... constructor and other methods not shown
}


/*========================================
QUESTION 1A: Write the WordList method numWordsOfLength. 
Method numWordsOfLength returns the number of words in the WordList that 
are exactly len letters long. For example, assume that the instance 
variable myList of the WordList animals contains the following.
    ["cat", "mouse", "frog", "dog", "dog"] 

The table below shows several sample calls to numWordsOfLength.

Call                                    Result returned by call
animals.numWordsOfLength(4)             1
animals.numWordsOfLength(3)             3
animals.numWordsOfLength(2)             0

Complete method numWordsOfLength below.

//postcond: returns the number of words in this WordList that 
//          are exactly len letters long 
public int numWordsOfLength(int len) {
    int count = 0;
    for ( String x : myList ) {
	if ( x.length() == lem ) {
	    count++;
	}
    }
    return count;
}
    
========================================*/

/*========================================
QUESTION 1B: Write the WordList method removeWordsOfLength. 
Method removeWordsOfLength removes all words from the WordList that are exactly 
len letters long, leaving the order of the remaining words unchanged. 
For example, assume that the instance variable myList of the WordList 
animals contains the following.
    ["cat", "mouse", "frog", "dog", "dog"] 

The table below shows a sequence of calls to the removeWordsOfLength method.

Call                                   myList after the call 
animals.removeWordsOfLength(4);        ["cat", "mouse", "dog", "dog"] 
animals.removeWordsOfLength(3);        ["mouse"] 
animals.removeWordsOfLength(2);        ["mouse"]

Complete method removeWordsOfLength below.

//postcond: all words that are exactly len letters long 
//          have been removed from this WordList, with the 
//          order of the remaining words unchanged 
public void removeWordsOfLength(int len) { 
    ArrayList<String> temp = new ArrayList<String>( myList.length 
						   - numWordsOfLength(len) );
    for ( int i = 0; i < myList.length; i++ ) {
	if ( myList.get(i).length() != len ) {
	    temp.add( myList.get(i) );
	    i--;
	}
    }
    myList = temp;
}

========================================*/