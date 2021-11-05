package org.dreambig.ds.string.practice.easy;
import org.dreambig.ds.picker.IQuestion;

import java.util.*;

public class ValidSuffle implements IQuestion {

public  boolean isValidSuffle(String a, String b, String payload){

  if (payload.length()!= a.length()+b.length()){
      return false;
  }
  int []om = new int [256];

  for (char c:payload.toCharArray()){
    om[c]++;
  }
  for (char c:a.toCharArray()){
    om[c]--;
  }
  for (char c:b.toCharArray()){
    om[c]--;
  }

  for (int i:om){
    if(i!=0)
      return false;
  }

  return true;
}

@Override
public String getQuestion(){
  return "1XY2 is a valid shuffle of XY and 12\n" +
          "Y1X2 is a valid shuffle of XY and 12     \n" +
          "Y21XX is not a valid shuffle of XY and 12\n" +
          "In the above example, we have a string array named results. It contains three strings: 1XY2, Y1X2, and Y21XX. We are checking if these three strings are valid shuffle of strings first(XY) and second(12).";
}
@Override
public  List<String> getCompanies() {
  return null;
}
@Override
public String getThingsToRemember() {
    return "";
    }

public  boolean isValidSuffle2(String a, String b, String payload){
  char[]c= (a+b).toCharArray();
  Arrays.sort(c);
  char[]p=payload.toCharArray();
  Arrays.sort(p);
  if(p.length!=c.length)
    return false;
  else{
    for (int i=0; i<p.length;i++){
      if(p[i]!=c[i]) return false;
    }
    return true;
  }

}


public static void main(String ... args){
  String pl="1xy2yx";
  String a="xy";
  String b="12";
  ValidSuffle vs = new ValidSuffle();
  System.out.println(vs.isValidSuffle2(a,b,pl));
  System.out.println(vs.isValidSuffle(a,b,pl));
}

}
