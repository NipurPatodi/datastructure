package org.dreambig.ds.string.practice.medium;
import org.dreambig.ds.picker.IQuestion;

import java.util.*;

public class CountAndSay implements IQuestion {


@Override
public String getQuestion(){
  return "The count-and-say sequence is a sequence of digit strings defined by the recursive formula:\n" +
          "\n" +
          "countAndSay(1) = \"1\"\n" +
          "countAndSay(n) is the way you would \"say\" the digit string from countAndSay(n-1), which is then converted into a different digit string.\n" +
          "To determine how you \"say\" a digit string, split it into the minimal number of groups so that each group is a contiguous section all of the same character. Then for each group, say the number of characters, then say the character. To convert the saying into a digit string, replace the counts with a number and concatenate every saying.\n" +
          "\n" +
          "For example, the saying and conversion for digit string \"3322251\":\n" +
          "\n" +
          "\n" +
          "Given a positive integer n, return the nth term of the count-and-say sequence.\n" +
          "\n" +
          " \n" +
          "\n" +
          "Example 1:\n" +
          "\n" +
          "Input: n = 1\n" +
          "Output: \"1\"\n" +
          "Explanation: This is the base case.\n" +
          "Example 2:\n" +
          "\n" +
          "Input: n = 4\n" +
          "Output: \"1211\"\n" +
          "Explanation:\n" +
          "countAndSay(1) = \"1\"\n" +
          "countAndSay(2) = say \"1\" = one 1 = \"11\"\n" +
          "countAndSay(3) = say \"11\" = two 1's = \"21\"\n" +
          "countAndSay(4) = say \"21\" = one 2 + one 1 = \"12\" + \"11\" = \"1211\"";
}
@Override
public  List<String> getCompanies() {
  return null;
}

public  String getThingsToRemember(){
  return "So when doing StringBuilder (int +\"\" +char ) char is converted to int and added. Just be mind full";
}


/***
Recursive Method to compute String
***/
public String countAndSay(int n){

  int i=0;
  String res="1";
  while(i<n-1){

      res=count(res);
      System.out.println(res);
      i++;
    }

  return res;
}


private String count(String res){
  if(res.length()==1)
    return "1"+res;
    int ctr=1;
    StringBuilder sb= new StringBuilder();
  for(int i=0;i<res.length()-1;i++){
    if(res.charAt(i)!=res.charAt(i+1)){
      sb.append(ctr+""+res.charAt(i));
      ctr=1; //resetting CTR to 1
    }else{
      ctr++;
    }
  }

  sb.append(ctr+""+res.charAt(res.length()-1));


  return sb.toString();
}

public static void main (String ... arg){
  CountAndSay  cs= new CountAndSay ();
  System.out.println(cs.countAndSay(4));
}





}
