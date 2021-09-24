package org.dreambig.ds.string.learning;

public class PrintFrequency {

  public static void print(String ip){
    int [] tkn=new int[26];
    for (char c : ip.toCharArray()){
    int t=c;
    int idx=t-97;
    tkn[idx]=tkn[idx]+1;
  }

  for (int i=0;i<26;i++){
    if(tkn[i]!=0){
      char c=(char)(i+97);
      System.out.println(c+"="+tkn[i]);
    }
  }

  }

public static void main (String [] arg){

  print("geekforgeeks");

}





}
