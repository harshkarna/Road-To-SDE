package com.Linked_List;

public class Print_LL_Recursively {


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
        //Base case
        if(head==null){
            return;
        }
        System.out.print(head.data+" ");
        print_recursive(head.next);

    }


    public static void main(String[] args) {
        Node <Integer> head=createLinkedList();
        print_recursive(head);


    }
}
