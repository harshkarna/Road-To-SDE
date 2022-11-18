//BST to LL
//
//        Given a BST, convert it into a sorted linked list. You have to return the head of LL.
//        Input format:
//        The first and only line of input contains data of the nodes of the tree in level order form.
//        The data of the nodes of the tree is separated by space. If any node does not have left or right child,
//        take -1 in its place. Since -1 is used as an indication whether the left or right nodes exist,
//        therefore, it will not be a part of the data of any node.
//        Output Format:
//        The first and only line of output prints the elements of sorted linked list.
//        Constraints:
//        Time Limit: 1 second
//        Sample Input 1:
//        8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
//        Sample Output 1:
//        2 5 6 7 8 10


package com.Binary_Search_Tree;

import com.Linked_List.Node;
import com.Trees.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BST_To_LL {


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

    public static  void print_LL(Node<Integer> head) {
        //Printing Linked List
        //Note : good practice is keeping head in temp and iterate over temp
        Node<Integer> temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    static class Pair_of_Node_element{
        Node <Integer> head;
        Node <Integer> tail;

        public Pair_of_Node_element(Node<Integer> head, Node<Integer> tail) {
            this.head = head;
            this.tail = tail;
        }

        public Pair_of_Node_element() {

        }
    }


//    public static Pair_of_Node_element BST_to_LL_helper(BinaryTreeNode<Integer> root){
//        //base case
//        if(root==null){
//            return new Pair_of_Node_element(null,null);
//        }
//        Node<Integer> newNode =new Node<>(root.data);
//        Pair_of_Node_element left=BST_to_LL_helper(root.left);
//        Pair_of_Node_element right=BST_to_LL_helper(root.right);
//        //creating the answer pair
//        Pair_of_Node_element headAndTail=new Pair_of_Node_element();
//
//        //doubt---
//        //we have alreday linked 3 parts here , then we cant simply return left.head;
//        if(left.tail!=null){
//            left.tail.next=newNode;
//        }
//        newNode.next= right.head;
//
//        //checking if left part is null or not , if not null then attach its tail ka next to newNode
//        if(left.head!=null){
//           headAndTail.head = left.head;
//        }
//        else{
//            headAndTail.head=newNode;
//        }
//        //checking if right part is null or not , if not null then attach its tail ka next to newNode
//        if(right.tail!=null){
//            headAndTail.tail=right.tail;
//        }
//        else{
//            headAndTail.tail=newNode;
//        }
//        return headAndTail;
//
//    }
    public static Pair_of_Node_element BST_to_LL_helper(BinaryTreeNode<Integer> root){
        //base case
        if(root==null){
            return new Pair_of_Node_element(null,null);
        }
        Node<Integer> newNode =new Node<>(root.data);
        Pair_of_Node_element left=BST_to_LL_helper(root.left);
        Pair_of_Node_element right=BST_to_LL_helper(root.right);
        //creating the answer pair
        Pair_of_Node_element headAndTail=new Pair_of_Node_element();

        //doubt---
        //we have alreday linked 3 parts here , then we cant simply return left.head;
//        if(left.tail!=null){
//            left.tail.next=newNode;
//        }
        newNode.next= right.head;

        //checking if left part is null or not , if not null then attach its tail ka next to newNode
        if(left.tail!=null){
            left.tail.next=newNode;
            headAndTail.head = left.head;
        }
        else{
            headAndTail.head=newNode;
        }
        //checking if right part is null or not , if not null then attach its tail ka next to newNode
        if(right.tail!=null){
            headAndTail.tail=right.tail;
        }
        else{
            headAndTail.tail=newNode;
        }
        return headAndTail;

    }

    public static Node<Integer> BST_to_LL(BinaryTreeNode<Integer> root){
        return BST_to_LL_helper(root).head;
   }


    public static void main(String[] args) {
        BinaryTreeNode<Integer> root=takeInputLevelwise();
       print_LL(BST_to_LL(root));
       //4 2 6 1 3 5 7 -1 -1 -1 -1 -1 -1 -1 -1


    }
}
