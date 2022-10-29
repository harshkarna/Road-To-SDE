//Is node present?
//
//        For a given Binary Tree of type integer and a number X, find whether a node exists in the tree with data X or not.
//        Input Format:
//        The first and the only line of input will contain the node data, all separated by a single space.
//        Since -1 is used as an indication whether the left or right node data exist for root, it will not be a part of the node data.
//        Output Format:
//        The only line of output prints 'true' or 'false'.
//        Note:
//        You are not required to print anything explicitly. It has already been taken care of.
//        Constraints:
//        1 <= N <= 10^5
//        Where N is the total number of nodes in the binary tree.
//
//        Time Limit: 1 sec
//        Sample Input 1:
//        8 3 10 1 6 -1 14 -1 -1 4 7 13 -1 -1 -1 -1 -1 -1 -1
//        7
//        Sample Output 1:
//        true
//        Sample Input 2:
//        2 3 4 -1 -1 -1 -1
//        10
//        Sample Output 2:
//        false

package com.Trees;

import java.util.Scanner;

public class IsNodePresent {

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
    public static boolean isNodePresent(BinaryTreeNode<Integer> root, int x){
        if(root==null){
            return false;
        }
        if(root.data==x){
            return true;
        }
        return (isNodePresent(root.left,x) || isNodePresent(root.right,x));
//         or

        /* boolean checkLeft= isNodePresent(root.left,x);
        boolean checkRight=isNodePresent(root.right,x);
        if (checkRight || checkLeft ){
            return true;
        }
        else{
            return false;
        }*/



    }

    public static void main(String[] args) {

        BinaryTreeNode<Integer> root=treeInputBetter(true,0,false);
        System.out.println(isNodePresent(root,5));


    }

}
