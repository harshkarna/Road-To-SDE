//Merge Sort LL
//
//        Given a singly linked list of integers, sort it using 'Merge Sort.'
//        Note :
//        No need to print the list, it has already been taken care. Only return the new head to the list.
//        Input format :
//        The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.
//
//        The first and the only line of each test case or query contains the elements of the singly linked list separated by a single space.
//        Remember/Consider :
//        While specifying the list elements for input, -1 indicates the end of the singly linked list and hence, would never be a list element
//        Output format :
//        For each test case/query, print the elements of the sorted singly linked list.
//
//        Output for every test case will be printed in a seperate line.
//        Constraints :
//        1 <= t <= 10^2
//        0 <= M <= 10^5
//        Where M is the size of the singly linked list.
//
//        Time Limit: 1sec
//        Sample Input 1 :
//        1
//        10 9 8 7 6 5 4 3 -1
//        Sample Output 1 :
//        3 4 5 6 7 8 9 10
//        Sample Output 2 :
//        2
//        -1
//        10 -5 9 90 5 67 1 89 -1
//        Sample Output 2 :
//        -5 1 5 9 10 67 89 90

        package com.Linked_List;

import com.sun.org.apache.xml.internal.security.algorithms.implementations.IntegrityHmac;

import java.util.Scanner;

public class Merge_Sort_LL {

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
                //Now tail is refreing to last Node
                //Connect current Node after last Node
                tail.next=currentNode;
            }

            data=s.nextInt();
        }
        return head;
    }

    public static Node <Integer> get_mid_Node(Node <Integer> head){
        if(head==null){
            return head;
        }
        Node<Integer> fast=head;
        Node<Integer> slow=head;

        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
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

        if (t1.data <= t2.data) {
            head = t1;
            tail = t1;
            t1 = t1.next;
        } else {
            head = t2;
            tail = t2;
            t2 = t2.next;
        }
        while (t1 != null && t2 != null) {
            if (t1.data <= t2.data) {
                tail.next = t1;
                tail = t1;
                t1 = t1.next;
            } else {
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

    public static Node <Integer> merge_sort(Node <Integer> head){

        if(head ==null || head.next == null ){
            return head;
        }

        Node <Integer> mid_node=get_mid_Node(head);
        Node <Integer> head_1=head;
        Node <Integer> head_2=mid_node.next;
        mid_node.next=null;

        head_1=merge_sort(head_1);
        head_2=merge_sort(head_2);
        Node <Integer> final_head= merge_ll_sorted(head_1,head_2);

        return final_head;

    }

    public static void main(String[] args) {

        Node <Integer> head= takeInput();
        head=merge_sort(head);
        print(head);




    }
}
