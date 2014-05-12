// JENNY BARAN
// APCS2 pd 9
// HW37
// 2014-05-10

/*****************************************************
 * class BST - skeleton
 * Implementation of the BINARY SEARCH TREE abstract data type (ADT) 
 * A BST maintains the invariant that, for any node N with value V, 
 * L<V && V<R, where L and R are node values in N's left and right
 * subtrees, respectively.
 * This BST only holds ints (its nodes have int cargo)
 *****************************************************/

public class BST {

    private TreeNode _root;

    /*****************************************************
     * default constructor
     *****************************************************/
    BST( ) {
	_root = null;
    }


    /*****************************************************
     * void insert( int ) 
     * Adds a new data element to the tree at appropriate location.
     *****************************************************/
    public void insert( int newVal ) {
     	if ( _root == null ) {
	    _root = new TreeNode( newVal );
	}
	else if ( _root.getValue() == newVal ) {

	}
	else {
	    int rootVal = _root.getValue();
	    TreeNode newNode = new TreeNode( newVal );
	    TreeNode temp = _root;
	    boolean inserted = false;
	    while ( !inserted ) {
		if ( rootVal > newVal ) {
		    if ( temp.getLeft() != null ) { //more nodes to left exist
			temp = temp.getLeft(); //set temp to left node, repeat
		    }
		    else {
			temp.setLeft( newNode );
			inserted = true;
		    }
		}
		else if ( rootVal < newVal ) {
		    if ( temp.getRight() != null ) { //more nodes to right exist
			temp = temp.getRight(); //set temp to right node, repeat
		    }
		    else { //the spot is empty, can put newVal there
			temp.setRight( newNode );
			inserted = true;
		    }
		}
		else { //vals are equal, nV is already in tree
		    System.out.println( "Error, this value is already in the tree." );
		    break;
		}
		rootVal = temp.getValue(); //match rootVal to current subtree root (temp)
	    }
	}
    }


    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //~~~~~~~~~~~~~v~~TRAVERSALS~~v~~~~~~~~~~~~~~~~~~~~~
    public void preOrderTrav() {
    	TreeNode temp = _root;
	preOTHelper( temp );
    }
    
    public void preOrderTrav( TreeNode r ) {
	if ( r != null ) {
	    System.out.println( r.getValue() );
	    preOrderTrav( r.getLeft() );
	    preOrderTrav( r.getRight() );
	}
    }

    public void inOrderTrav() {
    	TreeNode temp = _root;
	inOTHelper( temp );
    }

    public void inOrderTrav( TreeNode r ) {
	if ( r != null ) {
	    inOrderTrav( r.getLeft() );
	    System.out.println( r.getValue() );
	    inOrderTrav( r.getRight() );
	}
    }

    public void postOrderTrav() {
	TreeNode temp = _root;
	postOTHelper( temp );
    }

    public void postOrderTrav( TreeNode r ) {
	if ( r != null ) {
	    postOrderTrav( r.getLeft() );
	    postOrderTrav( r.getRight() );
	    System.out.println( r.getValue() );
	}
    }
    //~~~~~~~~~~~~~^~~TRAVERSALS~~^~~~~~~~~~~~~~~~~~~~~~
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    //main method for testing
    public static void main( String[] args ) {


	BST arbol = new BST();

	arbol.insert( 4 );
	arbol.insert( 2 );
	arbol.insert( 5 );
	arbol.insert( 6 );
	arbol.insert( 1 );
	arbol.insert( 3 );

	System.out.println( "\npre-order traversal:" );
	arbol.preOrderTrav();

	System.out.println( "\nin-order traversal:" );
	arbol.inOrderTrav();
	
	System.out.println( "\npost-order traversal:" );
	arbol.postOrderTrav();	
	/*~~~~~~~~~~~~move~me~down~~~~~~~~~~~~~~~~~~~~~~
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }

}//end class





    
