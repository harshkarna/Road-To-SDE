//Delete every N nodes
//
//        You have been given a singly linked list of integers along with two integers, 'M,' and 'N.'
//        Traverse the linked list such that you retain the 'M' nodes, then delete the next 'N' nodes.
//        Continue the same until the end of the linked list.
//        To put it in other words, in the given linked list, you need to delete N nodes after every M nodes.
//        Note :
//        No need to print the list, it has already been taken care. Only return the new head to the list.
//        Input format :
//        The first line contains an Integer 't' which denotes the number of test cases or queries to be run.
//        Then the test cases follow.
//
//        The first line of each test case or query contains the elements of the singly linked list separated by a single space.
//
//        The second line of input contains two integer values 'M,' and 'N,' respectively. A single space will separate them.
//        Remember/Consider :
//        While specifying the list elements for input, -1 indicates the end of the singly linked list and hence, would never be a list element
//        Output format :
//        For each test case/query, print the elements of the updated singly linked list.
//
//        Output for every test case will be printed in a seperate line.
//        Constraints :
//        1 <= t <= 10^2
//        0 <= P <= 10^5
//        Where P is the size of the singly linked list.
//        0 <= M <= 10^5
//        0 <= N <= 10^5
//
//        Time Limit: 1sec
//        Sample Input 1 :
//        1
//        1 2 3 4 5 6 7 8 -1
//        2 2
//        Sample Output 1 :
//        1 2 5 6
//        Sample Input 2 :
//        2
//        10 20 30 40 50 60 -1
//        0 1
//        1 2 3 4 5 6 7 8 -1
//        2 3
//        Sample Output 2 :
//        1 2 6 7
//        Explanation of Sample Input 2 :
//        For the first query, we delete one node after every zero elements hence removing all the items of the list. Therefore, nothing got printed.
//
//        For the second query, we delete three nodes after every two nodes, resulting in the final list, 1 -> 2 -> 6 -> 7.

package com.Linked_List;

import java.util.Scanner;

public class Delete_every_n_Nodes {
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


    public static Node <Integer> delete_every_n_nodes(Node <Integer> head, int m , int n){
        if(m==0){
            return null;
        }

        Node <Integer> cn1=head;
        Node <Integer> cn2=head;


        while(cn2!=null ){
            int cp1=1;
            int cp2=0;
            while(cp1<m && cn2 !=null){
                cn1=cn1.next;
                cn2=cn2.next;
                cp1++;
            }
            while(cp2<n && cn2.next!=null){
                cn2=cn2.next;
                cp2++;

            }
            cn1.next=cn2.next;
            cn2=cn2.next;
            cn1=cn2;

        }
        return head;

    }


    public static void main(String[] args) {
        Node <Integer> head=takeInputOptimised();
        head=delete_every_n_nodes(head,2,3);
        print(head);




    }


}
