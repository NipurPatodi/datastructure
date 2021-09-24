package org.dreambig.ds;// WAP to Traverse tree
import java.util.Queue;
import java.util.LinkedList;

class Node{
  int data;
  Node left;
  Node right;
}

class BinaryTree{

int key;
Node root;

public   void traverseInOrder(Node node){
    if(node!=null){
      traverseInOrder(node.left);
      System.out.print(node.data+" ");
      traverseInOrder(node.right);
    }
  }

public  void traversePreOrder(Node node){
    if(node!=null){
      traverseInOrder(node.left);
      traverseInOrder(node.right);
      System.out.print(node.data+" ");
      }
  }

public  void traversePostOrder(Node node){
    if(node!=null){
      System.out.print(node.data+" ");
      traverseInOrder(node.left);
      traverseInOrder(node.right);
      }
  }

  public void levelOrderTraversing (Node node){
    Queue<Node>q= new LinkedList<>();
    q.add(node);
    while(!q.isEmpty()){
      Node tmp =q.remove();
      System.out.print(tmp+" ");
      if(tmp.left !=null)
        q.add(tmp.left);
      if(tmp.right !=null)
          q.add(tmp.right);

    }
  }


}
