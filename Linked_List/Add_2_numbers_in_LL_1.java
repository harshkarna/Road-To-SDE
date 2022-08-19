package com.Linked_List;

import java.util.Scanner;

public class Add_2_numbers_in_LL_1 {

    //Good Approach

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
    public static Node <Integer> createLinkedList() {
        Node<Integer> n1=new Node<>(1);
        Node<Integer> n2=new Node<>(2);
        Node<Integer> n3=new Node<>(3);
        n1.next=n2;
        n2.next=n3;
        return n1;

    }

    public static void print(Node<Integer> head) {
        //Printing Linked List
        //Note : good practice is keeping head in temp and iterate over temp
        Node <Integer> temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static Node <Integer> reverse_LL(Node <Integer> head){
        Node <Integer> currentNode=head;
        Node <Integer> prev=null;

        while(currentNode!=null){
            Node <Integer> forward=currentNode.next;
            currentNode.next=prev;
            prev=currentNode;
            currentNode=forward;
        }
        return prev;
    }


    public static Node <Integer> addTwoNumbers(Node <Integer> head1, Node <Integer> head2) {

        if (head1 == null)
            return head2;

        if (head2 == null)
            return head1;

        Node <Integer> tail = null, head = null;
        int carry = 0;

        // while end of list is not reached
        while (head1 != null || head2 != null) {
            int sum = 0;
            // add value in linkedList 1
            if (head1 != null) {
                sum = sum+ head1.data;
                head1 = head1.next;
            }
            // add value in linkedList 2
            if (head2 != null) {
                sum = sum+ head2.data;
                head2 = head2.next;
            }
            // add carry
            sum = sum + carry;

            int toAdd = sum % 10;
            carry = sum / 10;
            // node with the remainder value
            Node <Integer> toAddNode = new Node <>(toAdd);
            if (tail != null) {
                tail.next = toAddNode;
                tail = tail.next;
            } else {
                tail =toAddNode;
                head = toAddNode;// for the first iteration
            }
        }
        // if carry is present
        if (carry > 0) {
            tail.next = new Node <>(carry);
        }

        head = reverse_LL(head);
        return head;
    }

    public static void main(String[] args) {
        Node <Integer> head1= takeInputOptimised();
        Node <Integer> head2=takeInputOptimised();
        head1=reverse_LL(head1);
        head2=reverse_LL(head2);
        Node <Integer> output=addTwoNumbers(head1,head2);
        print(output);

    }
}
