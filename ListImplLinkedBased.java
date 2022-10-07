package mylist;

public class ListImplLinkedBased<E> implements List {
    private LinkedNode<E> head;
    private int counter;

    public ListImplLinkedBased() {
        head = null;
        counter = 0;
    }

    @Override
    public void clear() {
        head = null;
        counter = 0;
    }

    @Override
    public boolean insert(Object item, int index) {
        if (index < 0 || index > counter)
            return false;

        if (index == 0) {
            if (head == null) {
                head = new LinkedNode<E>((E) item, null);
            } else {
                LinkedNode<E> node = new LinkedNode<E>((E) item, null);
                node.setNext(head);
                head = node;
            }
        } else {
            int actual_index = Math.min(index, counter);
            int i = 0;
            LinkedNode<E> node = head;
            while (i < actual_index - 1) {
                node = node.getNext();
                i++;
            }
            LinkedNode<E> n = new LinkedNode<E>((E) item, null);
            n.setNext(node.getNext());
            node.setNext(n);
        }
        counter++;
        return true;
    }

    @Override
    public boolean append(Object item) {
        try {
            if (head == null) {
                head = new LinkedNode<E>((E) item, null);
                counter = 1;
                return true;
            } else {
                LinkedNode<E> node = head;
                while (node.getNext() != null) {
                    node = node.getNext();
                }
//            create new node
                LinkedNode<E> n = new LinkedNode<E>((E) item, null);
                node.setNext(n);
                counter++;
                return true;
            }
        } catch (Exception e) {
            return false;
        }

//        return false;
    }

    @Override
    public int size() {
        return counter;
    }

    @Override
    public boolean isEmpty() {
        return counter == 0;
    }

    @Override
    public boolean remove(int index) {
        if (index < 0 || index >= counter)
            return false;
        if (index == 0) {
            head = head.getNext();
        } else {
            LinkedNode<E> previous = head;
            for (int i = 0; i < index - 1; i++) {
                previous = previous.getNext();
            }
            LinkedNode<E> remove = previous.getNext();
            previous.setNext( remove.getNext());
        }
        counter--;
        return true;
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index >= counter)
            return false;
        LinkedNode<E> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        return currentNode.getElement();
    }

    @Override
    public boolean set(Object item, int index) {
        if (index < 0 || index >= counter)
            return false;
        LinkedNode<E> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        currentNode.setElement((E)item);
        return true;
    }

    @Override
    public Object head() {
        return head.getElement();
    }

    @Override
    public Object[] head(int size) {
        int actual_size = Math.min(size, counter);
        E[] l = (E[]) new Object[actual_size];
        int i = 0;
        LinkedNode<E> node = head;
        while (i < actual_size) {
            l[i] = node.getElement();
            node = node.getNext();
            i++;
        }
        return l;
    }

    @Override
    public Object tail() {
        LinkedNode<E> node = head;
        while (node.getNext() != null)
            node = node.getNext();
        return node.getElement();
    }

    @Override
    public Object[] tail(int size) {
        int actual_size = Math.min(size, counter);
        E[] l = (E[]) new Object[actual_size];
        int i = 0;
        LinkedNode<E> node = head;
        while (i < counter - actual_size) {
            node = node.getNext();
            i++;
        }
        i = 0;
        while (node.getNext() != null) {
            l[i] = node.getElement();
            node = node.getNext();
            i++;
        }
//        get the last element
        l[i] = node.getElement();
        return l;
    }

    @Override
    public String toString() {
        LinkedNode<E> node = head;
        String s = "";
        while (node.getNext() != null) {
            s += node.getElement() + " --> ";
            node = node.getNext();
        }
        s += node.getElement();
        return s;
    }
}
