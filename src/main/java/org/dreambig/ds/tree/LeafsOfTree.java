package org.dreambig.ds.tree;

import org.dreambig.ds.picker.IQuestion;

import java.util.ArrayList;
import java.util.List;

public class LeafsOfTree implements IQuestion {
    @Override
    public String getQuestion() {
        return null;
    }

    @Override
    public List<String> getCompanies() {
        return null;
    }

    @Override
    public String getThingsToRemember() {
        return null;
    }
    public static class Node {
        int data;
        Node left, right;
        Node (int d){this.data=d;}

    }

    Boolean isLeaf (Node root, List<Node> leafs){
        // base case
        if(root==null){
            return  false;
        }

        // best case
        if( root.left==null && root .right==null){
            leafs.add(root);
            return  true;
        }

        if( isLeaf(root.left,leafs)){
            root.left=null;
        }
        if( isLeaf(root.right,leafs)){
            root.right=null;
        }

        return false;
    }

    public static void main(String[] args) {
        LeafsOfTree tree= new LeafsOfTree();
        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        boolean allDone=false;
        while(!allDone) {
            List<Node> res = new ArrayList<>();
            allDone= tree.isLeaf(root, res);
            for (Node node : res) {
                System.out.print(node.data + " ");
            }
            System.out.println("");
        }
    }
}
