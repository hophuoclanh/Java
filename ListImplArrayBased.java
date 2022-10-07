package mylist;

public class ListImplArrayBased<E> implements List{
//    declare a constant
    private static final int defaultSize = 20;
//    define states of object
    private int maxSize;
    private int listSize;
    private E [] listArray;

//    constructors
    public ListImplArrayBased(){
        this(defaultSize);
    }
    @SuppressWarnings("unchecked")
    public ListImplArrayBased(int size) {
        maxSize = size;
        listSize = 0;
        listArray = (E[]) new Object[size];
    }

//    implement methods
    @Override
    public void clear() {
        listSize = 0;
    }

    @Override
    public boolean insert(Object item, int index) {
        if(index >=0 && index <= listSize){
//            shift to right listSize - index
            for (int i = listSize; i> index; i--){
                listArray[i] = listArray[i-1];
            }
            listArray[index] = (E)item;
            listSize++;
            return true;
        }
        return false;
    }

    @Override
    public boolean append(Object item) {
        if(listSize < maxSize){
            listArray[listSize] = (E)item;
            listSize++;
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return listSize;
    }

    @Override
    public boolean isEmpty() {
        return listSize == 0;
    }

    @Override
    public boolean remove(int index) {
        if(index>=0 && index < listSize){
            int start = index;
            while (start < listSize-1) {
                listArray[start] = listArray[start + 1];
                start++;
            }
            listSize--;
            return true;
        }
        return false;
    }

    @Override
    public Object get(int index) {
        if(index>=0 && index < listSize){
            return listArray[index];
        }
        return null;
    }

    @Override
    public boolean set(Object item, int index) {
        if(index >=0 && index < listSize){
            listArray[index] = (E)item;
            return true;
        }
        return false;
    }

    @Override
    public Object head() {
        return get(0);
    }

    @Override
    public Object[] head(int size) {
        int actual_size = Math.min(size, listSize);
        Object[] l = new Object[actual_size];
        for(int i = 0; i< actual_size; i++){
            l[i] = get(i);
        }
        return l;
    }

    @Override
    public Object tail() {
        return get(listSize-1);
    }

    @Override
    public E[] tail(int size) {
        int actual_size = Math.min(size, listSize);
        E[] l = (E[])new Object[actual_size];
        int start = listSize-actual_size;
        for(int i = start; i< listSize; i++){
            l[i - start] = (E)get(i);
        }
        return l;
    }
}
