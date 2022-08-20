//Delete node Recursively
//
//        Given a singly linked list of integers and position 'i', delete the node present at the 'i-th' position in the linked list recursively.
//        Note :
//        Assume that the Indexing for the linked list always starts from 0.
//
//        No need to print the list, it has already been taken care. Only return the new head to the list.
//        input format :
//        The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.
//
//        The first line of each test case or query contains the elements of the singly linked list separated by a single space.
//
//        The second line of input contains a single integer depicting the value of 'i'.
//        Remember/Consider :
//        While specifying the list elements for input, -1 indicates the end of the singly linked list and hence, would never be a list element
//        Output format :
//        For each test case/query, print the elements of the updated singly linked list.
//
//        Output for every test case will be printed in a seperate line.
//        Constraints :
//        1 <= t <= 10^2
//        0 <= M <= 10^5
//        Where M is the size of the singly linked list.
//        0 <= i < M
//
//Time Limit:  1sec
//        Sample Input 1 :
//        1
//        3 4 5 2 6 1 9 -1
//        3
//        Sample Output 1 :
//        3 4 5 6 1 9
//        Sample Input 2 :
//        2
//        30 -1
//        0
//        10 20 30 50 60 -1
//        4
//        Sample Output 2 :
//        10 20 30 50

        package com.Linked_List;

public class Delete_Node_Recursively {

    public static Node <Integer> createLinkedList() {
        Node<Integer> n1=new Node<>(10);
        Node<Integer> n2=new Node<>(20);
        Node<Integer> n3=new Node<>(30);
        Node<Integer> n4=new Node<>(40);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        return n1;

    }

    public static void print_recursive(Node <Integer> head){
        if(head==null){
            return;
        }
        System.out.print(head.data+" ");
        print_recursive(head.next);

    }


    public static Node <Integer> delete_recursively(Node <Integer> head, int index){

        if(index==0){
            return head.next;
        }

        Node <Integer> smallerhead= delete_recursively(head.next, index-1);
        head.next=smallerhead;
        return head;

    }

    public static void main(String[] args) {

            Node <Integer> head=createLinkedList();
            head=delete_recursively(head,2);
            print_recursive(head);


    }
}