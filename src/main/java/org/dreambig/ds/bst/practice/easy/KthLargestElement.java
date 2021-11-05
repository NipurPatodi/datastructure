package org.dreambig.ds.bst.practice.easy;

import org.dreambig.ds.picker.IQuestion;

import java.util.*;

public class KthLargestElement implements IQuestion {
    @Override
    public String getQuestion() {
        return "th largest element in BST \n" +
                "Easy Accuracy: 42.26% Submissions: 51024 Points: 2\n" +
                "Given a Binary search tree. Your task is to complete the function which will return the Kth largest element without doing any modification in Binary Search Tree.\n" +
                "\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input:\n" +
                "      4\n" +
                "    /   \\\n" +
                "   2     9\n" +
                "k = 2 \n" +
                "Output: 4\n" +
                "\n" +
                "Example 2:\n" +
                "\n" +
                "Input:\n" +
                "       9\n" +
                "        \\ \n" +
                "          10\n" +
                "K = 1\n" +
                "Output: 10\n" +
                "\n" +
                "Your Task:\n" +
                "You don't need to read input or print anything. Your task is to complete the function kthLargest() which takes the root of the BST and an integer K as inputs and returns the Kth largest element in the given BST.\n" +
                "\n" +
                "\n" +
                "Expected Time Complexity: O(H + K).\n" +
                "Expected Auxiliary Space: O(H)\n" +
                "Please find more details at https://practice.geeksforgeeks.org/problems/kth-largest-element-in-bst/1";
    }

    @Override
    public List<String> getCompanies() {
        return null;
    }

    @Override
    public String getThingsToRemember() {
        return null;
    }

    static  class Node {
        Node left,right;
        int data;
        public  Node (int data){
            this.data=data;
        }
    }

    public static class RefInt{
        int d;
        public RefInt(int d) {
            this.d = d;
        }
    }
    public void inOrder( Node node,  List<Node>sorted){
      if( node==null)
          return; // base case
        inOrder(node.left,sorted);

        sorted.add(node);
        inOrder(node.right,sorted);
    }

    private static int res=0;
    private static  Node kthNode=null;
    public void inOrderTricky(Node node,int k){
        if( node==null)
            return ; // base case
        inOrderTricky(node.right,k);
       res++;
       if(res==k)
       {
           kthNode=node;
           return;
       }
       inOrderTricky(node.left,k);
    }

    public static void main(String[] args) {
      Node root= new Node(20);

      root.left=new Node(8);
      root.right=new Node(22);

      root.left.left=new Node(4);
      root.left.right=new Node(12);

      root.left.right.left=new Node(10);
      root.left.right.right=new Node(14);
      KthLargestElement  obj = new KthLargestElement ();
        /***
             20
            8       22
         4   12
           10   14

         */
      List<Node> nodes = new ArrayList<>();
      //obj.inOrder(root, nodes);

      //System.out.println(nodes.get(nodes.size()-3).data);
      obj.inOrderTricky(root,3);
      System.out.println(kthNode.data);

    }
}
