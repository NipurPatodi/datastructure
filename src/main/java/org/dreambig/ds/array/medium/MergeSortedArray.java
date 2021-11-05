package org.dreambig.ds.array.medium;

import org.dreambig.ds.picker.IQuestion;

import java.util.Arrays;
import java.util.List;


public class MergeSortedArray implements IQuestion {
    @Override
    public String getQuestion() {
        return "We are given two sorted arrays. We need to merge these two arrays such that the initial numbers (after complete sorting) are in the first array and the remaining numbers are in the second array. Extra space allowed in O(1).\n" +
                "\n" +
                "Example: \n" +
                "\nInput: ar1[] = {10};\n" +
                "       ar2[] = {2, 3};\n" +
                "Output: ar1[] = {2}\n" +
                "        ar2[] = {3, 10}  \n" +
                "\n" +
                "Input: ar1[] = {1, 5, 9, 10, 15, 20};\n" +
                "       ar2[] = {2, 3, 8, 13};\n" +
                "Output: ar1[] = {1, 2, 3, 5, 8, 9}\n" +
                "        ar2[] = {10, 13, 15, 20}" +
                "Please find more details at https://www.geeksforgeeks.org/merge-two-sorted-arrays-o1-extra-space/";
    }

    @Override
    public List<String> getCompanies() {
        return Arrays.asList("linkedin.md".split(" "));
    }

    @Override
    public String getThingsToRemember() {
        return "Sweet Trick ... take time to revise";
    }

    public void merge (int[] arr1, int[] arr2){
        int n=arr1.length;
        int m=arr2.length;

        // Now Iterating from 2nd one in reverse order
        for (int i=m-1; i>=0;i--){
            // find last
            int last=arr1[n-1];
            int j=n-2;
            // swapping until we find element bigger than arr2[i]
            for (;j>=0 && arr1[j]>arr2[i];j--){
                arr1[j+1]=arr1[j];
            }

            //Now check if swap happened
            if(j!=n-2 || arr1[j+1]!=last){
                arr1[j+1]=arr2[i];
                arr2[i]=last;
            }


        }


    }

    public static void main(String[] args) {
        MergeSortedArray msa= new MergeSortedArray();
        int ar1[] = {1, 5, 9, 10, 15, 20};
        int ar2[] = {2, 3, 8, 13};
        msa.merge(ar1,ar2);
        for(int i: ar1)
            System.out.print(i+" ");
        System.out.println("--");
        for(int i: ar2)
            System.out.print(i+" ");




    }


}
