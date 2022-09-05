package com.Linked_List;

public class Insert_node_Recursively_in_LL {

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


    public static Node <Integer> insert_recursively(Node <Integer> head, int  data, int index){
        if(head==null && index > 0){
            return null; //return head
        }
        //Base cas
        if(index==0){
            Node <Integer> new_head= new Node<>(data);
            new_head.next=head;
            return new_head;
//            head=new_head;
//            return head;
        }
//        else{
           Node <Integer> smallerhead= insert_recursively(head.next,data, index-1);
           head.next=smallerhead;

           return head;
//        }

    }

    public static void main(String[] args) {
        Node <Integer> head=createLinkedList();
        head=insert_recursively(head,9,8);
        print_recursive(head);


    }
}
