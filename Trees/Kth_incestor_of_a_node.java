package com.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Kth_incestor_of_a_node {


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



//    public static void kthAncestor(BinaryTreeNode<Integer> root, int k , int node){
//
//
//    }



// Need to try by kth sum by approach
//    static int ans;
//    public static void solve(BinaryTreeNode<Integer> root, int k, int node, ArrayList<Integer> path) {
//      if(root==null){
//          return;
//      }
//      path.add(root.data);
//
//      solve(root.left, k,node,path);
//      solve(root.right, k,node ,path);
//
//      if(root.data==node && k<=path.size()) {
//          int size=path.size();
//          for(int i=size-1;i>=size-k-1;i--){
//              ans=path.get(i);
//          }
//       }
//      else if(root.data==node && k > path.size()){
//          ans=-1;
//      }
//        path.remove(path.size()-1);
//    }
//
//    public static int kthAncestor(BinaryTreeNode<Integer> root,int k , int node){
//        ArrayList<Integer> path=new ArrayList<>();
//        solve(root,k,node,path);
//        return ans;
//
//    }


    public static void main(String[] args) {
        BinaryTreeNode<Integer> root=takeInputLevelwise();
//        System.out.println(kthAncestor(root,2,4));


    }
}
