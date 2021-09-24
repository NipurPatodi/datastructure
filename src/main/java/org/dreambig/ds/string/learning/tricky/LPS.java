package org.dreambig.ds.string.learning.tricky;
/***
WAP to computr Largest Common Suffix which is also Prefix for given string
**/
public class LPS{

  public static int [] computeLPS(String ip)
  {
    int [] lps=new int [ip.length()];
    int len=0;
    lps[0]=0;
    for ( int i=1; i<ip.length();){
      if(ip.charAt(i)==ip.charAt(len)){
        lps[i]=len+1;
        len++;
        i++;
      }else{
        if(len==0)
          {
            lps[i]=0;
            i++;
          }
        else
          {
            len=lps[len-1];
          }
        }
    }
    return lps;
  }


public static void main(String[] args) {
  int[] res=computeLPS("abacabad");
  for( int i:res){
    System.out.print(i+" ");
  }
}


}
