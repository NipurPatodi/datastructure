package org.dreambig.ds.stack.easy;

import org.dreambig.ds.picker.IQuestion;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class SpecialStack  implements IQuestion {
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
        return " This can be solved using AuX Stack if extra space is ok. But it would be best with no Extra space and that make its tricky" ;
    }

    private Stack<Integer> aux= new Stack<>();
    private Stack<Integer> base= new Stack<>();
    public  void push(int data){
        base.push(data);
        if(aux.isEmpty()){
            aux.push(data);
        }else if(aux.peek()>data){
            aux.push(data);
        }

    }
    public  int pop(){
        int res= base.pop();
        if(aux.peek()==res){
            aux.pop();
        }
        return res;
    }

    public  int getMin(){
        return aux.peek();
    }

    public static void main(String[] args) {
        SpecialStack stack= new SpecialStack();
        stack.push(18);
        stack.push(19);
        stack.push(29);
        stack.push(15);
        stack.push(16);

        System.out.println(stack.getMin());
        stack.pop();
        stack.pop();
        System.out.println(stack.getMin());
    }



}
