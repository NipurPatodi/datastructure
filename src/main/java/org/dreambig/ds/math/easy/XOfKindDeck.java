package org.dreambig.ds.math.easy;

import org.dreambig.ds.picker.IQuestion;

import java.util.Arrays;
import java.util.List;

public class XOfKindDeck implements IQuestion {
    @Override
    public String getQuestion() {
        return "In a deck of cards, each card has an integer written on it.\n" +
                "\n" +
                "Return true if and only if you can choose X >= 2 such that it is possible to split the entire deck into 1 or more groups of cards, where:\n" +
                "\n" +
                "Each group has exactly X cards.\n" +
                "All the cards in each group have the same integer.\n" +
                " \n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: deck = [1,2,3,4,4,3,2,1]\n" +
                "Output: true\n" +
                "Explanation: Possible partition [1,1],[2,2],[3,3],[4,4]." +
                "https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards/";
    }

    @Override
    public List<String> getCompanies() {
        return null;
    }

    @Override
    public String getThingsToRemember() {
        return null;
    }

    public boolean hasGroupsSizeX(int[] deck) {
        if(deck.length==1){
            return false;
        }

        if(deck.length==2 && deck[0]==deck[1]){
            return true;
        }

        Arrays.sort(deck);
        int x=0;
        int curr=1;
        boolean first=true;
        for ( int i=1;i<deck.length;i++){
            // change for first time
            if(deck[i-1]!=deck[i] && first){
                if(curr==1)
                    return false;
                x=curr;
                first=false;
                curr=0;
            }else if(deck[i-1]!=deck[i] && curr!=x){ // change happen unexpected
                return false;
            }else if(deck[i-1]!=deck[i] && curr==x){ //change happen as expected
                curr=0;
            }
            curr++;
        }

        return curr==x?true:false;

    }

    public static void main(String[] args) {
        int [] ip={1,1};
        XOfKindDeck obj= new XOfKindDeck();
        System.out.println(obj.hasGroupsSizeX(ip));

    }
}
