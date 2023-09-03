package org.dreambig.ds.array.easy;

import org.dreambig.ds.picker.IQuestion;

import java.util.List;

public class SumOfAllOddLengthArray implements IQuestion {
    @Override
    public String getQuestion() {
        return "Given an array of positive integers arr, return the sum of all possible odd-length subarrays of arr.\n" +
                "\n" +
                "A subarray is a contiguous subsequence of the array.\n" +
                "\n" +
                " \n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: arr = [1,4,2,5,3]\n" +
                "Output: 58\n" +
                "Explanation: The odd-length subarrays of arr and their sums are:\n" +
                "[1] = 1\n" +
                "[4] = 4\n" +
                "[2] = 2\n" +
                "[5] = 5\n" +
                "[3] = 3\n" +
                "[1,4,2] = 7\n" +
                "[4,2,5] = 11\n" +
                "[2,5,3] = 10\n" +
                "[1,4,2,5,3] = 15\n" +
                "If we add all these together we get 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58\n" +
                "Example 2:\n" +
                "\n" +
                "Input: arr = [1,2]\n" +
                "Output: 3\n" +
                "Explanation: There are only 2 subarrays of odd length, [1] and [2]. Their sum is 3.\n" +
                "Example 3:\n" +
                "\n" +
                "Input: arr = [10,11,12]\n" +
                "Output: 66\n";
    }

    @Override
    public List<String> getCompanies() {
        return null;
    }

    @Override
    public String getThingsToRemember() {
        return null;
    }

    public static int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length, answer = 0;

        for (int i = 0; i < n; ++i) {
            int left = i, right = n - i - 1;
            answer += arr[i] * (left / 2 + 1) * (right / 2 + 1);
            answer += arr[i] * ((left + 1) / 2) * ((right + 1) / 2);
        }

        return answer;

    }

    public static void main(String[] args) {

        System.out.println(sumOddLengthSubarrays(new int[]{1, 4, 2, 5, 3}));
    }
}
