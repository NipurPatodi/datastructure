package org.dreambig.ds.string.learning.tricky.easy;

/***
 * WAP to check is two string are rotation of each other
 */
public class RotatedString {

    public  static boolean isRotated(String s1, String s2){
        //return (s1+s1).indexOf(s2)>=0;
        return (s1+s1).contains(s2);
    }

    public static void main(String[] args) {
        System.out.println(isRotated("Nipur","purNi"));
    }
}
