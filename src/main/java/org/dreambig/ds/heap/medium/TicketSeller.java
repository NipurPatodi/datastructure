package org.dreambig.ds.heap.medium;

import org.dreambig.ds.picker.IQuestion;

import java.util.*;

public class TicketSeller implements IQuestion {
    @Override
    public String getQuestion() {
        return "There are N ticket sellers each of whom has a certain amount of tickets. The price of a ticket is the number of tickets remaining with the ticket seller. They can sell a total of K tickets. Find the maximum amount they can earn by selling K tickets. The amount of tickets of each seller is provided in array A. Give the answer modulo 109 + 7.\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: N = 5, K = 3\n" +
                "A = {4, 3, 6, 2, 4}\n" +
                "Output: 15\n" +
                "Explaination: Consider 0 based indexing. \n" +
                "For first two turns the 2nd seller sells. \n" +
                "For the third turn either 0th or 2nd \n" +
                "seller can sell. So the total becomes \n" +
                "6 + 5 + 4 = 15." +
                "Find more Details at https://practice.geeksforgeeks.org/problems/ticket-sellers3241/1";
    }

    @Override
    public List<String> getCompanies() {
        return Arrays.asList("linkedin.md");
    }

    @Override
    public String getThingsToRemember() {
        return null;
    }

   public int getMaxEarn(int N, int K, int [] A){
        PriorityQueue<Integer>maxHeap= new PriorityQueue<>(Comparator.reverseOrder());
        for ( int i =0;i<N;i++)
            maxHeap.add(A[i]);

        int sum=0;
        for (int i=0;i<K;i++){
            int tmp=maxHeap.remove();
            sum+=tmp;
            maxHeap.add(tmp-1);// this need to be added
        }
        return sum;
    }

    public static void main(String[] args) {
        TicketSeller seller= new
                TicketSeller();
        int N = 5, K = 4;
        int []A = {4, 3, 6, 2, 4};
        System.out.println(seller.getMaxEarn(N,K,A));
        // 6+5+4 +4
    }
}
