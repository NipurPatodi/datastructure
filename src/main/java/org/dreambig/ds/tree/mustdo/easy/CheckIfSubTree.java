package org.dreambig.ds.tree.mustdo.easy;

public class CheckIfSubTree {

  public static class Node {
    Node left,right;
    int data;
    Node(int d){
      this.data=d;
    }
  }

  boolean isIdentical(Node t, Node s){
    if( t==null && s==null) return true;
    if( t!=null && s!=null && t.data==s.data){
      return  isIdentical(t.left, s.left) && isIdentical(t.right, s.right);
    }
    return false;
  }



  boolean isSubTree( Node t, Node s){
    //base cases
    if(s==null)
        return true;

    if(t==null)
      return false;

  if(isIdentical(t,s))
      return  true;
  return  isSubTree(t.right ,s) || isSubTree(t.left,s);
  }


  public static void main(String[] args) {
    CheckIfSubTree obj= new CheckIfSubTree();
    Node root= new Node(1);



    root.left=new Node(2);
    root.left.left=new Node(4);
    root.left.right=new Node(5);
    root.left.right.left=new Node(10);
    root.right=new Node(3);
    root.right.left=new Node(6);
    root.right.right=new Node(7);

    Node root2=new Node(2);
    root2.left=new Node(4);
    root2.right=new Node(5);

    System.out.println(obj.isSubTree(root,root2));

  }



}
