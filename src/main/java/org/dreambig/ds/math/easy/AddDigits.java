package org.dreambig.ds.math.easy;

import org.dreambig.ds.picker.IQuestion;

import java.util.Arrays;
import java.util.List;

public class AddDigits implements IQuestion {
    @Override
    public String getQuestion() {
        return "Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.\n" +
                "\n" +
                " \n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: num = 38\n" +
                "Output: 2\n" +
                "Explanation: The process is\n" +
                "38 --> 3 + 8 --> 11\n" +
                "11 --> 1 + 1 --> 2 \n" +
                "Since 2 has only one digit, return it.\n" +
                "Example 2:\n" +
                "\n" +
                "Input: num = 0\n" +
                "Output: 0" +
                "Please find more details @ https://leetcode.com/problems/add-digits/";
    }

    @Override
    public List<String> getCompanies() {
        return Arrays.asList("linkedin.md".split(" "));
    }

    @Override
    public String getThingsToRemember() {
        return null;
    }


    public int addDigits(int num) {
        if(num<10){
            return num;
        }
        while(num>=10){

            char[] tkn=(num+"").trim().toCharArray();
            int res=0;
            for (char cr : tkn){
                res += Integer.parseInt(cr+"");
            }
            num=res;
        }

        return num;

    }
}
