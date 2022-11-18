package com.Binary_Search_Tree;

import com.Trees.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Check_is_BST_2 {
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

    //This is another approach for checking if a tree is BST
    //HERE AT every node we are checking if that node is lying in that allowed range or not , if violated , its false.

    ///idea - The idea is to write a utility helper function isBSTUtil(struct node* node, int min, int max) that traverses down
    // the tree keeping track of the narrowing min and max allowed values as it goes, looking at each node only once.
    // The initial values for min and max should be INT_MIN and INT_MAX — they narrow from there.

    public static boolean check_is_BST(BinaryTreeNode<Integer> root){

        return isBSTHelper(root,Integer.MIN_VALUE,Integer.MAX_VALUE);

    }

    private static boolean isBSTHelper(BinaryTreeNode<Integer> root, int minRange_of_left, int maxRange_of_right) {
        if(root==null){
            return true;
        }
        if(root.data < minRange_of_left || root.data > maxRange_of_right){
            return false;
        }
        boolean isLeftWithinRange =isBSTHelper(root.left,minRange_of_left,root.data-1);
        boolean isRightWithinRange =isBSTHelper(root.right,root.data,maxRange_of_right);

        return  isLeftWithinRange && isRightWithinRange;

    }


    public static void main(String[] args) {
        BinaryTreeNode<Integer> root=takeInputLevelwise();
        System.out.println(check_is_BST(root));

    }
}
