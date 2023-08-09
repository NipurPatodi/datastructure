package org.dreambig.ds.dp.easy;

import org.dreambig.ds.picker.IQuestion;

import java.util.ArrayList;
import java.util.List;

public class LongestIncSubsequence implements IQuestion {
    @Override
    public String getQuestion() {
        return "WAP to implement longest increase in array subsequence using array. " +
                "Please find more dtails @ https://www.geeksforgeeks.org/longest-increasing-subsequence-dp-3/" ;
    }

    @Override
    public List<String> getCompanies() {
        return null;
    }

    @Override
    public String getThingsToRemember() {
        return null;
    }

    /***
     * This approach uses DP
     * @param ip Input array
     * @return Longest Increasing subsequence length
     */
    public  int getLongestIncSub(int [] ip){

        int [] lis= new int [ip.length]; // Longest increasing subsequence till IDX
        // this problem has overlapping solution
        lis[0]=1;

        int max=0;
        for (int i=1;i<ip.length;i++){
            for (int j=0;j<i;j++){
                if(ip[j]<ip[i]){
                    max=Math.max(max,lis[j]);
                }

            }
            lis[i]= max+1;
            max=0;
        }
         int res=lis[0];
        for ( int ctr=1;ctr<ip.length;ctr++){
            res= Math.max(res,lis[ctr]);
        }
        return res;
    }


    private  int  search(int val, int [] lst, int s, int e){
            while(e>s){
                int mid= s+(e-s)/2;
                if(lst[mid]>=val){
                    e=mid;
                }else{
                    s=mid+1;
                }
            }
            return  e;
        }


    /***
     * This is n log n solution
     * @param ip
     * @return
     */
  public   int getLongestIncSub_nlogn(int[]ip){
    // Algo is very simple , find smallest in LIS and keep swapping
      // and finally find size of array list
      int[] res= new int[ip.length];
      res[0]=ip[0];
      int len=0;
      for (int i=1;i<ip.length;i++){
         if(res[len]<=ip[i]){
             len++;
             res[len]=ip[i];
         }else {
             int idx = search(ip[i], res,0,len);
             res[idx] = ip[i];
         }
      }
      return len+1;


    }





    public static void main(String[] args) {
        LongestIncSubsequence obj = new LongestIncSubsequence();
        int[] ip={3,4,2,8,10,5,11};

        System.out.println(obj.getLongestIncSub(ip));
        // Completed in 8.25 mins //

        int[] ip2={5,4,1,2,1};
        System.out.println(obj.getLongestIncSub_nlogn(ip2));
        System.out.println(obj.getLongestIncSub(ip2));
    }




}
