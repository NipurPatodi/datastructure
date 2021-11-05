package org.dreambig.ds.company.twitter;

public class NQueenProblem{

  private void print (String x){
    System.out.print(x);
  }
  private void println (String x){
    System.out.println(x);
  }

  private final int N;

  public NQueenProblem(int n){
    this.N=n;
  }

  private void printBoard( int [][] b, int N){
    for (int i=0;i<N;i++){
      for (int j=0; j<N; j++){
          print(b[i][j]+" ");
      }
      println(" ");
    }
  }

  /***
  check 1. column 2. row 3  diagonals
  ***/
  private boolean isSafe (int [][] b, int row, int col){

  // left side rows
  for (int i=0; i<col; i++){
    if(b[row][i]==1)
        return false;
  }

  // check diagonals on  upper left
  for ( int i =row,j=col; i>=0 && j>=0; i--,j--){
      if(b[i][j]==1)
          return false;
    }

  // check diagonals on lower left
  for ( int i=row,j=col; i<b.length && j>=0;j--,i++){
      if(b[i][j]==1)
        return false;
 }

 return true;

}

/**
  Function to solve N Queen problem using back tracking
**/

boolean solveNQUtil(int [][]b, int col)
{
   if (col>=N){
    return true; // All Queens are placed
   }

   // iterating on Row and trying find best fit
   for ( int i=0; i<N; i++){

      if(isSafe(b,i,col)){
        b[i][col]=1;

          if(solveNQUtil(b, col+1))
            return true;
        b[i][col]=0;    // Back tracking and reverting to original value
      }


   }
   return false; // Nothing fit
  }



public boolean solve(){
int board[][] = { { 0, 0, 0, 0 },
                          { 0, 0, 0, 0 },
                          { 0, 0, 0, 0 },
                          { 0, 0, 0, 0 }};

        printBoard(board,4);
        println ("Before");
        if (solveNQUtil(board, 0) == false) {
            System.out.print("Solution does not exist");
            return false;
        }

        printBoard(board,4);
        return true;
}

  public static void main( String ... args){

  NQueenProblem p= new NQueenProblem(4);
  p.solve();


  }




}
