package org.example.myLinkedList;

import java.util.Iterator;


public class MyIterator implements Iterator<Integer> {
    MyLinkedList list;
    MyNode node;
    int index = 0;

    public MyIterator(MyLinkedList list) {
        this.list = list;
        node = list.getFirst();
    }


    @Override
    public boolean hasNext() {
        return node != null;
    }

    @Override
    public Integer next() {
        Integer data = node.getData();
        node = node.getNext();
        return data;
    }

    @Override
    public void remove() {
        node.setData(null);
        node = node.getNext();
    }
}
