package com.Linked_List;

public class Find_middle_point_ll {


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

    public static Node <Integer> get_mid_point(Node <Integer> head){
        Node <Integer> slow=head, fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {

        Node <Integer> head=createLinkedList();
        head=get_mid_point(head);
        System.out.println(head.data);

    }
}
