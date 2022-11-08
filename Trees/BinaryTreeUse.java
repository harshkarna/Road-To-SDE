package com.Trees;

import java.util.Scanner;

public class BinaryTreeUse {

    public static BinaryTreeNode<Integer> treeInput(){
        System.out.println("Enter root data");
        Scanner sc=new Scanner(System.in);
        int rootData=sc.nextInt();
        if(rootData==-1){
            return null;
        }
        BinaryTreeNode<Integer> root =new BinaryTreeNode<>(rootData);
        BinaryTreeNode<Integer> leftChild =treeInput();
        BinaryTreeNode<Integer> rightChild =treeInput();
        root.left=leftChild;
        root.right=rightChild;
        return root;

    }

    public static BinaryTreeNode<Integer> treeInputBetter(boolean isRoot,int parentData,boolean isLeft){
        if(isRoot){
            //this will be executed once
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

    public static void printTree(BinaryTreeNode<Integer> root){
        //Take care of the  base case
        if(root==null){
            return;
        }
        System.out.println(root.data);

        printTree(root.left);
        printTree(root.right);
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

    public static void main(String[] args) {
//        BinaryTreeNode<Integer> root =new BinaryTreeNode<>(1);
//        BinaryTreeNode<Integer> rootLeft =new BinaryTreeNode<>(2);
//        BinaryTreeNode<Integer> rootRight =new BinaryTreeNode<>(3);
//        root.left=rootLeft;
//        root.right=rootRight;
//
//        BinaryTreeNode<Integer> twoRight =new BinaryTreeNode<>(4);
//        BinaryTreeNode<Integer> threeLeft =new BinaryTreeNode<>(5);
//
//        rootLeft.right= twoRight;
//        rootRight.left=threeLeft;
        BinaryTreeNode<Integer> root=treeInputBetter(true,0,false);
        printTreeDetailed(root);



    }
}
