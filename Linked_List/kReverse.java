//kReverse
//
//        Given a singly linked list of integers, reverse the nodes of the linked list 'k' at a
//        time and return its modified list.
//        'k' is a positive integer and is less than or equal to the length of the linked list.
//        If the number of nodes is not a multiple of 'k,' then left-out nodes, in the end, should be reversed as well.
//        Example :
//        Given this linked list: 1 -> 2 -> 3 -> 4 -> 5
//
//        For k = 2, you should return: 2 -> 1 -> 4 -> 3 -> 5
//
//        For k = 3, you should return: 3 -> 2 -> 1 -> 4 -> 5
//        Note :
//        No need to print the list, it has already been taken care. Only return the new head to the list.
//        Input format :
//        The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.
//
//        The first line of each test case or query contains the elements of the singly linked list separated by a single space.
//
//        The second line of input contains a single integer depicting the value of 'k'.
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
//        0 <= k <= M
//
//        Time Limit:  1sec
//        Sample Input 1 :
//        1
//        1 2 3 4 5 6 7 8 9 10 -1
//        4
//        Sample Output 1 :
//        4 3 2 1 8 7 6 5 10 9
//        Sample Input 2 :
//        2
//        1 2 3 4 5 -1
//        0
//        10 20 30 40 -1
//        4
//        Sample Output 2 :
//        1 2 3 4 5
//        40 30 20 10
package com.Linked_List;

import java.util.Scanner;

public class kReverse {

        public static Node<Integer> takeInputOptimised(){
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


        public static Node <Integer> kReverse(Node <Integer> head, int k){
            if(k==0 || k==1){
                return head;
            }

            Node <Integer> currentNode=head;
            Node <Integer> forward=null;
            Node <Integer> prev=null;

            int count=0;

            while(count < k && currentNode!=null){
                forward=currentNode.next;
                currentNode.next=prev;
                prev=currentNode;
                currentNode=forward;
                count++;
            }

            if(forward!=null){
                head.next=kReverse(forward,k);
            }
            return prev;
        }


        public static void main(String[] args) {
            Node <Integer> head=takeInputOptimised();
            head=kReverse(head, 4);
            print(head);

        }


    }

