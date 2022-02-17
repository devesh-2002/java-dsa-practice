package com.Trees;

import java.util.*;

import static java.lang.Integer.MIN_VALUE;

public class GenericTrees {
    public static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }
/*  Tree structure
*                                  10
*           20                     30                40
*          50 60            70     80     90        100
*                                110  120
* 110,120 are child nodes of 80,similarly 20 and 40 have child nodes
*  10 has child nodes 20,30,40
*  10 is the root node
* horizontal height = 3 (edges)
* vertical height = 4 (roots)
* */
    public static void main(String[] args) {
        int [] arr = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
        Node root = null;
        Stack<Node> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==-1){
                st.pop();
            }
            else{
                Node t = new Node();
                t.data = arr[i];
                if(st.size()>0){
                    st.peek().children.add(t);
                }
                else{
                    root=t;
                }
                st.push(t);
            }
        }
        display(root); //display tree in the form of root->children
        //size of tree
        System.out.println("Size of Generic tree is "+size(root));
        //max of all nodes
        System.out.println("Maximum of all nodes is "+max(root));
        System.out.println("Height is "+height(root));
      //  traversals(root);

    } //Displays node -> children
    public static void display(Node node) {
        //prints child of the root
        String str = node.data + " -> ";
        for (Node child : node.children) {
            str += child.data + ", ";
        }
        str += ".";
        System.out.println(str);
        //prints child of the children of root
        for (Node child : node.children) {
            display(child);

        }
    }
    public static int size(Node node){
        int s=0; //s = size
        for(Node child:node.children){
            int child_size = size(child);
            //size of one child is the number of children it has and including itself
            s = s+ child_size;
        }
        s = s+1;
        return s;
    }
    //size of root = sum of sizes of all children + 1
    public static int max(Node node){
        int max = MIN_VALUE;
        //MIN_VALUE = -2147483648
        // The most minimum possible value in java
        for(Node child: node.children){
            int child_max = max(child);
            max = Math.max(child_max,max);
            //Compares the children of nodes
            //If my child_max is greater than max, then max gets updated to child_max
        }
        max = Math.max(node.data,max);//Compares max between max of children

        return max;
    }
    public static int height(Node node){
        //height is number of nodes or edges
        int ht = -1; //if height in terms of edges
        //if height in terms of nodes, ht = 0

        for(Node child:node.children){
            int child_height = height(child);//Compares the height of children
            ht = Math.max(child_height,ht);//The child which has max children is seen
            //number of children
        }
        ht+=1; //includes the root
        return ht;
    }
    public static void traversals(Node node){
        //euler's left, pre area
        System.out.println("Node pre " + node.data);
        for(Node child:node.children){
            //edge pre - means just came to that edge
            System.out.println("Edge Pre "+node.data+"--"+child.data);
            traversals(child);
            System.out.println("Edge post "+node.data+"--"+child.data);
            //edge post - means just crossed that edge
        }
        System.out.println("Node Post "+node.data);
    }
    public static void levelOrder(Node node){
        //LevelOrder means traversing level by level from left to right
        Queue<Node> q = new ArrayDeque<>();
        q.add(node);
        while(q.size()>0){
            node = q.remove();
            System.out.println(node.data+" ");
            for(Node child:node.children){
                q.add(child);
            }
        }
        System.out.println(".");
        }

    }

