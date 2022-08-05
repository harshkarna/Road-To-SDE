//Find a node in LL (recursive)
//
//        Given a singly linked list of integers and an integer n, find and return the index for the first
//        occurrence of 'n' in the linked list. -1 otherwise.
//        Follow a recursive approach to solve this.
//        Note :
//        Assume that the Indexing for the linked list always starts from 0.
//        Input format :
//        The first line contains an Integer 't' which denotes the number of test cases or queries to be run.
//        Then the test cases follow.
//
//        The first line of each test case or query contains the elements of the singly linked list separated by a single space.
//
//        The second line of input contains a single integer depicting the value of 'n'.
//        Remember/Consider :
//        While specifying the list elements for input, -1 indicates the end of the singly linked list and hence,
//        would never be a list element
//        Output format :
//        For each test case/query, print the elements of the updated singly linked list.
//
//        Output for every test case will be printed in a seperate line.
//        Constraints :
//        1 <= t <= 10^2
//        0 <= M <= 10^5
//        Where M is the size of the singly linked list.
//
//        Time Limit:  1sec
//        Sample Input 1 :
//        1
//        3 4 5 2 6 1 9 -1
//        100
//        Sample Output 1 :
//        -1
//        Sample Input 2 :
//        2
//        10 20010 30 400 600 -1
//        20010
//        100 200 300 400 9000 -34 -1
//        -34
//        Sample Output 2 :
//        1
//        5

package com.Linked_List;

import java.util.Scanner;

public class Find_a_node_in_ll_recusrive {

    public static Node <Integer> takeInputOptimised(){
        //TC is O(n) is actually  good

        Scanner s =new Scanner(System.in);
        int data=s.nextInt();
        Node<Integer> head = null, tail=null;
        while(data!=-1){
            Node <Integer> currentNode= new Node<Integer>(data);
            //This if will run only once
            if(head==null){
                //Make this node as head and tail node
                head=currentNode;
                tail=currentNode;
            }
            else{
                tail.next=currentNode;
                //Update Tail
                tail=currentNode; // or tail=tail.next;
            }
            data=s.nextInt();
        }
        return head;
    }

    public static int get_node_index(Node <Integer> head, int data){
        if(head==null || head.next==null){
            return -1;
        }
        if(head.data==data){
            return 0;
        }

        int smallAns=get_node_index(head.next,data);

        if(smallAns==-1){
            return -1;
        }
        return smallAns+1;

    }


    public static void main(String[] args) {
        Node <Integer> head=takeInputOptimised();
        System.out.println(get_node_index(head, 10));


    }
}
