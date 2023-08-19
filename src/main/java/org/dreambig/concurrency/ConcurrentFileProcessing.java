package org.dreambig.concurrency;

import org.dreambig.ds.picker.IQuestion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ConcurrentFileProcessing implements IQuestion {
    @Override
    public String getQuestion() {
        return "Write a Java program that reads a list of file paths from a text file. For each file path, create a separate thread to process the file. The processing involves counting the number of words in the file. Finally, collect the word counts from all threads and print the total word count.";
    }

    @Override
    public List<String> getCompanies() {
        return null;
    }

    @Override
    public String getThingsToRemember() {
        return null;
    }
    static  class WordCounter implements Callable<Integer> {
        private final String fileName;
        public WordCounter(String fileName){
            this.fileName =fileName;
        }

        @Override
        public Integer call() throws Exception {
            int result =0;
            try (BufferedReader br = new BufferedReader(new FileReader(this.fileName))) {
                String line;
                while ((line = br.readLine()) != null) {
                   result+=line.split(" ").length;
                }
            }
            System.out.println("Sum computed by thread "+Thread.currentThread().getName() +" is "+ result);
            return result;
        }
    }

    public static void main(String[] args) throws Exception {
        String metaFile="/Users/npatodi/code/datastructure/src/main/java/org/dreambig/concurrency/meta";
        List<String> fileNames = new ArrayList<>();
        try(BufferedReader br= new BufferedReader(new FileReader(metaFile))){
            String line;
            while((line=br.readLine())!=null){
                fileNames.add(line);
            }
        }
        ExecutorService executor = Executors.newFixedThreadPool(4);
        List<Future<Integer>>results = new ArrayList<>();
        for (String file : fileNames){
            results.add(executor.submit(new WordCounter(file)));
        }
        int sum =0;
        for (Future<Integer> res : results){
            sum+=res.get();
        }
        executor.shutdown();
        System.out.println(sum);
    }
}
