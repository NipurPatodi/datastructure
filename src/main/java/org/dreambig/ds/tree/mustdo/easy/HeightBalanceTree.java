package org.dreambig.ds.tree.mustdo.easy;

public class HeightBalanceTree {

  public static class Node {
    int data;
    Node left,right;
    public Node(int d){
      this.data=d;
    }
  }

  public int height (Node root){
    if (root==null){
      return 0;
    }
    return 1+ Math.max(height(root.left),height(root.right));
  }



  boolean isbalanced(Node root){
    if(root ==null){
      return true;
    }
    int lh=height(root.left);
    int rh=height(root.right);
    if( Math.abs(lh-rh)<=1){
      return isbalanced(root.left) && isbalanced(root.right);
    }
    return false;

  }

public static void main(String[] args) {
  Node root= new Node(1);
  root.left=new Node(2);
  //root.right=new Node(3);
  root.left.left=new Node(4);
  root.left.right=new Node(5);
  //root.right.left=new Node(6);
    //root.right.right=new Node(7);
    HeightBalanceTree  obj= new HeightBalanceTree ();
  System.out.println(  obj.isbalanced(root));
}

}
