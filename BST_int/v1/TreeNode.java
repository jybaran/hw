// JENNY BARAN
// APCS2 pd 9
// HW37
// 2014-05-10

/*****************************************************
 * class TreeNode
 * Implements a node for use in a binary tree.
 * Only holds int cargo.
 *****************************************************/

public class TreeNode {

    //instance variables / attributes of a TreeNode:
    private int _value;
    private TreeNode _left;
    private TreeNode _right;

    /*****************************************************
     * default constructor
     * Construct a tree node with specified value, 
     * with null left and right subtrees.
     *****************************************************/
    TreeNode( int initValue )
    {
	_value = initValue;
	_left = null;
	_right = null;
    }
          

    /*****************************************************
     * overloaded constructor
     * Construct a tree node with specified value, left, and right subtrees.
     *****************************************************/
    TreeNode( int initValue, TreeNode initLeft, TreeNode initRight ) 
    {
	_value = initValue;
	_left = initLeft;
	_right = initRight;
    }
 

    /*****************************************************
     * Returns the left subtree of this node.
     *****************************************************/
    TreeNode getLeft() 
    {
	return _left;
    }


    /*****************************************************
     * Returns the right subtree of this node.
     *****************************************************/
    TreeNode getRight() 
    {
	return _right;
    }


    /*****************************************************
     * Returns the value stored in this tree node.
     *****************************************************/
    int getValue() 
    {
	return _value;
    }


    /*****************************************************
     * Sets the value of the left subtree of this node.
     *****************************************************/
    void setLeft( TreeNode theNewLeft ) 
    {
	_left = theNewLeft;
    }


    /*****************************************************
     * Sets the value of the right subtree of this node.
     *****************************************************/
    void setRight( TreeNode theNewRight ) 
    {
	_right = theNewRight;
    }


    /*****************************************************
     * Sets the value of this tree node.
     *****************************************************/
    void setValue( int theNewValue ) 
    {
	_value = theNewValue;
    }
 
}//end class
