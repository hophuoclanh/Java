package mylist;

public class DoublyLinkedList<E> implements List<E> {
    private DoublyLinkedNode<E> head;
    private DoublyLinkedNode<E> tail;
    private int counter;

    public DoublyLinkedList() {
        head = null;
        tail = null;
        counter = 0;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        counter = 0;
    }

    //    day la method insert vao dau cua list
//            Y tuong:
//            B1: tao newNode voi element la item, prev la null, next la head
//            B2: gan prev cua head la newNode
//            B3: gan head la newNode
//            B4: counter += 1
    public boolean push(E item) {
        if (isEmpty()) {
            return append(item);
        }
        DoublyLinkedNode<E> newNode = new DoublyLinkedNode<>(item, null, head);
        head.setPrevious(newNode);
        head = newNode;
        counter += 1;
        return true;
    }

//    method nay de chen item vao vi tri index

//    Y tuong1:
//    B1: tim node tai vi tri index
//        b1: gan currentNode la head
//        b2: gan currentNode = currentNode.getNext cho den khi den vi tri index
//    B2: insert
//        b1: gan prevNode = currentNode.getPrevious
//        b2: tao newNode voi element la item, prev la prevNode, next la currentNode
//        b3: gan prevNode.next = newNode
//        b4: gan currentNode.previous = newNode
//    B3: counter += 1
//public boolean insert(E item, int index) {
//    if (index < 0 || index > counter) {
//        return false;
//    }
//    if (index == counter) {
////            day la truong hop insert vao cuoi cua list
//        return append(item);
//    }
//    if (index == 0) {
//        return push(item);
//    }
//    DoublyLinkedNode<E> currentNode = head;
//    for (int i = 0; i < index; i++) {
//        currentNode = currentNode.getNext();
//    }
//    DoublyLinkedNode<E> prevCurrentNode = currentNode.getPrevious();
//    DoublyLinkedNode<E> newNode = new DoublyLinkedNode<>(item, prevCurrentNode, currentNode);
//    prevCurrentNode.setNext(newNode);
//    currentNode.setPrevious(newNode);
//    counter += 1;
//    return true;
//}

//    Y tuong 2:
    //    B1: tao 1 bien dem = counter / 2;
//    B2: neu index < bien dem thi cho currentNode = head (TH1)
//        con neu index > bien dem thi cho currentNode = tail (TH2)
//    B3: TH1:
//        b1: gan currentNode = currentNode.getNext cho den index la vi tri can insert
//        b2: gan prevNode = currentNode.getPrevious
////        b3: tao newNode voi element la item, prev la prevNode, next la currentNode
////        b4: gan prevNode.next = newNode
////        b5: gan currentNode.previous = newNode
//    TH2:
//        b1: gan currentNode = currentNode.getPrevious cho den index la vi tri can lay gia tri
    //        b2: gan prevNode = currentNode.getPrevious
////        b3: tao newNode voi element la item, prev la prevNode, next la currentNode
////        b4: gan prevNode.next = newNode
////        b5: gan currentNode.previous = newNode


    @Override
    public boolean insert(E item, int index) {
        if (index < 0 || index > counter) {
            return false;
        }
        if (index == counter) {
//            day la truong hop insert vao cuoi cua list
            return append(item);
        }
        if (index == 0) {
            return push(item);
        }
        int middle = counter / 2;
        DoublyLinkedNode<E> currentNode;
        if (index < middle) {
            currentNode = head;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.getNext();
            }
        } else {
            currentNode = tail;
            for (int i = 0; i < (counter - 1 - index); i++) {
                currentNode = currentNode.getPrevious();
            }
        }
        DoublyLinkedNode<E> prevCurrentNode = currentNode.getPrevious();
        DoublyLinkedNode<E> newNode = new DoublyLinkedNode<>(item, prevCurrentNode, currentNode);
        prevCurrentNode.setNext(newNode);
        currentNode.setPrevious(newNode);
        counter += 1;
        return true;
    }

    //    method nay dung de them 1 node co gia tri bang item vao cuoi doubly linked list
    @Override
    public boolean append(E item) {
//        Truong hop 1 la list rong.
//        Dau tien, tao node moi.
//        Thu 2, gan head = node moi.
//        Thu 3, gan tail = node moi.
//        Cuoi cung, counter += 1.
        if (isEmpty()) {
            DoublyLinkedNode<E> newNode = new DoublyLinkedNode<>(item, null, null);
            head = newNode;
            tail = newNode;
            counter += 1;
        } else {
//            Truong hop 2 la list co node.
//            Dau tien, tao node moi.
//            Thu 2, gan prev cua node moi la tail.
//            Thu 3, gan next cua tail la node moi.
//            Thu 4, gan tail = node moi.
//            Cuoi cung, couter += 1.
            DoublyLinkedNode<E> newNode = new DoublyLinkedNode<>(item, tail, null);
            tail.setNext(newNode);
            tail = newNode;
            counter += 1;
        }
        return true;
    }

    @Override
    public int size() {
        return counter;
    }

    @Override
    public boolean isEmpty() {
        return counter == 0;
    }


    //    Y tuong
//    B1: middle = counter / 2
//    B2: neu index < middle thi prevNode = head (TH1)
//        nguoc lai thi nextNode = tail (TH2)
//    B3: TH1
//        b1: gan prevNode.getNext den vi tri index - 1
//        b2: removeNode = prevNode.getNext
//        b3: nextNode = removeNode.getNext
//        b4: prevNode.setNext(nextNode)
//        b5: nextNode.setPrevious(prevNode)
//        b6: counter --
//    TH2:
//        b1: gan prevNode.getPrevious den vi tri index - 1
////        b2: removeNode = prevNode.getNext
////        b3: nextNode = removeNode.getNext
////        b4: prevNode.setNext(nextNode)
////        b5: nextNode.setPrevious(prevNode)
////        b6: counter --
    @Override
    public boolean remove(int index) {
        if (index < 0 || index >= counter)
            return false;
        if (index == 0) {
            head = head.getNext();
        } else if (index == counter - 1) {
            tail = tail.getPrevious();
            tail.setNext(null);
        } else {
            int middle = counter / 2;
            if (index < middle) {
                DoublyLinkedNode<E> prevNode = head;
                for (int i = 0; i < index - 1; i++) {
                    prevNode = prevNode.getNext();
                }
                DoublyLinkedNode<E> removeNode = prevNode.getNext();
                DoublyLinkedNode<E> nextNode = removeNode.getNext();
                prevNode.setNext(nextNode);
                nextNode.setPrevious(prevNode);
            } else {
                DoublyLinkedNode<E> prevNode = tail;
                for (int i = 0; i < counter - index; i++) {
                    prevNode = prevNode.getPrevious();
                }
                DoublyLinkedNode<E> removeNode =  prevNode.getNext();
                DoublyLinkedNode<E> nextNode = removeNode.getNext();
                prevNode.setNext(nextNode);
                nextNode.setPrevious(prevNode);
            }
        }
        counter--;
        return true;
    }

    //    Y tuong 1:
//    Cho currentNode la head, sau do currentNode.getNext
//    Cho den index la vi tri can lay gia tri
//    public E get(int index) {
//        if (index >= counter || index < 0) {
//            return null;
//        }
//        DoublyLinkedNode<E> currentNode = head;
//        for (int i = 0; i < index; i++) {
//            currentNode = currentNode.getNext();
//        }
//        return currentNode.getElement();
//    }
//    Y tuong 2:
    //    B1: tao 1 bien dem = counter / 2;
//    B2: neu index < bien dem thi cho currentNode = head (TH1)
//        con neu index > bien dem thi cho currentNode = tail (TH2)
//    B3: TH1:
//        b1: gan currentNode = currentNode.getNext cho den index la vi tri can lay gia tri
//        b2: return currentNode.getElement
//    TH2:
//        b1: gan currentNode = currentNode.getPrevious cho den index la vi tri can lay gia tri
//        b2: return currentNode.getElement

    @Override
    public E get(int index) {
        if (index >= counter || index < 0) {
            return null;
        }
        int middle = counter / 2;
        DoublyLinkedNode<E> currentNode;
        if (index < middle) {
            currentNode = head;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.getNext();
            }
        } else {
            currentNode = tail;
            for (int i = 0; i < (counter - 1 - index); i++) {
                currentNode = currentNode.getPrevious();
            }
        }
        return currentNode.getElement();
    }

    //    Y tuong 1:
//    Cho currentNode la head, cho currentNode.getNext
//    cho den index la vi tri can thay doi gia tri.
//    De thay doi gia tri currentNode.setElement = item.
//    @Override
//    public boolean set(E item, int index) {
//        if (index >= counter || index < 0) {
//            return false;
//        }
//        DoublyLinkedNode<E> currentNode = head;
//        for (int i = 0; i < index; i++) {
//            currentNode = currentNode.getNext();
//        }
//        currentNode.setElement(item);
//        return true;
//    }

    //    Y tuong 2
//    B1: tao 1 bien dem = counter / 2;
//    B2: neu index < bien dem thi cho currentNode = head (TH1)
//        con neu index > bien dem thi cho currentNode = tail (TH2)
//    B3: TH1:
//        b1: gan currentNode = currentNode.getNext cho den index laf vi tri can thay doi gia tri
//        b2: gan currentNode.setElement = item
//    TH2:
//        b1: gan currentNode = currentNode.getPrevious cho den index laf vi tri can thay doi gia tri
//        b2: gan currentNode.setElement = item
    public boolean set(E item, int index) {
        if (index >= counter || index < 0) {
            return false;
        }
        int middle = counter / 2;
        DoublyLinkedNode<E> currentNode;
        if (index < middle) {
            currentNode = head;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.getNext();
            }
        } else {
            currentNode = tail;
            for (int i = 0; i < (counter - 1 - index); i++) {
                currentNode = currentNode.getPrevious();
            }
        }
        currentNode.setElement(item);
        return true;
    }

    //    method nay de lay gia tri cua node head
    @Override
    public E head() {
        return head.getElement();
    }

    //    method nay tra ve array co length bang size
//    gom cac gia tri la element cua node bat dau tu head
    @Override
    public E[] head(int size) {
        if (size < 0) {
            return (E[]) new Object[0];
        }
        int actual_size = Math.min(size, counter);
        E[] l = (E[]) new Object[actual_size];
        DoublyLinkedNode<E> currentNode = head;
        for (int i = 0; i < actual_size; i++) {
            l[i] = currentNode.getElement();
            currentNode = currentNode.getNext();
        }
        return l;
    }

    //    method nay de lay gia tri cua node tail
    @Override
    public E tail() {
        return tail.getElement();
    }

    //    method nay tra ve array co length bang size
//    gom cac gia tri la element cua node bat dau tu tail
    @Override
    public E[] tail(int size) {
        if (size < 0) {
            return (E[]) new Object[0];
        }
        int actual_size = Math.min(size, counter);
        E[] l = (E[]) new Object[actual_size];
        DoublyLinkedNode<E> currentNode = tail;
        for (int i = 0; i < actual_size -1; i++) {
//            l[i] = currentNode.getElement();
            currentNode = currentNode.getPrevious();
        }
        for (int i = 0; i < actual_size; i++){
            l[i] = currentNode.getElement();
            currentNode = currentNode.getNext();
        }
        return l;
    }

    @Override
    public String toString() {
        DoublyLinkedNode<E> node = head;
        String s = "";
        while (node.getNext() != null) {
            s += node.getElement() + " --> ";
            node = node.getNext();
        }
        s += node.getElement();
        return s;
    }
}

