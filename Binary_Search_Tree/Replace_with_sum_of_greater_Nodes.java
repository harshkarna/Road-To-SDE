//Replace with Sum of greater nodes
//
//        Given a binary search tree, you have to replace each node's data with the sum of all nodes which are greater
//        or equal than it. You need to include the current node's data also.
//        That is, if in given BST there is a node with data 5, you need to replace it with sum of its data (i.e. 5)
//        and all nodes whose data is greater than or equal to 5.
//        Note: You don't need to return or print, just change the data of each node.
//        Input format:
//        The first line of input contains data of the nodes of the tree in level order form. The data of the nodes
//        of the tree is separated by space. If any node does not have left or right child, take -1 in its place. Since -1 is used as an indication whether the left or right nodes exist, therefore, it will not be a part of the data of any node.
//        Output format:
//        In the output, data of the nodes of the tree are printed in level order form. Each level of the tree is printed on a separate line.
//        Constraints:
//        Time Limit: 1 second
//        Sample Input 1 :
//        8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
//        Sample Output 1 :
//        18
//        36 10
//        38 31
//        25
package com.Binary_Search_Tree;

import com.Trees.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Replace_with_sum_of_greater_Nodes {


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

    //Intuition :
    //we all know  that inrorder of bst gives us in sorted order , here we are applying reverse inorder
    //hence starting from rightmost elemnt , firts we are taking that roots data in sum , (sum initially =0), then we are
    //replacing root'data with that sum .First it will solve right , then node , the laft part.

    //A simple method for solving this is to find the sum of all greater values for every node. This method would take O(n^2) time.
    //The method discussed in this article uses the technique of reverse in-order tree traversal of BST which optimizes
    // the problem to be solved in a single traversal.
    //Approach: In this problem as we could notice that the largest node would remain the same. The value of 2nd
    // largest node = value of largest + value of second largest node. Similarly, the value of nth largest node will
    // be the sum of the n-th node and value of (n-1)th largest node after modification. So if we traverse the tree in descending
    // order and simultaneously update the sum value at every step while adding the value to the root node, the problem would be solved.
    //So to traverse the BST in descending order we use reverse in-order traversal of BST. This takes a global
    // variable sum which is updated at every node and once the root node is reached it is added to the value of
    // root node and value of the root node is updated.
    static int sum=0;
    public static BinaryTreeNode<Integer> replace_with_sum_of_greater_Nodes(BinaryTreeNode<Integer> root){
        if(root==null){
            return null;
        }
        BinaryTreeNode<Integer> right=  replace_with_sum_of_greater_Nodes(root.right);

        sum=sum+root.data;
        root.data = sum;

        BinaryTreeNode<Integer> left= replace_with_sum_of_greater_Nodes(root.left);

        root.right=right;
        root.left=left;
        return root;

    }

    public static void main(String[] args) {
        //50 30 70 20 40 60 80 -1 -1 -1 -1 -1 -1 -1 -1
        BinaryTreeNode<Integer> root=takeInputLevelwise();
         print_Levelwise(replace_with_sum_of_greater_Nodes(root));
//        print_Levelwise(root);

    }
}
