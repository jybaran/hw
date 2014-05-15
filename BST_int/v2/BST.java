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
    	return search( _root, target );
    }
    
    TreeNode search( TreeNode stRoot, int target ) {
	if ( stRoot == null || stRoot.getValue() == target ) {
	    return stRoot;
	}
	else if ( target < stRoot.getValue() ) {
	    return search( stRoot.getLeft(), target );
	}
	else if ( target > stRoot.getValue() ) {
	    return search( stRoot.getRight(), target );
	}
	else {
	    return null;
	}
    }

    /*****************************************************
     * void remove( int )
     * if remVal is present, removes it from tree
     * Assumes no duplicates in tree.
     *****************************************************/
    public void remove( int remVal ) {
	TreeNode lead = _root;
	TreeNode follow = null; //piggybacker

	//first, walk ptr down to target w/ trailing follow ptr
	while ( lead != null && lead.getValue() != remVal ) {
	    if ( remVal < lead.getValue() ) {
		follow = lead;
		lead = lead.getLeft();
	    }
	    else { //remVal > lead.getValue()
		follow = lead;
		lead = lead.getRight();
	    }
	}

	if ( lead == null ) { //remVal not in tree
	    return lead;
	}

	//CASE 1: removal node is a leaf
	// action: snip it
	if ( isLeaf(lead) ) {
	    //subcase: 1-node tree
	    if ( lead == _root ) {
		_root = null;
		return lead;
	    }
	    
	    //subcase: rem node is a left child
	    if ( follow.getLeft() == lead ) {
		follow.setLeft( null );
		return lead;
	    }
	    //subcase: rem node is a right child
	    else {
		follow.setRight( null );
		return lead;
	    }
	}

	//CASE 2: rem node has 1 subtree
	//action: replace node w/ only child
	else if ( lead.getRight() == null ) { //rem node's child is on left
	    //subcase: rem node is root
	    if ( lead == _root ) {
		_root = lead.getLeft();
		return lead;
	    }

	    //subcase: rem node is a left child
	}

	//CASE 3: rem node has 2 subtrees
	//action: overwrite rem node val with max val in left subtree
	//        (deepest node w/ no right child), then remove that node,
	//        promoting its left child if exists
	else {
	    TreeNode maxLST = lead.getLeft();
	    while( maxLST.getRight() != null ) {
		maxLST = maxLST.getRight();
	    }

	    //create replacement node for rem node
	    TreeNode tmp2;
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
	if ( isLeaf(stRoot) ) {
	    return 1;
	}
	else {
	    return 1 + Math.max( height( stRoot.getLeft() ), height( stRoot.getRight() ) );
	}
    }

    public boolean isLeaf( TreeNode nnnode ) {
	return ( nnnode.getLeft()==null ) && ( nnnode.getRight()==null );
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

	arbol.insert( 3 );
	arbol.insert( 4 );
	arbol.insert( 5 );
	arbol.insert( 6 );
	arbol.insert( 2 );
	arbol.insert( 1 );

	System.out.println( "\nheight: " + arbol.height());

	/*~~~~~~~~~~~~move~me~down~~~~~~~~~~~~~~~~~~~~~~
	System.out.println( "\npre-order traversal:" );
	arbol.preOrderTrav();

	System.out.println( "\nin-order traversal:" );
	arbol.inOrderTrav();
	
	System.out.println( "\npost-order traversal:" );
	arbol.postOrderTrav();	

	System.out.println();

	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }

}//end class

