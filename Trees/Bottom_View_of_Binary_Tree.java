package com.Trees;

import java.util.*;

public class Bottom_View_of_Binary_Tree {

    public static BinaryTreeNode<Integer> takeInputLevelwise(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Root data ");
        int rootdata= sc.nextInt();
        //This is for if main root is null
        if(rootdata == -1){
            return null;
        }

        BinaryTreeNode<Integer> root=new BinaryTreeNode<>(rootdata);
        Queue<BinaryTreeNode<Integer>> pendingChildren=new LinkedList<>();
        pendingChildren.add(root);

        while(!pendingChildren.isEmpty()){
            BinaryTreeNode<Integer> front= pendingChildren.poll();

            System.out.println("Enter left Child of " + front.data);
            int left= sc.nextInt();
            if(left!=-1){
                BinaryTreeNode<Integer> leftChild=new BinaryTreeNode<Integer>(left);
                front.left=leftChild;
                pendingChildren.add(leftChild);
            }
            System.out.println("Enter Right Child of " + front.data);
            int right= sc.nextInt();
            if(right!=-1){
                BinaryTreeNode<Integer> rightChild=new BinaryTreeNode<Integer>(right);
                front.right=rightChild;
                pendingChildren.add(rightChild);
            }
        }
        return root;
    }


    private static class Pair {
        int hd;
        BinaryTreeNode<Integer>  node;

        public Pair(int hd, BinaryTreeNode<Integer> node) {
            this.hd = hd;
            this.node= node;
        }
    }

    public static ArrayList<Integer> bottomView(BinaryTreeNode<Integer> root){
        //First we need one queue which can store pair
        //Here pair is combination of Hd - horizontal distance from root , and node's reference
        Queue<Pair> pendingChildren=new LinkedList<>();
        //Now we need one Map which will store key -> HD from root and value -> node ka data , and here we are uing treemap ,
        // which will store keys im ascending order, Tree map is part of collections in java
        Map<Integer,Integer> map=new TreeMap<>();

        //Let go with preorder Traversal , check in root first in queue
        pendingChildren.add(new Pair(0,root));

        //Now lets start with the queue
        while(!pendingChildren.isEmpty()){
            //Poll the first in queue
            Pair current=pendingChildren.poll();
            //First check if map contains current hd or not
            //just everytime add, or replace value for that particular key
            map.put(current.hd,current.node.data);

            //NoW For left and right we will leave it to the queue.
            if(current.node.left !=null){
                pendingChildren.add(new Pair(current.hd-1,current.node.left));
            }
            if(current.node.right !=null){
                pendingChildren.add(new Pair(current.hd+1,current.node.right));
            }

        }
        ///Now you need to return arraylist as answer
        ArrayList<Integer> ans =new ArrayList<>();
        for (Map.Entry<Integer,Integer> entry:map.entrySet()){
            ans.add(entry.getValue());
        }
        return ans;
    }



    public static void main(String[] args) {
        BinaryTreeNode<Integer> root=takeInputLevelwise();
        ArrayList<Integer> ans=bottomView(root);
        System.out.println(ans);


    }
}
