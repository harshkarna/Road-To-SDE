package com.Linked_List.Striver;

public class DoublyLinkedList {

    static class Node {
        int data;
        Node next;
        Node back;
        Node(int data) {
            this.data = data;
            this.next = null;
            this.back = null;
        }
        Node(int data, Node next , Node back) {
            this.data = data;
            this.next = next;
            this.back = back;
        }

    }

    private static Node arrayToDLLLinkedList(int[] array) {
        Node head=new Node(array[0]);
        Node prev=head;
        for(int i=1; i<array.length; i++) {
            Node temp=new Node(array[i], null,prev);
            prev.next = temp;
            prev=temp;
        }
        return head;

    }
    private static void printLinkedList(Node head) {
        Node current=head;
        while(current!=null){
            System.out.print(current.data +" -> ");
            current=current.next;
        }
        System.out.println();
    }

    private static Node removesHead(Node head) {
        // Check if the linked list is empty
        if (head == null || head.next==null)
            return null;
        // Move the head to the next node
        head = head.next;
        // Return the updated head of the linked list
        return head;
        // There’s no need to delete the earlier head since it gets automatically deleted.
    }

    private static Node removesTail(Node head) {
        // Check if the linked list is empty
        if (head == null || head.next==null)
            return null;
        Node tail=head;
        while(tail.next!=null){
            tail = tail.next;
        }
        tail.back.next=null;
        return head;
    }

    private static Node removeKthElement(Node head, int k) {
        if (head == null) {
            return null;
        }
        int count = 0;
        Node kNode = head;
        while (kNode != null) {
            count++;
            if (count == k) {
                break;
            }
            kNode = kNode.next;
        }
        Node prev = kNode.back;
        Node front = kNode.next;

        if (prev == null && front == null) {
            return null;
        } else if (prev == null) {
            return removesHead(head);
        } else if (front == null) {
            return removesTail(head);
        }

        prev.next = front;
        front.back = prev;
        return head;
    }

    private static void deleteNode(Node temp){
        Node prev = temp.back;
        Node front = temp.next;

        // edge case if temp is the tail node
        if(front==null){
            prev.next = null;
            temp.back = null;
            return;
        }
        //Disconnect temp from the doubly linked list
        prev.next = front;
        front.back = prev;

    }

    private static Node insertBeforeHead(Node head, int val){
        // Create new node with data as val
        Node newHead = new Node(val, head, null);
        // Set old head's back pointer to the new Head
        head.back = newHead;
        // Return the new head
        return newHead;
    }


    private static Node insertBeforeTail(Node head, int val){
        // Edge case, if dll has only one elements
        if(head.next==null){
            // If only one element
            return insertBeforeHead(head, val);
        }

        // Create pointer tail to traverse to the end of list
        Node tail = head;
        while(tail.next!=null){
            tail = tail.next;
        }
        // Keep track of node before tail using prev
        Node prev = tail.back;

        // Create new node with value val
        Node newNode = new Node(val, tail, prev);

        // Join the new node into the doubly linked list
        prev.next = newNode;
        tail.back = newNode;

        // Return the updated linked list
        return head;
    }

    private static Node insertBeforeKthElement(Node head, int k, int val){

        if(k==1){
            // K = 1 means node has to be insert before the head
            return insertBeforeHead(head, val);
        }

        // temp will keep track of the node
        Node temp = head;

        // count so that the Kth element can be reached
        int count = 0;
        while(temp!=null){
            count ++;
            // On reaching the Kth position, break out of the loop
            if(count == k) break;
            // keep moving temp forward till count != K
            temp = temp.next;
        }
        // track the node before the Kth node
        Node prev = temp.back;
        // create new node with data as val
        Node newNode = new Node(val, temp, prev);

        //join the new node in between prev and temp
        prev.next = newNode;
        temp.back = newNode;

        // Set newNode's pointers to prev and temp
        newNode.next = temp;
        newNode.back = prev;

        // Return the head of the updated doubly linked list
        return head;
    }

    private static void insertBeforeNode(Node node, int val) {
        // Get the node before the given node
        Node prev = node.back;

        // Create a new node with the given val
        Node newNode = new Node(val, node, prev);

        // Connect the newNode to the doubly linked list
        prev.next = newNode;
        node.back = newNode;

    }


    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4, 5};

        // Convert the array to a linked list
        Node head = arrayToDLLLinkedList(array);
        System.out.println("Original DLL ");
        printLinkedList(head);

        System.out.println("Removing Head");
        head = removesHead(head);
        printLinkedList(head);

        System.out.println("Removing Tail");
        head = removesTail(head);
        printLinkedList(head);

        System.out.println("Removing Kth node ");
        head = removeKthElement(head, 2);
        printLinkedList(head);

        System.out.println("Removing  node ");
        deleteNode(head.next);
        printLinkedList(head);

        System.out.println("Inserting before head  ");
        head=insertBeforeHead(head, 100);
        printLinkedList(head);

        System.out.println("Inserting before Tail  ");
        head=insertBeforeTail(head, 200);
        printLinkedList(head);

        System.out.println("Inserting before Kth node  ");
        head=insertBeforeKthElement(head, 2,153);
        printLinkedList(head);

        System.out.println("Inserting before  node  ");
        insertBeforeNode(head.next.next,186);
        printLinkedList(head);






    }


}
