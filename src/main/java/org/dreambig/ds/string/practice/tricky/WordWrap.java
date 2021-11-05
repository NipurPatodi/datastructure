package org.dreambig.ds.string.practice.tricky;

import org.dreambig.ds.picker.IQuestion;

import java.util.List;
import java.util.Arrays;


public class WordWrap implements IQuestion {
    @Override
    public String getQuestion() {
        return "Given a sequence of words, and a limit on the number of characters that can be put in one line (line width). Put line breaks in the given sequence such that the lines are printed neatly. Assume that the length of each word is smaller than the line width.\n" +
                "The word processors like MS Word do task of placing line breaks. The idea is to have balanced lines. In other words, not have few lines with lots of extra spaces and some lines with small amount of extra spaces. \n" +
                " \n" +
                "\n" +
                "The extra spaces includes spaces put at the end of every line except the last one.  \n" +
                "The problem is to minimize the following total cost.\n" +
                " Cost of a line = (Number of extra spaces in the line)^3\n" +
                " Total Cost = Sum of costs for all lines\n" +
                "\n" +
                "For example, consider the following string and line width M = 15\n" +
                " \"Geeks for Geeks presents word wrap problem\" \n" +
                "     \n" +
                "Following is the optimized arrangement of words in 3 lines\n" +
                "Geeks for Geeks\n" +
                "presents word\n" +
                "wrap problem \n" +
                "\n" +
                "The total extra spaces in line 1, line 2 and line 3 are 0, 2 and 3 respectively. \n" +
                "So optimal value of total cost is 0 + 2*2 + 3*3 = 13" +
                "Find More Details at https://www.geeksforgeeks.org/word-wrap-problem-dp-19/";
    }

    @Override
    public List<String> getCompanies() {
        String[] c = "Microsoft ".split(" ");
        return Arrays.asList(c);
    }

    @Override
    public String getThingsToRemember() {
        return "";
    }

    public int solveWordWrapUsingMemo(int[] nums, int k) {
        // Mem table to hold values
        // k+1 because k+1th will yield result
        int[][] mem = new int[nums.length][k + 1];

        // Populating all by -1
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= k; j++)
                mem[i][j] = -1;
        }


        return solveWordWrapUsingMemo(nums,nums.length,k,0,k,mem);
    }


    private int solveWordWrapUsingMemo(int[] words, int n, int length, int wordIndex, int remLength, int[][] memo) {
        if (memo[wordIndex][remLength] != -1) // Already populated
            return memo[wordIndex][remLength];

        memo[wordIndex][remLength] = solveWordWrap(words, n, length, wordIndex, remLength, memo);
        return memo[wordIndex][remLength];
    }

    private int solveWordWrap(int[] words, int n, int length, int wordIndex, int remLength, int[][] memo) {
        // 1. Base case  when word is last word
        if (wordIndex == n - 1) {
            memo[wordIndex][remLength] = words[wordIndex] < remLength ? 0 : (int) Math.pow(remLength, 2);
            return memo[wordIndex][remLength];
        }
        int curr = words[wordIndex];
        // else
        if (curr < remLength) {
            return Math.min(
                    // if kept in same line
                    solveWordWrapUsingMemo(words, n, length, wordIndex + 1, remLength == length ? remLength - curr : remLength - curr - 1, memo),
                    // if kept in next line
                    (int) Math.pow(remLength, 2) + solveWordWrapUsingMemo(words, n, length, wordIndex + 1, length - curr, memo));
        } else
            return (int) Math.pow(remLength, 2) + solveWordWrapUsingMemo(words, n, length, wordIndex + 1, length - curr, memo);


    }

    public static void main(String[] args) {
        WordWrap ww= new WordWrap();
        int [] ip={3,2,2};
        System.out.println( ww.solveWordWrapUsingMemo(ip,4));

    }
}