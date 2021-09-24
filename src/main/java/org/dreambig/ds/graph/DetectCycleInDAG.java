package org.dreambig.ds.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DetectCycleInDAG {

private int V;
private List<Integer> adj[];

  public DetectCycleInDAG(int V)
    {
          this.V = V;
          adj = new LinkedList[V];

          for (int i = 0; i < V; i++)
              adj[i]=new LinkedList<>();
      }

      private void addEdge(int source, int dest) {
             adj[source].add(dest);
         }


    public void bfs(int s){
      Queue<Integer> q= new LinkedList<>();
      boolean []visited = new boolean[V];
      visited[s]=true;
      q.add(s);

      while(!q.isEmpty()){
        int tmp= q.remove();
        System.out.print(tmp+" ");
        for (int edge: adj[tmp]){
          if(!visited[edge]){
              visited[edge]=true ;
              q.add(edge);
            }
        }

      }
    }

    public boolean isCycle(int s){
      boolean[] visited = new boolean[V];
    return detectCycle(s,visited);
    }

    private boolean detectCycle(int s , boolean[] visited){
      visited[s]=true;
      List<Integer> nodes= adj[s];
      for (Integer node :nodes){
          if(!visited[node]){
              if(detectCycle(node,visited))
                  return  true;
          }else if(node!=s){
              return true;
          }
      }
      return false;
    }

    public boolean isTree(){
      boolean [] visited= new boolean[V];
      boolean res= detectCycle(0,visited);
      // can not be tree as there is Cycle
      if (res)
        return false;
    for (int i=0;i<V;i++){
      if(!visited[i])
        return false;
    }
    return true;
    }





    public void dfs(int s){
      boolean []visited= new boolean[V];
      dfsRecursive (visited , s);

    }


    public void dfsRecursive(boolean[] visited,int s){
      visited[s]=true;
      System.out.print(s+" ");
      List <Integer> nodes= adj[s];
      for (int node : nodes){
        if( !visited[node])
        {
          dfsRecursive(visited,node);
        }
      }
    }



      public static void main(String[] args)
       {
           DetectCycleInDAG graph = new DetectCycleInDAG(4);
           graph.addEdge(0, 1);
           graph.addEdge(0, 2);
           graph.addEdge(1, 2);
           graph.addEdge(2, 3);
           //graph.addEdge(3, 3);
           graph.bfs(0);
           System.out.println("\n");
           graph.dfs(0);
          // System.out.println("\n "+graph.isCycle(0));
           System.out.println("\n"+graph.isTree());
           //if(graph.isCyclic())
            //   System.out.println("Graph contains cycle");
           //else
            //   System.out.println("Graph doesn't "
              //                         + "contain cycle");
       }
   }
