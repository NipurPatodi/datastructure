package org.dreambig.ds.array.medium;

import org.dreambig.ds.picker.IQuestion;

import java.util.*;

public class FindGreatestPair implements IQuestion {
    @Override
    public String getQuestion() {
        return "Find pair with greatest product in array\n" +
                "Difficulty Level : Medium\n" +
                "Last Updated : 28 Aug, 2021\n" +
                "Given an array of n elements, the task is to find the greatest number such that it is product of two elements of given array. If no such element exists, print -1. Elements are within the range of 1 to 10^5.\n" +
                "Examples : \n" +
                " \n" +
                "\n" +
                "Input :  arr[] = {10, 3, 5, 30, 35}\n" +
                "Output:  30\n" +
                "Explanation: 30 is the product of 10 and 3.\n" +
                "\n" +
                "Input :  arr[] = {2, 5, 7, 8}\n" +
                "Output:  -1\n" +
                "Explanation: Since, no such element exists.\n" +
                "\n" +
                "Input :  arr[] = {10, 2, 4, 30, 35}\n" +
                "Output:  -1\n" +
                "\n" +
                "Input :  arr[] = {10, 2, 2, 4, 30, 35}\n" +
                "Output:  4\n" +
                "\n" +
                "Input  : arr[] = {17, 2, 1, 35, 30}\n" +
                "Output : 35" +
                "Please find more details at https://www.geeksforgeeks.org/find-pair-with-greatest-product-in-array/";
    }

    @Override
    public List<String> getCompanies() {
        return Arrays.asList("linkedin.md".split(" "));
    }

    @Override
    public String getThingsToRemember() {
        return null;
    }

    public int findGreatestPair(int [] arr, int n){

        // we need map to store occurrence of number
        Map<Integer,Integer> map = new HashMap<>();
        for (int i:arr){
            if(map.containsKey(i)){
                map.put(i,map.get(i)+1);
            }
            else
                map.put(i,1);
        }
        // Now sorting to iterate in sqrt order
        Arrays.sort(arr);
        // first from largest to smallest

        for (int i=n-1;i>1;i--){
            for(int j=0;j<i && arr[j]<=Math.sqrt(arr[i]);j++) {
                // iterating from smallest to largest
                // Now check divisibility

                if (arr[i] % arr[j] == 0) {
                    int res = arr[i] / arr[j];

                    if( res==arr[i] && map.containsKey(res) && map.get(res)>1){ // *1 and is not same idx
                        return arr[i];
                    }
                    if (res != arr[j]  && res != arr[i] && map.containsKey(res)  ) {
                        return arr[i];
                    }

                    if (res == arr[j] && map.containsKey(res) && map.get(res)>1) // repeatative
                        return arr[i];


                }
            }


            }
        return  -1;
    }

    public static void main(String[] args) {
        FindGreatestPair obj = new FindGreatestPair();
        int []arr = {17, 2, 2, 15, 4};

        System.out.println(obj.findGreatestPair(arr,arr.length));
        int [] arr2={5, 1, 25};
        System.out.println(obj.findGreatestPair(arr2,arr2.length));
    }


}

