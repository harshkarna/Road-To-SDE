//Path Sum Root to Leaf
//
//        For a given Binary Tree of type integer and a number K,
//        print out all root-to-leaf paths where the sum of all the node data along the path is equal to K.
//        Example:
//        alt txt
//
//        If you see in the above-depicted picture of Binary Tree, we see that there are a total of two paths,
//        starting from the root and ending at the leaves which sum up to a value of K = 13.
//
//        The paths are:
//        a. 2 3 4 4
//        b. 2 3 8
//
//        One thing to note here is, there is another path in the right sub-tree in reference to the root,
//        which sums up to 13 but since it doesn't end at the leaf, we discard it.
//        The path is: 2 9 2(not a leaf)
//        Input Format:
//        The first line of input will contain the node data, all separated by a single space.
//        Since -1 is used as an indication whether the left or right node data exist for root, it will not be a part of the node data.
//
//        The second line of input contains an integer value K.
//        Output Format:
//        Lines equal to the total number of paths will be printed. All the node data in every path will be printed in a
//        linear fashion taken in the order they appear from top to down bottom in the tree. A single space will separate them all.
//        Constriants:
//        1 <= N <= 10^5
//        0 <= K <= 10^8
//        Where N is the total number of nodes in the binary tree.
//
//        Time Limit: 1 second
//        Sample Input 1:
//        2 3 9 4 8 -1 2 4 -1 -1 -1 6 -1 -1 -1 -1 -1
//        13
//        Sample Output 1:
//        2 3 4 4
//        2 3 8
//        Sample Input 2:
//        5 6 7 2 3 -1 1 -1 -1 -1 9 -1 -1 -1 -1
//        13
//        Sample Output 2:
//        5 6 2
//        5 7 1
//

package com.Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Path_Sum_To_Leaf {

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
    public  static void  path_sum_to_leaf(BinaryTreeNode<Integer> root,int k ,String str){
        if(root==null){

            return;
        }

        //in string we will store the path
        str=str+" "+root.data;
        //when we encounter leaf node , will check if that leaf node value is equal to k ,
        // as every recursive call , we are decreasing k by that node value
        if(root.left==null && root.right==null){
            if(root.data==k){
                System.out.println(str);
            }
        }
        path_sum_to_leaf(root.left,k-root.data,str);
        path_sum_to_leaf(root.right,k-root.data,str);

    }


    public static void main(String[] args) {
        BinaryTreeNode<Integer> root=takeInputLevelwise();
        path_sum_to_leaf(root,13,"");



    }
}
