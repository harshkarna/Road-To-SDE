//Create & Insert Duplicate Node
//
//        For a given a Binary Tree of type integer, duplicate every node of the tree and attach it to the left of itself.
//        The root will remain the same. So you just need to insert nodes in the given Binary Tree.
//        Example:
//        alt txt
//
//        After making the changes to the above-depicted tree, the updated tree will look like this.
//        alt txt
//
//        You can see that every node in the input tree has been duplicated and inserted to the left of itself.
//        Input format :
//        The first and the only line of input will contain the node data, all separated by a single space.
//        Since -1 is used as an indication whether the left or right node data exist for root, it will not be a part of the node data.
//        Output Format :
//        The updated tree will be printed in a level order fashion where each level will be printed on a new line.
//        Elements on every level will be printed in a linear fashion. A single space will separate them.
//        Note:
//        You are not required to print anything explicitly. It has already been taken care of. Just implement the function to achieve the desired structure of the tree.
//        Constraints :
//        1 <= N <= 10^5
//        Where N is the total number of nodes in the binary tree.
//
//        Time Limit: 1 sec
//        Sample Input 1:
//        10 20 30 40 50 -1 60 -1 -1 -1 -1 -1 -1
//        Sample Output 1:
//        10
//        10 30
//        20 30 60
//        20 50 60
//        40 50
//        40
//        Sample Input 2:
//        8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
//        Sample Output 2:
//        8
//        8 10
//        5 10
//        5 6
//        2 6 7
//        2 7
package com.Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Create_and_insert_duplicate_node {
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
    public static void print_Levelwise(BinaryTreeNode<Integer> root){

        Queue<BinaryTreeNode<Integer>> pendingChildren=new LinkedList<>();
        pendingChildren.add(root);

        while(!pendingChildren.isEmpty()){
            BinaryTreeNode<Integer> front=pendingChildren.poll();
            System.out.print(front.data +":L:");
            if(front.left!=null){
                pendingChildren.add(front.left);
                System.out.print(front.left.data + ",R");
            }
            else{
                System.out.print(-1 + ",R:");
            }
            if(front.right!=null){
                pendingChildren.add(front.right);
                System.out.println(front.right.data);
            }
            else{
                System.out.println(-1);
            }
        }
    }

    public static void double_Tree(BinaryTreeNode<Integer> root){
        if(root==null){
            return;
        }

        //Doubt in below line
        BinaryTreeNode<Integer> new_Node=new BinaryTreeNode<>(root.data);
        BinaryTreeNode<Integer> rootLeft=root.left;
        root.left=new_Node;
        new_Node.left=rootLeft;

        double_Tree(rootLeft);
        double_Tree(root.right);

    }


    public static void main(String[] args) {
        BinaryTreeNode<Integer> root=takeInputLevelwise();
        print_Levelwise(root);
        System.out.println();
        double_Tree(root);
        print_Levelwise(root);


    }
}
