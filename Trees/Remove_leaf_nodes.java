package com.Trees;

import java.util.Scanner;

public class Remove_leaf_nodes {
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
    public static void printTreeDetailed(BinaryTreeNode<Integer> root){
        //Take care of the base case
        if(root==null){
            return;
        }
        System.out.print(root.data + ":");

        if(root.left!=null){
            System.out.print("L" + root.left.data + ",");
        }
        if(root.right!=null){
            System.out.print("R" + root.right.data);
        }

        System.out.println();

        printTreeDetailed(root.left);
        printTreeDetailed(root.right);
    }

    public static BinaryTreeNode<Integer> remove_leaf_nodes(BinaryTreeNode<Integer> root){
        if(root==null){
            return null;
        }
        if((root.left==null) && (root.right==null)){
            return null;
        }
        root.left=remove_leaf_nodes(root.left);
        root.right=remove_leaf_nodes(root.right);
        return root;
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root=treeInputBetter(true,0,false);
        printTreeDetailed(remove_leaf_nodes(root));

    }
}
