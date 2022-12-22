//Given a binary search tree, the task is to flatten it to a sorted list. Precisely,
//        the value of each node must be lesser than the values of all the nodes at its right,
//        and its left node must be NULL after flattening. We must do it in O(H) extra space where ‘H’ is the height of BST.

package com.Binary_Search_Tree;

import com.Trees.BinaryTreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Flatten_BST_T0_LL {

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

    public static BinaryTreeNode<Integer> flatten_ll(BinaryTreeNode<Integer> root){
        ArrayList<Integer> inorder_list=new ArrayList<>();
        //to store inorder of bst in arraylist , as it will be sorted
        store_inorder_in_list(root,inorder_list);
        //now take the first element of arraylist , create first node of the answer node list
        BinaryTreeNode<Integer>  newRoot=new BinaryTreeNode<>(inorder_list.get(0));
        //store that new root in current as we need to traverse through array list
        //current will change
        BinaryTreeNode<Integer>  current= newRoot;
        //storing the size
        int size_of_inorder_list=inorder_list.size();
        //traversing through the list from i=1 as i =0 already stored in newRoot
        for(int i=1; i<size_of_inorder_list;i++){

            BinaryTreeNode<Integer>  temp=new BinaryTreeNode<>(inorder_list.get(i));
            //set current left ==null
            current.left=null;
            //set current right to temp, means next
            current.right=temp;
            //move the current
            current=temp;
        }
       //last step for final node as we need to set its left and right both null
        current.right=null;
        current.left=null;
        return newRoot;
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root=takeInputLevelwise();
        flatten_ll(root);

    }
}
