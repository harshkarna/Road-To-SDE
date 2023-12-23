package com.Linked_List.Striver;

public class LinkedList {

    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Function to convert an array to a linked list
    static Node arrayToLinkedList(int[] arr) {

        Node head=new Node(arr[0]);
        Node current=head;

        for(int i=1; i<arr.length; i++) {
           Node newNode=new Node(arr[i]);
           current.next=newNode;
           current=newNode;
        }
        return head;
    }

    private static int countLinkedList(Node head) {
        Node current=head;
        int count=0;
        while(current!=null){
            current=current.next;
            count++;
        }
       return count;
    }

    private static void printLinkedList(Node head) {
        Node current=head;
        while(current!=null){
            System.out.print(current.data +" -> ");
            current=current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};

        // Convert the array to a linked list
        Node linkedList = arrayToLinkedList(array);
        System.out.println("Lenth of LL: " + countLinkedList(linkedList));

        // Print the linked list
        System.out.print("Linked List: ");
        printLinkedList(linkedList);

    }

}
