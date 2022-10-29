package com.Trees;

import java.util.Scanner;

public class No_of_leaf_nodes {

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
    public static int no_of_leaf_nodes(BinaryTreeNode<Integer> root){
        boolean flag=false;
        if(root==null){
            return 0;
        }
        if(root.left==null && root.right==null){
            flag=true;
        }

        int left=no_of_leaf_nodes(root.left);
        int right=no_of_leaf_nodes(root.right);
        if(flag){
            return 1+left+right;
        }
        else{
            return left+right;
        }
    }

    public static int no_of_leaf_nodes_better(BinaryTreeNode<Integer> root){
        boolean flag=false;
        if(root==null){
            return 0;
        }
        if(root.left==null && root.right==null){
            return 1;
        }
        return no_of_leaf_nodes(root.left)+no_of_leaf_nodes_better(root.right);

    }


    public static void main(String[] args) {
        BinaryTreeNode<Integer> root=treeInputBetter(true,0,false);
        System.out.println(no_of_leaf_nodes_better(root));

    }
}
