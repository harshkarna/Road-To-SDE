package com.Trees;

import java.util.Scanner;

public class Find_No_of_nodes_tree {
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
    public static int no_of_nodes(BinaryTreeNode<Integer> root){
        if(root==null){
            return 0;
        }
        int leftNodeCount=no_of_nodes(root.left);
        int rightNodeCount =no_of_nodes(root.right);
        return rightNodeCount+leftNodeCount+1;

    }

    public static void main(String[] args) {
//        BinaryTreeNode<Integer> root =new BinaryTreeNode<>(1);
//        BinaryTreeNode<Integer> rootLeft =new BinaryTreeNode<>(2);
//        BinaryTreeNode<Integer> rootRight =new BinaryTreeNode<>(3);
//        root.left=rootLeft;
//        root.right=rootRight;
        BinaryTreeNode<Integer> root=treeInputBetter(true,0,false);
        System.out.println(no_of_nodes(root));


    }
}
