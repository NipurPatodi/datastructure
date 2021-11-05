package org.dreambig.ds.tree.mustdo.easy;

public class SymmetricTree {

  public static class Node{
    int data;
    Node left,right;
    public Node(int d){
      this.data=d;
    }
  }


  public boolean isSymmetric(Node root){

    return isMirror(root,root);
  }

  public boolean isMirror(Node n1, Node n2){
    // If both are null
    if(n1==null && n2==null) return true;

    if( n1!=null && n2!= null && n1.data==n2.data){
        return isMirror(n1.left,n2.right) && isMirror(n1.right, n2.left);
    }
    return false;

  }

  public static void main(String[] args) {
    SymmetricTree tree= new SymmetricTree();
    Node root= new Node(1);
    root.left=new Node(2);
    root.right=new Node(2);
    root.left.left=new Node(3);
    root.right.right=new Node(4);
    System.out.println(tree.isSymmetric(root));
  }


}
