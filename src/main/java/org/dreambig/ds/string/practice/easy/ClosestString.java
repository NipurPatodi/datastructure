package org.dreambig.ds.string.practice.easy;

import org.dreambig.ds.picker.IQuestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ClosestString implements IQuestion {
    @Override
    public String getQuestion() {
        return "Given a list of words followed by two words, the task to find the minimum distance between the given two words in the list of words\n" +
                "\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input:\n" +
                "S = { \"the\", \"quick\", \"brown\", \"fox\", \n" +
                "     \"quick\"}\n" +
                "word1 = \"the\"\n" +
                "word2 = \"fox\"\n" +
                "Output: 3\n" +
                "Explanation: Minimum distance between the \n" +
                "words \"the\" and \"fox\" is 3\n" +
                "Example 2:\n" +
                "\n" +
                "Input:\n" +
                "S = {\"geeks\", \"for\", \"geeks\", \"contribute\", \n" +
                "     \"practice\"}\n" +
                "word1 = \"geeks\"\n" +
                "word2 = \"practice\"\n" +
                "Output: 2\n" +
                "Explanation: Minimum distance between the\n" +
                "words \"geeks\" and \"practice\" is 2" +
                "Find More Details at https://www.geeksforgeeks.org/minimum-distance-between-words-of-a-string/";
    }

    @Override
    public List<String> getCompanies() {
        return Arrays.asList("linkedin.md".split(" "));
    }

    @Override
    public String getThingsToRemember() {
        return null;
    }

    public int findClosestString (String [] ip, String w1, String w2){
        List<Integer>w1occ= new LinkedList<>();
        List<Integer>w2occ= new LinkedList<>();
        for (int i=0;i<ip.length;i++){
            if(ip[i].equals(w1))
                w1occ.add(i);
            else if (ip[i].equals(w2))
                w2occ.add(i);
        }
        int minDist=Integer.MAX_VALUE;
        for (int i:w1occ){
            for (int j:w2occ){

                minDist=Math.min(minDist, Math.abs(i-j));
            }
        }
        return  minDist;
    }

    public  int findClosetStringOptimized (String [] ip, String w1, String w2){
        int minDist= Integer.MAX_VALUE;
        if(w1.equals(w2))
            return 0;

        for( int i=0;i<ip.length;i++){
            if(ip[i].equals(w1))
            for (int j=0;j<ip.length;j++){
                if(ip[j].equals(w2)){
                    minDist=Math.min(minDist , Math.abs(i-j));
                }
            }
        }
        return minDist;
    }




    public static void main(String[] args) {
        ClosestString obj= new ClosestString();
        String [] ip= "the quick the brown quick brown the frog".split(" ");
        String w1="quick",w2="frog";
        System.out.println(obj.findClosestString(ip,w1,w2));
        System.out.println(obj.findClosetStringOptimized(ip,w1,w2));
        String []s = {"geeks", "for", "geeks", "contribute",
                "practice"};
        String word1 = "practice";
        String word2 = "geeks";
        System.out.println(obj.findClosestString(s,word1,word2));
        System.out.println(obj.findClosetStringOptimized(s,word1,word2));
    }
}
