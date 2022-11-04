//Minimum and Maximum in the Binary Tree
//
//        For a given a Binary Tree of type integer, find and return the minimum and the maximum data values.
//        Return the output as an object of Pair class, which is already created.
//        Note:
//        All the node data will be unique and hence there will always exist a minimum and maximum node data.
//        Input Format:
//        The first and the only line of input will contain the node data, all separated by a single space.
//        Since -1 is used as an indication whether the left or right node data exist for root, it will not be a part of the node data.
//        Output Format:
//        The only line of output prints two integers denoting the minimum and the maximum data values respectively.
//        A single line will separate them both.
//        Constraints:
//        2 <= N <= 10^5
//        Where N is the total number of nodes in the binary tree.
//
//        Time Limit: 1 sec
//        Sample Input 1:
//        8 3 10 1 6 -1 14 -1 -1 4 7 13 -1 -1 -1 -1 -1 -1 -1
//        Sample Output 1:
//        1 14
//        Sample Input 2:
//        10 20 60 -1 -1 3 50 -1 -1 -1 -1
//        Sample Output 2:
//        3 60

package com.Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Min_and_max_in_the_BinaryTree {
    public static BinaryTreeNode<Integer> takeInputLevelwise(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Root data ");
        int rootdata= sc.nextInt();
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


    public static int max_and_Min(BinaryTreeNode<Integer> root){
        if(root==null){
            return Integer.MIN_VALUE;
        }
        int rootData=root.data;
        int leftMAx=max_and_Min(root.left);
        int rightMax=max_and_Min(root.right);

        return Math.max(rootData,Math.max(leftMAx,rightMax));

    }


    public static void main(String[] args) {
        BinaryTreeNode<Integer> root=takeInputLevelwise();
        System.out.println((max_and_Min(root)));

    }
}
