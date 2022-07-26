//AppendLastNToFirst
//
//        You have been given a singly linked list of integers along with an integer 'N'.
//        Write a function to append the last 'N' nodes towards the front of the singly linked list and
//        returns the new head to the list.
//        Input format :
//        The first line contains an Integer 't' which denotes the number of test cases or queries to be run.
//        Then the test cases follow.
//
//        The first line of each test case or query contains the elements of the singly linked
//        list separated by a single space.
//
//        The second line contains the integer value 'N'. It denotes the number of nodes to be moved from
//        last to the front of the singly linked list.
//        Remember/Consider :
//        While specifying the list elements for input, -1 indicates the end of the singly linked list and
//        hence, would never be a list element.
//        Output format :
//        For each test case/query, print the resulting singly linked list of integers in a row, separated
//        by a single space.
//
//        Output for every test case will be printed in a seperate line.
//        Constraints :
//        1 <= t <= 10^2
//        0 <= M <= 10^5
//        0 <= N < M
//Time Limit: 1sec
//
//        Where 'M' is the size of the singly linked list.
//        Sample Input 1 :
//        2
//        1 2 3 4 5 -1
//        3
//        10 20 30 40 50 60 -1
//        5
//        Sample Output 1 :
//        3 4 5 1 2
//        20 30 40 50 60 10
//        Sample Input 2 :
//        1
//        10 6 77 90 61 67 100  -1
//        4
//        Sample Output 2 :
//        90 61 67 100 10 6 77
//        Explanation to Sample Input 2 :
//        We have been required to move the last 4 nodes to the front of the list. Here, "90->61->67->100" is the list which represents the last 4 nodes. When we move this list to the front then the remaining part of the initial list which is, "10->6->77" is attached after 100. Hence, the new list formed with an updated head pointing to 90.

package com.Linked_List;

public class Append_last_n_to_firts {

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

    public static int Length(Node <Integer> head){
        Node<Integer> temp= head;
        int count=0;
        while (temp!=null){
            count++;
            temp=temp.next;
        }
        return count;
//        System.out.println("Length is " + count);
    }

    public static Node<Integer> append_last_n_to_first(Node <Integer> head, int lastn){
        int start =Length(head)-lastn;

        Node<Integer> last=head;
        Node<Integer> prev=head;
        Node<Integer> currentNode;
        int position=0;

        //Going to last
         while(last.next!=null){
             last=last.next;
         }
         while(prev!=null && position<start-1){
             prev=prev.next;
             position++;
         }
         //break i-1;
         currentNode=prev.next;
         prev.next=null;
         last.next=head;
         head=currentNode;


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

    public static void main(String[] args) {

        Node <Integer> head=createLinkedList();
        Node <Integer> ans= append_last_n_to_first(head,3);
        print(ans);


    }
}
