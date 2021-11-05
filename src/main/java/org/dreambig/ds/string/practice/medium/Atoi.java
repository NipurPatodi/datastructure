package org.dreambig.ds.string.practice.medium;

import org.dreambig.ds.picker.IQuestion;

import java.util.List;

public class Atoi implements IQuestion {
    @Override
    public String getQuestion() {
        return "Your task  is to implement the function atoi. The function takes a string(str) as argument and converts it to an integer and returns it.\n" +
                "\n" +
                "Note: You are not allowed to use inbuilt function.\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input:\n" +
                "str = 123\n" +
                "Output: 123\n" +
                "Example 2:\n" +
                "\n" +
                "Input:\n" +
                "str = 21a\n" +
                "Output: -1\n" +
                "Explanation: Output is -1 as all\n" +
                "characters are not digit only.";
    }

    @Override
    public List<String> getCompanies() {
        return null;
    }

    @Override
    public String getThingsToRemember() {
        return null;
    }


    public int parseInt(String ip){
        String s=ip.trim();
        char [] tkn=s.toCharArray();
        int start='0';
        int end='9';
        int sign='-';
        int res=-1;
        int ctr =0;
        for (int i= tkn.length-1;i>=0;i--){
            int c= tkn[i];
            if(c!=sign &&(c>end || c<start) ){
                return -1;
            } else if(c==sign){
                res=res *-1;
                continue;
            }
            else{
                c=c-start;
            }
            if(res==-1)
                res=  (int)(c*Math.pow(10,ctr));
            else
            res= res+ (int)(c*Math.pow(10,ctr));
            ctr++;
        }
        return  res;
    }

    public static void main(String[] args) {
        String ip="12345";
        Atoi obj=new Atoi();
        System.out.println(obj.parseInt(ip));
        System.out.println(obj.parseInt("12u5"));
        System.out.println(obj.parseInt("-125"));
    }

}
