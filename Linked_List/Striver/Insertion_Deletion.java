package com.Linked_List.Striver;

public class Insertion_Deletion {



    /*
    * So here we will implement 8 functions
    * Deletion and Insertion for
    * - head
    * - tail
    * - byPosition
    * - byValue
    * */

    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }


    }




    private static Node removesHead(Node head) {
        // Check if the linked list is empty
        if (head == null)
            return null;
        // Move the head to the next node
        head = head.next;
        // Return the updated head of the linked list
        return head;
        // There’s no need to delete the earlier head since it gets automatically deleted.
    }

    private static Node removesTail(Node head) {
        // Check if the linked list is empty
        if (head == null || head.next == null)
            return null;
        Node current = head;
        while(current.next.next != null){
            current = current.next;
        }
        current.next=null;
        return head;
    }

    private static Node removeKthpostion(Node head, int k){
       if(head==null) return head;
       if(k==1){
          head=head.next;
          return head;
       }
       int cnt=0;
       Node prev=null;
       Node curr=head;
       while(curr !=null){
           cnt++;
           if(cnt==k){
             prev.next=prev.next.next;
             break;
           }
           prev=curr;
           curr=curr.next;
       }

       return head;
    }
    private static Node removeByValue(Node head, int value){
        if(head==null) return head;
        if(head.data== value){
            head=head.next;
            return head;
        }

        Node prev=null;
        Node curr=head;
        while(curr !=null){
            if(curr.data==value){
                prev.next=prev.next.next;
                break;
            }
            prev=curr;
            curr=curr.next;
        }
        return head;
    }

    private static Node insertAtHead(Node head, int value){
        Node temp= new Node(value,head);
        return temp;
    }

    private static Node insertAtTail(Node head, int value){
        Node curr=head;
        while(curr.next!=null){
            curr=curr.next;
        }
        Node temp=new Node(value);
        curr.next=temp;
        return head;

    }

    private static Node insertAtPosition(Node head, int value, int k){
        if (head==null){
            if(k==1){
                Node temp=new Node(value);
                return temp;
            }
            else{
                return head;
            }
        }
        if(k==1){
            Node temp=new Node(value,head);
            return temp;
        }
        int count=0;
        Node curr=head;
        while(curr!=null){
            count++;
            if(count==k-1){
                Node temp=new Node(value,curr.next);
                curr.next=temp;
                break;
            }
            curr=curr.next;
        }
        return head;
    }

    private static Node insertBeforeValue(Node head, int element, int value  ){
        if (head == null){
            return null;
        }
        if(head.data == value) {
            Node temp=new Node(element,head);
            return temp;
        }

        Node curr=head;
        while(curr.next!=null){
            if(curr.next.data==value){
                Node temp=new Node(value,curr.next);
                curr.next=temp;
                break;
            }
            curr=curr.next;
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


    public static void main(String[] args) {
        int[] arr = { 2, 5, 8, 7 , 11, 19};

        Node head = new Node(arr[0]);
        head.next = new Node(arr[1]);
        head.next.next = new Node(arr[2]);
        head.next.next.next = new Node(arr[3]);
        head.next.next.next.next = new Node(arr[4]);
        head.next.next.next.next.next = new Node(arr[5]);

        System.out.println("Original LL ");
        printLinkedList(head);
        head = removesHead(head);
        System.out.println("Removing head");
        printLinkedList(head);
        head = removesTail(head);
        System.out.println("Removing Tail");
        printLinkedList(head);
        System.out.println("Removing kth position");
        head = removeKthpostion(head,1);
        printLinkedList(head);
        System.out.println("Removing Value");
        head = removeByValue(head,14);
        printLinkedList(head);
        System.out.println("Inserting At Head");
        head = insertAtHead(head,1);
        printLinkedList(head);
        System.out.println("Inserting At Tail");
        head = insertAtTail(head,100);
        printLinkedList(head);
        System.out.println("Inserting At Postion");
        head = insertAtPosition(head,200,3);
        printLinkedList(head);
        System.out.println("Inserting Before Value");
        head = insertAtPosition(head,300,4);
        printLinkedList(head);

    }
}
