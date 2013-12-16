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

    private ArrayList<String> myList; // contains Strings made up of letters                   

    public WordList(int n) {
        myList = new ArrayList<String>(n);
    }

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
        ArrayList<String> temp = new ArrayList<String>( myList.size()
                                                        - numWordsOfLength(len) );
        int j = 0;
        for ( int i = 0; i < myList.size(); i++ ) {
            if ( myList.get(i).length() != len ) {
                temp.add( j, myList.get(i) );
                i--;
                j++;
            }
        }
        myList = temp;
    }
