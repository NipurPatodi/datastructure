package org.dreambig.ds.Tricky;

public class Sum {

    public int add(int a, int b){
        int  sum=0;
        while(b!=0){

            int carry= a & b;
            // Sum by XORing value
            a = a ^ b;

            // Shifting carry
            b=carry<<1;
        }
        return a;
    }
    public  int addRecurive(int a, int b){
        if( b==0)
            return a;
        else
            return addRecurive(a^b,(a & b) <<1);
    }

    public static void main(String[] args) {
        Sum sum= new Sum();
        System.out.println(sum.add(3,2));
        System.out.println(sum.addRecurive(3,2));
    }
}
