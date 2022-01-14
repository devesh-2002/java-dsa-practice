package com.StackQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class InBuiltExamples {
    public static void main(String[] args) {
   //   Stack<Integer> stack = new Stack<>();
   //   stack.push(34);
   //   stack.push(45);
   //   stack.push(3);
   //   stack.push(4);
   //   stack.push(22);
   //   System.out.println(stack.pop());//LIFO, so 22 was last hence, 22 will be popped
   //   //Will show error if stack.pop is used when stack is empty

        Queue<Integer> queue = new LinkedList<>(); //Queue is implemented as a Linked List
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(10);
        queue.add(11);
        System.out.println(queue.peek());
        //peek shows top element that is 1 in this case
        queue.remove();//Removes top element
        System.out.println(queue);
    }
}
