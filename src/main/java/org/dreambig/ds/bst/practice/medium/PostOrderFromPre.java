package org.dreambig.ds.bst.practice.medium;

import org.dreambig.ds.picker.IQuestion;

import java.util.Arrays;
import java.util.List;

public class PostOrderFromPre implements IQuestion {
    @Override
    public String getQuestion() {
        return "Given an array representing preorder traversal of BST, print its postorder traversal. " +
                "Input : 40 30 35 80 100\n" +
                "Output : 35 30 100 80 40\n" +
                "\n" +
                "Input : 40 30 32 35 80 90 100 120\n" +
                "Output : 35 32 30 120 100 90 80 40" +
                "Find more details at https://www.geeksforgeeks.org/find-postorder-traversal-of-bst-from-preorder-traversal/";
    }

    @Override
    public List<String> getCompanies() {
        return Arrays.asList("Linkedin".split(" "));
    }

    @Override
    public String getThingsToRemember() {
        return "Very Tricky... but easy pasy if get it. Enjoy :)";
    }


    public int[] convertPreOrderToPost(int[] pre) {
        int len = pre.length;
        int[] post = new int[len];
        // setting up root right
        int root = pre[0];
        post[len - 1] = root;
        int i = 1;
        for (; i < len; i++) {
            if (pre[i] >= root)
                break;
        }

        // Now placing left sub tree first
        int ctr = 0;
        for (int j = i - 1; j > 0; j--) {
            post[ctr] = pre[j];
            ctr++;
        }
        // Now placing right sub tree first
        for (int j = len - 1; j >= i; j--) {
            post[ctr] = pre[j];
            ctr++;
        }
        return post;

    }

    public void print(int[] arr) {
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println("");
    }


    public static void main(String... args) {
        PostOrderFromPre obj = new PostOrderFromPre();
        int[] ip = {40, 30, 35, 80, 100};
        int[] op = obj.convertPreOrderToPost(ip);
        obj.print(op);

        int[] ip2 = {40, 30, 32, 35, 80, 90, 100, 120};
        int[] op2 = obj.convertPreOrderToPost(ip2);
        obj.print(op2);
    }


}
