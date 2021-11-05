package org.dreambig.ds.tree.mustdo.medium;

import org.dreambig.ds.tree.mustdo.easy.ZigzagTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class PrintTreeVertically {
  public static class Node{
    int data;
    Node left, right;
    public Node (int d){
      this.data=d;
    }
  }

  public void findMinMax(Node root, Map<Integer, List<Integer>> map, int hd){
    // Will traverse tree in preorder fashion
    if(root ==null)
      return;

      List<Integer> hdList;
    if(map.containsKey(hd)){
      hdList=map.get(hd);
    }
    else{
      hdList= new LinkedList<>();
      map.put(hd,hdList);
    }
    hdList.add(root.data);

    findMinMax(root.left,map,hd-1);
    findMinMax(root.right,map,hd+1);

  }

  public void PrintTreeVertical(Node root){
    Map<Integer, List<Integer>> map= new TreeMap<>();
    findMinMax(root,map,0);
    for (int key: map.keySet()){
      for ( int tkn: map.get(key))
          System.out.print (tkn+" ");
        System.out.println (" ");
    }


  }

public static void main(String[] args) {
  PrintTreeVertically obj = new PrintTreeVertically();
    Node root= new Node(1);
    root.left=new Node(2);
    root.right=new Node(3);
    root.left.left=new Node(4);
    root.left.right=new Node(5);
    root.right.left=new Node(6);
    root.right.right=new Node(7);
    root.right.right.left=new Node(8);
    root.right.right.right=new Node(9);
    /*
       1
      2   3
    4  5 6 7
       */

    obj.PrintTreeVertical(root);

}




}
