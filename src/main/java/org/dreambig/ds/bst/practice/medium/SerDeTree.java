package org.dreambig.ds.bst.practice.medium;

import org.dreambig.ds.picker.IQuestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SerDeTree implements IQuestion {
    @Override
    public String getQuestion() {
        return "Serialization is to store a tree in an array so that it can be later restored and Deserialization is reading tree back from the array. Now your task is to complete the function serialize which stores the tree into an array A[ ] and deSerialize which deserializes the array to the tree and returns it.\n" +
                "Note: The structure of the tree must be maintained. Multiple nodes can have the same data.\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input:\n" +
                "      1\n" +
                "    /   \\\n" +
                "   2     3\n" +
                "Output: 2 1 3\n" +
                "Example 2:\n" +
                "\n" +
                "Input:\n" +
                "         10\n" +
                "       /    \\\n" +
                "      20    30\n" +
                "    /   \\\n" +
                "   40  60\n" +
                "Output: 40 20 60 10 30";
    }

    @Override
    public List<String> getCompanies() {
        return Arrays.asList("linkedin.md".split(""));
    }

    @Override
    public String getThingsToRemember() {
        return null;
    }

    static class Node{
        int data;
        Node left;
        Node right;
        public  Node(int data){
            this.data=data;
        }
    }

    private void serialize(Node root, List<Integer> a){
        // if root is null still add -1 to a
        if(null==root){
            a.add(-1);
            return;
        }
        // Else add root
        a.add(root.data);

        //now traverse its childs left and right
        serialize(root.left,a);
        serialize(root.right,a);
    }

    public  List<Integer> serialize(Node root){
        List<Integer> media= new ArrayList<>();
        serialize(root,media);
        return  media;
    }

    private int idx=0;
    public  Node deserialize(List<Integer> media){
        // Reached at End or no more element
        if(idx==media.size() ||media.get(idx)==-1) {
            idx++;
            return null;
        }

        // else create Node
        Node curr= new Node(media.get(idx));
        idx++;
        curr.left= deserialize(media);
        //idx++;
        curr.right= deserialize(media);
        return curr;

    }

    public void  inorder(Node node){
        if(node!=null){
            inorder(node.left);
            System.out.print(node.data+" ");
            inorder(node.right);
        }
    }

    public static void main(String[] args) {
        SerDeTree obj= new SerDeTree();
        Node root= new Node(20);
        root.left=new Node(8);

        root.left.left=new Node(4);
        root.left.right=new Node(12);

        root.left.right.left=new Node(10);
        root.left.right.right=new Node(14);

        List<Integer> res=obj.serialize(root);
        for ( Integer i:res){
            System.out.print(i+" ");
        }
        System.out.println(" ");
        Node ne= obj.deserialize(res);
        obj.inorder(ne);



    }



}
