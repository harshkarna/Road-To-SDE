package com.Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Check_if_Trees_are_identical {

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

    public static boolean isIdentical(BinaryTreeNode<Integer> root1,BinaryTreeNode<Integer> root2){
        //Tc=O(N)
        // base case
        if(root1 == null && root2 == null) {
            return true;
        }

        //if either of them
        if((root1 == null && root2 != null )||( root1 != null && root2 == null)) {
            return false;
        }

        boolean check_current= root1.data.equals(root2.data);

        boolean left = isIdentical(root1.left, root2.left);
        boolean right = isIdentical(root1.right, root2.right);

        return (check_current && left && right);

    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root1=takeInputLevelwise();
        BinaryTreeNode<Integer> root2=takeInputLevelwise();
        System.out.println(isIdentical(root1,root2));

    }
}
