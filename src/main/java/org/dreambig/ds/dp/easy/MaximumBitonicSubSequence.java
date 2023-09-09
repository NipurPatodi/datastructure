package org.dreambig.ds.dp.easy;

public class MaximumBitonicSubSequence {
    static int getMaxLenBitonicSeq(int [] nums){
        int [] lis = new int[nums.length];
        int [] lds = new int[nums.length];
        // computing lis
        lis[0]=1;
        for(int i=1;i<nums.length;i++){
            int maxLen=0;
            for (int j=i-1;j>=0;j--){
                if(nums[i]>=nums[j])
                    maxLen=Math.max(maxLen, lis[j]);
            }
            lis[i]=maxLen+1;
        }

        // Computing LDS
        lds[nums.length-1]=1;
        for (int i=nums.length-2;i>=0;i--){
            int maxLen=0;
            for (int j=i+1; j<nums.length;j++){
                if(nums[i]<=nums[j])
                    maxLen=Math.max(maxLen, lds[j]);
            }
            lds[i]=maxLen+1;
        }
        int max=1;
        for (int i=0;i<nums.length;i++){
            max=Math.max(max, lds[i]+lis[i]-1);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] ip ={1,11,2,10,4,5,2,1};
        System.out.println(getMaxLenBitonicSeq(ip));
    }
}
