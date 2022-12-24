package com.Binary_Search_Tree;

import com.Trees.BinaryTreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Merge_2_BST {

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

    public static void print_Levelwise(BinaryTreeNode<Integer> root){

        Queue<BinaryTreeNode<Integer>> pendingChildren=new LinkedList<>();
        pendingChildren.add(root);

        while(!pendingChildren.isEmpty()){
            BinaryTreeNode<Integer> front=pendingChildren.poll();
            System.out.print(front.data +":L:");
            if(front.left!=null){
                pendingChildren.add(front.left);
                System.out.print(front.left.data + ",R");
            }
            else{
                System.out.print(-1 + ",R:");
            }
            if(front.right!=null){
                pendingChildren.add(front.right);
                System.out.println(front.right.data);
            }
            else{
                System.out.println(-1);
            }
        }
    }


    public static void store_inorder_in_list(BinaryTreeNode<Integer> root, ArrayList<Integer> InorderVal){
        //performing inorder traversal to get the sorted array
        //base case
        if(root==null){
            return;
        }
        store_inorder_in_list(root.left,InorderVal);
        InorderVal.add(root.data);
        store_inorder_in_list(root.right,InorderVal);
    }

    private static ArrayList<Integer> mergeArrays(ArrayList<Integer> a, ArrayList<Integer> b) {
          ArrayList<Integer> ans=new ArrayList<>(a.size()+ b.size());
          int i=0,j=0;
          int k=0;
         while( i< a.size() && j < b.size()){
            if(a.get(i) < b.get(j)){
                ans.add(a.get(i));
                i++;
            }
            else{
                ans.add(b.get(j));
                j++;
            }
        }
        while(i< a.size()){
            ans.add(a.get(i));
            i++;
        }
        while(j < b.size()){
            ans.add(b.get(j));
            j++;
        }

        return ans;

    }

    public static BinaryTreeNode<Integer> inorder_to_bst(int start, int end ,ArrayList<Integer> inorder_list){
        //base case
        if(start > end) {
            return null;
        }
        int mid =(start+end)/2;
        BinaryTreeNode<Integer> root=new BinaryTreeNode<>(inorder_list.get(mid));
        root.left= inorder_to_bst(start,mid-1,inorder_list);
        root.right=inorder_to_bst(mid+1,end,inorder_list);
        return root;
    }


    public static BinaryTreeNode<Integer> mergeBST(BinaryTreeNode<Integer> root1,BinaryTreeNode<Integer> root2){
        //step 1 : store inorder  - o(m)
        ArrayList<Integer> bst1=new ArrayList<>();
        ArrayList<Integer> bst2=new ArrayList<>();
        store_inorder_in_list(root1,bst1);
        store_inorder_in_list(root2,bst2);


        //step 2 - merge both arrays
        ArrayList<Integer> mergedArray=mergeArrays(bst1,bst2);

        //step 3 - use merged array to built inorder
        int s=0,e=mergedArray.size()-1;
        return inorder_to_bst(s,e,mergedArray);

    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root1=takeInputLevelwise();
        System.out.println("enter second tree");
        BinaryTreeNode<Integer> root2=takeInputLevelwise();
        print_Levelwise(mergeBST(root1,root2));
        //5 1 6 -1 -1 -1 -1 8 4 9 -1 -1 -1 -1
    }
}
