package org.dreambig.ds.string.learning.tricky;

public class KMPSearch{

private static int[]computeLPS(String p){

 int [] lps=new int[p.length()];
 lps[0]=0;
 int i=1;
 int len=0;
 while(i<lps.length) {
     if (p.charAt(i) == p.charAt(len)) {
         len++;
         lps[i] = len;
         i++;
     } else {
         if (len == 0) {
             lps[i] = 0;
             i++;
         } else {
             len = lps[len - 1];
         }
     }
    }
    return lps;
 }

 public static void printSearch(String ip, String pt){
    int pSize=pt.length();
    int iSize=ip.length();
    int [] lps=computeLPS(pt);
    int i=0,j=0; //i is ip ptr and j is pattern ptr
    while (i<iSize){

        // case 1 when both char match
        if(j<pSize && ip.charAt(i)== pt.charAt(j)){
            i++;
            j++;
        }
        // case 2 when j=i
        if(j==pSize){
            System.out.println(i-j);
            j=lps[j-1];
        }
        // case 3
        else if(j<pSize && ip.charAt(i) != pt.charAt(j) ){
            //case 3.1
            if(j==0) i++;
            else {
                //case 3.2 . Please note that we don't increment j in this scenerio
                j=lps[j-1];
            }

        }


    }
}


public static void main(String[] args) {
   printSearch("aaaaab","aaa");
  }
}







