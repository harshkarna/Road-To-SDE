package com.Binary_Search_Tree;

import com.Trees.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Prdecessor_and_Sucessor_in_BST {

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

    //intuition
//    Input: root node, key
//    output: predecessor node, successor node
//
//     1. If root is NULL
//     then return
//     2. if key is found then
    //    a. If its left subtree is not null
    //    Then predecessor will be the right most
    //    child of left subtree or left child itself.
    //    b. If its right subtree is not null
    //    The successor will be the left most child
    //    of right subtree or right child itself.
    //    return
//     3. If key is smaller than root node
//    set the successor as root
//    search recursively into left subtree
//    else
//    set the predecessor as root
//    search recursively into right subtree
    static int successor =-1;
    static int predecessor =-1;

    public static void FindPredAndSucess(BinaryTreeNode<Integer> root,int key){
        //base case
        if(root==null){
            return;
        }
        //if key is present at the root
        if(root.data ==key){
            // The maximum value in left subtree is predecessor
            if (root.left != null)
            {
                //fining the maximum in left sunbtree
                BinaryTreeNode<Integer>  temp = root.left;
                while (temp.right != null){
                    temp = temp.right;
                }
                predecessor = temp.data;
            }
            // The minimum value in right subtree is successor
            if (root.right != null)
            {
                BinaryTreeNode<Integer>  temp = root.right;
                while (temp.left != null){
                    temp = temp.left;
                }
                successor = temp.data;
            }
            return;
        }
        // If key is smaller than root's key, go to left subtree
        if (root.data > key)
        {
            //setting current root as potential successor before searching in left subtree
            //as if the root has both child then above root condition will themselves find
            //succ and pred
            //but suppose if node has one child i.e left , then right will return -1 , but at
            //case we need to set the lowest ancestor of that root as successor .
            //thats we are setting potential successor and predecessor
            successor = root.data;
            FindPredAndSucess(root.left, key);
        }

        // Go to right subtree
        else
        {
            //setting current root as potential predecessor before searching in left subtree
            predecessor = root.data;
            FindPredAndSucess(root.right, key);
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root=takeInputLevelwise();
        FindPredAndSucess(root,3);
        //5 3 8 2 -1 6 10 -1 -1 -1 -1 -1 -1 -1 -1
        System.out.println(" predecessor - "+ predecessor + " successor - " + successor);

    }
}
