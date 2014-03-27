// JENNY BARAN
// APCS2 pd 9
// HW21
// 2014-03-26

/*****************************************************
 * interface List
 * Specifies actions a List must be able to perform.
 *****************************************************/

public interface List<T> { 

    public boolean add( T x ); 

    public void add( int i, T x );

    public T remove( int i );

    public T get( int i ); 

    public T set( int i, T x ); 

    public int size(); 
}
