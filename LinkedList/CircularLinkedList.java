package com.LinkedList;
//1->2->3->4->1
//4 is tail and 1 is head, connected to each other

public class CircularLinkedList {
    public CircularLinkedList() {

    }

    private class Node{
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }
    private Node head;
    private Node tail;
    public CircularLinkedList(Node head, Node tail) {
        this.head = head;
        this.tail = tail;
    }
    public void insert(int val){
        Node node = new Node(val);
        if(head==null){
            //If head is null, then head and tail both are same, that is new node
            head = node;
            tail = node;
            return;
        }
        tail.next = node;//New node is the next of tail
        node.next = head;//New node next is head
        tail = node;//New node becomes tail
    }
    public void display(){
        Node node = head;
        if(head!=null){
            do{
                System.out.print(node.val+"-> ");
                node = node.next;
            }while(node!=head);//Till node is not equal to head, it will iterate
        }
        System.out.println("HEAD");//The node comes again at head
    }
    public void delete(int val){
        Node node = head;
        if(node==null){
            return;
        }

        if(node.val == val){
            head= head.next;
            tail.next=head;
            return;
        }
        //Check if the next node is the value to delete
        //Make a link between current node and tail
        do{
            Node n = node.next;
            if(n.val==val){
                node.next = n.next;
                break;
            }
            node=node.next;
        }while(node!=head);
    }
    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        list.insert(23);
        list.insert(10);
        list.insert(100);
        list.display();
    }
}
