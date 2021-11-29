package org.dreambig.ds.array.medium;

import org.dreambig.ds.picker.IQuestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FactorialsOfNumber implements IQuestion {
    @Override
    public String getQuestion() {
        return "Numbers can be regarded as the product of their factors.\n" +
                "\n" +
                "For example, 8 = 2 x 2 x 2 = 2 x 4.\n" +
                "Given an integer n, return all possible combinations of its factors. You may return the answer in any order.\n" +
                "\n" +
                "Note that the factors should be in the range [2, n - 1].\n" +
                "\n" +
                " \n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: n = 1\n" +
                "Output: []\n" +
                "Example 2:\n" +
                "\n" +
                "Input: n = 12\n" +
                "Output: [[2,6],[3,4],[2,2,3]]\n" +
                "Example 3:\n" +
                "\n" +
                "Input: n = 37\n" +
                "Output: []\n" +
                "Example 4:\n" +
                "\n" +
                "Input: n = 32\n" +
                "Output: [[2,16],[4,8],[2,2,8],[2,4,4],[2,2,2,4],[2,2,2,2,2]]\n" +
                "Please find more details at https://leetcode.com/problems/factor-combinations/";
    }

    @Override
    public List<String> getCompanies() {
        return Arrays.asList("linkedin".split(" "));
    }

    @Override
    public String getThingsToRemember() {
        return null;
    }


    public void getFactorRecursive(int num, int factor, List<Integer> tmp, List<List<Integer>> result){
        // Factor is starting
        //i is smaller than and equal sqrt of num
        // because beyond that it will never contribute to factor
        for ( int i=factor; i*i<=num;i++){
            if(num%i!=0){ // Not a factor
                continue;
            }
            tmp.add(i);
            List<Integer> res = new ArrayList<>(tmp);
            res.add(num / i);
            result.add(res);

            if( i*i<=num/i){// futhur find facto
                getFactorRecursive(num/i,i,tmp,result);
            }
            tmp.remove(tmp.size()-1);

        }

    }



    public List<List<Integer>> getFactor( int num){
        List<List<Integer>> result= new ArrayList<>();
        if(num<3) return  result;

        getFactorRecursive(num, 2, new ArrayList<>(),result);
        return result;

    }

    public static void main(String[] args) {
        FactorialsOfNumber fon = new FactorialsOfNumber();
        List<List<Integer>> res = fon.getFactor(32);
        for (List<Integer> i : res) {
            for (Integer j : i) {
                System.out.print(" "+j);

            }
            System.out.println("");
        }

    }
}
