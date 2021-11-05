package org.dreambig.ds.heap.hard;

import org.dreambig.ds.picker.IQuestion;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MedianOfContinuesStream implements IQuestion {
    @Override
    public String getQuestion() {
        return "Given an input stream of N integers. The task is to insert these numbers into a new stream and find the median of the stream formed by each insertion of X to the new stream.\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input:\n" +
                "N = 4\n" +
                "X[] = 5,15,1,3\n" +
                "Output:\n" +
                "5\n" +
                "10\n" +
                "5\n" +
                "4\n" +
                "Explanation:Flow in stream : 5, 15, 1, 3 \n" +
                "5 goes to stream --> median 5 (5) \n" +
                "15 goes to stream --> median 10 (5,15) \n" +
                "1 goes to stream --> median 5 (5,15,1) \n" +
                "3 goes to stream --> median 4 (5,15,1 3) \n" +
                " \n" +
                "\n" +
                "Example 2:\n" +
                "\n" +
                "Input:\n" +
                "N = 3\n" +
                "X[] = 5,10,15\n" +
                "Output:\n" +
                "5\n" +
                "7.5\n" +
                "10\n" +
                "Explanation:Flow in stream : 5, 10, 15\n" +
                "5 goes to stream --> median 5 (5) \n" +
                "10 goes to stream --> median 7.5 (5,10) \n" +
                "15 goes to stream --> median 10 (5,10,15) " +
                "Find more details @ https://www.geeksforgeeks.org/median-of-stream-of-integers-running-integers/";
    }

    @Override
    public List<String> getCompanies() {
        String []c="MorganStanley".split(" ");
        return Arrays.asList(c);

    }



    @Override
    public String getThingsToRemember() {
        return "Trick is add element to min and max Heap and balance these by moving elements";
    }

    private PriorityQueue<Integer> max= new PriorityQueue<>(Comparator.reverseOrder());
    private PriorityQueue<Integer> min= new PriorityQueue<>();

    public void add(int val){

        if(max.isEmpty()){
            max.add(val);
        }else if(val >max.peek() ) {
            min.add(val);
        }else if(min.isEmpty()){
            min.add(max.peek());
            max.poll();
            max.add(val);
        }else
            max.add(val);
        balance();

    }

    private void balance(){
        if(!max.isEmpty() &&!min.isEmpty()){
            if(max.size()>min.size()){
                min.add(max.peek());
                max.poll();
            }else{
                max.add(min.peek());
                min.poll();
            }

        }
    }


    public float getMedian(){
        float median=0.0f;
        if((max.size()+min.size()) %2==0){ // even case
            median= (max.peek()+ min.peek())/2.0f;
        }
        else if(max.size()>min.size()){
            median=max.peek();
        }
        else
            median=min.peek();


        return median;
    }


    public static void main(String[] args) {
        MedianOfContinuesStream m= new MedianOfContinuesStream();
        // 5, 15, 1, 3
        m.add(5);
        m.add(15);
        m.add(1);
        System.out.println(m.getMedian());
        m.add(3);
        System.out.println(m.getMedian());
        m.add(7);
        System.out.println(m.getMedian());
        m.add(27);
        System.out.println(m.getMedian());

    }




}
