//Level wise linkedList
//
//        Given a binary tree, write code to create a separate linked list for each level.
//        You need to return the array which contains head of each level linked list.
//        Input format :
//        The first line of input contains data of the nodes of the tree in level order form.
//        The data of the nodes of the tree is separated by space. If any node does not have left or right child, take -1 in its place. Since -1 is used as an indication whether the left or right nodes exist, therefore, it will not be a part of the data of any node.
//        Output format :
//        Each level linked list is printed in new line (elements are separated by space).
//        Constraints:
//        Time Limit: 1 second
//        Sample Input 1:
//        5 6 10 2 3 -1 -1 -1 -1 -1 9 -1 -1
//        Sample Output 1:
//        5
//        6 10
//        2 3
//        9

package com.Binary_Search_Tree;

import com.Linked_List.Node;
import com.Trees.BinaryTreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Level_wise_LinkedList {


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


    //here Node =LinkedListNode
    public static ArrayList<Node<Integer>>  constructLinkedListForEachLevel(BinaryTreeNode<Integer> root){
        if(root==null){
            return null;
        }
        //as its a level order traversal lets make a queue
        Queue<BinaryTreeNode<Integer>> pendingNodes=new LinkedList<>();
        //add the root first
        pendingNodes.add(root);

        int currentLevelRemaining=1;
        int nextLevelCount=0;

        Node<Integer>  currentlevelHead=null;
        Node<Integer>  currentlevelTail=null;

        //to store the head of every linked list formed in arraylist
        ArrayList<Node<Integer>> output=new ArrayList<>();

        while(!pendingNodes.isEmpty()){
            BinaryTreeNode<Integer> currentNode=pendingNodes.remove();

            Node<Integer> newNode= new Node<>(currentNode.data);

            if(currentlevelHead==null){
                currentlevelHead=newNode;
                currentlevelTail=newNode;
            }
            else{
                currentlevelTail.next=newNode;
                currentlevelTail=newNode;
            }

            //now lets handle if their are child of current node
            if(currentNode.left!=null){
                pendingNodes.add(currentNode.left);
                nextLevelCount++;
            }
            if(currentNode.right!=null){
                pendingNodes.add(currentNode.right);
                nextLevelCount++;
            }

            currentLevelRemaining--;
            //below mean ki if one level is completed
            if(currentLevelRemaining==0){
                //add the head of current LL to arraylist
                output.add(currentlevelHead);
                currentlevelHead=null;
                currentlevelTail=null;
                currentLevelRemaining=nextLevelCount;
                nextLevelCount=0;
            }

        }
        return output;
    }


    public static void main(String[] args) {
        BinaryTreeNode<Integer> root=takeInputLevelwise();
        ArrayList<Node<Integer>> answer= constructLinkedListForEachLevel(root);
        for(int i=0;i<answer.size();i++){
            System.out.print(answer.get(i).data +" ");
        }

    }
}
