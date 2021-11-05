package org.dreambig.ds.company.twitter;

import java.math.BigInteger;

/**
 * c(n)=1/n+1 * (2n,n)
 */
public class CatalanNumber {

    private static  BigInteger compute (int n){
        return BinomialCoeifficent.compute(2*n,n).divide(BigInteger.valueOf(n+1));
    }

    public static void main(String[] args) {
        System.out.println(compute(384));
    }
}
