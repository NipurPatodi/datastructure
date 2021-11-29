package org.dreambig.ds.company.twitter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PrintWords2 {



    private boolean printWords(String pl, List<String> store, Set<String> dictionary) {
        if(pl.length() == 0) {
            return true;
        }
        for(int i = 1; i <= pl.length(); i++) {
            String curWord = pl.substring(0, i);
            if(dictionary.contains(curWord) && printWords(pl.substring(i), store, dictionary)) {
                store.add(curWord);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        PrintWords2 instance = new PrintWords2();
        Set<String> dictionary = new HashSet();
        dictionary.add("i");
        dictionary.add("a");
        dictionary.add("am");
        dictionary.add("don");
        List<String> store = new ArrayList<String>();
        instance.printWords("iamamdon", store, dictionary);
        for(int i = store.size() - 1; i >= 0; --i) {
            System.out.println(store.get(i));
        }


    }

}
