//Print Reverse LinkedList
//
//        You have been given a singly linked list of integers. Write a function to print the list in a reverse order.
//        To explain it further, you need to start printing the data from the tail and move towards the head of the list,
//        printing the head data at the end.
//        Note :
//        You can’t change any of the pointers in the linked list, just print it in the reverse order.
//        Input format :
//        The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.
//
//        The first and the only line of each test case or query contains the elements of the singly linked list separated by a single space.
//        Remember/Constraints :
//        While specifying the list elements for input, -1 indicates the end of the singly linked list and hence, would never be a list element.
//        Output format :
//        For each test case, print the singly linked list of integers in a reverse fashion, in a row, separated by a single space.
//
//        Output for every test case will be printed in a seperate line.
//        Constraints :
//        1 <= t <= 10^2
//        0 <= M <= 10^3
//        Time Limit: 1sec
//
//        Where 'M' is the size of the singly linked list.
//        Sample Input 1 :
//        1
//        1 2 3 4 5 -1
//        Sample Output 1 :
//        5 4 3 2 1
//        Sample Input 2 :
//        2
//        1 2 3 -1
//        10 20 30 40 50 -1
//        Sample Output 2 :
//        3 2 1
//        50 40 30 20 10
//

package com.Linked_List;

public class Print_Reverse_Linked_List {

    public static Node <Integer> createLinkedList() {
        Node<Integer> n1=new Node<>(1);
        Node<Integer> n2=new Node<>(2);
        Node<Integer> n3=new Node<>(3);
        Node<Integer> n4=new Node<>(4);
        Node<Integer> n5=new Node<>(5);
        Node<Integer> n6=new Node<>(6);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=n6;
        return n1;

    }

    public static void print_ll_in_reverse(Node <Integer> head){
        //base case
        if(head==null){
            return;
        }

        print_ll_in_reverse(head.next);

        //First element ka kaam hum karenge
        System.out.print(head.data +" ");

    }

    public static void main(String[] args) {
        Node <Integer> head=createLinkedList();
        print_ll_in_reverse(head);


    }
}
