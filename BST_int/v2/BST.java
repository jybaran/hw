// JENNY BARAN
// APCS2 pd 9
// HW38
// 2014-05-12

/*****************************************************
 * class BST
 * Implementation of a BINARY SEARCH TREE
 * A BST maintains the invariant that, for any node N with value V, 
 * L<V && V<R, where L and R are node values in N's left and right
 * subtrees, respectively.
 * This BST only holds ints (its nodes have int cargo)
 *****************************************************/

public class BST {

    //instance variables
    TreeNode _root;


    /*****************************************************
     * default constructor
     * Initializes an empty tree.
     *****************************************************/
    BST( ) {
	_root = null;
    }


    /*****************************************************
     * void insert( int ) 
     * Adds a new data element to the tree at appropriate location.
     *****************************************************/
    public void insert( int newVal ) {

	TreeNode newNode = new TreeNode( newVal );

	if ( _root == null ) {
	    _root = newNode;
	    return;
	}
        insert( _root, newNode );
    }

    //recursive helper for insert(int)
    public void insert( TreeNode stRoot, TreeNode newNode ) {

	if ( newNode.getValue() < stRoot.getValue() ) {
	    //if no left child, make newNode the left child
	    if ( stRoot.getLeft() == null )
		stRoot.setLeft( newNode );
	    else //recurse down left subtree
		insert( stRoot.getLeft(), newNode );
	    return;
	}
	else { // new val >= curr, so look down right subtree
	    //if no right child, make newNode the right child
	    if ( stRoot.getRight() == null )
		stRoot.setRight( newNode );
	    else //recurse down right subtree
		insert( stRoot.getRight(), newNode );
	    return;
	}
    }



    /*****************************************************
     * TreeNode search(int)
     * returns pointer to node containing target,
     * or null if target not found
     *****************************************************/
    TreeNode search( int target ) {
    	TreeNode retTN = search( _root, target );
	return retTN;
    }
    
    TreeNode search( TreeNode stRoot, int target ) {
	int tempVal = stRoot.getValue();
	TreeNode retTN = null;
	if ( stRoot == null ) {
	    return null;
	}
	if ( tempVal == target ) {
	    retTN = stRoot;
	}
	else if ( tempVal > target ) {
	    retTN = search( stRoot.getLeft(), target );
	}
	else {
	    retTN = search( stRoot.getRight(), target );
	}
	return retTN;
    }

    /*****************************************************
     * void remove( int )
     * if remVal is present, removes it from tree
     * Assumes no duplicates in tree.
     *****************************************************/
    public void remove( int remVal ){
	if ( search(remVal) == null ) { //check that remVal is in tree
	    return;
	}
	remove( null, _root, remVal );
    }

    public void remove( TreeNode parent, TreeNode stRoot, int remVal ) {
	if ( stRoot == null ) {
	    return;
	}
	if ( stRoot.getValue() == remVal ) { //if root is val to be removed
	    if ( stRoot.getLeft() == null && stRoot.getRight() == null ) { //root has no children
		stRoot = null; //tree now empty
		return;
	    }
	    else if ( stRoot.getLeft() == null ) { //root has no left child
		if ( parent != null ) {
		    parent.setRight( stRoot.getRight() );
		    stRoot = null;
		}
		else {
		    stRoot = stRoot.getRight();
		}
		return;
	    }
	    else if ( _root.getRight() == null ) { //root has no right child
		if ( parent != null ) {
		    parent.setLeft( stRoot.getLeft() );
		    stRoot = null;
		}
		else {
		    stRoot = stRoot.getLeft();
		}
		return;
	    }
	    else {
		stRoot.setValue( findAndDeleteMin( stRoot.getRight() ) );
		return;
	    }
	}
	parent = stRoot;
	if ( stRoot.getValue() > remVal ) {
	    remove( parent, stRoot.getLeft(), remVal );
	}
	else {
	    remove( parent, stRoot.getRight(), remVal );
	}
    }

    public int findAndDeleteMin( TreeNode stRoot ) {
	if ( stRoot.getLeft() == null ) {
	    int retVal = stRoot.getValue();
	    stRoot = null;
	    return retVal;
	}
	return findAndDeleteMin( stRoot.getLeft() );
    }

    /*****************************************************
     * int height()
     * returns height of this tree (length of longest leaf-to-root path)
     * eg: a 1-node tree has height 1
     *****************************************************/
    public int height() {
	return height( _root );
    }

    public int height( TreeNode stRoot ) {
	if ( stRoot == null ) {
	    return 0;
	}
	else {
	    return 1 + Math.max( height( stRoot.getLeft() ), height( stRoot.getRight() ) );
	}
    }

    /*****************************************************
     * int numLeaves()
     * returns number of leaves in tree
     *****************************************************/
    public int numLeaves() {
	return numLeaves( _root );
    }

    public int numLeaves( TreeNode stRoot ) {
	if ( stRoot == null ) {
	    return 0;
	}
	else if ( stRoot.getLeft() == null && stRoot.getRight() == null ) {
	    return 1;
	}
	else {
	    return numLeaves( stRoot.getLeft() ) + numLeaves( stRoot.getRight() );
	}
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //~~~~~~~~~~~~~v~~TRAVERSALS~~v~~~~~~~~~~~~~~~~~~~~~
    //process root, recurse left, recurse right
    public void preOrderTrav() {
	preOrderTrav( _root );
    }
    public void preOrderTrav( TreeNode currNode ) {
	if ( currNode == null )
	    return;
	System.out.print( currNode.getValue() + " " );
	preOrderTrav( currNode.getLeft() );
	preOrderTrav( currNode.getRight() );
    }

    //recurse left, process root, recurse right
    public void inOrderTrav() {
	inOrderTrav( _root );
    }
    public void inOrderTrav( TreeNode currNode ) {
	if ( currNode == null )
	    return;
	inOrderTrav( currNode.getLeft() );
	System.out.print( currNode.getValue() + " " );
	inOrderTrav( currNode.getRight() );
    }

    //recurse left, recurse right, process root
    public void postOrderTrav() {
	postOrderTrav( _root );
    }
    public void postOrderTrav( TreeNode currNode ) {
	if ( currNode == null )
	    return;
	postOrderTrav( currNode.getLeft() );
	postOrderTrav( currNode.getRight() );
	System.out.print( currNode.getValue() + " "  );
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

	arbol.remove( 6 );



	System.out.println( "\npre-order traversal:" );
	arbol.preOrderTrav();

	System.out.println( "\nin-order traversal:" );
	arbol.inOrderTrav();
	
	System.out.println( "\npost-order traversal:" );
	arbol.postOrderTrav();	

	System.out.println();
	/*~~~~~~~~~~~~move~me~down~~~~~~~~~~~~~~~~~~~~~~
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }

}//end class

