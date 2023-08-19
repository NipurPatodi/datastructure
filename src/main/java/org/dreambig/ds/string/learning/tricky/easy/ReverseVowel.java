package org.dreambig.ds.string.learning.tricky.easy;

import org.dreambig.ds.picker.IQuestion;

import java.util.Arrays;
import java.util.List;

public class ReverseVowel implements IQuestion {
    @Override
    public String getQuestion() {
        return "Given a string s, reverse only all the vowels in the string and return it.\n" +
                "\n" +
                "The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.\n" +
                "\n" +
                " \n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: s = \"hello\"\n" +
                "Output: \"holle\"\n" +
                "Example 2:\n" +
                "\n" +
                "Input: s = \"leetcode\"\n" +
                "Output: \"leotcede\"\n";
    }

    @Override
    public List<String> getCompanies() {
        return null;
    }

    @Override
    public String getThingsToRemember() {
        return null;
    }

    private void swap(char [] token, int i, int j){
        char t =token[i];
        token[i]=token[j];
        token[j]=t;
    }

    public String reverseVowels(String s){
        char[] tokens=s.toCharArray();
        List<String> vowels = Arrays.asList("a,e,i,o,u,A,E,I,O,U".split(","));
        // I will try this with two point approach
        int l=0,r=tokens.length-1;
        while (l<r){
            if (!vowels.contains(tokens[l]+"")){
                l++;
            }
            if (!vowels.contains(tokens[r]+"")){
                r--;
            }
            if (vowels.contains(tokens[l]+"") && vowels.contains(tokens[r]+"")){
                swap(tokens, l, r);
                l++; r--;
            }
        }
        return  new String(tokens);
    }

    public static void main(String[] args) {
        String input="lEotcede";
        ReverseVowel rv= new ReverseVowel();
        System.out.println(rv.reverseVowels(input));

    }

}
