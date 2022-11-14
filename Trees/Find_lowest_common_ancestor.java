//Given a Binary Tree with all unique values and two nodes value, n1 and n2.
// The task is to find the lowest common ancestor of the given two nodes.
// We may assume that either both n1 and n2 are present in the tree or none of them are present.
//
// LCA: It is the first common ancestor of both the nodes n1 and n2 from bottom of tree.

package com.Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Find_lowest_common_ancestor {

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

//    lets talk abou the approcah to solve this problem
//    1. 1st approach -
//    Get the path from root to n1 and n2 , and the inbetween nodes in their path in separate arraylist
//    Now , you can start traversing from   end , means from leaf to start , and whenever you encouter
//    first matching elemnet thats  a LCA.
//    But the problem is here 3 traversal same time ,thus increasing the tc
//    1st travesring every node , and then comparing 2 arraylist


//    2.2nd Approach , TC=On
//    Now this this intuitive approcah
//    We know our lCA can be found in 4 use case
//    1.either currentnode=  a || currentnode = b
//    2.either one a in left subtree and another one  b in right subtree
//    3.both a and b can be in any one subtree
//    4.None of a and b in any subtree.

    public static BinaryTreeNode<Integer> lca(BinaryTreeNode<Integer>  root, int n1 , int n2 ){
        //base case
        if(root==null){
            return null;
        }
        //Now this 1st check on root
        if(root.data==n1 || root.data ==n2){
            return root;
        }

        //Now rest leaves on recursion
        BinaryTreeNode<Integer> left=lca(root.left,n1,n2);
        BinaryTreeNode<Integer> right=lca(root.right,n1,n2);

        //2nd check
        //left null means both a and b lies in right subtree
        if(left==null){
            return right;
        }
        if(right==null){
            return left;
        }
        return root;

    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root=takeInputLevelwise();
        int n1=3;
        int n2=5;
        BinaryTreeNode<Integer> ans=lca(root,n1,n2);
        System.out.println(ans.data);


    }
}
