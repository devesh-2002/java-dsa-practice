package com.LinkedList;

import org.w3c.dom.Node;

public class LL {
    private Node head;
    private Node tail;
    private int size;
    public LL(){
        this.size = 0;
    }
    public void insertFirstPosition(int val){
        Node node = new Node(val); //Creating new node
        node.next = head; //Pointing my node to head
        head = node;//Head always points to new node
        if(tail == null){
            tail = head;
            //If there is only one element then the same element is pointed by head and tail
        }
        size +=1;
    }
    public void insertLastPosition(int val){
        if (tail==null) {insertFirstPosition(val); return;}
        //If list has 0 elements then insert at first position
        Node node = new Node(val);
        tail.next = node; //new node is next to current tail
        tail = node; //Now the current tail points to new node
        size++;
    }
    public void insert(int val, int index){
        if(index==0){
            insertFirstPosition(val);
            return;
        }//Element gets inserted at 0th position i.e first position
        if(index==size){
            insertLastPosition(val);
            return;
        }//Element gets inserted at the last position
        Node temp = head;
        for (int i = 1; i < size; i++) {
            temp = temp.next;
        }
        Node node = new Node(val,temp.next);
        temp.next = node;
        size++;
    }
//Insertion using recursion
    public void insertRec(int val, int index) {
        head = insertRec(val, index, head);
    }

    private Node insertRec(int val, int index, Node node) {
        if (index == 0) {
            Node temp = new Node(val, node);
            size++;
            return temp;
        }

        node.next = insertRec(val, index-1, node.next);
        return node;

    //While insertion, next node of the current node and new node would be same
    //Current node and next node will break and new node and next node will be formed
    //Recursion


}
    public int DeleteFirst(){
        int val = head.value;
        head = head.next;
        //When we shift head to the next, it automatically means the previous head was deleted!

        if(head==null){
            tail=null;
        }
        size--;//size reduce by one because element is deleted

        return val;
    }
    public Node get(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;//Returns pointer to that index
    }

    public Node node(int index){
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }
    public int delete(int index){
        if(index==0){return DeleteFirst();}
        if(index==size-1){return DeleteLast();}
        Node prev = get(index - 1);//Finds the previous pointer
        int val = prev.next.value; //Value of the pointer supposed to be deleted
        prev.next = prev.next.next; //Pointer between prev and next

        return val;
    }
    public Node find(int value) {
        Node node = head;
        while (node != null) {
            if (node.value == value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    private int DeleteLast() {
        if (size <= 1) {
            return DeleteFirst();
        }

        Node secondLast = get(size - 2); //Element pointing to second last node
        int val = tail.value; //Value of tail
        tail = secondLast;
        tail.next = null; //the next node will be null, after deleting the last node
        return val;

    }

    public void display(){
        Node temp = head; //Temporary variable temp is created because head can't be modified
        while(temp!=null){
            System.out.print(temp.value+" -> ");
            temp = temp.next; //temp points to next variable
        }
        System.out.println("END");
    }



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

    public static void main(String[] args) {
     //  LL list = new LL();
     //  list.insertFirstPosition(13);
     //  list.insertFirstPosition(15);
     //  list.insertFirstPosition(34);
     //  list.insertLastPosition(244);
     //  list.insert(1,3);
     //  list.display();
     //  System.out.println(list.DeleteLast());
     //  list.display();
     //  list.insertRec(88,2);
     //  list.display();

        //for merge question
        LL first = new LL();
        LL second = new LL();
        first.insertLastPosition(1);
        first.insertLastPosition(3);
        first.insertLastPosition(5);

        second.insertLastPosition(1);
        second.insertLastPosition(2);
        second.insertLastPosition(9);
        second.insertLastPosition(14);
        LL ans = LL.Merge(first,second);
        ans.display();


    }
    //Q1 ->duplicates
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

    //q2->merge of two lists
  public static LL Merge(LL first, LL second) {
      Node f = first.head;//Head of first Linked List
      Node s = second.head;//Head of second Linked List

      LL ans = new LL();

      while (f != null && s != null) {
          if (f.value < s.value) {
              ans.insertLastPosition(f.value);
              //If first value is lesser than second value insert
              f = f.next;
          } else {
              //else move to the second list, and compare the respective element
              ans.insertLastPosition(s.value);
              s = s.next;
          }
      }
      //When one of the list will get completed, part of other list will be left
      //But that part would already be sorted, because both the lists are initially sorted
      //Either of the two while loops will run

      while (f != null) {
          ans.insertLastPosition(f.value);
          f = f.next;
      }

      while (s != null) {
          ans.insertLastPosition(s.value);
          s = s.next;
      }

      return ans;
  }
  //Q3-> cycle linked list

    public boolean hasCycle(Node head){
        //Two pointers taken, fast and slow pointing to head
        Node fast = head;
        Node slow = head;

        while(fast!=null & fast.next !=null){
            //Fast is twice ahead of slow
            fast = fast.next.next;
            slow = slow.next;
            //If it's a cycle, then both pointers meet surely at a point
            if(fast==slow){
                return true;
            }
        }
        return false;
    }

}