package org.dreambig.ds.stack.easy;

import org.dreambig.ds.picker.IQuestion;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class SpecialStackV2 implements IQuestion {
    @Override
    public String getQuestion() {
        return "Design a data-structure SpecialStack that supports all the stack operations like push(), pop(), isEmpty(), isFull() and an additional operation getMin() which should return minimum element from the SpecialStack. Your task is to complete all the functions, using stack data-Structure.\n" +
                "\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input:\n" +
                "Stack: 18 19 29 15 16\n" +
                "Output: 15\n" +
                "Explanation:\n" +
                "The minimum element of the stack is 15." +
                "Find more details at https://practice.geeksforgeeks.org/problems/special-stack/1/?company[]=Linkedin&company[]=Linkedin&page=1&query=company[]Linkedinpage1company[]Linkedin";
    }

    @Override
    public List<String> getCompanies() {
        return Arrays.asList("linkedin.md".split(" "));
    }

    @Override
    public String getThingsToRemember() {
        return " Amazing trick by simple concept of mod enjoyed it :)";
    }

    int min=Integer.MAX_VALUE;
    final int div=420;
    private Stack<Integer> base= new Stack<>();
    public  void push(int data){

        if(min==Integer.MAX_VALUE){
            min=data;
        }else {
            min =Math.min(min,data);
        }
        if(data==div)
            throw  new RuntimeException("Approach will not work as data data and divident is same ...="+data);
        base.push((data*div)+min);
    }
    public  int pop(){
        int res= base.pop()/div;
        min= base.peek()%div;
        return res;
    }

    public  int getMin(){
        return min;
    }

    public static void main(String[] args) {
        SpecialStackV2 stack= new SpecialStackV2();
        stack.push(18);
        stack.push(19);
        stack.push(29);
        stack.push(15);
        stack.push(16);

        System.out.println("v2=>"+stack.getMin());
        stack.pop();
        stack.pop();
        System.out.println(stack.getMin());
        //stack.push(420);
    }



}
