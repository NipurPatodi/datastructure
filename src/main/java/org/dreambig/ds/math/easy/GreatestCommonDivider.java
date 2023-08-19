package org.dreambig.ds.math.easy;

import org.dreambig.ds.picker.IQuestion;

import java.util.List;

public class GreatestCommonDivider implements IQuestion {
    @Override
    public String getQuestion() {
        return "Given two numbers a and b, the task is to find the GCD of the two numbers.\n" +
                "\n" +
                "Note: GCD (Greatest Common Divisor) or HCF (Highest Common Factor) of two numbers is the largest number that divides both of them. ";
    }

    @Override
    public List<String> getCompanies() {
        return null;
    }

    @Override
    public String getThingsToRemember() {
        return null;
    }

    public int getGreatestCommonDivider(int a, int b){
        if (a==0 || b==0)
            return 1;
        if (a==b)
            return a;

        if (a>b && a%b==0)
                return b;
        if (b>a && b%a==0)
                return a;
        if(a>b)
            return getGreatestCommonDivider(a-b,b);
        else
            return getGreatestCommonDivider(a, b-a);

    }

    public static void main(String[] args) {
        GreatestCommonDivider instance = new GreatestCommonDivider();
        System.out.println(instance.getGreatestCommonDivider(0,111));
    }
}
