package org.dreambig.ds.string.learning;

public class LeftMostRepeatingChar {

    /***
     * O(n2)
     * @param ip
     * @return
     */
  public static int getleftMostRepChar(String ip){
    if(ip.length()<=1) return -1;

    for (int i=0;i<ip.length()-1;i++){
        for(int j=i+1;j<ip.length();j++){
          if(ip.charAt(i)==ip.charAt(j))
            {
              return i;
            }
          }
      }
      return -1;
    }

    /***
     * O(n) with n extra space
     * @param ip
     * @return
     */
    public static int getleftMostRepCharBetter(String ip){
        if(ip.length()<=1) return -1;
        int [] tkn= new int[256];

        for (int i=0;i<ip.length();i++){
            tkn[ip.charAt(i)]++;
        }
        for (int i=0;i<ip.length();i++){
           if(tkn[ip.charAt(i)]>1)
               return i;
        }

        return -1;
    }

/***
  Best Approach
**/

    public static int getleftMostRepCharBest(String ip){
        if(ip.length()<=1) return -1;
        int [] tkn= new int[256];
        int res=Integer.MAX_VALUE;



        for (int i=0;i<ip.length();i++){
            if(tkn[ip.charAt(i)]>0)
            {
              res=Math.min(tkn[ip.charAt(i)]-1,res);
            }
            else{
              tkn[ip.charAt(i)]=i+1;
            }
        }


        return res ==Integer.MAX_VALUE ?-1: res;
    }




public static void main (String ... arg){
    //System.out.println(getleftMostRepChar("Hello Hulk"));
    //System.out.println(getleftMostRepChar("Hello Dulk"));
    //System.out.println(getleftMostRepCharBetter("Hello Hulk"));
    //System.out.println(getleftMostRepCharBetter("Hello Dulk"));
    System.out.println(getleftMostRepCharBest("Hello Hulk"));
    System.out.println(getleftMostRepCharBest("Hello Dulk"));


    }
}
