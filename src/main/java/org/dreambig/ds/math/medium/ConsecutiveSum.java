package org.dreambig.ds.math.medium;

import org.dreambig.ds.picker.IQuestion;

import java.util.Arrays;
import java.util.List;

public class ConsecutiveSum implements IQuestion {
    @Override
    public String getQuestion() {
        return "Count ways to express a number as sum of consecutive numbers\n" +
                "Difficulty Level : Medium\n" +
                "Last Updated : 18 Jun, 2021\n" +
                "Given an integer N, the task is to find the number of ways to represent this number as a sum of 2 or more consecutive natural numbers.\n" +
                "\n" +
                "Examples: \n" +
                " Input: N = 15 \n" +
                "Output: 3 \n" +
                "Explanation: \n" +
                "15 can be represented as: \n" +
                " \n" +
                "\n" +
                "1 + 2 + 3 + 4 + 5\n" +
                "4 + 5 + 6\n" +
                "7 + 8\n" +
                "Input: N = 10 \n" +
                "Output: 1 ";
    }

    @Override
    public List<String> getCompanies() {
        return Arrays.asList("linkedin.md");
    }

    @Override
    public String getThingsToRemember() {
        return " Formula is N=a+(a+1)+(a+2).... (a+L) so a=(N-(l*(l+1))/2)";
    }

    public int getConsecutiveSumCount(final int N){
        int res=0;

        for ( int l=1;l*(l+1)<2*N; l++){
            double a=(double) (N-(l*(l+1)/2))/(1+l);
            if(a==(int)a) {
                System.out.println("a="+a+" and l="+l);
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ConsecutiveSum obj = new ConsecutiveSum();
        System.out.println(obj.getConsecutiveSumCount(17530));
    }



}
