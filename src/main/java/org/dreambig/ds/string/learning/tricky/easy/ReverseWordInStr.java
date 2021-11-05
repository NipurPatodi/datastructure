package org.dreambig.ds.string.learning.tricky.easy;
import java.util.*;

public class ReverseWordInStr{

    /***
     * Niave Solution
     * could be better with stack
     * @param ip
     * @return
     */
  public static String reverseWordNaive(String ip){
   StringBuffer sb=new StringBuffer();
   List<String> res= new ArrayList<>();

   for (int i=0;i<ip.length();i++){
      if(ip.charAt(i)==' '){
        res.add(sb.toString());
        sb.delete(0,sb.length());
      }
      else{
      sb.append(ip.charAt(i));
      }

   }
   if(sb.length()!=0)
      res.add(sb.toString());

  sb.delete(0,sb.length());

    for (int i=res.size()-1;i>=0;i--)
        sb.append(res.get(i)+" ");

      return sb.toString();
  }

private static char[] reverse (char [] ip, int s, int e){
    while( s<e  && s<ip.length){
      char tmp= ip[s];
      ip[s]=ip[e];
      ip[e]=tmp;
      s++;
      e--;
    }
    return ip;
}



public static String reverseWord(String ip){
  char [] tkn=ip.toCharArray();
   int s=0, e=1;
   for (int i=1;i<tkn.length-1;i++){
      if(tkn[i]==' '){
        e=i-1;
        tkn=reverse(tkn,s,e);

        s=i+1;
      }
   }

   if(e<tkn.length-1){
    e=tkn.length-1;
    tkn=reverse(tkn,s,e);
   }
   tkn =reverse(tkn,0,tkn.length-1);

   return new String(tkn);
}



public static void main(String ... args){
  //System.out.println(reverseWordNaive("Hello Dear ok"));
    System.out.println(reverseWord("Hello Dear ok"));

}


}
