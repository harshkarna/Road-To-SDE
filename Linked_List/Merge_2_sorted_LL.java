//Merge Two Sorted LL
//
//        You have been given two sorted(in ascending order) singly linked lists of integers.
//        Write a function to merge them in such a way that the resulting singly linked list is also sorted(in ascending order) and return the new head to the list.
//        Note :
//        Try solving this in O(1) auxiliary space.
//
//        No need to print the list, it has already been taken care.
//        Input format :
//        The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.
//
//        The first line of each test case or query contains the elements of the first sorted singly linked list separated by a single space.
//
//        The second line of the input contains the elements of the second sorted singly linked list separated by a single space.
//        Remember/Consider :
//        While specifying the list elements for input, -1 indicates the end of the singly linked list and hence, would never be a list element
//        Output :
//        For each test case/query, print the resulting sorted singly linked list, separated by a single space.
//
//        Output for every test case will be printed in a seperate line.
//        Constraints :
//        1 <= t = 10^2
//        0 <= N <= 10 ^ 4
//        0 <= M <= 10 ^ 4
//        Where N and M denote the sizes of the singly linked lists.
//
//        Time Limit: 1sec
//        Sample Input 1 :
//        1
//        2 5 8 12 -1
//        3 6 9 -1
//        Sample Output 1 :
//        2 3 5 6 8 9 12
//        Sample Input 2 :
//        2
//        2 5 8 12 -1
//        3 6 9 -1
//        10 40 60 60 80 -1
//        10 20 30 40 50 60 90 100 -1
//        Sample Output 2 :
//        2 3 5 6 8 9 12
//        10 10 20 30 40 40 50 60 60 60 80 90 100

package com.Linked_List;

import java.util.Scanner;

public class Merge_2_sorted_LL {

    public static Node <Integer> takeInput(){
        //TC is O(n^2) is actually not good
        Scanner s =new Scanner(System.in);
        int data=s.nextInt();
        Node<Integer> head = null;
        while(data!=-1){
            Node <Integer> currentNode= new Node<Integer>(data);
            //This if will run only once
            if(head==null){
                //Make this node as head
                head=currentNode;
            }
            else{
                Node<Integer> tail=head;
                while(tail.next!=null){
                    tail=tail.next;
                }
                //Now tail is referring to last Node
                //Connect current Node after last Node
                tail.next=currentNode;
            }

            data=s.nextInt();
        }
        return head;
    }

    public static  void print(Node<Integer> head) {
        //Printing Linked List
        //Note : good practice is keeping head in temp and iterate over temp
        Node<Integer> temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static Node <Integer> merge_ll_sorted (Node <Integer> head_1, Node <Integer> head_2) {
        Node<Integer> head = null;
        Node<Integer> tail = null;
        Node<Integer> t1 = head_1;
        Node<Integer> t2 = head_2;


       //This will run only once for setting head and tail
        if (t1.data <= t2.data) {
            head = t1;
            tail = t1;
            t1 = t1.next;
        }
        else {
            head = t2;
            tail = t2;
            t2 = t2.next;
        }

        //this wwhile loop will run until one LL iteration finishes
        while (t1 != null && t2 != null) {
            if (t1.data <= t2.data) {
                tail.next = t1;
                tail = t1;
                t1 = t1.next;
            }
            else {
                tail.next = t2;
                tail = t2;
                t2 = t2.next;
            }
        }
        //one list is over
        if(t1!=null){
            //firts list is remaining
            tail.next=t1;
        }
        else{
            tail.next=t2;
        }
        return head;

    }



    public static void main(String[] args) {
        Node <Integer> head_1=takeInput();
        Node <Integer> head_2=takeInput();
        head_2=merge_ll_sorted(head_1,head_2);
        print(head_2);

    }
}
