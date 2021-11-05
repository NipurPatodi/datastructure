package org.dreambig.ds.tree.mustdo.medium;

import org.dreambig.ds.picker.IQuestion;

import java.util.*;

public class InOrderIterative implements IQuestion {
    @Override
    public String getQuestion() {
        return "Inorder Tree Traversal without Recursion\n" +
                "Please find more details at https://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion/";
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

        public Node(int d) {
            this.data = d;
        }
    }

    public List<Integer> inOrderIterative(Node node) {
        if (node == null)
            return null;

        List<Integer> res = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        //stack.push(node);
        Node curr = node;
        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;

            }
            curr = stack.pop();

            res.add(curr.data);
            curr = curr.right;
        }

        return res;
    }

    public static void main(String[] args) {
        InOrderIterative obj = new InOrderIterative();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.right.left = new Node(8);
        root.right.right.right = new Node(9);
    /*
           1
        2    3
      4 5   6 7
             8 9
     */
        for (int n : obj.inOrderIterative(root)) {
            System.out.print(n + " ");
        }

    }


}
