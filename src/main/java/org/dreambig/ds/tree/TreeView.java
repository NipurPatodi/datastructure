/***
Problem: Given a Binary Tree. The task is to print the nodes of the binary tree when viewed from different sides. That is, the left view of the binary tree will contain only those nodes which can be seen when the Binary tree is viewed from left.

Example:
Consider the Below Binary Tree:
       1
    2    3
  4  5  6  7
8  9 10 11 12 13 14 15
Left View of above Tree will be: 1, 2, 4
Right View of above Tree will be: 1, 3, 7
Top View of above Tree will be: 4, 2, 1, 3, 7
Bottom View of above Tree will be: 4, 5, 6, 7
***/
package org.dreambig.ds.tree;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.Map;
import java.util.Queue;

public class TreeView{

  public static class Node{
    int data;
    Node left;
    Node right;
    int hd;
    public Node(int data){
      this.data=data;
    }
  }

/*
function to print left view of Tree
We need to put marker as level changes
*/
  public void printLeftView(Node root){
    Queue <Node> q= new LinkedList<>();
    q.add(null); //1st marker
    q.add(root);
    q.add(null);//2nd marker

    while(!q.isEmpty()){
      Node temp =q.peek(); //Peeking without removing


      if(temp!=null) // Put level iteration
      {
        // First print left most
        System.out.println(temp.data);
        // Now checking until next null is not recieved
        while(q.peek()!=null){

           if(temp.left!=null)
              q.add(temp.left);
           if(temp.right!=null)
                 q.add(temp.right);

            q.remove();
            temp=q.peek();
          }
          q.add(null);// End of Level

        }

      q.remove();

    }

  }

  public void printRightView(Node root){
    Queue<Node> q= new LinkedList<>();
    q.add(null);
    q.add(root);
    q.add(null);
    Node end=null;

    while(!q.isEmpty()){
      Node tmp = q.peek();

      if(tmp !=null){
      while(q.peek()!=null){

        if(tmp.left!=null)
          q.add(tmp.left);
        if(tmp.right!=null)
          q.add(tmp.right);

        end=q.remove();
        tmp=q.peek();
        }
        System.out.println(end.data);
        q.add(null);
      }

      q.remove();

    }


  }


/*
  Print top view of tree
*/
 public void printTopViewOfTree(Node root){
   Map<Integer, Integer> distMap= new TreeMap<>();
   Queue<Node> q= new LinkedList<>();
   root.hd=0;
   q.add(root);

   int hd=0;
   while(!q.isEmpty()){
        Node tmp=q.peek();
        hd=tmp.hd;
        if(!distMap.containsKey(hd))
          distMap.put(hd,tmp.data);

        if( tmp.left!=null){
          tmp.left.hd=hd-1;
          q.add(tmp.left);
        }
        if( tmp.right!=null){
          tmp.right.hd=hd+1;
          q.add(tmp.right);
        }
        q.remove();
      }

  for(int k:distMap.keySet()){
    System.out.print(distMap.get(k)+" ");
  }

 }

 public void printBottomView(Node root){
   // Need Map of hd and data
  Map<Integer, Integer>distMap= new TreeMap<>();
  Queue<Node>q= new LinkedList<>();
  root.hd=0;
  q.add(root);
  int hd=0;
  while(!q.isEmpty()){
    Node tmp= q.peek();
    hd=tmp.hd;
    distMap.put(hd,tmp.data);
    if(tmp.left!=null){
      tmp.left.hd=hd-1;
      q.add(tmp.left);
    }
    if(tmp.right!=null){
      tmp.right.hd=hd+1;
      q.add(tmp.right);
    }
    q.remove();
  }

  for(int k :distMap.keySet()){
    System.out.print(distMap.get(k)+" ");
  }



 }















  public static void main(String[] args) {
      TreeView tree= new TreeView();
      Node root= new Node(1);
      root.left= new Node(2);
      root.right= new Node(3);
      root.left.left= new Node(4);
      root.left.right= new Node(5);
      root.right.left= new Node(6);
      root.right.right= new Node(7);
      tree.printLeftView(root);
      System.out.println("-----");
      tree.printRightView(root);
      System.out.println("-----");
      tree.printTopViewOfTree(root);
      System.out.println("-----");
      tree.printBottomView(root);


    }



}
