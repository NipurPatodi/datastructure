package org.dreambig.ds.string.learning;

public class Palindrome {
    static  boolean isPalindrome (String ip){
        int s=0,e=ip.length()-1;
        while(s<e){

            if(ip.charAt(s)!=ip.charAt(e)){
                return false;
            }
            s++;
            e--;
        }
        return true;
    }



    public static void main(String[] args) {
        System.out.println(isPalindrome("Hello"));
        System.out.println(isPalindrome("okko"));

    }


}

