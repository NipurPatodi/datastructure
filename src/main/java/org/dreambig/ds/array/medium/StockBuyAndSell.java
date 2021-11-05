package org.dreambig.ds.array.medium;

import org.dreambig.ds.picker.IQuestion;

import java.util.List;
import java.util.*;
public class StockBuyAndSell implements IQuestion {
    @Override
    public String getQuestion() {
        return "The cost of stock on each day is given in an array A[] of size N. Find all the days on which you buy and sell the stock so that in between those days your profit is maximum.\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input:\n" +
                "N = 7\n" +
                "A[] = { 100, 180, 260, 310, 40, 535, 695 }\n" +
                "\n" +
                "Output:\n" +
                "(0 3) (4 6)\n" +
                "\n" +
                "Explanation 1:\n" +
                "We can buy stock on day 0, \n" +
                "and sell it on 3rd day, \n" +
                "which will give us maximum profit.\n";
    }

    @Override
    public List<String> getCompanies() {
        return null;
    }

    @Override
    public String getThingsToRemember() {
        return null;
    }


    public void buyAndSell(int [] stock){

      boolean buy=true;
      int b=-1,s=-1;

      for ( int i=0;i<stock.length;i++){

          if(i==0) {
              if( stock[i+1]>stock[i]){
            b=0;
            buy=false;
          }
          }
          else if(buy){
           if(stock[i]<stock[i-1]){
              b=i;
              buy=false;
           }
          }
          else{
            if(stock[i]<stock[i-1]){
                s=i-1;
                buy=true;
                System.out.print("("+b+" "+s+")");
                b=s+1;
                s=-1;
              }

          }



        }

      if(s==-1){
          System.out.print("("+b+" "+(stock.length-1)+")");
      }

      }


    public static void main(String[] args) {
        StockBuyAndSell obj= new StockBuyAndSell();
        int [] ip={886,2777,6915,7793,8335,5386,492,6649,1421,2362,27,8690,59,7763,3926,540,3426,9172,5736,5211,5368,2567,6429,5782,1530,2862,5123,4067,3135,3929,9802,4022,3058,3069,8167,1393,8456,5011,8042,6229,7373,4421,4919,3784,8537,5198,4324,8315,4370,6413,3526,6091,8980,9956,1873,6862,9170,6996,7281,2305,925,7084,6327,336,6505,846,1729,1313,5857,6124,3895,9582,545,8814,3367,5434,364,4043,3750,1087,6808,7276,7178,5788};
        obj.buyAndSell(ip);
        System.out.println("\n");
        int []ip2={ 100, 180, 260, 310, 40, 535, 695 };
        obj.buyAndSell(ip2);
    }


}
