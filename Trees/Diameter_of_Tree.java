//Diameter Of Binary Tree
//
//        For a given Binary of type integer, find and return the ‘Diameter’.
//        Diameter of a Tree
//        The diameter of a tree can be defined as the maximum distance between two leaf nodes.
//        Here, the distance is measured in terms of the total number of nodes present along the path of the two leaf nodes, including both the leaves.
//        Example:
//        alt txt
//
//        The maximum distance can be seen between the leaf nodes 8 and 9.
//        The distance is 9 as there are a total of nine nodes along the longest path from 8 to 9(inclusive of both). Hence the diameter according to the definition will be 9.
//        Input Format:
//        The first and the only line of input will contain the node data, all separated by a single space. Since -1 is used as an indication whether the left or right node data exist for root, it will not be a part of the node data.
//        Output Format:
//        The only line of output prints an integer, representing the diameter of the tree.
//        Note:
//        You are not required to print anything explicitly. It has already been taken care of.
//        Constraints:
//        1 <= N <= 10^5
//        Where N is the total number of nodes in the binary tree.
//
//        Time Limit: 1 sec
//        Sample Input 1:
//        2 4 5 6 -1 -1 7 20 30 80 90 -1 -1 8 -1 -1 9 -1 -1 -1 -1 -1 -1
//        Sample Output 1:
//        9
//        Sample Input 2:
//        1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1
//        Sample Output 2:
//        5
package com.Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
//Intuition :
//Diameter - longest path between 2 leaf/ending nodes
//Here we have 3 options to calculate height of the tree
//1.leftheight+ rightheight
//But in some cases largest distance can be on either side of the root as
//distance should  not necessarily pass through root
//so we will ask recursion to do same step whatever we are doing at root
//and then compare and whatever max of 3 , will be the answer


public class Diameter_of_Tree {
    public static int height_of_tree(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        int left = height_of_tree(root.left);
        int right = height_of_tree(root.right);
        return 1 + Math.max(left, right);
    }

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



    //1st Approach
    //Time Complexity is coming O(n^2), can we improve to 0(n)
    public static int diameter_of_tree(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height_of_tree(root.left);
        int rightHeight = height_of_tree(root.right);
        int diameter_1 = 1 + leftHeight + rightHeight;

        int left = diameter_of_tree(root.left);
        int right = diameter_of_tree(root.right);

        return Math.max(Math.max(left, right), diameter_1);

    }


    //2nd Approach
    private static class Pair<T, T1> {
        int diameter;
        int height;

        public Pair(int diameter, int height) {
            this.diameter = diameter;
            this.height = height;
        }
    }
    //Time complexity is O(n)

    public static Pair diameterHelper(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return new Pair(0, 0);
        }

        Pair leftPair = diameterHelper(root.left);
        Pair rightPair = diameterHelper(root.right);

        int leftHeight = leftPair.height;
        int rightHeight = rightPair.height;
        int diamter_option_via_root = 1 + leftHeight + rightHeight;

        int leftoption = leftPair.diameter;
        int rightoption = rightPair.diameter;

        return new Pair(Math.max(diamter_option_via_root, Math.max(leftoption, rightoption)),Math.max(leftHeight,rightHeight)+1);

    }

    public static int diameter_of_tree_Optimised(BinaryTreeNode<Integer> root) {
        Pair pair = diameterHelper(root);
        return pair.diameter;
    }


    public static void main(String[] args) {
        BinaryTreeNode<Integer> root =takeInputLevelwise();
//        System.out.println(diameter_of_tree(root));
        System.out.println(diameter_of_tree_Optimised(root));


    }


}


