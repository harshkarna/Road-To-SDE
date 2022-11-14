//Given a binary tree and an integer K. Find the number of
// paths in the tree which have their sum equal to K.
//A path may start from any node and end at any node in the downward direction.

package com.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class K_Sum_Paths {
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
    static int count;
    public static void  solve(BinaryTreeNode<Integer> root, int k, ArrayList<Integer> path){
        ///Base case
        if(root==null){
            return;
        }
        ///push root data in path
        path.add(root.data);

        //now lets recursion handle left and right subtree nodes
        solve(root.left, k,path);
        solve(root.right, k,path);

        //now ate every step you will for a list ,
        //and now you need to to  backtrack(leaf node to root) so loop will run in reverse order
        int size=path.size();
        int sum=0;
        for(int i=size-1;i>=0;i--){
            sum=sum+path.get(i);
            if(sum==k){
                count++;
            }
        }

        //remove the last node , as while going up
        path.remove(path.size()-1);

    }

    public static int sumk(BinaryTreeNode<Integer> root, int k){
        ArrayList<Integer> path=new ArrayList<>();
        solve(root, k, path);
        System.out.println(path.size());
        return count;
    }

      public static void main(String[] args) {
        BinaryTreeNode<Integer> root=takeInputLevelwise();
        System.out.println(sumk(root,3));


    }
}
