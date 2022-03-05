package com.Trees;

import java.util.Stack;
/*
             50
            /   \
         25       75
        /   \    /   \
       12   37  62    87
            /   \
           30   70
 */

public class BinaryTrees {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data, Node left, Node right){ //Constructor
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    public static class Pair{
        Node node;
        int state; //1,2,3 ->states
        //1 ->left 2->right 3->pop
        Pair(Node node, int state){
            this.node = node;
            this.state = state;
        }
    }
    public static void display(Node node){
        if(node ==null){
            //If there are no children of that node then return to the previous node
            return;
        }
        String str = "";
        str+=node.left==null?"." : node.left.data + " ";//Ternary operators
        //If left is null add . , else add data of left
        str+="<-"+node.data+"->";
        //If right is null add ., else add data of right
        str+= node.right == null?".":node.right.data+" ";
        System.out.println(str);
        //Recursion
        //First travelling to left of the node then travelling to right of the node
        display(node.left);
        display(node.right);

    }
    public static void main(String[] args) {
        Integer[] arr = {50,25,12,null,null,37,30,null,null,null
                ,75,62,null,70,null,null,87,null,null};
        Node root = new Node(arr[0],null,null);
        Pair root_pair = new Pair(root,1);
        Stack<Pair> st = new Stack<>();
        st.push(root_pair); //Pushing root pair in Stack
        int index = 0;
        while(st.size()>0){
            Pair top = st.peek();
            if(top.state ==1){ //Left
               index++;
               if(arr[index]!= null){
                   //Making Left Node of Top when element is not null
                    top.node.left = new Node(arr[index],null,null);
                    Pair left_pair = new Pair(top.node.left,1);
                    st.push(left_pair);
               }else{
                   top.node.left = null;
               }
               top.state++; //Increasing the state of top
            }
            else if(top.state == 2){ //Right
                index++;
                if(arr[index]!= null){
                    //Making Right Node of Top when element is not null
                    top.node.right = new Node(arr[index],null,null);
                    Pair right_pair = new Pair(top.node.right,1);
                    st.push(right_pair);
                }else{
                    top.node.right = null;
                }
                top.state++;
            }
            else{
                st.pop();
            }
        }
        display(root);
    }

}
