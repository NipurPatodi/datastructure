package org.dreambig.ds.company.twitter;
import java.util.*;
public class RomanToInteger {
  /***
  I 1
V 5
X 10
L 50
C 100
D 500
M 1000
  ***/



  public static int RomanToInt(String ip){
    Map<Character,Integer> charMap=new HashMap<>();
    charMap.put('I',1);
    charMap.put('V',5);
    charMap.put('X',10);
    charMap.put('L',50);
    charMap.put('C',100);
    charMap.put('D',500);
    charMap.put('M',1000);
    char [] tokens= ip.toCharArray();
    int res=0;
    for (int i=tokens.length-1; i>=0;i++ ){
      res+=charMap.get(i);
    }
    return res;

  }
}
