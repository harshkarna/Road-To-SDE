package com.Linked_List;


import java.util.LinkedList;
import java.util.Scanner;

public class LinkedListUse {

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

    public static Node <Integer> takeInput(){
        //TC is O(n^2) is actually not good
        Scanner s =new Scanner(System.in);
        int data=s.nextInt();
        Node<Integer> head = null;
        while(data!=-1){
            Node <Integer> currentNode= new Node<Integer>(data);
            //This if will run only once
            if(head==null){
                //Make this node as head
                head=currentNode;
            }
            else{
                Node<Integer> tail=head;
                while(tail.next!=null){
                    tail=tail.next;
                }
                //Now tail is refreing to last Node
                //Connect current Node after last Node
                tail.next=currentNode;
            }

            data=s.nextInt();
        }
        return head;
    }

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

    public static void Length(Node <Integer> head){
        Node<Integer> temp= head;
        int count=0;
        while (temp!=null){
            count++;
            temp=temp.next;
        }
        System.out.println("Length is " + count);
    }

    public static void increment (Node <Integer> head){
        Node<Integer> temp= head;
        while (temp!=null){
            temp.data++;
            temp=temp.next;
        }
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

//        System.out.println("Print "+ head);
//        System.out.println(head.data);
//        System.out.println(head.next.data);
//        System.out.println(head.next.next.data);
//        System.out.println(head.next.next.next.data);




    public static void main(String[] args) {

        Node <Integer> head=createLinkedList();
//        Node <Integer> head=takeInputOptimised();

//        increment((head);
        print(head);
//        Length(head);

//        Node <Integer> n1=new Node<>(10);
//        System.out.println(n1);
//        System.out.println(n1.data);
//        System.out.println(n1.next);
    }


}
