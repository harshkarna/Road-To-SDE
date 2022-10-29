//Replace Node With Depth
//
//        For a given a Binary Tree of integers, replace each of its data with the depth of the tree.
//        Root is at depth 0, hence the root data is updated with 0. Replicate the same further going down the in the depth of the given tree.
//        The modified tree will be printed in the in-order fashion.
//        Example:
//        Alt text
//
//        The above tree after updating will look like this:
//        Alt text
//
//        Output: 2 1 2 0 2 1 2 (printed in the in-order fashion)
//        Input Format:
//        The first and the only line of input will contain the node data, all separated by a single space. Since -1 is used as an indication whether the left or right node data exist for root, it will not be a part of the node data.
//        Output Format:
//        The first and the only line of output prints the updated tree in the in-order fashion.
//        Note:
//        You are not required to print anything explicitly. It has already been taken care of.
//        Constraints:
//        1 <= N <= 10^5
//        Where N is the total number of nodes in the binary tree.
//
//        Time Limit: 1sec
//        Sample Input 1:
//        2 35 10 2 3 5 2 -1 -1 -1 -1 -1 -1 -1 -1
//        Sample Output 1:
//        2 1 2 0 2 1 2
//        Sample Input 2:
//        1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1
//        Sample Output 2:
//        2 1 2 0 2 1 2

package com.Trees;

import java.util.Scanner;

public class Replace_node_with_depth {
    public static BinaryTreeNode<Integer> treeInputBetter(boolean isRoot,int parentData,boolean isLeft){
        if(isRoot){
            System.out.println("Enter root data");
        }
        else {
            if(isLeft){
                System.out.println("Enter left child of " + parentData);
            }
            else {
                System.out.println("Enter right child of " + parentData);
            }
        }
        Scanner sc=new Scanner(System.in);
        int rootData=sc.nextInt();
        if(rootData==-1){
            return null;
        }
        BinaryTreeNode<Integer> root =new BinaryTreeNode<>(rootData);
        BinaryTreeNode<Integer> leftChild =treeInputBetter(false,rootData,true);
        BinaryTreeNode<Integer> rightChild =treeInputBetter(false ,rootData,false);
        root.left=leftChild;
        root.right=rightChild;
        return root;

    }
    public static void printTreeDetailed(BinaryTreeNode<Integer> root){
        //Take care of the base case
        if(root==null){
            return;
        }
        System.out.print(root.data + ":");

        if(root.left!=null){
            System.out.print("L" + root.left.data + ",");
        }
        if(root.right!=null){
            System.out.print("R" + root.right.data);
        }

        System.out.println();

        printTreeDetailed(root.left);
        printTreeDetailed(root.right);
    }
    public static BinaryTreeNode<Integer> replace_node_with_depth(BinaryTreeNode<Integer> root, int level){
        if(root==null){
            return null;
        }
        root.data=level;
        replace_node_with_depth(root.left,level+1);
        replace_node_with_depth(root.right, level+1);
        return root;
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root=treeInputBetter(true,0,false);
        printTreeDetailed(replace_node_with_depth(root, 0));

    }
}
