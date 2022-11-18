//Elements Between K1 and K2
//
//        Given a Binary Search Tree and two integers k1 and k2, find and print the elements which are in range k1 and k2 (both inclusive).
//        Print the elements in increasing order.
//        Input format:
//        The first line of input contains data of the nodes of the tree in level order form.
//        The data of the nodes of the tree is separated by space. If any node does not have left or right child, take -1 in its place. Since -1 is used as an indication whether the left or right nodes exist, therefore, it will not be a part of the data of any node.
//        The following line contains two integers, that denote the value of k1 and k2.
//        Output Format:
//        The first and only line of output prints the elements which are in range k1 and k2 (both inclusive).
//        Print the elements in increasing order.
//        Constraints:
//        Time Limit: 1 second
//        Sample Input 1:
//        8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
//        6 10
//        Sample Output 1:
//        6 7 8 10

package com.Binary_Search_Tree;

import com.Trees.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Elements_between_K1_and_K2 {
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

    public static void print_val_bw_k1_and_k2(BinaryTreeNode<Integer> root, int k1, int k2){
        if(root==null){
            return;
        }
        if(root.data > k2 ){
            print_val_bw_k1_and_k2(root.left,k1,k2);
        }
        else if(root.data < k1){
            print_val_bw_k1_and_k2(root.right,k1,k2);
        }
        else{
            print_val_bw_k1_and_k2(root.left,k1,k2);
            System.out.println(root.data +" ");
            print_val_bw_k1_and_k2(root.right,k1,k2);

        }

    }


    public static void main(String[] args) {
        BinaryTreeNode<Integer> root=takeInputLevelwise();
        print_val_bw_k1_and_k2(root,6,10);


    }
}
