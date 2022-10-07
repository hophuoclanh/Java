package mylist;

import java.util.Arrays;

public class Test {
    public static void main(String [] agrs){
        List<Integer> dll = new DoublyLinkedList<>();
        List<Integer> ll = new ListImplLinkedBased<>();
        for (int i = 0; i < 3000; i++) {
            dll.append(i);
            ll.append(i);
        }

//        System.out.println(dll);
        long startTime = System.nanoTime();
        dll.tail(100);
        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println("Total time doubly linked list: " + totalTime);

        startTime = System.nanoTime();
        ll.tail(100);
        endTime   = System.nanoTime();
        totalTime = endTime - startTime;
        System.out.println("Total time linked list: " + totalTime);
    }
}
