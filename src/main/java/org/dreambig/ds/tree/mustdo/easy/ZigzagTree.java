package org.dreambig.ds.tree.mustdo.easy;
import java.util.*;

public class ZigzagTree {
  public static class Node{
    int data;
    Node left,right;
    public Node (int d){
      this.data=d;
    }
  }

  public List<Node> traverseZigZag(Node root ){
    if(root==null){
      return null;
    }
    Stack<Node> cStack= new Stack<>();
    Stack<Node> nlStack= new Stack<>();
    List<Node>res= new ArrayList<>();
    cStack.add(root);

    boolean leftToRight=true;
    while( !cStack.isEmpty()){
        Node tmp=cStack.pop();
        res.add(tmp);
        if(leftToRight){
          if(tmp.left!=null)nlStack.add(tmp.left);
          if(tmp.right!=null)nlStack.add(tmp.right);
        }else{
          if(tmp.right!=null)nlStack.add(tmp.right);
          if(tmp.left!=null)nlStack.add(tmp.left);
        }

        if(cStack.isEmpty()){
          Stack <Node> tmpStack= cStack;
          cStack=nlStack;
          nlStack=tmpStack;
          leftToRight= !leftToRight;
        }

    }
    return res;
    }

    public static void main(String[] args) {
      ZigzagTree zt = new ZigzagTree();
      Node root= new Node(1);
      root.left=new Node(2);
      root.right=new Node(3);
      root.left.left=new Node(4);
      root.left.right=new Node(5);
      root.right.left=new Node(6);
        root.right.right=new Node(7);
      /*
      1
     2  3
    4 5 6 7
       */
      for (Node i: zt.traverseZigZag(root)){
          System.out.print(i.data+" ");
      }
    }


}
