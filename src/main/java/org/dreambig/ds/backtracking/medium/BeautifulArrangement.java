package org.dreambig.ds.backtracking.medium;

import org.dreambig.ds.picker.IQuestion;

import java.util.Arrays;
import java.util.List;

public class BeautifulArrangement implements IQuestion {
    @Override
    public String getQuestion() {
        return "Suppose you have n integers labeled 1 through n. A permutation of those n integers perm (1-indexed) is considered a beautiful arrangement if for every i (1 <= i <= n), either of the following is true:\n" +
                "\n" +
                "perm[i] is divisible by i.\n" +
                "i is divisible by perm[i].\n" +
                "Given an integer n, return the number of the beautiful arrangements that you can construct.\n" +
                "\n" +
                " \n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: n = 2\n" +
                "Output: 2\n" +
                "Explanation: \n" +
                "The first beautiful arrangement is [1,2]:\n" +
                "    - perm[1] = 1 is divisible by i = 1\n" +
                "    - perm[2] = 2 is divisible by i = 2\n" +
                "The second beautiful arrangement is [2,1]:\n" +
                "    - perm[1] = 2 is divisible by i = 1\n" +
                "    - i = 2 is divisible by perm[2] = 1\n" +
                "Example 2:\n" +
                "\n" +
                "Input: n = 1\n" +
                "Output: 1" +
                "Please find more details at https://leetcode.com/problems/beautiful-arrangement/";
    }

    @Override
    public List<String> getCompanies() {
        return Arrays.asList("linkedin".split(" "));
    }

    @Override
    public String getThingsToRemember() {
        return "It is a backtracking problem";
    }
        int count;

    int getBeautifulArrangement(int  N){
        boolean [] visited= new boolean[N +1];

          calculate(N,1,visited);
          return count;
    }

    void calculate(int  N, int pos, boolean[] visited){
        if(pos >N){
            count++;
        }
        for ( int i=1;i<=N;i++){ // Should start with 1 as 0/0 is NAN
            if(!visited[i]){
                if(i%pos==0 || pos%i==0){
                    visited[i]=true;
                    calculate(N,pos+1,visited);
                    visited[i]=false;
                }
            }
        }
    }

    public static void main(String[] args) {
        BeautifulArrangement ba= new BeautifulArrangement();
        System.out.println(ba.getBeautifulArrangement(3));
    }

}
