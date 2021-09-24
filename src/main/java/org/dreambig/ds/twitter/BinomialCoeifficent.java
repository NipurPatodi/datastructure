package org.dreambig.ds.twitter;

import java.math.BigInteger;

/**

C(n,k) =n!/(n-k)! k!
Now
n!/(n-k)! = n*(n-1).... (n-k+1)
k > n-k
use k = n-k
**/

public class BinomialCoeifficent {

public  static BigInteger compute(int n, int k){

    // k>n-k set k= n-k

    if(k>n-k){
      k=n-k;
    }
    BigInteger res=new BigInteger("1");
    for (int i=0;i<k;i++){
      res=res.multiply(BigInteger.valueOf(n-i));
      res=res.divide(BigInteger.valueOf(i+1));
    }

    return res;
  }

  public static void main(String[] args) {
    System.out.println(compute(8,2));
  }




}
