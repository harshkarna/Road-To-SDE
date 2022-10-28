package com.Trees;

import java.util.Scanner;

public class Node_with_largest_data {

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

    public static int largest_node(BinaryTreeNode<Integer> root){
        if(root==null){
            return -1;
        }
        int left=largest_node(root.left);
        int right=largest_node(root.right);
        return Math.max(root.data,Math.max(left,right));
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root=treeInputBetter(true,0,false);
        System.out.println(largest_node(root));
    }
}
