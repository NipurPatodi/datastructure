package org.dreambig.ds.dp.easy;

public class MaxCut {

    int maxCut(int leftOutRod, int a, int b, int c, int []cache){
        if (leftOutRod <a && leftOutRod < b && leftOutRod < c)
            return -1;
        if (leftOutRod ==a && leftOutRod == b && leftOutRod == c)
            return 1;

        if(cache[leftOutRod]==-1){


            int res=Math.max(Math.max(cache[leftOutRod-a],cache[leftOutRod-b]), cache[leftOutRod-c]);
            if(res==-1)
                cache[leftOutRod] =res;
            else
                cache[leftOutRod]= res+1;
        }
        return cache[leftOutRod];
    }

    int maxCut(int rode,int a, int b, int c){
        int[] cache =new int[rode.lenght]
    }

    public static void main(String[] args) {
        int road

    }
}
