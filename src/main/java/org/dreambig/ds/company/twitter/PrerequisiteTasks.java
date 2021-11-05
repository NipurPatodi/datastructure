package org.dreambig.ds.company.twitter;
import java.util.*;
public class PrerequisiteTasks {

  private static class Graph{
    List<Integer>[] adj;

    public Graph(int n) {
        adj = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void add( int x, int y){
            adj[x].add(y);
    }
    private boolean isCycle ( boolean[] visited, int node ){

            visited[node] = true;
            List<Integer> curr = this.adj[node];
            for (int c : curr) {
                if (!visited[c]) {
                    if (isCycle(visited, c))
                        return true;
                } else if(c!=node)
                {
                    return true;
                }
            }
            return false;

        }

        public boolean isCycle () {
            boolean[] visited = new boolean[adj.length];
            return isCycle(visited, 0);

        }
    }


    public static boolean isPossible(int N, int[][] pr)
    {
      Graph graph = new Graph(N);
      for ( int i=0;i<pr.length;i++){
          if(pr[i][1]==pr[i][0])
              return false;
        graph.add(pr[i][1],pr[i][0]);
      }
      return !graph.isCycle();
    }

    /**
     * 20
     * 8
     * 0 10
     * 3 18
     * 5 5
     * 6 11
     * 11 14
     * 13 1
     * 15 1
     * 17 4
     * @param args
     */

    public static void main(String[] args) {
        int[][] pr = {{0,10},{3,18},{5,5},{6,11},{11,14},{13,1},{15,1},{17,4}};
        System.out.println(isPossible(20,pr));
    }

}
