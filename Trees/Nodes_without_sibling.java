//Nodes without sibling
//
//        For a given Binary Tree of type integer, print all the nodes without any siblings.
//        Input Format:
//        The first and the only line of input will contain the node data, all separated by a single space. Since -1 is used as an indication whether the left or right node data exist for root, it will not be a part of the node data.
//        Output Format:
//        The only line of output prints the node data in a top to down fashion with reference to the root.
//        Node data in the left subtree will be printed first and then the right subtree.
//        A single space will separate them all.
//        Constraints:
//        1 <= N <= 10^5
//        Where N is the total number of nodes in the binary tree.
//
//        Time Limit: 1 second
//        Sample Input 1:
//        5 6 10 2 3 -1 -1 -1 -1 -1 9 -1 -1
//        Sample Output 1:
//        9
//        Sample Input 2:
//        2 4 5 6 -1 -1 7 20 30 80 90 -1 8 9 -1 -1 -1 -1 -1 -1 -1 -1 -1
//        Sample Output 2:
//        6 8 7 9
//        Explanation of Sample Input 2:
//        The input tree when represented in a two-dimensional plane, it would look like this:
//        alt txt
//
//        In respect to the root, node data in the left subtree that satisfy the condition of not having a sibling would be 6 and 8, taken in a top-down sequence. Similarly, for the right subtree, 7 and 9 are the node data without any sibling.
//
//        Since we print the siblings in the left-subtree first and then the siblings from the right subtree, taken in a top-down fashion, we print 6 8 7 9.

package com.Trees;

import java.util.Scanner;

public class Nodes_without_sibling {

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
    public static void nodes_without_siblings (BinaryTreeNode<Integer> root){
        if(root==null){
            return;
        }
        if((root.left !=null) && (root.right ==null)){
            System.out.print(root.left.data +" ");
        }
        else if((root.left ==null) && (root.right !=null)){
            System.out.print(root.right.data +" ");
        }
        nodes_without_siblings(root.left);
        nodes_without_siblings(root.right);
    }

    public static void main(String[] args) {

        BinaryTreeNode<Integer> root=treeInputBetter(true,0,false);
        nodes_without_siblings(root);


    }
}
