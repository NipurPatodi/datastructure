package org.dreambig.ds.tree;

import org.dreambig.ds.picker.IQuestion;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeUpSideDown implements IQuestion {
    @Override
    public String getQuestion() {
        return "Given the root of a binary tree, turn the tree upside down and return the new root.\n" +
                "\n" +
                "You can turn a binary tree upside down with the following steps:\n" +
                "\n" +
                "The original left child becomes the new root.\n" +
                "The original root becomes the new right child.\n" +
                "The original right child becomes the new left child.\n" +
                "\n" +
                "The mentioned steps are done level by level. It is guaranteed that every right node has a sibling (a left node with the same parent) and has no children.\n" +
                "\n" +
                " \n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "\n" +
                "Input: root = [1,2,3,4,5]\n" +
                "Output: [4,5,2,null,null,3,1]\n" +
                "Example 2:\n" +
                "\n" +
                "Input: root = []\n" +
                "Output: []\n" +
                "Example 3:\n" +
                "\n" +
                "Input: root = [1]\n" +
                "Output: [1]\n" +
                "Please find more details at https://leetcode.com/problems/binary-tree-upside-down/" ;
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
        Node (int data){
            this.data=data;
        }

    }

    public  Node flipBTree( Node root ){
        // base case
        // Root null
        if( root ==null){
            return root;
        }

        // If left and right child are null;
        if(root.left==null && root .right==null)
            return root; // No Fliping possible

        Node flippedRoot= flipBTree(root.left);

        //  rearranging main root Node after returning
        // from recursive call
        root.left.left=root.right;
        root.left.right=root;
        root.left=root.right=null;

        return flippedRoot;
    }

    public  void printLevelOrder(Node root){
        if(root != null ){

            Queue<Node> q= new LinkedList<>();
            q.add(root);
            q.add(null);
            Node prev=null;
            while( !q.isEmpty()){
                Node curr= q.remove();
                if(curr==null ){
                    if(prev==null){
                        q.clear();
                        break;
                    }
                    System.out.println("");
                    q.add(null);
                }else {
                    System.out.print(curr.data + " ");
                    if (curr.left != null) q.add(curr.left);
                    if (curr.right != null) q.add(curr.right);
                }
                prev=curr;
            }
        }

    }

    public static void main(String[] args) {
        BinaryTreeUpSideDown bt= new BinaryTreeUpSideDown();
        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(5);
        System.out.println("Level order traversal of given tree");
        bt.printLevelOrder(root);
        System.out.println("\nLevel order traversal of after fliping tree\n");
        Node newRoot=bt.flipBTree(root);
        bt.printLevelOrder(newRoot);

    }

}
