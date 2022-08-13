package com.Linked_List;

import java.util.Scanner;

public class Sort_0_1_2_in_LL {

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

    public static Node <Integer> sortList(Node <Integer> head){
        int zeroCount=0;
        int oneCount=0;
        int twoCount=0;

        Node <Integer> temp=head;
        while(temp!=null){
            if(temp.data==0){
                zeroCount++;
            }
            else if(temp.data==1){
                oneCount++;
            }
            else if(temp.data==2){
                twoCount++;
            }
            temp=temp.next;
        }
        temp=head;
        while(temp!=null){
            if(zeroCount!=0){
                temp.data=0;
                zeroCount--;
            }
            else if(oneCount!=0){
                temp.data=1;
                oneCount--;
            }
            else if(twoCount==2){
                temp.data=2;
                twoCount--;
            }

            temp=temp.next;
        }
        return head;
    }


    public static void main(String[] args) {

        Node <Integer> head=takeInputOptimised();
        sortList(head);
        print(head);


    }
}
