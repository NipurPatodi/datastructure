package org.dreambig.ds.string.learning.tricky;

public class RabinKarpPatternSearch {

    private static  int computeHash(String ip){
            /*int sum=0;
            for (int i=0;i<ip.length();i++) sum+=ip.charAt(i);
            return sum;*/
        return ip.hashCode();
    }

    public static  void search(String p, String pl){
        int ph=computeHash(p);
        int ch=0;

        for (int i=0; i<=pl.length()-p.length();i++){
            String cs=pl.substring(i,i+p.length());
             ch=computeHash(cs);
            if(ch==ph && cs.equals(p)){
                System.out.println(p);
            }
        }


    }

    public static void main(String ... arg){
        //printMatchNaive("aa", "haa haa oh aaa");
        search("ha", "haa haa oh aaaha");
    }
}
