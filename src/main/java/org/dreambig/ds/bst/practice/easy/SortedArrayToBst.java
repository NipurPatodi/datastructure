package org.dreambig.ds.bst.practice.easy;

import org.dreambig.ds.picker.IQuestion;

import java.util.ArrayList;
import java.util.List;

public class SortedArrayToBst implements IQuestion {
    @Override
    public String getQuestion() {
        return "Array to BST \n" +
                "Easy Accuracy: 70.55% Submissions: 7303 Points: 2\n" +
                "Given a sorted array. Convert it into a Height balanced Binary Search Tree (BST). Find the preorder traversal of height balanced BST. If there exist many such balanced BST consider the tree whose preorder is lexicographically smallest.\n" +
                "Height balanced BST means a binary tree in which the depth of the left subtree and the right subtree of every node never differ by more than 1.\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: nums = {1, 2, 3, 4}\n" +
                "Output: {2, 1, 3, 4}\n" +
                "Explanation: \n" +
                "The preorder traversal of the following \n" +
                "BST formed is {2, 1, 3, 4}:\n" +
                "           2\n" +
                "         /   \\\n" +
                "           1     3\n" +
                "               \\\n" +
                "                4" +
                "\nPlease find more details at https://practice.geeksforgeeks.org/problems/array-to-bst4443/1 ";
    }

    @Override
    public List<String> getCompanies() {
        return null;
    }

    @Override
    public String getThingsToRemember() {
        return null;
    }

    public static class Node{
      int data;
      Node left,right;
      public Node(int d){
        this.data=d;
      }
    }


    public Node arrayToBst(int [] arr, int start, int end){
        if(start>end) return null;

        int mid= (start+end)/2;
        Node curr= new Node(arr[mid]);
        curr.left=arrayToBst(arr,start,mid-1);
        curr.right=arrayToBst(arr,mid+1,end);

        return curr;
    }

  public void printInOrder(Node root){
      if(root==null)
        return;
      printInOrder(root.left);
      System.out.print(root.data+" ");
      printInOrder(root.right);

  }
    public void printInOrder(Node root,List<Integer> res){
        if(root==null)
            return;
        printInOrder(root.left,res);
        res.add(root.data);
        printInOrder(root.right,res);

    }


    public static void main(String[] args) {
    int [] ip= {1,2,3,4,5,6,7};
     SortedArrayToBst obj= new  SortedArrayToBst ();
     Node root= obj.arrayToBst(ip,0,ip.length-1);
     List<Integer> res= new ArrayList<>();

        obj.printInOrder(root,res);
        res.stream().mapToInt(i -> i).toArray();

  }



}
