package org.dreambig.ds.string.learning;

public class PatternSearch {

  public static void printMatchNaive(String p, String ip){
  int psize= p.length();
    for(int i=0; i<ip.length();i++){
      if(i+psize<ip.length()){
        String ss=ip.substring(i,i+psize);

        if(ss.equals(p)){
          System.out.println(i);
        }
      }
    }
  }


  /***
  * Search when pattern is distinct
  **/
  public static void printMatchNaiveDist(String p, String ip){
  int psize= p.length();

    for(int i=0; i<=ip.length()-psize;){

      int s=0;
        for (;s<psize;s++){

          if(p.charAt(s)!=ip.charAt(i+s))
            {
              break;
            }

        }
      if(s==psize){
        System.out.println(i); }
      if(s!=0){
        i+=s; // optimization
      }
      else
        i++; // Naive way of iterating
    }
  }






  public static void main(String ... arg){
  //printMatchNaive("aa", "haa haa oh aaa");
  printMatchNaiveDist("ha", "haa haa oh aaaha");
  }

}
