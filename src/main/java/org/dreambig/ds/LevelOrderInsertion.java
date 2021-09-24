package org.dreambig.ds;


//Problem: Given a Binary Tree and a node to be deleted from this tree.
//The task is to delete the given node from it.
/*
While performing the delete operation on binary trees, there arise a few cases:
The node to be deleted is a leaf node. That is it does not have any children.
The node to be deleted is a internal node. That is it have left or right child.
The node to be deleted is the root node.

In the first case 1, since the node to be deleted is a leaf node, we can simply delete the node without any overheads. But in the next 2 cases, we will have to take care of the children of the node to be deleted.

In order to handle all of the cases, one way to delete a node is to:
Starting at the root, find the deepest and rightmost node in binary tree and node which we want to delete.
Replace the deepest rightmost node’s data with the node to be deleted.
Then delete the deepest rightmost node.
*/

import java.util.LinkedList;
import java.util.Queue;



class Tree1 {

    static class Node {
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data=data;
        }
    }
    private Node root;

    public Tree1(Node node){
        root=node;
    }

    void deepDelete(Node root, Node toDeletNode){

        Queue<Node> q= new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node curr= q.remove();
            if(curr.right!=null){
                if(curr.right.equals(toDeletNode)){
                    curr.right=null;
                    toDeletNode=null;
                    return;
                }else{
                    q.add(curr.right);
                }
            }

            if(curr.left!=null){
                if(curr.left==toDeletNode){
                    curr.left=null;
                    toDeletNode=null;
                    return;
                }else{
                    q.add(curr.left);
                }
            }

        }

    }




    void delete(int toDelete, Node root){
        // Search node
        // If found replace it with right right
        // end delet right right

        // will Do level order traversal
        Node tmp=null;
        Node nodeToDel=null;
        Queue<Node> q= new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            tmp =q.remove();

            if(tmp.data==toDelete){
                nodeToDel=tmp;
            }
            if(tmp.right !=null)
                q.add(tmp.right);
            if(tmp.left!=null)
                q.add(tmp.left);
        }

        int x =tmp.data; // Data of last Node
        deepDelete(root,tmp);
        nodeToDel.data =x;




    }




}
