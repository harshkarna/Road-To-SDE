package com.Linked_List;

import sun.jvm.hotspot.types.CIntegerField;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Loop_Detection {

    public static Node <Integer> createLcycleinkedList() {
        Node<Integer> n1=new Node<>(10);
        Node<Integer> n2=new Node<>(20);
        Node<Integer> n3=new Node<>(30);
        Node<Integer> n4=new Node<>(40);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n2;

        return n1;

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

    public static  void print(Node<Integer> head) {
        //Printing Linked List
        //Note : good practice is keeping head in temp and iterate over temp
        Node<Integer> currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    public static boolean detectLoop(Node <Integer> head){
        if(head==null){
            return false;
        }
        LinkedHashMap<Node <Integer>, Boolean> visited = new LinkedHashMap<>();
        Node <Integer> temp=head;
        //Cycle is present
        while(temp!=null){
            if(visited.get(temp)==Boolean.TRUE){
                System.out.println("Cycle is present at Node " + temp.data);
                return true;
            }

            visited.put(temp,Boolean.TRUE);
            temp=temp.next;
        }
        return false;
    }

    public static Node <Integer> floydDetectLoop(Node <Integer> head){
        if(head==null){
            return null;
        }
        Node <Integer> slow=head;
        Node <Integer> fast=head;

        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;

            if(fast==slow){
//                System.out.println("Cycle is present at Node "+ slow.data);
               return slow;
            }
        }
        return null;
    }

    public static Node <Integer> getStartingNodeOfCycle(Node <Integer> head){
        if(head==null){
            return null;
        }
        Node <Integer> intersection =floydDetectLoop(head);
        Node <Integer> slow=head;
        while(slow!=intersection){
            slow=slow.next;
            intersection=intersection.next;
        }
        return slow;
    }

    public static void removeCyclicLoop(Node <Integer> head){
        if(head==null){
            return;
        }
        Node <Integer> startOfLoop=getStartingNodeOfCycle(head);
        Node <Integer> temp=startOfLoop;
        while(temp.next!=startOfLoop){
            temp=temp.next;
        }
        temp.next=null;
    }


    public static void main(String[] args) {
//        Node <Integer> head=takeInputOptimised();
        Node <Integer> head=createLcycleinkedList();

        Node <Integer> output=getStartingNodeOfCycle(head);
        if(output!=null){
            System.out.println("Cycle is Present at Node " + output.data);
        }
        else{
            System.out.println("No Cycle is Present");
        }

        removeCyclicLoop(head);
        print(head);




    }
}
