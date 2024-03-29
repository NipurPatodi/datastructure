package org.dreambig.ds.array.medium;

import org.dreambig.ds.picker.IQuestion;

import java.util.List;

public class CompressString implements IQuestion {
    @Override
    public String getQuestion() {
        return "Given an array of characters chars, compress it using the following algorithm:\n" +
                "\n" +
                "Begin with an empty string s. For each group of consecutive repeating characters in chars:\n" +
                "\n" +
                "If the group's length is 1, append the character to s.\n" +
                "Otherwise, append the character followed by the group's length.\n" +
                "The compressed string s should not be returned separately, but instead, be stored in the input character array chars. Note that group lengths that are 10 or longer will be split into multiple characters in chars.\n" +
                "\n" +
                "After you are done modifying the input array, return the new length of the array.\n" +
                "\n" +
                "You must write an algorithm that uses only constant extra space.\n" +
                "\n" +
                " \n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: chars = [\"a\",\"a\",\"b\",\"b\",\"c\",\"c\",\"c\"]\n" +
                "Output: Return 6, and the first 6 characters of the input array should be: [\"a\",\"2\",\"b\",\"2\",\"c\",\"3\"]\n" +
                "Explanation: The groups are \"aa\", \"bb\", and \"ccc\". This compresses to \"a2b2c3\".\n" +
                "Example 2:\n" +
                "\n" +
                "Input: chars = [\"a\"]\n" +
                "Output: Return 1, and the first character of the input array should be: [\"a\"]\n" +
                "Explanation: The only group is \"a\", which remains uncompressed since it's a single character.\n" +
                "Example 3:\n" +
                "\n" +
                "Input: chars = [\"a\",\"b\",\"b\",\"b\",\"b\",\"b\",\"b\",\"b\",\"b\",\"b\",\"b\",\"b\",\"b\"]\n" +
                "Output: Return 4, and the first 4 characters of the input array should be: [\"a\",\"b\",\"1\",\"2\"].\n" +
                "Explanation: The groups are \"a\" and \"bbbbbbbbbbbb\". This compresses to \"ab12\".\n" +
                " \n" +
                "\n" +
                "Constraints:\n" +
                "\n" +
                "1 <= chars.length <= 2000\n" +
                "chars[i] is a lowercase English letter, uppercase English letter, digit, or symbol.";

    }

    @Override
    public List<String> getCompanies() {
        return null;
    }

    @Override
    public String getThingsToRemember() {
        return null;
    }
    public int compress(char[] chars) {
        StringBuilder sb= new StringBuilder();
        char prev=chars[0];
        sb.append(prev);
        int ctr=1;
        for (int i=1;i<chars.length;i++){
            if (chars[i]==prev){
                ctr++;
            }else{
                if (ctr>1){
                    sb.append(ctr);

                }
                sb.append(chars[i]);
                ctr=1;
                prev=chars[i];
            }

        }
        if (ctr>1)
            sb.append(ctr);
        char [] res= sb.toString().toCharArray();
        for (int i=0;i<res.length;i++ ){
            chars[i]=res[i];
        }
        return sb.length();

    }

    public static void main(String[] args) {
        CompressString cs= new CompressString();
        char [] ip={'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        cs.compress(ip);
        for (int i=0;i<ip.length;i++){
            System.out.print(ip[i]);
        }
    }
}
