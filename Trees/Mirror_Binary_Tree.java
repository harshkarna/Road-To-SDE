//Mirror Binary Tree
//
//        For a given Binary Tree of type integer, update it with its corresponding mirror image.
//        Example:
//        Alt text
//
//        Input Format:
//        The first and the only line of input will contain the node data, all separated by a single space. Since -1 is used as an indication whether the left or right node data exist for root, it will not be a part of the node data.
//        Output Format:
//        The only line of output prints the mirrored tree in a level-wise order.
//        Each level will be printed on a new line. Elements printed at each level will be separated by a single line.
//        Note:
//        You are not required to print anything explicitly. It has already been taken care of.
//        Constraints:
//        1 <= N <= 10^5
//        Where N is the total number of nodes in the binary tree.
//
//        Time Limit: 1 sec
//        Sample Input 1:
//        1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1
//        Sample Output 1:
//        1
//        3 2
//        7 6 5 4
//        Sample Input 2:
//        5 10 6 2 3 -1 -1 -1 -1 -1 9 -1 -1
//        Sample Output 2:
//        5
//        6 10
//        3 2
//        9

package com.Trees;

import java.util.Scanner;

public class Mirror_Binary_Tree {

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

    public static BinaryTreeNode<Integer> mirrpr_binary_tree(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return null;
        }
        BinaryTreeNode<Integer> temp = root.left;
        root.left = root.right;
        root.right = temp;
        mirrpr_binary_tree(root.left);
        mirrpr_binary_tree(root.right);
        return root;
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root=treeInputBetter(true,0,false);
        printTreeDetailed(mirrpr_binary_tree(root));


    }
}
