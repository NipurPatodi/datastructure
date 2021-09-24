package org.dreambig.ds.string.learning;

/***
 * WAP to find left most non repeating char
 */
public class LeftMostNonRepeatingChar {

  public static int getLeftMostNonRepeatingChar(String ip){
      int [] visited= new int[256];
      for (int i=0; i<ip.length();i++){
        visited[ip.charAt(i)]++;
      }

      for (int i=0;i<ip.length();i++){
        if(visited[ip.charAt(i)]==1)
          return i;
      }
      return -1;

  }

//One traversal solution
  public static int getLeftMostNonRep_OT(String ip){
      int [] v= new int[256];
      for (int i=0;i<256;i++) v[i]=-1;

      for (int i=0; i<ip.length();i++){
        if(v[ip.charAt(i)]>-1){
            v[ip.charAt(i)]=-2; // already visited
        }
        v[ip.charAt(i)]=i;
      }

      int res=Integer.MAX_VALUE;
      for (int i=0;i<256;i++){
        if(v[i]>=0)
          res=Math.min(res,v[i]);
      }
      return res==Integer.MAX_VALUE?-1:res;

  }


  public static  void main (String ... arg){
    //System.out.println(getLeftMostNonRepeatingChar("HelloH"));
      //System.out.println(getLeftMostNonRepeatingChar("elloH"));

      System.out.println(getLeftMostNonRep_OT("HelloH"));
         System.out.println(getLeftMostNonRep_OT("elloH"));
     }
  }


