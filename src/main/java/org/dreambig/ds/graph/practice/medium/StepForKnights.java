package org.dreambig.ds.graph.practice.medium;

import org.dreambig.ds.picker.IQuestion;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class StepForKnights implements IQuestion {
    @Override
    public String getQuestion() {
        return "Minimum steps to reach target by a Knight | Set 1\n" +
                "Difficulty Level : Hard\n" +
                "Last Updated : 16 Jul, 2021\n" +
                "Given a square chessboard of N x N size, the position of Knight and position of a target is given. We need to find out the minimum steps a Knight will take to reach the target position." +
                "In above diagram Knight takes 3 step to reach \n" +
                "from (4, 5) to (1, 1) (4, 5) -> (5, 3) -> (3, 2) \n" +
                "-> (1, 1)  as shown in diagram";
    }

    @Override
    public List<String> getCompanies() {
        return Arrays.asList("linkedin".split(" "));
    }

    @Override
    public String getThingsToRemember() {
        return null;
    }

    static class Position {
        int _1;
        int _2;
        public Position(int _1, int _2){
            this._1=_1;
            this._2=_2;
        }
    }

    static class Cell{
        int x,y,dist;
        public Cell(int x, int y,int dist){
            this.x=x;
            this.y=y;
            this.dist=dist;
        }
    }

    private boolean isInsideBoard(int x, int y){
        return  x>=1 && x<=30 && y>=1 && y<=30;
    }

    private final int [] rowNbr={-1,-1,1,1,-2,2,2,-2};
    private final int [] colNbr={-2,2,2,-2,-1,-1,1,1};
    public int getSteps(Position src, Position target){
        boolean [][]visited= new boolean[30+1][30+1];
        Cell base= new Cell(src._1,src._2,0);
        Queue<Cell>q= new LinkedList<>();
        q.add(base);
        visited[base.x][base.y]=true;
        while (!q.isEmpty()){
            Cell t= q.remove();

            if(t.x==target._1 && t.y==target._2){
                return  t.dist;
            }
            // visiting nbrs to see if can be added
            for ( int i =0; i<8; i++){
                int x= t.x+rowNbr[i];
                int y= t.y+colNbr[i];
                if(isInsideBoard(x,y) && !visited[x][y]){
                    visited[x][y]=true;
                    q.add(new Cell(x,y,t.dist+1));
                }
            }


        }
        return  Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        Position src=new Position(1,1);
        Position trg=new Position(30,30);
        StepForKnights obj= new StepForKnights();
        System.out.println(obj.getSteps(src,trg));

        Position src2=new Position(4,5);
        Position trg2=new Position(1,1);
        System.out.println(obj.getSteps(src2,trg2));

    }



}
