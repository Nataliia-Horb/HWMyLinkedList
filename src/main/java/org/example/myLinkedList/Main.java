package org.example.myLinkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;


public class Main {
    public static void main(String[] args) {

        MyLinkedList list = new MyLinkedList();
        list.pushToHead(3);
        list.pushToHead(5);
        list.pushToTail(4);
        list.pushByIndex(22, 0);
        System.out.println(list.getFirst());

        list.pushAfterElement(100, list.getByIndex(3));
        System.out.println(list.getFirst());

        System.out.println(list.removeByIndex(4));
        System.out.println(list.getFirst());

        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        list.pushAll(2, arr);
        System.out.println(list.getFirst());

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // System.out.println(  list.removeLast());
        // System.out.println(  list.removeFirst());
        //System.out.println(list.getFirst());
        // System.out.println(  list.removeLast());
        //System.out.println(  list.removeLast());
        // System.out.println(list.getSize());

    }
}