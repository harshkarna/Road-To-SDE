//Postorder Binary Tree
//
//        For a given Binary Tree of integers, print the post-order traversal.
//        Input Format:
//        The first and the only line of input will contain the node data, all separated by a single space. Since -1 is used as an indication whether the left or right node data exist for root, it will not be a part of the node data.
//        Output Format:
//        The only line of output prints the post-order traversal of the given binary tree.
//        Constraints:
//        1 <= N <= 10^6
//        Where N is the total number of nodes in the binary tree.
//
//        Time Limit: 1 sec
//        Sample Input 1:
//        1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1
//        Sample Output 1:
//        4 5 2 6 7 3 1
//        Sample Input 2:
//        5 6 10 2 3 -1 -1 -1 -1 -1 9 -1 -1
//        Sample Output 1:
//        2 9 3 6 10 5

package com.Trees;

import java.util.Scanner;

public class Post_Order_Traversal {

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

    public static void printTree(BinaryTreeNode<Integer> root){
        //Take care of the  base case
        if(root==null){
            return;
        }
        printTree(root.left);
        printTree(root.right);
        System.out.println(root.data);

    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root=treeInputBetter(true,0,false);
        printTree(root);


    }

}
