package org.dreambig.ds.string.learning;

/***
 * WAP to check if two string anagram of each other
 */
public class AnagramCheck {

    public static boolean isAnagram (String a, String b){

      if(a.length()!=b.length())  return false;
      int sum=a.charAt(0)^b.charAt(0);
      for (int i=1;i<a.length();i++){
        sum=sum^a.charAt(i)^b.charAt(i);
      }
      return sum == 0;
    }

    public static boolean isAnagramArr (String a, String b){
      int [] tkn= new int[256];
      if(a.length()!=b.length())  return false;
      for ( int i =0;i<a.length();i++){
        tkn[a.charAt(i)]++;
        tkn[b.charAt(i)]--;
      }
      for ( int i=0;i<a.length();i++){
        if(tkn[i]!=0)
          return false;
      }
      return true;
    }



public static void main(String ... args){

 // System.out.println("===> ana==>"+isAnagram("nipu","rupi"));
  System.out.println("===> anaRec==>"+isAnagramArr("nipu","rupi"));
 // System.out.println("===> anaRec==>"+isAnagramArr("nipur","rupin"));
}



}
