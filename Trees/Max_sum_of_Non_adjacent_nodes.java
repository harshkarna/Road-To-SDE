//Given a binary tree with a value associated with each node,
// we need to choose a subset of these nodes such that sum of chosen nodes is maximum under
// a constraint that no two chosen node in subset should be directly connected that is,
// if we have taken a node in our sum then we can’t take its any children or parents in consideration and vice versa.

package com.Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Max_sum_of_Non_adjacent_nodes {

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
    private static class Pair<T, T1> {
        int include;
        int exclude;

        public Pair(int include, int exclude) {
            this.include = include;
            this.exclude= exclude;
        }
    }


    public static Pair solve(BinaryTreeNode<Integer> root){

        if(root==null){
            return new Pair(0,0);
        }

        //we have two options i.e. include or exclulde
        Pair left = solve(root.left);
        Pair right = solve(root.right);
        //if we include root then sum of the exclude part of the left and right subtree with root data
        int includeRoot = root.data+left.exclude+right.exclude;
        //if we exclude root then we can take the include part or exlude part of left and right subtree
        //for maximum sum, we take the the max
        int excludeRoot = Math.max(left.include,left.exclude)+Math.max(right.include,right.exclude);
        return new Pair(includeRoot,excludeRoot);
    }

    static int getMaxSum(BinaryTreeNode<Integer> root)
    {
        // add your code here
        Pair p = solve(root);
        //we have to return maximum value. so,we have to decide which value have to be taken include or exclude part
        return Math.max(p.include,p.exclude);
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root=takeInputLevelwise();
        System.out.println(getMaxSum(root));
    }
}
