//Nodes Greater Than X
//
//        For a given a binary tree of integers and an integer X, find and return the total number
//        of nodes of the given binary tree which are having data greater than X.
//        Input Format:
//        The first line of input will contain the node data, all separated by a single space.
//        Since -1 is used as an indication whether the left or right node data exist for root, it will not be a part of the node data.
//
//        The second line of input contains an integer, denoting the value of X.
//        Note:
//        You are not required to print anything explicitly. It has already been taken care of.
//        Output Format:
//        The only line of output prints the total number of nodes where the node data is greater than X.
//        Constraints:
//        1 <= N <= 10^5
//        Where N is the total number of nodes in the binary tree.
//
//        Time Limit: 1 sec
//        Sample Input 1:
//        1 4 2 3 -1 -1 -1
//        2
//        Sample Output 1:
//        2
//        Explanation for Sample Input 1:
//        Out of the four nodes of the given binary tree, [3, 4] are the node data that are greater than X = 2.
//        Sample Input 2:
//        5 6 10 2 3 -1 -1 -1 -1 -1 9 -1 -1
//        5
//        Sample Output 2:
//        3
package com.Trees;

import java.util.Scanner;

public class Nodes_greater_than_x {

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

    public static int nodes_greater_than_x(BinaryTreeNode<Integer> root, int x){
        if(root==null){
            return 0;
        }
        int left=nodes_greater_than_x(root.left,x);
        int right=nodes_greater_than_x(root.right,x);
        if(root.data>x){
            return 1+left+right;
        }
        else{
            return left+right;
        }

    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root=treeInputBetter(true,0,false);
        System.out.println(nodes_greater_than_x(root,3));

    }
}
