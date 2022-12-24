//Largest BST
//
//        Given a Binary tree, find the largest BST subtree. That is, you need to find the BST with maximum height in
//        the given binary tree. You have to return the height of largest BST.
//        Input format :
//        The first line of input contains data of the nodes of the tree in level order form. The data of the nodes
//        of the tree is separated by space. If any node does not have left or right child, take -1 in its place. Since -1 is used as an indication whether the left or right nodes exist, therefore, it will not be a part of the data of any node.
//        Output format:
//        The first and only line of output contains the height of the largest BST.
//        Constraints:
//        Time Limit: 1 second
//        Sample Input 1:
//        5 10 6 2 3 -1 -1 -1 -1 -1 9 -1 -1
//        Sample Output 1:
//        2

package com.Binary_Search_Tree;

import com.Trees.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//Approach :
//1st Approach and bruteforce is that on root itself we can check if whole tree is BST then just return the height.
//and if not then call left and right recursive and take max from both an return.
//Pseudo code:

//        if(isBST(root){
//        height(root)
//            }
//        else{
//            a=LargestBST(left);
//            b= LargestBST(right);
//        }
//       return max (a,b);
//Now the issue here is Tc as here at every node we are checking if its Bst or not and getting the height as well so n2

//2nd Approach :
//this approach that we will create a helper function we can return me 4 value of a node at one time
//- min, max ,isBST, height


public class  Largest_BST_1 {

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

    static class nodeInfo{
        int max;
        int min;
        int height;
        boolean isBST;

//        public nodeInfo(int max, int min, int height, boolean isBST) {
//            this.max = max;
//            this.min = min;
//            this.height = height;
//            this.isBST = isBST;
//        }

    }

    public static nodeInfo largestBSTSubtreeHelper(BinaryTreeNode<Integer> root){
        // Base case : When the current subtree is empty or
        // the node corresponds to a null.
        if(root==null){
            nodeInfo ans=new nodeInfo();
            ans.max=Integer.MIN_VALUE;
            ans.min=Integer.MAX_VALUE;
            ans.isBST= true;
            ans.height=0;
            return ans;
        }

        // We will here do the postorder traversal since we
        // want our left and right subtrees to be computed
        // first.

        // Recur for left subtree and right subtrees
        nodeInfo left= largestBSTSubtreeHelper(root.left);
        nodeInfo right= largestBSTSubtreeHelper(root.right);

        // Create a new nodeInfo variable to store info
        // about the current node.
        nodeInfo currentNode=new nodeInfo();
        currentNode.min = Math.min(left.min, root.data);
        currentNode.max = Math.max(right.max, root.data);
        currentNode.isBST = left.isBST && right.isBST && root.data > left.max && root.data < right.min;

        /*
        If suppose the left and right subtrees of the
        current node are BST and the current node value is
        greater than the maximum value in the left subtree
        and also the current node value is smaller that the
        minimum value in the right subtree (Basic conditions
        for the formation of BST) then our whole subtree
        with the root as current root can be consider as a
        BST. Hence the size of the BST will become size of
        left BST subtree + size of right BST subtree +
        1(adding current node).

        Else we will consider the largest of the left BST or
        the  right BST.
        */

        /*We need to find maximum height BST subtree then
        adding the height of left an right subtree will not
        give the maximum height, we need to find max.
        */

        if (currentNode.isBST)

            // Calculate the size of subtree if
            // this is a BST
            currentNode.height = left.height + right.height + 1;
        else
            currentNode.height  = Math.max(left.height, right.height);

        return currentNode;

    }

    public static int largestBSTSubtree(BinaryTreeNode<Integer> root){
        return largestBSTSubtreeHelper(root).height;
    }


    public static void main(String[] args) {
        BinaryTreeNode<Integer> root=takeInputLevelwise();
        System.out.println(largestBSTSubtree(root));


    }
}
