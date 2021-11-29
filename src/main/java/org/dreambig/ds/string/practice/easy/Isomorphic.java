package org.dreambig.ds.string.practice.easy;

import org.dreambig.ds.picker.IQuestion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Isomorphic implements IQuestion {
    @Override
    public String getQuestion() {
        return "Given two strings s and t, determine if they are isomorphic.\n" +
                "\n" +
                "Two strings s and t are isomorphic if the characters in s can be replaced to get t.\n" +
                "\n" +
                "All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.\n" +
                "\n" +
                " \n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: s = \"egg\", t = \"add\"\n" +
                "Output: true\n" +
                "Example 2:\n" +
                "\n" +
                "Input: s = \"foo\", t = \"bar\"\n" +
                "Output: false\n" +
                "Example 3:\n" +
                "\n" +
                "Input: s = \"paper\", t = \"title\"\n" +
                "Output: true\n" +
                "Please find more details at https://leetcode.com/problems/isomorphic-strings/"
                ;
    }

    @Override
    public List<String> getCompanies() {
        return Arrays.asList("linkedin".split(" "));
    }

    @Override
    public String getThingsToRemember() {
         return "Convert Array to transform string using index  and then match strings";
    }


    private String transform (String s){
        Map<Character, Integer> map = new HashMap<>();
        for (int i =0; i<s.length();i++){
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),i);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i =0; i<s.length();i++) {
        sb.append(map.get(s.charAt(i)));
        sb.append(" ");
        }
        return sb.toString();
        }

    public boolean isIsomorphic (String s1, String s2){
        return  transform(s1).equals(transform(s2));
    }

    public static void main(String[] args) {
        Isomorphic obj= new Isomorphic();
        System.out.println( obj.isIsomorphic("Babad","Heled"));
    }
}
