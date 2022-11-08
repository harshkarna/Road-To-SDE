package com.Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Print_in_all_types_of_Traversal {

    public static BinaryTreeNode<Integer> takeInputLevelwise(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Root data ");
        int rootdata= sc.nextInt();
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

    public static void inorder(BinaryTreeNode<Integer> root){
        if(root==null){
            return;
        }
        //Inorder
        //First Left , then root , then right
        inorder(root.left);
        System.out.print(root.data +" ");
        inorder(root.right);
    }

    public static void preorder(BinaryTreeNode<Integer> root){
        if(root==null){
            return;
        }
        //First Root , then left , then right
        System.out.print(root.data +" ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void postorder(BinaryTreeNode<Integer> root){
        if(root==null){
            return;
        }
        //First left , then right , then root
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data +" ");
    }


    public static void main(String[] args) {

        BinaryTreeNode<Integer> root=takeInputLevelwise();
        System.out.print("Inorder -> ");
        inorder(root);
        System.out.println();
        System.out.print("Preorder -> ");
        preorder(root);
        System.out.println();
        System.out.print("Postorder -> ");
        postorder(root);

    }
}
