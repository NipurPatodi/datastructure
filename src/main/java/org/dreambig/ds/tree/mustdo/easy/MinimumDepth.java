package org.dreambig.ds.tree.mustdo.easy;

public class MinimumDepth {

  public static class Node {
    int data;
    Node left,right;
    public Node (int d){
      this.data=d;
    }
  }

  int getMinDepth(Node node){
    if(node==null){
      return 0;
    }

    if(node.left==null && node.right ==null)
      return 1;

    if(node.left==null){
      return getMinDepth(node.right)+1;
    }

    if(node.right==null){
      return getMinDepth(node.left)+1;
    }

    return 1+ Math.min(getMinDepth(node.right) ,getMinDepth(node.left));

  }

public static void main(String[] args) {
  MinimumDepth obj= new MinimumDepth();
  Node root= new Node(1);
  root.left=new Node(2);
  //root.right=new Node(3);
  root.left.left=new Node(4);
  root.left.right=new Node(5);
  //root.right.left=new Node(6);
    //root.right.right=new Node(7);
    System.out.println(obj.getMinDepth(root));

}



}
