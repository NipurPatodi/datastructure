package org.dreambig.ds.string.practice.easy;

import org.dreambig.ds.picker.IQuestion;

import java.util.Arrays;
import java.util.List;

public class SubStringWithEq01 implements IQuestion {
    @Override
    public String getQuestion(){
        return "Given a binary string str of length N, the task is to find the maximum count of consecutive substrings str can be divided into such that all the substrings are balanced i.e. they have equal number of 0s and 1s. If it is not possible to split str satisfying the conditions then print -1.\n" +
                "Example: \n" +
                " \n" +
                "\n" +
                "Input: str = “0100110101” \n" +
                "Output: 4 \n" +
                "The required substrings are “01”, “0011”, “01” and “01”.\n" +
                "Input: str = “0111100010” \n" +
                "Output: 3 " +
                "" +
                "More Details at https://www.geeksforgeeks.org/split-the-binary-string-into-substrings-with-equal-number-of-0s-and-1s/";
    }
    @Override
    public List<String> getCompanies() {
        String []c=" ".split(" ");
        return Arrays.asList(c);
    }

    @Override
    public String getThingsToRemember() {
        return "Did it in first attempt... Awesome:)";
    }

    public int naive (String ip){
        char [] tkn=ip.toCharArray();
        int zeros=tkn[0]=='0'?1:-1;
        int ctr=0;
        for (int i=1;i<tkn.length;i++){
            if(tkn[i]=='0')
                zeros++;
            else
                zeros--;
            if(zeros==0)
                ctr++;
        }

        if(zeros !=0)
            return -1;
        else
           return ctr;
    }

    public static void main(String[] args) {
        SubStringWithEq01 obj= new SubStringWithEq01();

        System.out.println(obj.naive("11100010"));
    }
}
