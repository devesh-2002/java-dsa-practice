package com.LinkedList;
//Sorted Lists
import org.w3c.dom.Node;

public class Duplicates {

        private Node head;
        private Node tail;
        private int size;

    private class Node {
        private int value;
        private Node next;

        //All these are private, so that they can't be directly accessed
        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;

        }
    }

    public void duplicates() {
        Node node = head;

        while (node.next != null) {//Traverse till last
            if (node.value == node.next.value) { //If current value and next value are equal
                node.next = node.next.next;
                size--;//Deleting the node
            } else {
                node = node.next;//Continue traversing
            }
        }
        tail = node;
        tail.next = null;
    }
    public static void main(String[] args) {
        LL list = new LL();

        list.insertFirstPosition(1);
        list.insertFirstPosition(1);
        list.insertFirstPosition(2);
        list.insertFirstPosition(2);
        list.insertFirstPosition(2);
        list.insertFirstPosition(3);
        list.insertFirstPosition(4);
        list.insertFirstPosition(4);
        list.display();
        list.duplicates();
        list.display();
    }
}
