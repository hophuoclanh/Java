package mylist;

public class DoublyLinkedNode<E> {
    private E element;
    private DoublyLinkedNode<E> previous;
    private DoublyLinkedNode<E> next;

    public DoublyLinkedNode(E elem, DoublyLinkedNode<E> prevNode, DoublyLinkedNode<E> nextNode) {
        element = elem;
        previous = prevNode;
        next = nextNode;
    }

    public void setNext(DoublyLinkedNode<E> nextNode) {
        next = nextNode;
    }

    public DoublyLinkedNode<E> getNext() {
        return next;
    }

    public void setPrevious(DoublyLinkedNode<E> prevNode) {
        previous = prevNode;
    }

    public DoublyLinkedNode<E> getPrevious() {
        return previous;
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }
}

