package com.Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Check_if_Tree_is_Balanced_or_Not {
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


    public static int height_of_tree(BinaryTreeNode<Integer> root){
        if(root==null){
            return 0;
        }
        int left=height_of_tree(root.left);
        int right=height_of_tree(root.right);
        return 1 + Math.max(left,right);
    }

    //1st Approach Tc=o(n2)
    public static boolean isBalanced (BinaryTreeNode<Integer> root){

        if(root==null){
            return true;
        }
        //as we can see at every node we are calling height
        //hence Tc = O(N^2) , which can be improved
        int leftHeight=height_of_tree(root.left);
        int rightHeight=height_of_tree(root.right);
        //Formula : To checl balance
        //Diff of left height and right height should =<1 for all nodes in tree
        if( Math.abs(leftHeight-rightHeight) > 1 ){
            return false ;
        }
        boolean isLeftBalanced=isBalanced(root.left);
        boolean isRightBalanced=isBalanced(root.right);

        return isLeftBalanced && isRightBalanced;

    }

    //2nd Approach
    private static class Pair<T, T1> {
        boolean isBalanced;
        int height;

        public Pair(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }


    public static Pair isBalancedHelper(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return new Pair(true,0);
        }

        Pair left=  isBalancedHelper(root.left);
        Pair right = isBalancedHelper(root.right);

        if( Math.abs(left.height-right.height) > 1 ){
            return new Pair(false,0);
        }

        boolean isLeftBalanced=left.isBalanced;
        boolean isRightBalanced=right.isBalanced;


        return new Pair((isLeftBalanced && isRightBalanced),Math.max(left.height,right.height)+1);

    }

    public static boolean isBalanced_Optimised(BinaryTreeNode<Integer> root) {
        Pair pair = isBalancedHelper(root);
        return pair.isBalanced;
    }




    public static void main(String[] args) {
        BinaryTreeNode<Integer> root=takeInputLevelwise();
//        System.out.println("Is balanced " + isBalanced(root));
        System.out.println("Is balanced " + isBalanced_Optimised(root));



    }
}
