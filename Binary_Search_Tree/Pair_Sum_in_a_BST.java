//Pair sum in a BST
//
//        Given a binary search tree and an integer S, find pair of nodes in the BST which sum to S.
//        You can use extra space of the order of O(log n).
//        Note:
//        1. Assume BST contains all unique elements.
//        2. In a pair, print the smaller element first.
//        Input Format :
//        The first line of input contains data of the nodes of the tree in level order form. The data of the nodes of the tree is separated by space. If any node does not have left or right child, take -1 in its place. Since -1 is used as an indication whether the left or right nodes exist, therefore, it will not be a part of the data of any node.
//        The following line of input contains an integer, that denotes the value of S.
//        Output format:
//        You have to print each pair in a different line (pair elements separated by space). The order of different pairs, to be printed, does not matter.
//        Constraints:
//        Time Limit: 1 second
//        Sample Input 1:
//        8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
//        12
//        Sample Output 1:
//        2 10
//        5 7

package com.Binary_Search_Tree;

import com.Trees.BinaryTreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Pair_Sum_in_a_BST {

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

    public static void isPairPresentHelper(BinaryTreeNode<Integer> root, int target,ArrayList<Integer> InorderVal){
        //performing inorder traversal to get the sorted array
        //base case
        if(root==null){
            return;
        }
        isPairPresentHelper(root.left,target,InorderVal);
        InorderVal.add(root.data);
        isPairPresentHelper(root.right,target,InorderVal);

    }

    public static boolean isPairPresent(BinaryTreeNode<Integer> root, int target){
        ArrayList<Integer> InorderVal=new ArrayList<>();
        //to store inorder of bst in array , as it will be sorted
        isPairPresentHelper(root,target,InorderVal);

        //use 2 pointer approach to check if pair exists
        int i=0 , j=InorderVal.size()-1;
        while(i<j){
            int sum=InorderVal.get(i) +InorderVal.get(j);
            if(sum==target){
                return true;
            }
            else if (sum > target){
                j--;
            }
            else{
                i++;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root=takeInputLevelwise();
        System.out.println(isPairPresent(root,19));

    }
}
