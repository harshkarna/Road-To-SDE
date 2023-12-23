package com.Linked_List;

import java.util.Scanner;

public class Add_2_numbers_in_LL {

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
        Node<Integer> n1=new Node<>(9);
        Node<Integer> n2=new Node<>(0);
        Node<Integer> n3=new Node<>(0);
        n1.next=n2;
        n2.next=n3;
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

    public static Node <Integer> add_2_LL(Node <Integer> head1,Node <Integer> head2){
       Integer carry=0;
       Integer toAdd=0;
       Node <Integer> output = head1;
       Node <Integer> temp=output;
       Node <Integer> cn1=head1;
       Node <Integer> cn2=head2;
       while(cn1!=null && cn2!=null){
           int sum=cn1.data+cn2.data +carry;
           carry=0;
           if(sum >=10){
               toAdd=sum%10;
               carry=sum/10;
               temp.data=toAdd;
           }
           else
           {
               temp.data=sum;
           }
           temp=temp.next;
           cn1=cn1.next;
           cn2=cn2.next;
       }
       if(carry!=0){
           System.out.println("carry is left");
           temp.next = new Node <>(carry);
       }
       output=reverse_LL(output);
       return output;
    }

    public static void main(String[] args) {
        Node <Integer> head1= createLinkedList();
        Node <Integer> head2=createLinkedList();
        head1=reverse_LL(head1);
        head2=reverse_LL(head2);
        Node <Integer> output=add_2_LL(head1,head2);
        print(output);

    }
}
