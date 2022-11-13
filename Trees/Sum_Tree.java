//Given a Binary Tree. Return true if, for every node X in the tree other than the leaves, i
// ts value is equal to the sum of its left subtree's value and its right subtree's value. Else return false.
//
//        An empty tree is also a Sum Tree as the sum of an empty tree can be considered to be 0.
//        A leaf node is also considered a Sum Tree.
//
//Intuition -
//
//


package com.Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Sum_Tree {

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
    //TC=0(N) ,we can also solve this without pair but then tc will be O(N^2)
    private static class Pair<T, T1> {
        boolean isSum;
        int sum;

        public Pair(boolean isSum, int sum) {
            this.isSum = isSum;
            this.sum = sum;
        }
    }

    public static Pair isSumHelper(BinaryTreeNode<Integer> root) {
        //Base case
        if (root == null) {
            return new Pair(true,0);
        }

        //Condition for leaf Node
        if ((root.left == null && root.right == null)){
            return new Pair(true,root.data);
        }

        Pair left=isSumHelper(root.left);
        Pair right=isSumHelper(root.right);

        //check current node
        boolean current_node = root.data == left.sum +right.sum;

        boolean leftCheck=left.isSum;
        boolean rightCheck=right.isSum;

        return new Pair(leftCheck && rightCheck && current_node,root.data + left.sum+ right.sum);

    }

    public static  boolean isSumTree(BinaryTreeNode<Integer> root){
        Pair pair =isSumHelper(root);
        return pair.isSum;

    }

    public static void main(String[] args) {

        BinaryTreeNode<Integer> root=takeInputLevelwise();
        System.out.println(isSumTree(root));
    }
}
