package org.dreambig.ds.string.practice.medium;

import org.dreambig.ds.picker.IQuestion;

import java.util.Arrays;
import java.util.List;

public class FindSmallestGreaterNumber implements IQuestion {
    @Override
    public String getQuestion() {
        return "Given a number n, find the smallest number that has same set of digits as n and is greater than n. If n is the greatest possible number with its set of digits, then print “not possible”.\n" +
                "\n" +
                "Examples: \n" +
                "For simplicity of implementation, we have considered input number as a string. \n" +
                "\n" +
                "Input:  n = \"218765\"\n" +
                "Output: \"251678\"\n" +
                "\n" +
                "Input:  n = \"1234\"\n" +
                "Output: \"1243\"\n" +
                "\n" +
                "Input: n = \"4321\"\n" +
                "Output: \"Not Possible\"\n" +
                "\n" +
                "Input: n = \"534976\"\n" +
                "Output: \"536479\"" +
                "Find more details at https://www.geeksforgeeks.org/find-next-greater-number-set-digits/";
    }

    @Override
    public List<String> getCompanies() {
        String []c=" Microsoft Google".split(" ");
        return Arrays.asList(c);

    }

    @Override
    public String getThingsToRemember() {
        return null;
    }

    public String findSmallestNumber(String ip){
        return null;
    }



}
