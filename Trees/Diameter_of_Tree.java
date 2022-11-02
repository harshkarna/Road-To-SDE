//Diameter Of Binary Tree
//
//        For a given Binary of type integer, find and return the ‘Diameter’.
//        Diameter of a Tree
//        The diameter of a tree can be defined as the maximum distance between two leaf nodes.
//        Here, the distance is measured in terms of the total number of nodes present along the path of the two leaf nodes, including both the leaves.
//        Example:
//        alt txt
//
//        The maximum distance can be seen between the leaf nodes 8 and 9.
//        The distance is 9 as there are a total of nine nodes along the longest path from 8 to 9(inclusive of both). Hence the diameter according to the definition will be 9.
//        Input Format:
//        The first and the only line of input will contain the node data, all separated by a single space. Since -1 is used as an indication whether the left or right node data exist for root, it will not be a part of the node data.
//        Output Format:
//        The only line of output prints an integer, representing the diameter of the tree.
//        Note:
//        You are not required to print anything explicitly. It has already been taken care of.
//        Constraints:
//        1 <= N <= 10^5
//        Where N is the total number of nodes in the binary tree.
//
//        Time Limit: 1 sec
//        Sample Input 1:
//        2 4 5 6 -1 -1 7 20 30 80 90 -1 -1 8 -1 -1 9 -1 -1 -1 -1 -1 -1
//        Sample Output 1:
//        9
//        Sample Input 2:
//        1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1
//        Sample Output 2:
//        5
package com.Trees;

import java.util.Scanner;
//Intuition :
//Here we have 3 options to calculate height of the tree
//1.leftheight+ rightheight
//But in some cases largest distance can be on either side of the root as
//distance should  not necessarily pass through root
//so we will ask recursion to do same step whatever we are doing at root
//and then compare and whatever max of 3 , will be the answer

public class Diameter_of_Tree {
    public static int height_of_tree(BinaryTreeNode<Integer> root){
        if(root==null){
            return 0;
        }
        int left=height_of_tree(root.left);
        int right=height_of_tree(root.right);
        return 1 + Math.max(left,right);
    }
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

    public static int diameter_of_tree(BinaryTreeNode<Integer> root){
        if(root==null){
            return 0 ;
        }
        int leftHeight=height_of_tree(root.left);
        int rightHeight=height_of_tree(root.right);
        int diameter_1=leftHeight+rightHeight;

        int left=diameter_of_tree(root.left);
        int right=diameter_of_tree(root.right);

        return Math.max(Math.max(left,right),diameter_1);

    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root=treeInputBetter(true,0,false);
        System.out.println(diameter_of_tree(root));


    }
}
