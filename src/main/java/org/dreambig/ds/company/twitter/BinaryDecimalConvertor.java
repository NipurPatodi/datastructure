package org.dreambig.ds.company.twitter;

public class BinaryDecimalConvertor {

    static private void printDecimalToBinary(int no){

        int [] bin= new int[1000];
        int i=0;
        while (no>0){
            bin[i]=no%2;
            no=no/2;
            i++;
        }
        for (int j=i-1;j>=0;j--){
            System.out.print(bin[j]+"" );
        }

    }

    private static  int computeBinaryToDecimal(int binNo){
        int i=0;
        int res=0;
        while(binNo>0){
            int base= binNo%10;
            res+= base *Math.pow(2,i);
            binNo=binNo/10;
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        printDecimalToBinary(8);
        System.out.println("\n==>"+computeBinaryToDecimal(1000));
    }
}
