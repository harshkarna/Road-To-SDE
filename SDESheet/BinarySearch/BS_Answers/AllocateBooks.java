package com.SDESheet.BinarySearch.BS_Answers;
public class AllocateBooks {


    private static int getMax(int[] nums) {
        int maxi=Integer.MIN_VALUE;
        int n =nums.length;
        for(int i : nums){
            maxi=Math.max(maxi,i);
        }
        return maxi;
    }

    private static int sumAll(int[] nums) {
        int sum=0;
        int n =nums.length;
        for(int i : nums){
            sum += i;
        }
        return sum;
    }
    private static int countStudent(int[] arr, int pages) {
        int student=1;
        int pageStudent=0;
        for(int i=0;i <arr.length;i++){
           if(pageStudent +arr[i] <=pages){
               pageStudent+=arr[i];
           }
           else{
               student++;
               pageStudent=arr[i];
            }
        }
        return student;
    }


    public static int findPages(int[]A,int N,int M)
    {
        if(M>N) return -1;
        int low =getMax(A),high=sumAll(A),ans=N;
        while(low<=high){
            int mid=(low+high)/2;
            int student=countStudent(A,mid);
            if(student<=M){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }



    public static void main(String[] args) {


    }
}
