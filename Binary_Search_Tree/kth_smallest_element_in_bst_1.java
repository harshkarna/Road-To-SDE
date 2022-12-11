package com.Binary_Search_Tree;

import com.Trees.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class kth_smallest_element_in_bst_1 {

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

    // this can be one of the solutions ,we need to do inorder traversal
    //but even if we are getting the answer still we are searching entire BST that hurts here

    static  int count=0;
    public static  int  KthSmallestElementHelper(BinaryTreeNode<Integer> root, int k){
        //base case
        if(root==null){
            return -1;
        }
        // search in left subtree
        int left= KthSmallestElementHelper(root.left,k);
        // if k'th smallest is found in left subtree, return it
        if(left!=-1){
            return left;
        }

        // if current element is k'th smallest, return it
        count++;
        if(k==count){
            return root.data;
        }

        return KthSmallestElementHelper(root.right,k);

    }

    public static int KthSmallestElement(BinaryTreeNode<Integer> root, int k){
       return KthSmallestElementHelper(root,k);

    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root=takeInputLevelwise();
        System.out.println(KthSmallestElement(root,2));
    }
}
