package org.dreambig.ds.bst.practice.hard;

import org.dreambig.ds.picker.IQuestion;

import java.util.Arrays;
import java.util.List;

public class DistanceBtwNodes  implements IQuestion {
    @Override
    public String getQuestion() {
        return "Find the distance between two keys in a binary tree, no parent pointers are given. The distance between two nodes is the minimum number of edges to be traversed to reach one node from another.\n" +
                " \n" +
                "\n" +
                "The distance between two nodes can be obtained in terms of lowest common ancestor. Following is the formula. \n" +
                "\n" +
                "Dist(n1, n2) = Dist(root, n1) + Dist(root, n2) - 2*Dist(root, lca) \n" +
                "'n1' and 'n2' are the two given keys\n" +
                "'root' is root of given Binary Tree.\n" +
                "'lca' is lowest common ancestor of n1 and n2\n" +
                "Dist(n1, n2) is the distance between n1 and n2.\n" +
                "Following is the implementation of the above approach. The implementation is adopted from the last code provided in Lowest Common Ancestor Post. \n" +
                "\n";
    }

    @Override
    public List<String> getCompanies() {
        return Arrays.asList("linkedin.md".split(" "));
    }

    @Override
    public String getThingsToRemember() {
        return "Dist(n1, n2) = Dist(root, n1) + Dist(root, n2) - 2*Dist(root, lca)";
    }

    private int d1=-1,d2=-1,dist=-1;

    public  static class Node {
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data=data;
        }
    }

    public Node findLCAUpdateDist(Node node, int n1,int n2, int lvl){
        // Base case
        if(node== null){
            return null;
        }
        // if node data match with any of them
        // set respective Variable
        if(node.data==n1){
            d1=lvl;
            return node;
        }
        if(node.data==n2){
            d2=lvl;
            return node;
        }

        // now time to search sub trees
        Node leftLca= findLCAUpdateDist(node.left,n1,n2,lvl+1);
        Node rightLca= findLCAUpdateDist(node.right,n1,n2,lvl+1);

        // if both are not null mean
        // they are available in both side of trees
        // so dist can be computed
        if(leftLca!=null && rightLca!=null){
            dist=d1+d2-2*lvl;
            return node;
        }

        return leftLca==null?rightLca :leftLca;


    }


    public int findLevel(Node root, int n,int lvl){
        if (root==null) return -1;
        else if( root.data==n)
                return lvl;
        int lLVL=findLevel(root.left,n,lvl+1);
        int rLVL=findLevel(root.right,n,lvl+1);
        return lLVL==-1 ? rLVL: lLVL;
    }

    public int findMinDist(Node root, int n1,int n2){
        d1=-1;
        d2=-1;
        Node lca= findLCAUpdateDist(root,n1,n2,1);
        // if both d1 and d2 are not -1 that mean dist is right ans
        if(d1!=-1 && d2!=-1){
            return dist;
        }
        // n1 is ancestor of n2
        if(lca.data==n1)
            return findLevel(lca,n2,0);

        if(lca.data==n2)
            return findLevel(lca,n1,0);

        return -1;
    }


    public static void main(String[] args) {
        Node root= new Node(1);

        root.left=new Node(2);
        root.right=new Node(3);

        root.left.left=new Node(4);
        root.left.right=new Node(5);

        root.right.left=new Node(6);
        root.right.right=new Node(7);

        root.right.left.right=new Node(8);
        DistanceBtwNodes obj = new DistanceBtwNodes();

        System.out.println(obj.findMinDist(root,4,5));
        System.out.println(obj.findMinDist(root,4,6));
        System.out.println(obj.findMinDist(root,4,3));
        System.out.println(obj.findMinDist(root,4,2));
        System.out.println(obj.findMinDist(root,8,5));
    }
















}
