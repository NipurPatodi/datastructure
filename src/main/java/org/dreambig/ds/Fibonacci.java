package org.dreambig.ds;

public class Fibonacci {

    public int computeByMatrix(int n){
        int f[][] = new int[][]{{1,1},{1,0}};
       if(n==0){
           //  Fibonacci is same
           return n;
       }

       //Now to compute we need to compute power till n-1
       f=power(f,n-1);

       return f[0][0];
    }


    public int OptComputeByMatrix(int n){
        int f[][] = new int[][]{{1,1},{1,0}};
        if(n==0){
            //  Fibonacci is same
            return n;
        }

        //Now to compute we need to compute power till n-1
        f=power(f,n-1);

        return f[0][0];
    }



    private int[][] power(int [][] f, int n){
        int base [][]=new int [][]{{1,1},{1,0}};
        for (int i=2; i<n;i++){
            multiple(f,base);
        }

        return f;
    }

    private  int[][] multiple(int[][] m1,int [][] m2){
        int x=m1[0][0]*m2[0][0]+ m1[0][1]*m2[1][0];
        int y=m1[0][0]*m2[1][0]+ m1[0][1]*m2[1][1];
        int z=m1[1][0]*m2[0][0]+ m1[1][1]*m2[1][0];
        int w=m1[1][0]*m2[1][0]+ m1[0][1]*m2[1][1];
        m1[0][0]=x;
        m1[0][1]=y;
        m1[1][0]=z;
        m1[1][1]=w;
        return m1;
    }

    public static void main(String[] args) {
        Fibonacci f= new Fibonacci();
        System.out.println(f.computeByMatrix(9));
    }

    //0,1,1,2,3,5,8,13,21,34
}
