// JENNY BARAN
// APCS2 pd 9
// HW30
// 2014-04-23

public interface Queue<T> {

    public void enqueue( T x );

    public T dequeue();

    public T peekFront();

    public boolean isEmpty();

}