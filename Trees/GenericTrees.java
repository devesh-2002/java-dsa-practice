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
    //   levelOrder(root);
    //   levelOrderLineWise(root);
        //Tree after getting Linearized
      //  linearize(root);
      //  display(root);
        //LineWiseZigZagDisplay
       // levelOrderLineWiseZigZag(root);
       // System.out.println(find(root,30));
        System.out.println(nodeToRootPath(root,110));
        System.out.println(lowest_common_ancestor(root,110,70));
    }

    //Displays node -> children
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
        //LevelOrder means traversing level by level from left to right and top to bottom
        Queue<Node> q = new ArrayDeque<>();
        q.add(node);
        while(q.size()>0){
            node = q.remove();
            System.out.print(node.data+" ");
            for(Node child:node.children){
                q.add(child);//traversing through child
            }
        }
        System.out.print(".");
        }
        public static void levelOrderLineWise(Node node){
        //Prints the children of root per line
        Queue<Node> main_queue = new ArrayDeque<>();
        main_queue.add(node);//Adding the elements first into main queue
        Queue<Node> child_queue = new ArrayDeque<>();
            while(main_queue.size()>0){
                node = main_queue.remove(); //Remove the elements of main queue
                System.out.print(node.data+" ");
                for(Node child:node.children){
                    child_queue.add(child);//queue consisting of child elements of root
                }
                //Every child element of main queue gets added in child queue
                //The process repeats itself
                if(main_queue.size()==0){
                    main_queue=child_queue;
                    child_queue = new ArrayDeque<>();
                    System.out.println();//print child elements line by line
                }

            }
        }
        //Linearizing Tree
        public static void linearize(Node node){
        // In this the tail of previous child is attached to the next node.
        // (10-20-30-50-60)-(30-70-80-110-120-90)-(40-100)
        for(Node child:node.children){
            linearize(child);
        }
        while(node.children.size()>1){
            Node last_child = node.children.remove(node.children.size()-1);
            Node second_last = node.children.get(node.children.size()-1);
            Node second_last_tail = getTail(second_last);
            second_last_tail.children.add(last_child);
        }
        }

    private static Node getTail(Node node) {
        while(node.children.size()==1){
            node = node.children.get(0);
        }
        return node;
    }


    //Level Order Line Wise (Zig Zag)
    //Root -> children on one line (right to left) ->children on next line(right to left)->and so on
    //Basically print elements per line in a zig zag manner
    public static void levelOrderLineWiseZigZag(Node node){
        //Main Stack
        Stack<Node> main_stack = new Stack<>();
        main_stack.add(node);
        //Stack containing children
        Stack<Node> child_stack = new Stack<>();
        int level = 0;

        while(main_stack.size() > 0){
            node = main_stack.pop();//Removing the elements of main stack
            System.out.print(node.data + " ");

            if(level % 2 == 0){//Even level ->2,4..
                //Left to right elements
                for(int i = 0; i < node.children.size(); i++){
                    Node child = node.children.get(i);
                    child_stack.push(child);
                }
            } else {
                //For odd level
                //Right to left
                for(int i = node.children.size() - 1; i >= 0; i--){
                    Node child = node.children.get(i);
                    child_stack.push(child);
                }
            }
            //After main stack gets emptied
            if(main_stack.size() == 0){
                main_stack = child_stack;
                child_stack = new Stack<>();//Transfer contents of child stack to main stack
                level++;//increase the level
                System.out.println();
            }
    }
}
    //Find an element in Generic Tree
    public static boolean find(Node node, int data){
        if(node.data == data){
            //Matches data with node/root of tree
            //If root and the number are same, true is returned
            return true;
        }
        for (Node child: node.children) {
            boolean first_child = find(child,data);
            if(first_child){
                return true;//Finds the element in the children nodes
            }
        }
        return false;//Returns false if no element matches
    }

    public static ArrayList<Integer> nodeToRootPath(Node node, int data){
        //Finding element, printing root, children and element in array
        if(node.data == data){
            //If element is one of the data
            ArrayList<Integer> list = new ArrayList<>();
            list.add(node.data); //Add data
            return list;
        }
        for(Node child:node.children){ //Searching in children of the data
            ArrayList<Integer> path_till_child = nodeToRootPath(child,data); //Recursion
            if(path_till_child.size()>0){
                path_till_child.add(node.data);
                return path_till_child;
                //Keeps on adding children of data and root itself till element is found
            }
        }
        return new ArrayList<>();
    }
    public static int lowest_common_ancestor(Node node, int d1, int d2){
        //If suppose d1,d2 are 110 and 70, then lowest common ancestor is 30 because
        //110->80->30->10
        //70->30->10
        //Both have 30 and 10 in common and 30 is the closest common
        ArrayList<Integer> p1 = nodeToRootPath(node, d1); //d1 to Root
        ArrayList<Integer> p2 = nodeToRootPath(node, d2);//d2 to Root
        int i = p1.size() - 1;
        int j = p2.size()- 1;
        //Accesing common elements in d1 and d2 in d1 and d2
        while(i>=0&&j>=0&&p1.get(i)==p2.get(j)){
            i--;
            j--;
        }
        //Incrementing i and j to get first equal element
        i++;
        j++;
        return p1.get(i);
    }
}



