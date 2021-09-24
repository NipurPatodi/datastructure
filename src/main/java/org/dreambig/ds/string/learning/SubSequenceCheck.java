package org.dreambig.ds.string.learning;

/***
 * WAP to check is s2 is subsequence of s1
 * ae is sub sequence of abcde
 */
public class SubSequenceCheck {

   public static boolean isSubSeq(String s1, String s2){
    int i1=0;
    int i2=0;
    while( i1<s1.length() && i2<s2.length()){
      if(s2.charAt(i2)==s1.charAt(i1)){
        i1++;
      }
      i2++;
    }

    return i1==s1.length();
    }



    public static boolean isSubSeqRec(String s1, String s2){
      if(s1==null ||s1.isEmpty() ) return true;
      if(s2==null || s2.isEmpty()) return false;

      if( s1.charAt(0)==s2.charAt(0)){
          return isSubSeqRec(s1.substring(1),s2.substring(1));
      }
      else
        return isSubSeqRec(s1,s2.substring(1));

    }


public static void main (String ... args){

    //System.out.println(isSubSeq("Hm","Hell0"));

      System.out.println(isSubSeqRec("0l","Hell0"));

}


}
