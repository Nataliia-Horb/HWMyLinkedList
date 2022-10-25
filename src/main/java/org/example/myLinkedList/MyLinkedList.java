package org.example.myLinkedList;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class MyLinkedList implements Iterable<Integer> {
    MyNode first;
    int size;

    void pushToHead(Integer data) {
        MyNode node = new MyNode(data, null);
        if (first != null) {
            node.setNext(first);
        }
        first = node;
        size++;
    }

    void pushToTail(Integer data) {
        MyNode node = new MyNode(data, null);
        if (first == null) {
            first = node;
        } else {
            MyNode last = first;
            while (last.getNext() != null) {
                last = last.getNext();
            }
            last.setNext(node);
        }
        size++;
    }

    void pushByIndex(Integer data, int index) {
        MyNode node = new MyNode(data, null);
        MyNode f = first;
        if (index == 0) {
            pushToHead(data);
        } else if (index < 0) {
            System.out.println("index out of bounds");
        } else {
            int count = 0;
            while (count++ < index - 1 && f.getNext() != null) {
                f = f.getNext();
            }
            node.setNext(f.getNext());
            f.setNext(node);
            size++;
        }
    }

    void pushAfterElement(Integer data, MyNode current) {
        if (current != null) {
            MyNode node = new MyNode(data, current.getNext());
            current.setNext(node);
            size++;
        }
    }

    Integer removeFirst() {
        if (first == null) {
            return null;
        }
        Integer data = first.getData();
        first = first.getNext();
        size--;
        return data;
    }

    Integer removeLast() {
        MyNode l = getLast();
        if (l == null) {
            return null;
        }
        Integer data = l.getData();
        size--;
        if (size > 0) {
            getByIndex(size - 1).setNext(null);
        } else {
            first = null;
        }
        return data;
    }

    Integer removeByIndex(int index) {
        MyNode current = getByIndex(index);
        if (current == null) {
            return null;
        }
        Integer data = current.getData();
        if (index == 0) {
            removeFirst();
        } else if (index < 0 || index >= size) {
            System.out.println("index out of bounds");
            return null;
        } else {
            getByIndex(index - 1).setNext(current.getNext());
            current.setNext(null);
            size--;

        }
        return data;
    }

    int getSize() {
        return size;
    }

    MyNode getFirst() {
        return first;
    }

    MyNode getLast() {
        if (first == null) {
            return null;
        }
        MyNode last = first;
        while (last.getNext() != null) {
            last = last.getNext();
        }
        return last;
    }

    MyNode getByIndex(int index) {
        MyNode f = first;
        if (index < 0 || index >= size) {
            System.out.println("index out of bounds");
            return null;
        } else {
            int count = 0;
            while (count++ <= index - 1 && f.getNext() != null) {
                f = f.getNext();
            }
        }
        return f;
    }

    void clear() {
        MyNode l;
        while (size > 0) {
            l = getLast();
            l.setData(null);
            l.setNext(null);
        }
    }

    boolean pushAll(Collection<Integer> collection) {
        if (collection.size() == 0) {
            return false;
        }
        Iterator<Integer> iterator = collection.iterator();
        while (iterator.hasNext()) {
            pushToTail(iterator.next());
            size++;
        }
        return true;
    }

    boolean pushAll(int index, Collection<Integer> collection) {
        if (collection.size() == 0) {
            return false;
        }
        if (index < 0 || index > size) {
            System.out.println("index out of bounds");
            return false;
        }

        Iterator<Integer> iterator = collection.iterator();
        while (iterator.hasNext()) {
            pushByIndex(iterator.next(), index);
            index++;
            size++;
        }
        return true;
    }


    @Override
    public Iterator<Integer> iterator() {
        return new MyIterator(this);
    }
}
