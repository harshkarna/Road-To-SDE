package com.Hashmaps;


import java.util.ArrayList;

public class Map <K,V>{
    ArrayList<MapNode<K,V>> buckets;
    int count;
    int numBuckets;

    public Map(){
        buckets =new ArrayList<>();
        numBuckets=20;
        for(int i=0;i<numBuckets;i++){
            buckets.add(null);
        }

    }

    private int getBucketIndex(K key){
        int hc =key.hashCode();
        int index=hc % numBuckets;
        return index;
    }

    public int size(){
        return count;
    }

    public V removeKey(K key){
        int bucketIndex=getBucketIndex(key);
        MapNode<K,V> head=buckets.get(bucketIndex);
        MapNode<K,V> prev=null;

        while(head!=null){
            if(head.key.equals(key)){
                if(prev!=null){
                    prev.next=head.next;
                }
                else{
                    //if node to be deleted is the first node of linked list
                    buckets.set(bucketIndex,head.next);
                }
            }
            prev=head;
            head=head.next;
        }
        return null;

    }

    public V getValue(K key){
        int bucketIndex=getBucketIndex(key);
        MapNode<K,V> head=buckets.get(bucketIndex);
        while(head!=null){
            if(head.key.equals(key)){
                return head.value;
            }
            head=head.next;
        }
        return null;
    }

    public void insert(K key, V value){
        int bucketIndex=getBucketIndex(key);
        MapNode<K,V> head=buckets.get(bucketIndex);
        //element is already there , just update its value
        while(head!=null){
            if(head.key.equals(key)){
                head.value=value;
                return;
            }
            head=head.next;
        }
        //element is not there , insert at 0th position of linked list
        head=buckets.get(bucketIndex);
        MapNode<K,V> newNode=new MapNode<>(key, value);
        newNode.next=head;
        buckets.set(bucketIndex,newNode);
        count++;

    }


}
