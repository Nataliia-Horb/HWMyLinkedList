package org.example.myLinkedList;

import lombok.Data;

@Data
public class MyNode {
    Integer data;
    MyNode next;

    public MyNode(Integer data, MyNode next) {
        this.data = data;
        this.next = next;
    }
}
