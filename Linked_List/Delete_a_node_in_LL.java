//Delete Node In LL
//
//        You have been given a linked list of integers. Your task is to write a function that deletes a node from a given position, 'pos'.
//        Note :
//        Assume that the Indexing for the linked list always starts from 0.
//
//        If the position is greater than or equal to the length of the linked list, you should return the same linked list without any change.
//        Illustration :
//        The following images depict how the deletion has been performed.
//        Image-I :
//        Alt txt
//
//        Image-II :
//        Alt txt
//
//        Input format :
//        The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.
//
//        The first line of each test case or query contains the elements of the linked list separated by a single space.
//
//        The second line of each test case contains the integer value of 'pos'. It denotes the position in the linked list from where the node has to be deleted.
//        Remember/Consider :
//        While specifying the list elements for input, -1 indicates the end of the singly linked list and hence, would never be a list element
//        Output format :
//        For each test case/query, print the resulting linked list of integers in a row, separated by a single space.
//
//        Output for every test case will be printed in a separate line.
//        You don't need to print explicitly, it has been taken care of.
//        Constraints :
//        1 <= t <= 10^2
//        0 <= N <= 10^5
//        pos >= 0
//        Time Limit: 1sec
//
//        Where 'N' is the size of the singly linked list.
//        Sample Input 1 :
//        1
//        3 4 5 2 6 1 9 -1
//        3
//        Sample Output 1 :
//        3 4 5 6 1 9
//        Sample Input 2 :
//        2
//        3 4 5 2 6 1 9 -1
//        0
//        10 20 30 40 50 60 -1
//        7
//        Sample Output 2 :
//        4 5 2 6 1 9
//        10 20 30 40 50 60

package com.Linked_List;

public class Delete_a_node_in_LL {


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

    public static Node <Integer> delete_at_ith_ll(Node <Integer> head ,int index){

        if(index==0){//if deleting head;
            return head.next;
        }
        Node<Integer> prev=head;
        int position=0;
        while(prev!=null && position<index-1){
            prev=prev.next;
            position++;
        }

        prev.next=prev.next.next;
        return head;

    }

    public static void main(String[] args) {

        Node <Integer> head = createLinkedList();
        head=delete_at_ith_ll(head,2 );
        print(head);

    }





}
