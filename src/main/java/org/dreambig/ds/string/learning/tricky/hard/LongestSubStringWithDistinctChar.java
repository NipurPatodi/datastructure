package org.dreambig.ds.string.learning.tricky.hard;

/***
 * WAP To find longest substring with Distinct char
 * Example  ABCDABC
 * o/p =4  ABCD or BCDA or CDAB
 */
public class LongestSubStringWithDistinctChar {

    private   static  void refresh(int [] arr){
        for (int i=0;i<arr.length;i++)
            arr[i]=0;
    }

    /***
     * Complexity is n^2
     * @param ip input
     * @return result
     */
    public  static int  naive(String ip){
        int max= 0;
        int[] res= new int[256];
        int cur=0;
        for (int j=0;j<ip.length();j++)
        for (int i=j;i<ip.length();i++){
            if(res[ip.charAt(i)]>0){
                refresh(res);
                max=Math.max(cur,max);
                cur=0;
            }else{
                res[ip.charAt(i)]++;
                cur++;
            }
        }
       return max;
    }

    public  static int efficient (String ip){

        int []prev= new int [256];
        int res=0;
        int j=0;
        for (int i =0; i<ip.length();i++){
            j=Math.max(j,prev[ip.charAt(i)]+1); // This is tricky to add 1 in prev Idx
            int maxEnd=i-j+1;// curr idx - last occurrence  +1
            res=Math.max(res, maxEnd);
            prev[ip.charAt(i)]=i;
        }
        return  res;
    }




    public static void main(String[] args) {
        System.out.println(naive("ABCDABC"));
        System.out.println(naive("AAA"));
        System.out.println(naive(""));
        System.out.println(naive("nipur patodi"));
        System.out.println(efficient("nipur patodi"));
    }




}
