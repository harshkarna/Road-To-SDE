//Given a Binary Tree, find its Boundary Traversal. The traversal should be in the following order:
//
//        Left boundary nodes: defined as the path from the root to the left-most node ie-
//        the leaf node you could reach when you always travel preferring the left subtree over the right subtree.

//        Leaf nodes: All the leaf nodes except for the ones that are part of left or right boundary.
//        Reverse right boundary nodes: defined as the path from the right-most node to the root.

//        The right-most node is the leaf node you could reach when you always travel preferring the right subtree over
//        the left subtree. Exclude the root from this as it was already included in the traversal of left boundary nodes.
//        Note: If the root doesn't have a left subtree or right subtree, then the root itself is the left or right boundary.


package com.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boundary_Traversal {

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

    public static void traverseLeft(BinaryTreeNode<Integer> root, ArrayList<Integer> ans){
        //Base case
        if(root==null){
            return;
        }
        //If encounter leaf node dont print it , and return
        if(root.left==null && root.right==null){
            return;
        }
        //Add current data in ans array
        ans.add(root.data);

        //Now have recursion call for the rest nodes
        if(root.left!=null){
            traverseLeft(root.left,ans);
        }
        else{
            traverseLeft(root.right,ans);
        }
    }

    public static void traverseleaf(BinaryTreeNode<Integer> root,ArrayList<Integer> ans){
        ///base case{
        if(root==null){
            return;
        }
        //If encounter leaf node print it ,and return
        if(root.left==null && root.right==null){
            ans.add(root.data);
            return;
        }

        //Now have recursion call for other leaf nodes
        traverseleaf(root.left,ans);
        traverseleaf(root.right,ans);

    }

    public static void traverseRight(BinaryTreeNode<Integer> root,ArrayList<Integer> ans){
        //Base case
        if(root==null){
            return;
        }
        //If encounter leaf node dont print it , and return
        if(root.left==null && root.right==null){
            return;
        }
        //Firt have recusrion call as we need to start from second last and come above in tree towarsd root
        if(root.right!=null){
            traverseRight(root.right,ans);
        }
        else{
            traverseRight(root.left,ans);
        }
        //jab waapas aane lago last leaf node se
        ans.add(root.data);
    }

    public static ArrayList<Integer> boundaryTraversal(BinaryTreeNode<Integer> root){
        ArrayList <Integer> ans= new ArrayList<>();
        if(root==null){
            return null;
        }
        //sabse pehle root ka data enter in ans
        ans.add(root.data);

        //now go for left
        traverseLeft(root.left,ans);

        //dout - why cant we have all leaf nodes at once - give 1 only it will print root twice
        //left subtree ke leaf nodes
        traverseleaf(root.left,ans);
        //right subtree ke leaf nodes
        traverseleaf(root.right,ans);

        //Now go for right
        traverseRight(root.right,ans);

        return ans;

    }

    public static void main(String[] args) {

        BinaryTreeNode<Integer> root=takeInputLevelwise();
        ArrayList<Integer> ans=boundaryTraversal(root);
        System.out.println(ans);
    }
}
