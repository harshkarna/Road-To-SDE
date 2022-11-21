package com.Binary_Search_Tree;

import com.Trees.BinaryTreeNode;

import java.util.*;

public class Node_to_Root_path_Binary_tree {

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

    public static ArrayList<Integer> node_to_Root_path_Binary_tree(BinaryTreeNode<Integer> root, int x){
        if(root==null){
            return null;
        }
        //check if you got x on root itself , if yes then add it in list and return
        if(root.data==x){
         ArrayList<Integer> output=new ArrayList<>();
         output.add(root.data);
         return output;
        }

        //lets check on left with recursion
        ArrayList<Integer> left=node_to_Root_path_Binary_tree(root.left,x);
        //Now left can return a path which means x is found, if not it will return null, lets handle non null case
        if(left!=null){
            left.add(root.data);
            return left;
        }

        //lets check on right with recursion
        ArrayList<Integer> right=node_to_Root_path_Binary_tree(root.right,x);
        //Now right can return a path which means x is found, if not it will return null, lets handle non null case
        if(right!=null){
            right.add(root.data);
            return right;
        }

        //if x is neither found on root, nor left nor right , then simply return null.
        return null;
    }


    public static void main(String[] args) {

        BinaryTreeNode<Integer> root=takeInputLevelwise();
        System.out.println(node_to_Root_path_Binary_tree(root,5));

    }
}
