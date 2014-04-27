// JENNY BARAN
// APCS2 pd 9
// HW32a
// 2014-04-25

public interface Queue<T> {

    public void enqueue( T x );

    public T dequeue();

    public T peekFront();

    public boolean isEmpty();

}