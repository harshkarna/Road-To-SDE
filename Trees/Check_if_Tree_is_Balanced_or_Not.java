package com.Trees;

import java.util.Scanner;

public class Check_if_Tree_is_Balanced_or_Not {
    public static BinaryTreeNode<Integer> treeInputBetter(boolean isRoot,int parentData,boolean isLeft){
        if(isRoot){
            System.out.println("Enter root data");
        }
        else {
            if(isLeft){
                System.out.println("Enter left child of " + parentData);
            }
            else {
                System.out.println("Enter right child of " + parentData);
            }
        }
        Scanner sc=new Scanner(System.in);
        int rootData=sc.nextInt();
        if(rootData==-1){
            return null;
        }
        BinaryTreeNode<Integer> root =new BinaryTreeNode<>(rootData);
        BinaryTreeNode<Integer> leftChild =treeInputBetter(false,rootData,true);
        BinaryTreeNode<Integer> rightChild =treeInputBetter(false ,rootData,false);
        root.left=leftChild;
        root.right=rightChild;
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
    public static boolean isBalanced (BinaryTreeNode<Integer> root){
        if(root==null){
            return true;
        }
        int leftHeight=height_of_tree(root.left);
        int rightHeight=height_of_tree(root.right);
        if( Math.abs(leftHeight-rightHeight) > 1 ){
            return false ;
        }

        boolean isLeftBalanced=isBalanced(root.left);
        boolean isRightBalanced=isBalanced(root.right);

        return isLeftBalanced && isRightBalanced;

    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root=treeInputBetter(true,0,false);
        System.out.println("Is balanced " + isBalanced(root));


    }
}
