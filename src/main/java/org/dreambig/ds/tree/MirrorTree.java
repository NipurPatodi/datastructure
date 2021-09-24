package org.dreambig.ds.tree;
public class MirrorTree {

 static class Node{
  int data;
  Node left;
  Node right;
  public Node(int data){
    this.data= data;
  }
}

public void mirror(Node root){
  if(root==null)
    return;


  mirror(root.left);
  mirror(root.right);
  Node temp =root.right;
  root.right=root.left;
  root.left=temp;
}

public void inOrderTraveral(Node root){

  if( root ==null)
  return;

  inOrderTraveral(root.left);
  System.out.print(root.data+" ");
  inOrderTraveral(root.right);
}




public static void main(String[] args) {
  MirrorTree tree= new MirrorTree();
  Node root= new Node(1);
  root.left= new Node(2);
  root.right= new Node(3);
  root.left.left= new Node(4);
  root.right.left=new Node(5);
  tree.inOrderTraveral(root);
  tree.mirror(root);
  System.out.println("\n------");
  tree.inOrderTraveral(root);



}







}
