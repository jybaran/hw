// JENNY BARAN
// APCS2 pd 9
// HW19
// 2014-03-24

/*****************************************************
 * interface List
 * Specifies actions a List must be able to perform.
 *****************************************************/

public interface List<T> { 

    public boolean add( T x ); 

    public T get( int i ); 

    public T set( int i, T x ); 

    public int size(); 
}
