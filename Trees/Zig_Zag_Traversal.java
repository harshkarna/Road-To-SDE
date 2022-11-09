package com.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Zig_Zag_Traversal {

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

    public static ArrayList<Integer> zigZagTraversal(BinaryTreeNode<Integer> root){

        ArrayList <Integer> ans= new ArrayList<>();
        if(root==null){
            return ans;
        }
        Queue<BinaryTreeNode<Integer>> pendingChildren=new LinkedList<>();
        pendingChildren.add(root);
        boolean left_to_right=true;

        while(!pendingChildren.isEmpty()){

            int size =pendingChildren.size();

           //Taking temp  array to store each level answer
            int temp[] = new int[size];

            //Process each level
            for(int i=0;i<size;i++){
                BinaryTreeNode<Integer> frontNode=pendingChildren.peek();
                pendingChildren.poll();

                int index=left_to_right ? i : size - i-1;
                temp[index]= frontNode.data;

                if(frontNode.left!=null){
                    pendingChildren.add(frontNode.left);
                }
                if(frontNode.right!=null){
                    pendingChildren.add(frontNode.right);
                }
            }

            //Direction Change
            left_to_right = !left_to_right;

            //Copy karo main ans mein ek level ka answer
            for (int k = 0; k < temp.length; k++) {
                ans.add(temp[k]);
            }

        }
        return ans;

    }


    public static void main(String[] args) {

        BinaryTreeNode<Integer> root=takeInputLevelwise();
        //1 2 3 -1 -1 4 5 -1 -1 -1 -1
//        0 1 2 4 5 3 6 -1 -1 7 -1 -1 -1 -1 -1 -1 -1
        ArrayList <Integer> arr=zigZagTraversal(root);
        System.out.println(arr);
        System.out.println();
        for(int i=0;i<arr.size();i++){
            System.out.print(arr.get(i)+" ");
        }

    }
}
