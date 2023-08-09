package org.dreambig.ds.array.easy;

import org.dreambig.ds.picker.IQuestion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum implements IQuestion {
    @Override
    public String getQuestion() {
        return "Given array Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.\n" +
                "\n" +
                "You may assume that each input would have exactly one solution, and you may not use the same element twice.\n" +
                "\n" +
                "You can return the answer in any order.\n" +
                "\n" +
                " \n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: nums = [2,7,11,15], target = 9\n" +
                "Output: [0,1]\n" +
                "Output: Because nums[0] + nums[1] == 9, we return [0, 1].\n" +
                "Example 2:\n" +
                "\n" +
                "Input: nums = [3,2,4], target = 6\n" +
                "Output: [1,2]\n" +
                "Example 3:\n" +
                "\n" +
                "Input: nums = [3,3], target = 6\n" +
                "Output: [0,1]" +
                "Please find more details at https://leetcode.com/explore/interview/card/amazon/76/array-and-strings/508/";
    }

    @Override
    public List<String> getCompanies() {
        return Arrays.asList("amazon","");
    }

    @Override
    public String getThingsToRemember() {
        return null;
    }
    public int[] twoSum(int[] nums, int target) {
    int [] res= new int[2];
    Map<Integer,Integer> numIdxMap=new HashMap<>();
    for (int i=0;i<nums.length;i++) {
        numIdxMap.put(nums[i], i);
    }
    // iterating to find number
        for ( int i=0;i<nums.length;i++){
            int lo= target -nums[i];
            if(numIdxMap.containsKey(lo)){
                if(numIdxMap.get(lo)!=i){
                    res[0]=i;
                    res[1]=numIdxMap.get(lo);
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TwoSum obj= new TwoSum();
        int []num={2,7,11,15};
   Arrays.stream(obj.twoSum(num, 13)).forEach(System.out::println);
    }

}
