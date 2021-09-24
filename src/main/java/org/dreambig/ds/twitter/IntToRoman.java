package org.dreambig.ds.twitter;

public class IntToRoman {



private static class SymbolCarry{
String symbol;
int reminder;

public SymbolCarry(String symbol, int rem){
    this.symbol=symbol;
    this.reminder=rem;
  }
}
/***
I             1
IV            4
V             5
IX            9
X             10
XL            40
L             50
XC            90
C             100
CD            400
D             500
CM            900
M             1000
***/

private static  String buildString(int times, String str){
  if(times<=1)
  return str;
  else{
      String res=str;
    for (int i=1; i<times;i++){
        res+=str;
    }
    return res;
  }
}

private static SymbolCarry getSymbolCarry(int no){
  if(no>=1000){
    int t= no/1000;
    return new SymbolCarry(buildString(t,"M"),no%1000);
  }
  else if(no>=900){
    int t= no/900;
    return new SymbolCarry(buildString(t,"CM"),no%900);
  }
  else if(no>=500){
    int t= no/500;
    return new SymbolCarry(buildString(t,"D"),no%500);
  }else if(no>=400){
    int t= no/400;
    return new SymbolCarry(buildString(t,"CD"),no%400);
  }else if(no>=100){
    int t= no/100;
    return new SymbolCarry(buildString(t,"C"),no%100);
  }else if(no>=90){
    int t= no/90;
    return new SymbolCarry(buildString(t,"XC"),no%90);
  }else if(no>=50){
    int t= no/50;
    return new SymbolCarry(buildString(t,"L"),no%50);
  }else if(no>=40){
    int t= no/40;
    return new SymbolCarry(buildString(t,"XL"),no%40);
  }else if(no>=10){
    int t= no/10;
    return new SymbolCarry(buildString(t,"X"),no%10);
  }else if(no>=9){
    int t= no/9;
    return new SymbolCarry(buildString(t,"IX"),no%9);
  }else if(no>=5){
    int t= no/5;
    return new SymbolCarry(buildString(t,"V"),no%5);
  }else if(no>=4){
    int t= no/4;
    return new SymbolCarry(buildString(t,"IV"),no%4);
  }else{
    int t= no/1;
    return new SymbolCarry(buildString(t,"I"),0);
  }
  

}



    public static  String convertIntToRoman(int no) {
        StringBuilder sb = new StringBuilder();
        while (no != 0) {
            SymbolCarry curr = getSymbolCarry(no);
            sb.append(curr.symbol);
            no = curr.reminder;
        }
        return sb.toString();
    }



    public static void main(String[] args) {
      System.out.println(convertIntToRoman(3549));
    }

}
/***
 MMMDXLIX
 MMMDXLIX
 **/