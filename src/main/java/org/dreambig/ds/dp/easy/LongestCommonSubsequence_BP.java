package org.dreambig.ds.dp.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestCommonSubsequence_BP {


    public static String getLongestCommonSubSequence(String a, String b) {
        if (a == null || b == null || a.isEmpty() || b.isEmpty())
            return "";

        // Using Tabulation to first identify length of LCS
        int [][] cache = new int [a.length()+1][b.length()+1];
        // By default java array are initialized by zero;
        for (int i=1;i<=a.length();i++){
            for (int j=1;j<=b.length();j++){
                // Match case
                if(a.charAt(i-1)==b.charAt(j-1)){
                    cache[i][j]=1+cache[i-1][j-1];
                }else{
                    cache[i][j]= Math.max(cache[i-1][j],cache[i][j-1]);
                }
            }
        }

        int lcmLen = cache[a.length()][b.length()];

        // if nothing match
        if(lcmLen == 0)
            return "";

        //Creating LCM String
        char [] lcmStr = new char [lcmLen];
        int aCtr=a.length()-1, bCtr=b.length()-1, lcmCtr=lcmLen-1;

        while (aCtr>=0 && bCtr>=0){
            if(a.charAt(aCtr)==b.charAt(bCtr)){
                lcmStr[lcmCtr]=a.charAt(aCtr);
                lcmCtr--;
                aCtr--;
                bCtr--;
            }else{
                if (cache[aCtr+1][bCtr]>cache[aCtr][bCtr+1]){
                    bCtr--;
                }else{
                    aCtr--;
                }
            }
        }
        return new String(lcmStr);
}

    public static void main(String[] args) throws IOException {
        //String a="oxcpqrsvwf", b="shmtulqrypy";
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            String input=br.readLine();
            if(input.contains(";")){
                String [] token =input.split(";",-1);
                String a = token[0];
                String b = token[1];
                System.out.println(getLongestCommonSubSequence(a,b));
            }
        }

    }
}