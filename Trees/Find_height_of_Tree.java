//Height Of Tree
//
//        For a given Binary Tree of integers, find and return the height of the tree.
//        Example:
//           10
//          /      \
//        20      30
//        /         \
//        40        50
//
//        Height of the given tree is 3.
//
//        Height is defined as the total number of nodes along the longest path from the root to any of the leaf node.
//        Input Format:
//        The first and the only line of input will contain the node data, all separated by a single space. Since -1 is used as an indication whether the left or right node data exist for root, it will not be a part of the node data.
//        Output Format:
//        The first and the only line of output prints the height of the given binary tree.
//        Note:
//        You are not required to print anything explicitly. It has already been taken care of.
//        Constraints:
//        0 <= N <= 10^5
//        Where N is the total number of nodes in the binary tree.
//
//        Time Limit: 1 sec
//        Sample Input 1:
//        10 20 30 40 50 -1 -1 -1 -1 -1 -1
//        Sample Output 1:
//        3
//        Sample Input 2:
//        3 -1 -1
//        Sample Output 2:
//        1
package com.Trees;

import java.util.Scanner;

//Height of Tree - longest distnace betwen root node and leaf of a tree

public class Find_height_of_Tree {
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
        //Base Case
        if(root==null){
            return 0;
        }
        int left=height_of_tree(root.left);
        int right=height_of_tree(root.right);
        return 1 + Math.max(left,right);
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root=treeInputBetter(true,0,false);
        System.out.println(height_of_tree(root));

    }
}
