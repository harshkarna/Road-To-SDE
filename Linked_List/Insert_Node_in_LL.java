package com.Linked_List;

import java.util.Scanner;

public class Insert_Node_in_LL {

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
        Node<Integer> n1=new Node<>(10);
        Node<Integer> n2=new Node<>(20);
        Node<Integer> n3=new Node<>(30);
        Node<Integer> n4=new Node<>(40);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
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

    public static Node <Integer> insert_at_ith_ll(Node <Integer> head, int index, int data ){
     Node <Integer> newNode= new Node<Integer>(data);

       //edge case
        if(index==0){
            newNode.next=head;
            head=newNode;
            return head;
        }
        else{
            Node <Integer> prev =head;
            int position=0;
            while(prev!=null && position < index-1){
                prev=prev.next;
                position++;
            }
            //Below if to avoid excpetion when we pass index to be inserted out of size of LL
            if(prev!=null){
                //Storing i-1 next address in new node next
                newNode.next= prev.next;
                //Storing new node address in prev.next
                prev.next=newNode;
            }
            return head;
        }

    }

    public static void main(String[] args) {

        Node <Integer> head = createLinkedList();
        head = insert_at_ith_ll(head,0,15);
        print(head);

    }

}
