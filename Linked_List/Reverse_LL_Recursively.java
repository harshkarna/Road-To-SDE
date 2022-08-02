package com.Linked_List;

public class Reverse_LL_Recursively {


    public static Node <Integer> createLinkedList() {
        Node<Integer> n1=new Node<>(10);
        Node<Integer> n2=new Node<>(20);
        Node<Integer> n3=new Node<>(30);
        Node<Integer> n4=new Node<>(40);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        return n1;

    }

    public static void print_recursive(Node <Integer> head){
        if(head==null){
            return;
        }
        System.out.print(head.data+" ");
        print_recursive(head.next);

    }

    public static Node <Integer> recursive_ll(Node <Integer> head){
       if(head.next==null || head==null){ //if length 0 or 1;
           return head;
       }

       Node <Integer> small_head=recursive_ll(head.next);
       head.next.next=head;
       head.next=null;
       return small_head;

    }


    public static void main(String[] args) {
        Node <Integer> head=createLinkedList();
        head=recursive_ll(head);
        print_recursive(head);

    }


}
