package com.Binary_Search_Tree;

import com.Trees.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Check_is_BST {
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

    private static int leftMax(BinaryTreeNode<Integer> root) {
        if(root==null){
            return Integer.MIN_VALUE;
        }
        int left=leftMax(root.left);
        int right=leftMax(root.right);
        return Math.max(Math.max(left, right),root.data);

    }

    private static Integer righMin(BinaryTreeNode<Integer> root) {
        if(root==null){
            return Integer.MAX_VALUE;
        }
        int left=righMin(root.left);
        int right=righMin(root.right);
        return Math.min(Math.min(left, right),root.data);

    }

    //Time Complexity: O(N2), As we visit every node just once and our helper method also takes O(N) time,
    // so overall time complexity becomes O(N) * O(N) = O(N2)

    public static boolean check_is_BST(BinaryTreeNode<Integer> root){
        if(root==null){
            return true;
        }

        //check for root
        //1. it should be greater than every element of left subtree , hence we are comparing with max of left subtree to the root
        //2.it should be smaller than every element of right subtree , hence we are comparing with min of right subtree to the root
        if(root.data <= leftMax(root.left)){
            return false;
        }
        if (root.data > righMin(root.right)){
            return false;
        }
        //for rest , recursion will handle
        boolean is_left_subtree_ok=check_is_BST(root.left);
        boolean is_right_subtree_ok=check_is_BST(root.right);
        return is_left_subtree_ok && is_right_subtree_ok;

    }


    public static void main(String[] args) {
        BinaryTreeNode<Integer> root=takeInputLevelwise();
        System.out.println(check_is_BST(root));

    }
}
