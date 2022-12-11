package com.Binary_Search_Tree;

import com.Trees.BinaryTreeNode;
import com.sun.java.swing.plaf.windows.WindowsTextAreaUI;

public class BST {
     private BinaryTreeNode<Integer> root;
     //we want our size to dynamically update , as we want whenever insert or delete happens size should change ,and we
    //do not have tp write a full function for size
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
         size++;
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


     //Now lets talk about delete , and discuss all scenerios
     private  static int smallest(BinaryTreeNode<Integer> root){
         if(root==null){
             return Integer.MAX_VALUE;
         }
         int rootData=root.data;
         int leftMAx=smallest(root.left);
         int rightMax=smallest(root.right);

         return Math.min(rootData,Math.min(leftMAx,rightMax));

     }

    private static BSTReturn deleteDataHelper(BinaryTreeNode<Integer> root, int x){
         //firts case is root is null
         if(root==null){
             return new BSTReturn(null,false);
         }
         //2nd case if x is greater than root data
        if(root.data < x){
            BSTReturn outputRight=deleteDataHelper(root.right,x);
            root.right=outputRight.root;
            outputRight.root=root;
            return outputRight;
        }
        //3rd case if x smaller than root data
        if(root.data > x){
            BSTReturn outputLeft=deleteDataHelper(root.left,x);
            root.left=outputLeft.root;
            outputLeft.root=root;
            return outputLeft;
        }

        //if root has no child
        if(root.right==null && root.left==null){
            return new BSTReturn(null,true);
        }

        //only left child
        if(root.right==null && root.left!=null){
            return new BSTReturn(root.left,true);
        }
        //only righjt child
        if(root.right!=null && root.left==null){
            return new BSTReturn(root.right,true);
        }

        //if both child are present
        int rightMin=smallest(root.right);
        root.data =rightMin;
        BSTReturn outputRight=deleteDataHelper(root.right,rightMin);
        root.right=outputRight.root;
        return new BSTReturn(root,true);

    }

     public boolean deleteData(int x){
         BSTReturn output=deleteDataHelper(root, x);
         if(output.isDeleted){
             size--;
         }
         return output.isDeleted;

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
