//Level order traversal
//
//        For a given a Binary Tree of type integer, print it in a level order
//        fashion where each level will be printed on a new line. Elements on every level will
//        be printed in a linear fashion and a single space will separate them.
//        Example:
//        alt txt
//
//        For the above-depicted tree, when printed in a level order fashion, the output would look like:
//
//        10
//        20 30
//        40 50 60
//        Where each new line denotes the level in the tree.
//        Input Format:
//        The first and the only line of input will contain the node data, all separated by a single space
//        . Since -1 is used as an indication whether the left or right node data exist for root, it will not be a part of the node data.
//        Output Format:
//        The given input tree will be printed in a level order fashion where each level will be printed on a new line.
//        Elements on every level will be printed in a linear fashion. A single space will separate them.
//        Constraints:
//        1 <= N <= 10^5
//        Where N is the total number of nodes in the binary tree.
//
//        Time Limit: 1 sec
//        Sample Input 1:
//        10 20 30 40 50 -1 60 -1 -1 -1 -1 -1 -1
//        Sample Output 1:
//        10
//        20 30
//        40 50 60
//        Sample Input 2:
//        8 3 10 1 6 -1 14 -1 -1 4 7 13 -1 -1 -1 -1 -1 -1 -1
//        Sample Output 2:
//        8
//        3 10
//        1 6 14
//        4 7 13

package com.Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Level_Order_Traversal {
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
    public static void level_order_traversal(BinaryTreeNode<Integer> root){
        if(root==null){
            return;
        }
        Queue<BinaryTreeNode<Integer>> pendingChildren=new LinkedList<>();
        pendingChildren.add(root);
        pendingChildren.add(null);
        while(!pendingChildren.isEmpty()){
            BinaryTreeNode<Integer> front=pendingChildren.poll();
            if(front!=null){
                System.out.print(front.data +" ");
            }
            else{
                if(pendingChildren.isEmpty()){
                    break;
                }
                else{
                    pendingChildren.add(null);
                    System.out.println();
                    continue;
                }
            }
            if(front.left!=null){
                pendingChildren.add(front.left);
            }
            if(front.right!=null){
                pendingChildren.add(front.right);
            }
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root=takeInputLevelwise();
        level_order_traversal(root);


    }
}
