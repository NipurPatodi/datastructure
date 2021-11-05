package org.dreambig.ds.graph.practice.medium;

import org.dreambig.ds.picker.IQuestion;

import java.util.Arrays;
import java.util.List;

public class Icelands implements IQuestion {
    @Override
    public String getQuestion() {
        return "Given a boolean 2D matrix, find the number of islands. A group of connected 1s forms an island. For example, the below matrix contains 5 islands\n" +
                "Example: \n" +
                " \n" +
                "\n" +
                "Input : mat[][] = {{1, 1, 0, 0, 0},\n" +
                "                   {0, 1, 0, 0, 1},\n" +
                "                   {1, 0, 0, 1, 1},\n" +
                "                   {0, 0, 0, 0, 0},\n" +
                "                   {1, 0, 1, 0, 1}}\n" +
                "Output : 5\n" +
                "This is a variation of the standard problem: “Counting the number of connected components in an undirected graph”. \n"+
                "Please find more details @ https://www.geeksforgeeks.org/find-number-of-islands/";
    }

    @Override
    public List<String> getCompanies() {
        return Arrays.asList("linkedin.md".split(" "));
    }

    @Override
    public String getThingsToRemember() {
        return null;
    }
    private final  int ROW;
    private final  int COL;
    public Icelands(int r, int c){
        this.ROW=r;
        this.COL=c;
    }

    private final int []rowNbr =  { -1, -1, -1, 0, 0, 1, 1, 1 };
    private final  int [] colNbr =  { -1, 0, 1, -1, 1, -1, 0, 1 };

    private boolean isSafe(int row,int col, int [][]M, boolean [][]visited){
        return row>=0 && row<ROW&& col>=0&& col <COL && M[row][col]==1 &&!visited[row][col];
    }


    public void dfs(int [][]M, boolean [][]visited, int r, int c){

        visited[r][c]=true;
        // visiting all neighbours
        for ( int i=0;i<8;i++){
            if(isSafe(r+rowNbr[i],c+colNbr[i],M, visited)){
                dfs(M,visited,r+rowNbr[i],c+colNbr[i]);
            }
        }
    }

    public  int countIsland (int [][]M){
        boolean [][] visited=new boolean [ROW][COL];
        int cnt=0;
        // visiting all nodes
        for ( int i=0;i<ROW;i++){
            for (int j=0;j<COL;j++){
                if(M[i][j]==1 && !visited[i][j]){
                    dfs(M, visited, i, j);
                    cnt++;
                }

            }
        }
        return  cnt;
    }

    public static void main(String[] args) {
        Icelands obj = new Icelands(5,5);
        int [][]M = new int[][]
                { { 1, 1, 0, 0, 0 },
                  { 0, 1, 0, 0, 1 },
                  { 1, 0, 0, 1, 1 },
                  { 0, 0, 0, 0, 0 },
                  { 1, 0, 1, 0, 1 } };
        System.out.println(obj.countIsland(M));
    }


}
