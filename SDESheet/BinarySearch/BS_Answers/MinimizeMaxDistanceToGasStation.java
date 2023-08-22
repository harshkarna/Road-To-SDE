package com.SDESheet.BinarySearch.BS_Answers;

import java.util.PriorityQueue;

public class MinimizeMaxDistanceToGasStation {

    public static double findSmallestMaxDist_Brute(int stations[],int K) {
        int n =stations.length;
        int[] howManyPlaced=new int[n-1];
        for(int gasStations=1; gasStations <=K;gasStations++){
            double maxSectionLength=-1;
            int maxIndex=-1;
            for(int i =0; i < n-1; i++){
                double diff=stations[i+1]-stations[i];
                double sectionLength=diff/(double) (howManyPlaced[i]+1);
                if(sectionLength > maxSectionLength){
                    maxSectionLength=sectionLength;
                    maxIndex=i;
                }
            }
            howManyPlaced[maxIndex]++;
        }

        double maxAns=-1;
        for(int i =0; i < n-1; i++){
            double diff=stations[i+1]-stations[i];
            double sectionLength=diff/(double) (howManyPlaced[i]+1);
            maxAns=Math.max(maxAns,sectionLength);
        }
        return maxAns;

    }
    public static  class Pair{
        double sectionLength;
        int sectionIndex;

        public Pair(double sectionLength, int sectionIndex) {
            this.sectionLength = sectionLength;
            this.sectionIndex = sectionIndex;
        }
    }

    public static double findSmallestMaxDist_Heap(int stations[],int K) {
        int n =stations.length;
        int[] howManyPlaced=new int[n-1];
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> Double.compare(y.sectionLength,x.sectionLength));//max heap
        for(int i =0; i < n-1; i++){
            pq.add(new Pair(stations[i+1]-stations[i],i));
        }

        for(int gasStations=1; gasStations <=K;gasStations++){
          Pair top=pq.poll();
          int secIndex=top.sectionIndex;
          howManyPlaced[secIndex]++;
          double initialDiff=stations[secIndex+1]-stations[secIndex];
          double newSectionLength=initialDiff/(double) (howManyPlaced[secIndex]+1);
          pq.add(new Pair(newSectionLength,secIndex));
        }
        return pq.peek().sectionLength;

    }

    public static void main(String[] args) {


    }
}
