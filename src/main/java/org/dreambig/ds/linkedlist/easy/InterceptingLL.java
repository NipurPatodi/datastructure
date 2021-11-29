package org.dreambig.ds.linkedlist.easy;

import org.dreambig.ds.picker.IQuestion;

import java.util.Arrays;
import java.util.List;

public class InterceptingLL implements IQuestion {
    @Override
    public String getQuestion() {
        return "Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.\n" +
                "\n" +
                "For example, the following two linked lists begin to intersect at node c1:\n" +
                "\n" +
                "Please find more details at https://leetcode.com/problems/intersection-of-two-linked-lists/ ";
    }

    @Override
    public List<String> getCompanies() {
        return Arrays.asList("linkedin".split(" "));
    }

    @Override
    public String getThingsToRemember() {
        return null;
    }

    public  static class Node{
        Node next;
        int data;
        Node (int d){
            this.data=d;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "next=" + next +
                    ", data=" + data +
                    '}';
        }
    }

    public Node getInterceptingNode(Node n1, Node n2){
        Node n1Head=n1;
        Node n2Head=n2;
        int ctr=0;
        while(n1!=n2){
            n1= (n1==null)?n2Head:n1.next;
            n2= (n2==null)?n1Head:n2.next;
            ctr++;
        }
        System.out.println(ctr);
        return  n1;




    }

    public static void main(String[] args) {
        InterceptingLL obj= new InterceptingLL();
        Node l1=new Node(1);
        l1.next=new Node(2);
        l1.next.next=new Node(3);
        l1.next.next.next=new Node(4);
        Node l2=new Node(10);
        l2.next=new Node(22);
        l2.next.next=new Node(33);
       // l2.next.next.next= l1.next.next;

        Node res= obj.getInterceptingNode(l1,l2);
        System.out.println(res.data);
    }




}
