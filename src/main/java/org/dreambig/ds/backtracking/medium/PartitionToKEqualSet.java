package org.dreambig.ds.backtracking.medium;

import org.dreambig.ds.picker.IQuestion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionToKEqualSet implements IQuestion {
    @Override
    public String getQuestion() {
        return "Given an integer array nums and an integer k, return true if it is possible to divide this array into k non-empty subsets whose sums are all equal.\n" +
                "\n" +
                " \n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: nums = [4,3,2,3,5,2,1], k = 4\n" +
                "Output: true\n" +
                "Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.\n" +
                "Example 2:\n" +
                "\n" +
                "Input: nums = [1,2,3,4], k = 3\n" +
                "Output: false" +
                "Please find more details at https://leetcode.com/problems/partition-to-k-equal-sum-subsets/";
    }

    @Override
    public List<String> getCompanies() {
        return Arrays.asList("linkedin".split(" "));
    }

    @Override
    public String getThingsToRemember() {
        return null;
    }

    boolean canSplitByKOptimized(int[] arr, int k) {
        int totSum = 0; // First compute sum

        for (int i : arr) {
            totSum += arr[i];
        }
        if (totSum % k != 0) { // Can not be splitted in K parts
            return false;
        }
        char[] taken = new char[arr.length];
        for (int i=0;i<arr.length;i++){
            taken[i]='0';
        }
        Map<String,Boolean> cache= new HashMap<>();
        int targetTotal = totSum / k;

        return backtrackOpt(arr, 0, targetTotal, 0, k, taken,cache);

    }


    private boolean backtrackOpt(int[] arr, int currSum, final int target, int setCount, final int k, char[] taken, Map<String,Boolean>cache) {

        if (setCount == k - 1) { // because last will obviously work
            return true;
        }
        if (currSum > target) // this is invalid value
            return false;


        // this is place to see if we are repeating checks as can save alot by Memorization
        String cacheKey= new String(taken);
        if(cache.containsKey(cacheKey)){
            return  cache.get(cacheKey);
        }

        if (currSum == target) { // If positive  than try other alternate
            boolean res= backtrackOpt(arr, 0, target, setCount + 1, k, taken,cache);
            cacheKey= new String(taken);
            cache.put(cacheKey,res);
            return res;
        }

        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (taken[i]=='0') { // Proceed if not considered already
                taken[i] = '1';
                if (backtrackOpt(arr, currSum + arr[i], target, setCount, k, taken,cache)) {
                    return true;
                }
                taken[i] = '0';
            }
        }

        return false;
    }


    boolean canSplitByK(int[] arr, int k) {
        int totSum = 0; // First compute sum

        for (int i : arr) {
            totSum += arr[i];
        }
        if (totSum % k != 0) { // Can not be splitted in K parts
            return false;
        }
        boolean[] taken = new boolean[arr.length];
        int targetTotal = totSum / k;

        return backtrack(arr, 0, targetTotal, 0, k, taken);

    }

    private boolean backtrack(int[] arr, int currSum, final int target, int setCount, final int k, boolean[] taken) {

        if (setCount == k - 1) { // because last will obviously work
            return true;
        }
        if (currSum > target) // this is invalid value
            return false;

        if (currSum == target) { // If positive  than try other alternate
           return backtrack(arr, 0, target, setCount + 1, k, taken);

        }

        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (!taken[i]) { // Proceed if not considered already
                taken[i] = true;
                if (backtrack(arr, currSum + arr[i], target, setCount, k, taken)) {
                    return true;
                }
                taken[i] = false;
            }
        }

        return false;
    }


    public static void main(String[] args) {
        PartitionToKEqualSet obj = new PartitionToKEqualSet();
        int[] ip = {4, 3, 2, 3, 5, 2, 1};
        int k = 4;
        System.out.println(obj.canSplitByK(ip, k));
        System.out.println(obj.canSplitByKOptimized(ip, k));
    }


}
