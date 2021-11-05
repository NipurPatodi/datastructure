package org.dreambig.ds.bst.practice.easy;

import org.dreambig.ds.picker.IQuestion;

import java.util.Arrays;
import java.util.List;

public class CheckBST implements IQuestion {
    @Override
    public String getQuestion() {
        return "A program to check if a binary tree is BST or not\n" +
                "Difficulty Level : Medium\n" +
                "Last Updated : 07 Oct, 2021\n" +
                "A binary search tree (BST) is a node based binary tree data structure which has the following properties. \n" +
                "\n" +
                "The left subtree of a node contains only nodes with keys less than the node’s key.\n" +
                "The right subtree of a node contains only nodes with keys greater than the node’s key.\n" +
                "Both the left and right subtrees must also be binary search trees." +
                "Please find more details @ https://www.geeksforgeeks.org/a-program-to-check-if-a-binary-tree-is-bst-or-not/";
    }

    @Override
    public List<String> getCompanies() {
        return Arrays.asList("linkedIn");
    }

    @Override
    public String getThingsToRemember() {
        return "Please note that just recursive will not help as you would miss record of previsous nodes ";
    }

    static  class Node {
        Node left,right;
        int data;
        public  Node (int data){
            this.data=data;
        }
    }

    public boolean isBST(Node root){
        return isBst(root,null,null);
    }
    private  boolean isBst(Node root, Node l, Node r){
        if (root==null){
            return true;
        }
       if(l!=null && root.data<=l.data)
            return false;

       if(r!=null && root.data>=r.data)
           return false;
       return  isBst(root.left,l,root) && isBst(root.right,root,r);

    }

    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(4);
        CheckBST obj= new CheckBST();
        System.out.println(obj.isBST(root));
        /*
        3
       2  5
     1   4
         */

    }





}
