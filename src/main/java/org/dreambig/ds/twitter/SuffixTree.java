package org.dreambig.ds.twitter;

import java.util.LinkedList;
import java.util.List;

public class SuffixTree {

    public static class Node {
        Node [] children = new Node[256];
        LinkedList<Integer> index = new LinkedList<>();

        public void  insert(String s, int idx) {
            index.add(idx);

            if(s.length()>0){
                int cIdx= s.charAt(0);
                if(children[cIdx]==null) {
                    Node child = new Node();
                    children[cIdx] = child;
                }
                children[cIdx].insert(s.substring(1),idx+1);
            }
        }

        public  LinkedList<Integer> search (String s){
            if(s.length()==0)
                return this.index;
            else{
                if(children[s.charAt(0)]!=null)
                return children[s.charAt(0)].search(s.substring(1));
                else
                    return   null;
            }
        }

    }

    Node root = new Node();

     public SuffixTree(String str){
         for(int i=0;i<str.length();i++){
            root.insert(str.substring(i),i);
         }
     }

     public void search(String pl){
          List<Integer> idx=root.search(pl);
          if(idx== null){
              System.out.println("Noting found");
          }
          else{
              for ( int i: idx){
                  System.out.println("found at "+(i-pl.length()));
              }
          }
     }

    public static void main(String[] args) {
        SuffixTree tree= new SuffixTree("I am Nipur Patodi.");
        tree.search("i");
    }



}
