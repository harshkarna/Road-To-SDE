package com.PriorityQueues;

public class heapSort {

    //O(n logn)

    //Better version

    private static void heapifyAlgo(int[] arr, int size , int i) {
        //For max heap lets store the ith in largest
        int largest=i;
        int leftChild=2*i+1;
        int rightChild=2*i+2;

        //if its left child is greater than parent , replace largest index with leftchild index;
        if(leftChild < size  && arr[leftChild] > arr[largest]){
            largest=leftChild;
        }

        //if its right child is greater than parent , replace largest index with rightchild index;
        if(rightChild < size  && arr[rightChild] > arr[largest]){
            largest=rightChild;
        }

        //here if  we get to know if i is not equal to largest then just swap element of i and elemnent of largest
        if(largest!=i){
            int temp=arr[largest];
            arr[largest]=arr[i];
            arr[i]=temp;
            heapifyAlgo(arr,size,largest);
        }

    }

    public static void heapSort(int[] arr, int n){
         for(int current=n-1;current>0;current--) {
             //step1: swap root element with last element
             int temp = arr[0];
             arr[0] = arr[current];
             arr[current] = temp;
             //step2 :  send the array to heapify algo to take the root position to its correct position
             heapifyAlgo(arr,current,0);
             //repeat step 1 and step until sorted
             }
         }

    public static void main(String[] args) {

        int[] arr={4,1,3,9,7};
        int n= arr.length;
        //Create the max heap  from given array
        for(int i=n/2 -1;i>=0;i--){
            heapifyAlgo(arr,n,i);
        }

        //From the created heap array send that to heap sort function
        heapSort(arr,n);

        for(int i:arr){
            System.out.print(i + " ");
        }

    }
}










































//
//    Java
//            Refresh
//
//    Time (IST)	Status	User	Lang	Code
//2023-02-12 22:48:00	Wrong	harshkarna4	Java	View
//        2023-02-12 22:46:15	Wrong	harshkarna4	Java	View
//        2023-02-12 22:45:45	Wrong	harshkarna4	Java	View
//        2023-02-12 20:40:29	Correct	mdminha7dxs	Java	View
//        2023-02-12 19:45:19	Correct	redquark	Java	View
//        2023-02-12 14:20:32	Correct	vikasprtmc	Java	View
//        2023-02-12 13:38:04	Correct	itsme222	Java	View
//        2023-02-12 13:15:19	Correct	anant0211	Java	View
//        2023-02-11 23:09:58	Correct	tanaytic4la	Java	View
//        2023-02-11 21:12:42	Correct	i_m_sumitsingh	Java	View
//        2023-02-11 20:38:09	Correct	vijaymudit03	Java	View
//        2023-02-11 17:34:08	Correct	codeksaurav	Java	View
//        2023-02-11 16:09:13	Correct	ishaanjaiswal22	Java	View
//        2023-02-11 15:56:52	Correct	ishaanjaiswal22	Java	View
//        2023-02-11 15:56:23	Wrong	ishaanjaiswal22	Java	View
//        2023-02-11 14:35:36	Correct	rutvikbo7mv6	Java	View
//        2023-02-11 13:35:15	Wrong	ashisin8hyu	Java	View
//        2023-02-11 13:34:25	Wrong	ashisin8hyu	Java	View
//        2023-02-11 10:34:30	Correct	vg152	Java	View
//        2023-02-11 10:33:05	Wrong	vg152	Java	View
//        2023-02-10 21:16:51	Correct	promisedash79	Java	View
//        2023-02-10 21:12:44	Correct	saivarunbandari123	Java	View
//        2023-02-10 21:11:11	TLE	saivarunbandari123	Java	View
//        2023-02-10 19:58:23	Correct	suryanshhbtu	Java	View
//        2023-02-10 18:09:34	Correct	shivangiprasad1996	Java	View
//        2023-02-10 17:54:16	Correct	saurabhsahuishere	Java	View
//        2023-02-10 15:45:47	Correct	rohanmanchanda21	Java	View
//        2023-02-10 15:44:01	Compilation Error	rohanmanchanda21	Java	View
//        Java (1.8)
//        Average Time: 20m
//
//
//
//
//
//
//
//
//        Custom Input
//
//
//class Solution
//{
//    //Function to build a Heap from array.
//    void buildHeap(int arr[], int n)
//    {
//        // Your code here
//        for(int i=n/2-1;i>=0;i--){
//            heapify(arr,n,i);
//        }
//    }
//
//    //Heapify function to maintain heap property.
//    void heapify(int arr[], int n, int i)
//    {
//        // Your code here
//        int largest=i;
//        int l=2*i+1;
//        int r=2*i+2;
//        if(l<n&&arr[l]>arr[largest]){
//            largest=l;
//        }
//        if(r<n&&arr[r]>arr[largest]){
//            largest=r;
//        }
//        if(largest!=i){
//            swap(arr,i,largest);
//            heapify(arr,n,largest);
//        }
//    }
//
//    //Function to sort an array using Heap Sort.
//    public void heapSort(int arr[], int n)
//    {
//        //code here
//        buildHeap(arr,n);
//        for(int i=n-1;i>0;i--){
//            swap(arr,0,i);
//            heapify(arr,i,0);
//        }
//    }
//    void swap(int arr[],int a,int b){
//        int temp=arr[a];
//        arr[a]=arr[b];
//        arr[b]=temp;
//    }
//}
//
//
