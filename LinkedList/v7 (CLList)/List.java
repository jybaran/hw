// JENNY BARAN
// APCS2 pd 9
// HW32b
// 2014-04-25

/*****************************************************
 * interface List
 * Specifies actions a List must be able to perform.
 *****************************************************/

public interface List<T> { 
    
    public boolean addFront( T x );
    
    public boolean addEnd( T x );

    public void add( int i, T x );
    
    public T removeFront();
    
    public T removeEnd();

    public T remove( int i );

    public T get( int i ); 

    public T set( int i, T x ); 

    public int size(); 
}
