package org.dreambig.ds.string.practice.tricky;

import org.dreambig.ds.picker.IQuestion;

import java.util.Arrays;
import java.util.List;

public class Permutation implements IQuestion {
    @Override
    public String getQuestion(){
        return "WAP to compute all permutation of string";
    }
    @Override
    public List<String> getCompanies() {
        String []c=" ".split(" ");
        return Arrays.asList(c);
    }

    @Override
    public String getThingsToRemember() {
        return "This is DP problem and solution is tricky";
    }

    private String swap(String s, int i, int j){
        char[] tkn=s.toCharArray();
        char t= tkn[i];
        tkn[i]=tkn[j];
        tkn[j]=t;
        return new String (tkn);
    }



    void permute(String str, int s, int e){
        if(s==e)
            System.out.println(str);
        else{
            for (int i=s;i<=e;i++){
                str=swap(str,s,i);
                permute(str,s+1,e);
                str=swap(str,s,i);
            }
        }

    }


    public static void main(String[] args) {
        Permutation p= new Permutation();
       p.permute("abc",0,2);
    }



}
