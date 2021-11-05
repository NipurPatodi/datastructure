package org.dreambig.ds.bst.practice.medium;

import org.dreambig.ds.picker.IQuestion;

import java.util.Arrays;
import java.util.List;

public class BSTfromPreOrder implements IQuestion {
    @Override
    public String getQuestion() {
        return "Given preorder traversal of a binary search tree, construct the BST.\n" +
                "\n" +
                "For example, if the given traversal is {10, 5, 1, 7, 40, 50}, then the output should be the root of the following tree." +
                "Find more details at https://www.geeksforgeeks.org/construct-bst-from-given-preorder-traversa/";
    }

    @Override
    public List<String> getCompanies() {
        String[] ip={"Linkedin"};
        return Arrays.asList(ip);
    }

    @Override
    public String getThingsToRemember() {
        return null;
    }

    public  static  class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){this.data=data;}
    }

    private Node constructBST(int [] ip,int sIdx, int eIdx){
        if(sIdx>eIdx) return null;
        else if (sIdx==eIdx) return new Node(ip[sIdx]);
        else{
            int i;
            for(i=sIdx+1;i<=eIdx;i++){
                if(ip[i]>ip[sIdx]){ // Break as soon as we found first
                    break;
                }
            }
            Node node= new Node(ip[sIdx]);
            node.left= constructBST(ip,sIdx+1,i-1);
            node.right=constructBST(ip,i,eIdx);
            return node;
        }
    }

    public Node constructBST(int [] ip){
        return constructBST(ip,0,ip.length-1);
    }

    public void  inorder(Node node){
         if(node!=null){
             inorder(node.left);
             System.out.print(node.data+" ");
             inorder(node.right);
         }
    }

    public static void main(String[] args) {
        System.out.println("ex1.");
        int [] ip={40, 30, 35, 80, 100};
        BSTfromPreOrder obj= new BSTfromPreOrder();
        obj.inorder(obj.constructBST(ip) );
        System.out.println("\nex2.");
        int [] ip2={15, 10, 8, 12, 20, 16, 25};
        obj.inorder(obj.constructBST(ip2) );

    }






}
