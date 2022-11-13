package com.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Left_View_of_Binary_Tree {

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

    public static void leftViewhelper(BinaryTreeNode<Integer> root, int level, ArrayList<Integer> ans){
        //base case
        if(root==null){
           return;
        }
        //now do for the current node rest recursion will take care
        //Now we need to figure out how the recursion will now one level has been passed
        if(level == ans.size()){
            //we entered into a new level
            ans.add(root.data);
        }

        leftViewhelper(root.left,level+1,ans);
        leftViewhelper(root.right,level+1,ans);

    }


    public static ArrayList<Integer> leftView(BinaryTreeNode<Integer> root){
        //we can solve this by level order traversal also , as we have seen in earlier cases for top view and bottom view ,
        //and also we can use map / arraylist in level order traversal
        // but lets try to solve this tim eby recursion

        int level=0;
        ArrayList<Integer> ans=new ArrayList<>();
        leftViewhelper(root, level,ans);
        return ans;

    }


    public static void main(String[] args) {
        BinaryTreeNode<Integer> root=takeInputLevelwise();
        ArrayList<Integer> ans=leftView(root);
        System.out.println(ans);


    }
}
