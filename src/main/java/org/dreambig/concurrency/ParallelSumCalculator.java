package org.dreambig.concurrency;

import org.dreambig.ds.picker.IQuestion;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ParallelSumCalculator implements IQuestion {
    @Override
    public String getQuestion() {
        return "Problem: Parallel Sum Calculation\n" +
                "Implement a Java program that calculates the sum of elements in an array using multiple threads. Divide the array into smaller chunks and distribute the calculation of the sum among the threads. Finally, merge the results to obtain the total sum.\n" +
                "\n";
    }

    @Override
    public List<String> getCompanies() {
        return null;
    }

    @Override
    public String getThingsToRemember() {
        return null;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int [] inputArr ={1,2,3,4,5,6,7,8,9,10,10};
        int numThread = 4;
        int chunkSize = inputArr.length/numThread;
        ExecutorService executorPool = Executors.newFixedThreadPool(numThread);
        List<Future<Integer>>resultList = new ArrayList<>(numThread);
        // Defining and running thread
        for(int i=0; i<numThread;i++){
           int start = i*chunkSize;
           int end  = (i!= numThread-1) ? (i+1)*chunkSize : inputArr.length;
           Callable<Integer> task = new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    int sum =0;
                    for ( int ctr=start; ctr<end;ctr++)
                        sum+=inputArr[ctr];
                    return sum;
                }
            };
            resultList.add(executorPool.submit(task));
        }
        int totSum=0;
        for (Future<Integer>res : resultList){
            totSum+= res.get();
        }
        executorPool.shutdown();
        System.out.println(totSum);
    }
}