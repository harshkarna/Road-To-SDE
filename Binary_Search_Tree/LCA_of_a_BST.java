//LCA of BST
//
//        Given a binary search tree and data of two nodes, find 'LCA' (Lowest Common Ancestor) of the given two nodes
//        in the BST.
//        LCA
//        LCA of two nodes A and B is the lowest or deepest node which has both A and B as its descendants.
//        Example:
//        In this example, the green coloured node is the LCA to A and B.
//        Alt Text
//
//        Note:
//        It is defined that each node is a descendant to itself, so, if there are two nodes X and Y and X has a
//        direct connection from Y, then Y is the lowest common ancestor.
//        Example:
//        Alt Text
//
//        Note:
//        1. If out of 2 nodes only one node is present, return that node.
//        2. If both are not present, return -1.
//        Input format:
//        The first line of input contains data of the nodes of the tree in level order form. The data of the nodes of
//        the tree is separated by space. If any node does not have left or right child, take -1 in its place.
//        Since -1 is used as an indication whether the left or right nodes exist, therefore, it will not be a part of the data of any node.
//        The following line of input contains two integers, denoting the value of data of two nodes of given BST.
//        Output Format:
//        The first and only line of output contains the data associated with the lowest common ancestor node.
//        Constraints:
//        Time Limit: 1 second
//        Sample Input 1:
//        8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
//        2 10
//        Sample Output 1:
//        8
//        Sample Input 2:
//        8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
//        2 6
//        Sample Output 2:
//        5
//        Sample Input 3:
//        8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
//        12 78
//        Sample Output 3:
//        -1
package com.Binary_Search_Tree;

import com.Trees.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class LCA_of_a_BST {

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

    //this is the approach we followed for Tree in past.
    //same can be applied here , but we can use the property of BST and write more efficient solution.
//    public static BinaryTreeNode<Integer> lca_bst(BinaryTreeNode<Integer> root, int n1 , int n2){
//        if(root==null){
//            return null;
//        }
//
//        if(root.data==n1 || root.data ==n2){
//            return root;
//        }
//        //Now rest leaves on recursion
//        BinaryTreeNode<Integer> left=lca_bst(root.left,n1,n2);
//        BinaryTreeNode<Integer> right=lca_bst(root.right,n1,n2);
//
//        //2nd check
//        //left null means both a and b lies in right subtree
//        if(left==null){
//            return right;
//        }
//        if(right==null){
//            return left;
//        }
//        return root;
//
//    }



    //Intuition
    //The idea is that , we can use BST property . While traversing the tree from the top to bottom the first node which lies
    // in between the two numbers n1 and n2 is the LCA of the nodes, i.e. the first node n with the lowest depth which lies in
    // between n1 and n2 (n1<=n<=n2) n1<n2. So just recursively traverse the BST , if node’s value is greater than both n1 and n2
    // then our LCA lies in the left side of the node, if it is smaller than both n1 and n2, then LCA lies on the right side.
    // Otherwise, the root is LCA (assuming that both n1 and n2 are present in BST)
    public static BinaryTreeNode<Integer> LCA(BinaryTreeNode<Integer> root, int n1, int n2)
    {
        //base case
        if (root == null) {
            return null;
        }

        //If both n1 and n2 are smaller than data at current node, we call
        //the function recursively for finding LCA in the left subtree.
        if (root.data > n1 && root.data > n2)
        {
            return LCA(root.left, n1, n2);
        }
        //If both n1 and n2 are greater than data at current node, we call
        //the function recursively for finding LCA in the right subtree.
        if (root.data < n1 && root.data < n2)
        {
            return LCA(root.right, n1, n2);
        }
        //returning the lowest common ancestor.
        return root;
    }


    public static void main(String[] args) {

        BinaryTreeNode<Integer> root=takeInputLevelwise();
        int n1=2;
        int n2=10;
        BinaryTreeNode<Integer> ans=LCA(root,n1,n2);
        System.out.println(ans.data);

    }
}
