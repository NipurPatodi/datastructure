package org.dreambig.ds.string.practice.tricky;

public class WordWrapDP extends  WordWrap{

    @Override
    public String getThingsToRemember() {
        return "While computing optimal cost we need to iterate in reverse direction";
    }

    final int MAX=Integer.MAX_VALUE;

    int print (int []p, int n){
        int k;
        if (p[n] == 1)
            k = 1;
        else
            k = print(p, p[n]-1) + 1;

        return k;
    }

    /***
     *
     * @param ip : Ip list
     * @param n: size of input
     * @param m: Size of line
     */
    int solveWordWrapDP(int [] ip, int n, final int m){
        // matrix to store extra space
        //if word picked from i to j
        int [][] exSp= new int [n+1][n+1];

        // Line cost to have word from i to j
        int [][] lc=new int[n+1][n+1];

        // total cost to store from 1 to n
        int [] res= new int [n+1];

        for (int i=1;i<=n;i++){
            exSp[i][i]=m-ip[i-1];
            for (int j=i+1;j<=n;j++){
                exSp[i][j]=exSp[i][j-1]-ip[j-1]-1;
            }
        }

        // Now calculating lc for each iteration

        for (int i=1;i<=n;i++){
            for(int j=i;j<=n;j++){
                // 1. when extra space is in -ve
                if(exSp[i][j]<0){
                    lc[i][j]=MAX; // Not possible to hold
                }
                else if(j==n && exSp[i][j]>0){ // Ignore last line and mark it zero
                    lc[i][j]=0;
                }else{
                    lc[i][j]=exSp[i][j]*exSp[i][j]; // cost is square
                }

            }
        }

        // Now  Calculating minimum cost
        // res[j]=  optimal cost to import values from 1 to j
        // Trick is moving from left to right
        res[0]=0;
        int [] p= new int [n+1];
        for (int j = 1; j <= n; j++)
        {
            res[j] = MAX;
            for (int i = 1; i <= j; i++)
            {
                if (res[i-1] != MAX && lc[i][j] != MAX &&
                        (res[i-1] + lc[i][j] < res[j]))
                {
                    res[j] = res[i-1] + lc[i][j];
                    p[j] = i;
                }
            }
        }
       return print(p,n);

    }


    public static void main(String[] args) {
        WordWrapDP ww= new WordWrapDP();
        int [] ip={3,2,2,5};
        System.out.println( ww.solveWordWrapDP(ip,ip.length,6));

    }
}
