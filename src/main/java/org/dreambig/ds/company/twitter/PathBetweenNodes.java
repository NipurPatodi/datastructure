package org.dreambig.ds.company.twitter;

import java.util.ArrayList;
import java.util.List;

public class PathBetweenNodes {
    public static class Node {
        int data;
        Node left;
        Node right;
    }
    private boolean findPathFromRoot(Node root, List<Integer>path ,int data){
        if( root ==null)
            return  false;

        if (root.data== data){
            path.add(root.data);
            return true;
        }

        path.add(root.data); // adding before hand
        if(findPathFromRoot(root.left,path,data) || findPathFromRoot(root.right,path,data)){
            return  true;
        }
        path.remove(path.size()-1);// removing from end
        return false;

    }

    public  void printPathBetweenNodes(Node root, int d1, int d2){

        List<Integer>p1= new ArrayList<>();
        List<Integer>p2= new ArrayList<>();
        boolean p1Exist=findPathFromRoot(root,p1,d1);
        boolean p2Exist=findPathFromRoot(root,p2,d2);
        if(!p1Exist || !p2Exist){
            return;
        }
        // Find intersection
        int i=0,j=0;
        int intercept=0;
        while (i!=p1.size() && j!=p2.size()){
            if(i==j && p1.get(i)==p2.get(j)){
                i++; j++;
            }else{
                intercept=i-1;
                break;
            }
        }
        for ( int ctr=p1.size()-1; ctr>=intercept;ctr-- ){
            System.out.print(p1.get(ctr)+" ");
        }
        for ( int ctr=intercept+1; ctr<p2.size();ctr++ ){
            System.out.print(p2.get(ctr)+" ");
        }





    }






}
