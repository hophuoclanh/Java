package mylist;

public interface List<E> {
//    define methods
    public void clear();
    public boolean insert(E item, int index);
    public boolean append(E item); //add to the end
    public int size();
    public boolean isEmpty();
    public boolean remove(int index);
    public E get(int index);
    public boolean set(E item, int index);
    public E head();
    public E[] head(int size);
    public E tail();
    public E[] tail(int size);
}
