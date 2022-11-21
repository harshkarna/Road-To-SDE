package com.Binary_Search_Tree;

import com.Trees.BinaryTreeNode;
import com.sun.java.swing.plaf.windows.WindowsTextAreaUI;

public class BST {
     private BinaryTreeNode<Integer> root;
     private int size;

     // doubt - why static here
     private static boolean isPresentHelper(BinaryTreeNode<Integer> root, int x) {
         if(root==null){
             return false;
         }
         if(root.data==x){
             return true;
         }
         if(root.data > x){
             //call on left
             return isPresentHelper(root.left,x);
         }
         else{
             //call on right
             return isPresentHelper(root.right,x);
         }
     }

     public boolean isPresent(int x){
         return isPresentHelper(root,x);
     }



     public void insert(int x){
         //as our might get change , so we need to update our root
         root=insertHelper(root,x);
     }

     private static  BinaryTreeNode<Integer> insertHelper(BinaryTreeNode<Integer> root, int x) {
         if (root == null) {
             BinaryTreeNode<Integer> newRoot = new BinaryTreeNode<>(x);
             return newRoot;
         }
         if (x < root.data) {
//             BinaryTreeNode<Integer> left = insertHelper(root.left, x);
//             root.left = left;
//             or
             root.left= insertHelper(root.left, x);

         } else {
             root.right = insertHelper(root.right, x);

         }
         return root;
     }

     public boolean deleteData(int x){
         return false;

     }


     public int size(){
         return size;
     }


     public void printTree(){

         printTreeHelper(root);

     }
    private void printTreeHelper(BinaryTreeNode<Integer> root) {

            //Take care of the base case
            if(root==null){
                return;
            }
            System.out.print(root.data + ":");

            if(root.left!=null){
                System.out.print("L" + root.left.data + ",");
            }
            if(root.right!=null){
                System.out.print("R" + root.right.data);
            }

            System.out.println();

            printTreeHelper(root.left);
            printTreeHelper(root.right);

    }

}
