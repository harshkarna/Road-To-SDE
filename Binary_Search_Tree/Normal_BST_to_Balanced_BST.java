package com.Binary_Search_Tree;

import com.Trees.BinaryTreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Normal_BST_to_Balanced_BST {

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

    public static void store_inorder_in_list(BinaryTreeNode<Integer> root, ArrayList<Integer> InorderVal){
        //performing inorder traversal to get the sorted array
        //base case
        if(root==null){
            return;
        }
        store_inorder_in_list(root.left,InorderVal);
        InorderVal.add(root.data);
        store_inorder_in_list(root.right,InorderVal);

    }

    public static BinaryTreeNode<Integer> inorder_to_bst(int start, int end ,ArrayList<Integer> inorder_list){
        //base case
        if(start > end) {
            return null;
        }
        int mid =(start+end)/2;
        BinaryTreeNode<Integer> root=new BinaryTreeNode<>(inorder_list.get(mid));
        root.left= inorder_to_bst(start,mid-1,inorder_list);
        root.right=inorder_to_bst(mid+1,end,inorder_list);
        return root;
    }


    public static BinaryTreeNode<Integer> buildBalancedTree(BinaryTreeNode<Integer> root){
        ArrayList<Integer> inorder_list=new ArrayList<>();
        //to store inorder of bst in arraylist , as it will be sorted
        store_inorder_in_list(root,inorder_list);
        return inorder_to_bst(0,inorder_list.size()-1,inorder_list);
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root=takeInputLevelwise();
        buildBalancedTree(root);

    }
}
