package com.LinkedList;
// Example : null->3-><-5-><-6-><-9->null

public class DoublyLinkedList {
    Node head;
    private class Node {
        int val;
        Node next;
        Node prev;
        //next and prev pointers
        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next, Node prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }

    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;//node is the new node to be inserted, new node's next is current head
        node.prev = null;//new node's previous is null
        if(head!=null){
            head.prev = node;//backward link between head and new node
        }
        head = node; //After inserting, the current head will be new node
    }
    public void insertLast(int val){
        Node node = new Node(val);
        Node last = head;
        if (head == null) {
            node.prev = null;
            head = node; //Head points to new node now
            return;
        }
        //Till the last element is reached
        while(last.next!=null){
            last = last.next;
        }
    }
    public void display(){
        Node node = head;
        Node last = null;
        while(node!=null){
            last=node;
            System.out.print(node.val+"->");
            node = node.next;//Traversing
        }
        System.out.println("END");
        System.out.println("Print in reverse : ");
        while(last!=null){
            System.out.print(last.val+"-> ");
            last = last.prev;
        }
        System.out.println("START");
    }
    public Node find(int value) {
        Node node = head;
        while (node != null) {
            if (node.val == value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public void insert(int after, int val) {
        Node p = find(after);

        if (p == null) {
            System.out.println("does not exist");
            return;
        }

        Node node = new Node(val);
        node.next = p.next;
        p.next = node;
        node.prev = p;
        if (node.next != null) {
            node.next.prev = node;
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insertFirst(12);
        list.insertFirst(13);
        list.insertFirst(14);
        list.display();

    }
}
