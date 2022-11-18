//Construct BST
//
//        Given a sorted integer array A of size n, which contains all unique elements. You need to construct a balanced BST from this input array. Return the root of constructed BST.
//        Note: If array size is even, take first mid as root.
//        Input format:
//        The first line of input contains an integer, which denotes the value of n. The following line contains n space separated integers, that denote the values of array.
//        Output Format:
//        The first and only line of output contains values of BST nodes, printed in pre order traversal.
//        Constraints:
//        Time Limit: 1 second
//        Sample Input 1:
//        7
//        1 2 3 4 5 6 7
//        Sample Output 1:
//        4 2 1 3 6 5 7
package com.Binary_Search_Tree;
import com.Trees.BinaryTreeNode;

public class Construct_BST_from_sorted_Array {
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

    public static BinaryTreeNode<Integer> Construct_BST_helper(int arr[],int start, int end){
        //you need to have a base case
        if(start > end ){
            return null;
        }
        //we are dividing our array into half at every recursive call, so we are finding new mid everytime
        int mid_index=(start+end)/2;

        //will create a Node with middle elelment of array
        BinaryTreeNode<Integer> temp=new BinaryTreeNode<>(arr[mid_index]);

        //and rest recursion will do , by adjusting start and end values
        temp.left=Construct_BST_helper(arr,start,mid_index-1);
        temp.right=Construct_BST_helper(arr,mid_index+1,end );
        return temp;

    }
        public static BinaryTreeNode<Integer> Construct_BST(int arr[],int n){

        return Construct_BST_helper(arr,0,n-1);
    }


    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6,7,8};
        printTreeDetailed(Construct_BST(arr,8));

    }
}
