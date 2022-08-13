//Eliminate duplicates from LL
//
//        You have been given a singly linked list of integers where the elements are sorted in ascending order.
//        Write a function that removes the consecutive duplicate values such that the given list only contains unique
//        elements and returns the head to the updated list.
//        Input format :
//        The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.
//
//        The first and the only line of each test case or query contains the elements(in ascending order) of the singly linked list separated by a single space.
//        Remember/Consider :
//        While specifying the list elements for input, -1 indicates the end of the singly linked list and hence, would never be a list element.
//        Output format :
//        For each test case/query, print the resulting singly linked list of integers in a row, separated by a single space.
//
//        Output for every test case will be printed in a seperate line.
//        Constraints :
//        1 <= t <= 10^2
//        0 <= M <= 10^5
//        Time Limit: 1sec
//
//        Where 'M' is the size of the singly linked list.
//        Sample Input 1 :
//        1
//        1 2 3 3 4 3 4 5 4 5 5 7 -1
//        Sample Output 1 :
//        1 2 3 4 3 4 5 4 5 7
//        Sample Input 2 :
//        2
//        10 20 30 40 50 -1
//        10 10 10 10 -1
//        Sample Output 2 :
//        10 20 30 40 50
//        10

package com.Linked_List;

public class Eliminate_duplicates_from_sorted_LL {

    //Best Solution Approach

    public static Node <Integer> createLinkedList() {
        Node<Integer> n1=new Node<>(2);
        Node<Integer> n2=new Node<>(2);
        Node<Integer> n3=new Node<>(2);
        Node<Integer> n4=new Node<>(2);
        Node<Integer> n5=new Node<>(2);
        Node<Integer> n6=new Node<>(2);
        n1.next=n2;
         n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=n6;
        return n1;

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


    public static  Node <Integer> eliminate_dupes(Node <Integer> head){
        Node<Integer> currentNode= head;

        while(currentNode.next!=null){
            if(currentNode.data== currentNode.next.data){
                currentNode.next=currentNode.next.next;
            }
            else{
                currentNode=currentNode.next;

            }
        }

        return head;
    }

    public static void main(String[] args) {

        Node <Integer> head=createLinkedList();
        Node <Integer> ans= eliminate_dupes(head);
        print(ans);



    }
}
