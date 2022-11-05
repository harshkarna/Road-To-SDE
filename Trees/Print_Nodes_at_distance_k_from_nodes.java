//Print nodes at distance k from node
//
//        You are given a Binary Tree of type integer, a target node, and an integer value K.
//        Print the data of all nodes that have a distance K from the target node. The order in which they would be printed will not matter.
//        Example:
//        For a given input tree(refer to the image below):
//        1. Target Node: 5
//        2. K = 2
//        alt txt
//
//        Starting from the target node 5, the nodes at distance K are 7 4 and 1.
//        Input Format:
//        The first line of input will contain the node data, all separated by a single space.
//        Since -1 is used as an indication whether the left or right node data exist for root, it will not be a part of the node data.
//
//        The second line of input contains two integers separated by a single space, representing the value of the target node and K, respectively.
//        Output Format:
//        All the node data at distance K from the target node will be printed on a new line.
//
//        The order in which the data is printed doesn't matter.
//        Constraints:
//        1 <= N <= 10^5
//        Where N is the total number of nodes in the binary tree.
//
//        Time Limit: 1 sec
//        Sample Input 1:
//        5 6 10 2 3 -1 -1 -1 -1 -1 9 -1 -1
//        3 1
//        Sample Output 1:
//        9
//        6
//        Sample Input 2:
//        1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1
//        3 3
//        Sample Output 2:
//        4
//        5

package com.Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Print_Nodes_at_distance_k_from_nodes {

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
    public static void print_nodes_at_k(BinaryTreeNode<Integer> root,int target, int k){
        if(root==null){
            return;
        }
        if(k==0){
            System.out.println(root.data);
        }
        if(root.data==target){
            print_nodes_at_k(root.left,target,k-1);
            print_nodes_at_k(root.right,target,k-1);
        }

    }


    public static void main(String[] args) {

        BinaryTreeNode<Integer> root=takeInputLevelwise();



    }
}
