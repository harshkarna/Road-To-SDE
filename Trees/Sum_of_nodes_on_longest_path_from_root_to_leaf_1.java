//Given a binary tree of size N. Your task is to complete the function sumOfLongRootToLeafPath(),
// that find the sum of all nodes on the longest path from root to leaf node.
//        If two or more paths compete for the longest path, then the path having
//        maximum sum of nodes is being considered.

package com.Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Sum_of_nodes_on_longest_path_from_root_to_leaf_1 {


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

    //below one is how we can do from pair class
//     public int sumOfLongRootToLeafPath(Node root)
//     {
//         IntegerWrapper maxSumAndLevel = new IntegerWrapper(0, Integer.MIN_VALUE);
//         longestPathSumOfNodes(root, 0, 0, maxSumAndLevel);
//         return maxSumAndLevel.maxSum;
//     }
//     public static void longestPathSumOfNodes(Node root, int sum, int level, IntegerWrapper maxSumAndLevel) {
//         if (root == null) {
//             if (level > maxSumAndLevel.maxLevel) {
//                 maxSumAndLevel.maxLevel = level;
//                 maxSumAndLevel.maxSum = sum;
//             } else if (level == maxSumAndLevel.maxLevel) {
//                 maxSumAndLevel.maxSum = Math.max(sum, maxSumAndLevel.maxSum);
//             }
//             return;
//         }
//         sum += root.data;
//         longestPathSumOfNodes(root.left, sum, level + 1, maxSumAndLevel);
//         longestPathSumOfNodes(root.right, sum, level + 1, maxSumAndLevel);
//     }
// }
//   class IntegerWrapper {
//     int maxSum;
//     int maxLevel;

//     IntegerWrapper(int maxSum, int maxLevel) {
//         this.maxSum = maxSum;
//         this.maxLevel = maxLevel;
//     }

    //as we want to retain these 2 variables across
    //and also there is no pass by reference in java so we are having these globally
    static int maxSum=Integer.MIN_VALUE;
    static int maxLength=0;

    public  static void solve(BinaryTreeNode<Integer> root, int length, int sum) {
        //check for the base case
        if(root==null){
            return;
        }
        // 2nd base case
        //now if you have reached leaf node check current status for max length and max sum and before that
        //add leaf node value
        if(root.left==null && root.right==null){
            //add leaf node value to current sum
            sum=sum+root.data;
            if(length > maxLength){
                //if current length is greater than max length just replace both
                maxLength=length;
                maxSum=sum;
            }
            else if(length==maxLength){
                //if length become equal then compare the current sum and max sum value and replace it
                maxSum=Math.max(maxSum,sum);
            }
            return;
        }
        //adding current node data
        sum=sum+root.data;

        solve(root.left,length+1,sum);
        solve(root.right,length+1,sum);

    }

    public static int sumOfLongRootToLeafPath(BinaryTreeNode<Integer> root){

       int length=0;
       int sum=0;
       solve(root,length,sum);
        System.out.println("maxLength  - " + maxLength);
       return maxSum;

    }

    public static void main(String[] args) {
//        4 1 5 N 2 N N N 3
        //4 2 5 7 1 2 3 -1 -1 6 -1 -1 -1 -1 -1 -1 -1
        BinaryTreeNode<Integer> root=takeInputLevelwise();
        System.out.println(sumOfLongRootToLeafPath(root));


    }
}
