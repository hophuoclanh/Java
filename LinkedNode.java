package mylist;

public class LinkedNode<E>{
    private E element;
    private LinkedNode<E> next;

    public LinkedNode(E elem, LinkedNode n) {
        element = elem;
        next = n;
    }

    public void setNext(LinkedNode<E> n){
        next = n;
    }

    public LinkedNode<E> getNext(){
        return next;
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }
}
