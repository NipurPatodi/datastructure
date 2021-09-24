package org.dreambig.ds.array.hard;
import java.util.*;
/***
 * Given an array arr[] denoting heights of N towers and a positive integer K, you have to modify the height of each tower either by increasing or decreasing them by K only once. After modifying, height should be a non-negative integer.
 * Find out what could be the possible minimum difference of the height of shortest and longest towers after you have modified each tower.
 *
 * A slight modification of the problem can be found here.
 *
 *
 * Example 1:
 *
 * Input:
 * K = 2, N = 4
 * Arr[] = {1, 5, 8, 10}
 * Output:
 * 5
 * Explanation:
 * The array can be modified as
 * {3, 3, 6, 8}. The difference between
 * the largest and the smallest is 8-3 = 5.
 */
public class MinimizeHeight {


public static class Pair{

  int data;
  int idx;

  public Pair(int data, int idx){
    this.data=data;
    this.idx=idx;
  }

}

public static  int findMinimizeHeight(int [] arr,int k){
  // first convert this into Pair
  List<Pair> v= new ArrayList<>();

  for (int i=0;i<arr.length;i++){
      if(arr[i]>=k){
        v.add(new Pair(arr[i]-k,i));
      }
      v.add(new Pair(arr[i]+k,i));
  }

  //Now Sorting it in Asc order
    Collections.sort(v, new Comparator<Pair>(){

      public int compare(Pair p1, Pair p2){
        if(p1.data!=p2.data) return p1.data-p2.data;
        else{
          return p1.idx-p2.idx;
        }
        }
    });

    int elementCovered=0; // Ponter to take care of coverage
    int left=0;
    int right=0;
    int [] taken= new int [arr.length];

    while( elementCovered<arr.length &&  right<v.size()){ // will break if any is false
        if(taken[v.get(right).idx]==0){
          elementCovered++;
        }
        taken[v.get(right).idx]++;
        right++;
      }

    int result=v.get(right-1).data- v.get(left).data; // simple approach

    // Now checking if we covered smallest
    while( right<v.size()){
      if(taken[v.get(left).idx]==1){
        elementCovered--;
      }
      taken[v.get(left).idx]--;
      left++;

      while ( elementCovered<arr.length && right<v.size()){

        if(taken[v.get(right).idx]==0){
          elementCovered++;
        }
        taken[v.get(right).idx]++;
        right++;
      }

      if(elementCovered==arr.length)
        result= Math.min(result,v.get(right-1).data-v.get(left).data);
      else
        break;
      }

      return result;

    }


    public static void main(String[] args) {
      int [] arr={2, 6, 3, 4, 7, 2, 10, 3, 2, 1};
    System.out.println(  findMinimizeHeight(arr,5));
    }






  }







