package org.dreambig.ds.graph;

import java.util.*;
public class FloodFill {
private static class Pair
{
  int x;
  int y;
  public Pair(int x,int y){
    this.x=x;
    this.y=y;
  }
}

    /***
     *
     * @param mtx
     * @param x
     * @param y
     * @param xMax
     * @param yMax
     * @param nClr New Color
     */
  public  static void fill (int [][] mtx,int x, int y,int xMax,int yMax,int nClr){
    int pClr= mtx[x][y];
    Queue<Pair> q= new LinkedList<>();
    q.add(new Pair(x,y));
    boolean [][] visited= new boolean[xMax][yMax];
    while(!q.isEmpty()) {
        Pair curr = q.remove();
        mtx[curr.x][curr.y] = nClr;

        if (curr.x != 0 && mtx[curr.x - 1][curr.y] == pClr && !visited[curr.x - 1][curr.y]) {
            q.add(new Pair(curr.x - 1, curr.y));
            visited[curr.x - 1][curr.y] = true;
        }

        if (curr.y != 0 && mtx[curr.x][curr.y - 1] == pClr && !visited[curr.x][curr.y - 1]) {
            q.add(new Pair(curr.x, curr.y - 1));
            visited[curr.x][curr.y - 1] = true;
        }

        if (curr.x != xMax - 1 && mtx[curr.x + 1][curr.y] == pClr && !visited[curr.x + 1][curr.y]) {
            q.add(new Pair(curr.x + 1, curr.y));
            visited[curr.x + 1][curr.y] = true;

        }
        if (curr.y != yMax - 1 && mtx[curr.x][curr.y + 1] == pClr && !visited[curr.x][curr.y + 1]) {
            q.add(new Pair(curr.x, curr.y + 1));
            visited[curr.x][curr.y + 1] = true;
        }
    }
}

    public static void printMatrix(int[][] data,int n,int m){
  // Printing The Changed Matrix Of Pixels
      for (int i = 0; i < n; i++)
      {
          for (int j = 0; j < m; j++)
          {
           System.out.print(data[i][j]+" ");
          }
          System.out.println();
      }
      System.out.println();
}

    public static void main(String[] args) {
      int screen[][] = {{1, 1, 1, 1, 1, 1, 1, 1},
                     {1, 1, 1, 1, 1, 1, 0, 0},
                     {1, 0, 0, 1, 1, 0, 1, 1},
                     {1, 2, 2, 2, 2, 0, 1, 0},
                     {1, 1, 1, 2, 2, 0, 1, 0},
                     {1, 1, 1, 2, 2, 2, 2, 0},
                     {1, 1, 1, 1, 1, 2, 1, 1},
                     {1, 1, 1, 1, 1, 2, 2, 1},
                     };
      printMatrix(screen,8,8);
      fill (screen,1,1,8,8, 3);
      printMatrix(screen,8,8);
    }


}
