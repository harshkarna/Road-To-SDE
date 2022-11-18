//Search In BST
//
//        Given a BST and an integer k. Find if the integer k is present in given BST or not. You have to return true, if node with data k is present, return false otherwise.
//        Note: Assume that BST contains all unique elements.
//        Input Format:
//        The first line of input contains data of the nodes of the tree in level order form. The data of the nodes of the tree is separated by space. If any node does not have left or right child, take -1 in its place. Since -1 is used as an indication whether the left or right nodes exist, therefore, it will not be a part of the data of any node.
//        The following line of input contains an integer, that denotes the value of k.
//        Output Format:
//        The first and only line of output contains a boolean value. Print true, if node with data k is present, print false otherwise.
//        Constraints:
//        Time Limit: 1 second
//        Sample Input 1 :
//        8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
//        2
//        Sample Output 1 :
//        true
//        Sample Input 2 :
//        8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
//        12
//        Sample Output 2 :
//        false

package com.Binary_Search_Tree;

import com.Trees.BinaryTreeNode;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Search_in_BST {
    public static BinaryTreeNode<Integer> takeInputLevelwise(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Root data ");
        int rootdata= sc.nextInt();
        //This is for if main root is null
        if(rootdata == -1){
            return null;
        }

        BinaryTreeNode<Integer> root=new BinaryTreeNode<>(rootdata);
        Queue<BinaryTreeNode<Integer>> pendingChildren=new LinkedList<>();
        pendingChildren.add(root);

        while(!pendingChildren.isEmpty()){
            BinaryTreeNode<Integer> front= pendingChildren.poll();

            System.out.println("Enter left Child of " + front.data);
            int left= sc.nextInt();
            if(left!=-1){
                BinaryTreeNode<Integer> leftChild=new BinaryTreeNode<Integer>(left);
                front.left=leftChild;
                pendingChildren.add(leftChild);
            }
            System.out.println("Enter Right Child of " + front.data);
            int right= sc.nextInt();
            if(right!=-1){
                BinaryTreeNode<Integer> rightChild=new BinaryTreeNode<Integer>(right);
                front.right=rightChild;
                pendingChildren.add(rightChild);
            }
        }
        return root;
    }
    public static boolean searchInBST(BinaryTreeNode<Integer> root, int k){
        if(root==null){
            return false;
        }
        if(root.data==k){
            return true;
        }

        if(k<root.data) {
            return searchInBST(root.left, k);
        }
        else{
            return searchInBST(root.right,k);
        }

    }


    public static void main(String[] args) {
        BinaryTreeNode<Integer> root=takeInputLevelwise();
        System.out.println(searchInBST(root,12));


    }
}
