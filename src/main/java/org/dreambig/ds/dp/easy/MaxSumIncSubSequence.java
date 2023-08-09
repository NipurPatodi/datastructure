package org.dreambig.ds.dp.easy;

import org.dreambig.ds.picker.IQuestion;

import java.util.List;

public class MaxSumIncSubSequence implements IQuestion {
    @Override
    public String getQuestion() {
        return "WAP to find max increasing subsequence of array " +
                "Please find more details at https://practice.geeksforgeeks.org/tracks/DSASP-DP/?batchId=154&tab=1 ";
    }

    @Override
    public List<String> getCompanies() {
        return null;
    }

    @Override
    public String getThingsToRemember() {
        return null;
    }

    int getMaxSumIncSubSeq_dp(int [] ip){
        int [] res=new int[ip.length];
        // using DP idea is simple
        // will find max subSeq till index -1 and add curr value to it.
        // how ever this looks like n2 solution
        // lets see :)
        // ip[]={3,20,4,6,7,30}


        res[0]=ip[0];
        res[1]=(ip[1]>ip[0])? res[0]+ip[1]:ip[1];

        for ( int i=2;i<ip.length;i++){
             if(ip[i]>=ip[i-1]){
                 //just add to find current value
                 res[i]=ip[i]+res[i-1];
             }
             else{


             }


        }



        return ip[ip.length-1];
    }

}
