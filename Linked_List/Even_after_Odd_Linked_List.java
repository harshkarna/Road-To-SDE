//Even after Odd LinkedList
//
//        For a given singly linked list of integers, arrange the elements such that all the even numbers are
//        placed after the odd numbers. The relative order of the odd and even terms should remain unchanged.
//        Note :
//        No need to print the list, it has already been taken care. Only return the new head to the list.
//        Input format:
//        The first line contains an Integer 't' which denotes the number of test cases or queries to be run.
//        Then the test cases follow.
//
//        The first line of each test case or query contains the elements of the singly linked list separated by a single space.
//        Remember/Consider :
//        While specifying the list elements for input, -1 indicates the end of the singly linked list and hence, would never be a list element
//        Output format:
//        For each test case/query, print the elements of the updated singly linked list.
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
//        1 4 5 2 -1
//        Sample Output 1 :
//        1 5 4 2
//        Sample Input 2 :
//        2
//        1 11 3 6 8 0 9 -1
//        10 20 30 40 -1
//        Sample Output 2 :
//        1 11 3 9 6 8 0
//        10 20 30 40

package com.Linked_List;

import java.util.Scanner;

public class Even_after_Odd_Linked_List {

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

    public static Node <Integer> even_after_odd(Node <Integer> head){
        Node <Integer> oddH=null;
        Node <Integer> oddT=null;
        Node <Integer> evenH=null;
        Node <Integer> evenT=null;

        while(head!=null){
            if(head.data %2!=0){ //for odd
                //for 1 st time access to head
                if(oddH == null){
                    oddH=head;
                    oddT=head;
                }
                else{
                    oddT.next=head;
                    oddT=oddT.next;

                }
            }
            else{ //for even
                //for 1 st time access to head
                if(evenH==null ){
                    evenH=head;
                    evenT=head;
                }
                else{
                    evenT.next=head;
                    evenT=evenT.next;

                }
            }
            head=head.next;
        }


      //if one of odd or even is empty
        if(oddH==null){
            return evenH;
        }
        if(evenH==null){
//            oddT.next=null;
            return oddH;
        }
        else{
            oddT.next=null;
            evenT.next=null;
            oddT.next=evenH;
        }

        return oddH;

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

    public static void main(String[] args) {

        Node <Integer> head=takeInputOptimised();
        head=even_after_odd(head);
        print(head);




    }
}
