package org.dreambig.ds.string.learning.tricky.easy;

/***
Write program to see if String contain any anagram  for pattern provided
***/
public class  AnagramInString{

  private static boolean isAnagram(String a, String b){
    int [] tkn = new int [256];
    for ( int i =0;i <a.length();i++){
      tkn[a.charAt(i)]++;
    }

    for ( int i =0;i <b.length();i++){
      if( tkn[b.charAt(i)]==0)
        return false;
      else
        tkn[b.charAt(i)]--;
    }
    return true;
  }

  public static boolean exist(String ip, String p){
    int plen=p.length()+1;
   for (int i=0;i<ip.length()-p.length(); i++){
      if(isAnagram(ip.substring(i,i+plen),p))
        return true;
   }
   return false;
  }

public static void main(String[] args) {

    System.out.println(exist("I love dataStructure", "rock"));
}



}
