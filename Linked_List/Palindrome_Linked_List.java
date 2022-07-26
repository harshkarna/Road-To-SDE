//Palindrome LinkedList
//
//        You have been given a head to a singly linked list of integers. Write a function check to
//        whether the list given is a 'Palindrome' or not.
//        Input format :
//        The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.
//
//        First and the only line of each test case or query contains the the elements of the singly linked list separated by a single space.
//        Remember/Consider :
//        While specifying the list elements for input, -1 indicates the end of the singly linked list and hence, would never be a list element.
//        Output format :
//        For each test case, the only line of output that print 'true' if the list is Palindrome or 'false' otherwise.
//        Constraints :
//        1 <= t <= 10^2
//        0 <= M <= 10^5
//        Time Limit: 1sec
//
//        Where 'M' is the size of the singly linked list.
//        Sample Input 1 :
//        1
//        9 2 3 3 2 9 -1
//        Sample Output 1 :
//        true
//        Sample Input 2 :
//        2
//        0 2 3 2 5 -1
//        -1
//        Sample Output 2 :
//        false
//        true
//        Explanation for the Sample Input 2 :
//        For the first query, it is pretty intuitive that the the given list is not a palindrome, hence the output is 'false'.
//
//        For the second query, the list is empty. An empty list is always a palindrome , hence the output is 'true'.

package com.Linked_List;


public class Palindrome_Linked_List {
    public static Node <Integer> createLinkedList() {

        Node<Integer> n1=new Node<>(1);
        Node<Integer> n2=new Node<>(2);
        Node<Integer> n3=new Node<>(3);
        Node<Integer> n4=new Node<>(3);
        Node<Integer> n5=new Node<>(2);
        Node<Integer> n6=new Node<>(1);
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

    public static Node<Integer> reverse_ll(Node <Integer> head){
        Node <Integer> currentNode=head;
        Node <Integer> prev=null;

        while(currentNode!=null){
            Node <Integer> temp=currentNode.next;
            currentNode.next=prev;
            prev=currentNode;
            currentNode=temp;

        }
        return prev;
    }

    public static Node <Integer> get_mid_Node(Node <Integer> head){
        Node<Integer> fast=head;
        Node<Integer> slow=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
         return slow;
    }

    public static boolean isPalindrome(Node <Integer> head){
        Node <Integer> currentNode =head;
        Node <Integer> second_head=reverse_ll(get_mid_Node(head).next);

        while(second_head!=null){
            if(currentNode.data!=second_head.data){
                return false;
            }
            currentNode=currentNode.next;
            second_head=second_head.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Node <Integer> head=createLinkedList();
        System.out.println(isPalindrome(head));


    }
}
