//Sum Of Nodes
//
//        For a given Binary Tree of integers, find and return the sum of all the nodes data.
//        Example:
//                10
//            /        \
//           20      30
//        /    \
//        40    50
//
//        When we sum up all the nodes data together, [10, 20, 30, 40 50] we get 150. Hence, the output will be 150.
//        Input Format:
//        The first and the only line of input will contain the nodes data, all separated by a single space. Since -1 is used as an indication whether the left or right node data exist for root, it will not be a part of the node data.
//        Output Format:
//        The first and the only line of output prints the sum of all the nodes data present in the binary tree.
//        Note:
//        You are not required to print anything explicitly. It has already been taken care of.
//        Constraints:
//        1 <= N <= 10^6
//        Where N is the total number of nodes in the binary tree.
//
//        Time Limit: 1 sec
//        Sample Input 1:
//        2 3 4 6 -1 -1 -1 -1 -1
//        Sample Output 1:
//        15
//        Sample Input 2:
//        1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1
//        Sample Output 2:
//        28
package com.Trees;

import java.util.Scanner;

public class Sum_OF_Nodes {
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

    public static int nodes_sum(BinaryTreeNode<Integer> root){
        if(root==null){
            return 0;
        }
        int leftSum=nodes_sum(root.left);
        int rightSum=nodes_sum(root.right);
        return root.data+leftSum+rightSum;
    }

    public static void main(String[] args) {

        BinaryTreeNode<Integer> root=treeInputBetter(true,0,false);
        System.out.println(nodes_sum(root));

    }
}
