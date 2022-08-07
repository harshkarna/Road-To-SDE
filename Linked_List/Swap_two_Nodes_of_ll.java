package com.Linked_List;//Swap two Nodes of LL
//
//        You have been given a singly linked list of integers along with two integers, 'i,' and 'j.'
//        Swap the nodes that are present at the 'i-th' and 'j-th' positions.
//        Note :
//        Remember, the nodes themselves must be swapped and not the datas.
//
//        No need to print the list, it has already been taken care. Only return the new head to the list.
//        Input format :
//        The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.
//
//        The first line of each test case or query contains the elements of the singly linked list separated by a single space.
//
//        The second line of input contains two integer values 'i,' and 'j,' respectively. A single space will separate them.
//        Remember/consider :
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
//0 <= j < M
//
//Time Limit: 1sec
//        Sample Input 1 :
//        1
//        3 4 5 2 6 1 9 -1
//        3 4
//        Sample Output 1 :
//        3 4 5 6 2 1 9
//        Sample Input 2 :
//        2
//        10 20 30 40 -1
//        1 2
//        70 80 90 25 65 85 90 -1
//        0 6
//        Sample Output 2 :
//        10 30 20 40
//        90 80 90 25 65 85 70
//
//        package com.Linked_List;

import com.Linked_List.Node;

import java.util.Scanner;

public class Swap_two_Nodes_of_ll {

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


    public static Node <Integer> swap_i_j(Node <Integer> head, int i, int j){
        Node <Integer> cn1=head;
        Node <Integer> cn2=head;
        int p1=0;
        int p2=0;
        while(p1<i-1){
            cn1=cn1.next;
            p1++;
        }
        while(p2<j-1){
            cn2=cn2.next;
            p2++;
        }
        Node <Integer> temp1=cn1.next;
        Node <Integer> temp2=cn2.next;

        temp2.next=cn1.next.next;
        cn1.next=temp2;

        temp1.next=cn2.next.next;
        cn2.next=temp1;

        return head;

    }

    public static void main(String[] args) {
         Node <Integer> head=takeInputOptimised();
         head=swap_i_j(head,2,5);
         print(head);

    }


}
