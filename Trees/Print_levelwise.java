//Print Levelwise
//
//        For a given a Binary Tree of type integer, print the complete information of every node, when traversed in a level-order fashion.
//        To print the information of a node with data D, you need to follow the exact format :
//
//        D:L:X,R:Y
//
//        Where D is the data of a node present in the binary tree.
//        X and Y are the values of the left(L) and right(R) child of the node.
//        Print -1 if the child doesn't exist.
//        Example:
//        alt text
//
//        For the above depicted Binary Tree, the level order travel will be printed as followed:
//
//        1:L:2,R:3
//        2:L:4:,R:-1
//        3:L:5:,R:6
//        4:L:-1:,R:7
//        5:L:-1:,R:-1
//        6:L:-1:,R:-1
//        7:L:-1:,R:-1
//
//        Note: There is no space in between while printing the information for each node.
//        Input Format:
//        The first and the only line of input will contain the node data, all separated by a single space. Since -1 is used as an indication whether the left or right node data exist for root, it will not be a part of the node data.
//        Output Format:
//        Information of all the nodes in the Binary Tree will be printed on a different line where each node will follow a format of D:L:X,R:Y, without any spaces in between.
//        Constraints:
//        1 <= N <= 10^5
//        Where N is the total number of nodes in the binary tree.
//
//        Time Limit: 1 sec
//        Sample Input 1:
//        8 3 10 1 6 -1 14 -1 -1 4 7 13 -1 -1 -1 -1 -1 -1 -1
//        Sample Output 1:
//        8:L:3,R:10
//        3:L:1,R:6
//        10:L:-1,R:14
//        1:L:-1,R:-1
//        6:L:4,R:7
//        14:L:13,R:-1
//        4:L:-1,R:-1
//        7:L:-1,R:-1
//        13:L:-1,R:-1
//        Sample Input 2:
//        1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1
//        Sample Output 2:
//        1:L:2,R:3
//        2:L:4,R:5
//        3:L:6,R:7
//        4:L:-1,R:-1
//        5:L:-1,R:-1
//        6:L:-1,R:-1
//        7:L:-1,R:-1



package com.Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Print_levelwise {
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

    public static void main(String[] args) {

        BinaryTreeNode<Integer> root=takeInputLevelwise();
        print_Levelwise(root);


    }
}
