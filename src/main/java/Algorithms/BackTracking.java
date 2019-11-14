package Algorithms;

public class BackTracking {
    public static int[][] grid;
    public static int size;

    public int[] findBlankLocation(){
        int[] cell = new int[2];
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(grid[i][j]==0){
                    cell[0]=i;
                    cell[1]=j;
                    return cell;
                }
            }
        }
        //if the grid is full
        cell[0]=-1;
        cell[1]=-1;
        return cell;
    }
    public boolean UsedInRow(int row,int n){
        for(int i=0;i<size;i++){
            if(grid[row][i]==n)
                return true;
        }
        return false;
    }
    public boolean UsedInColumn(int col,int n){
        for(int i=0;i<size;i++){
            if(grid[i][col]==n)
                return true;
        }
        return false;
    }
    public boolean UsedInBox(int boxStartRow,int boxStartCol,int n){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(grid[i+boxStartRow][j+boxStartCol]==n)
                    return true;
            }
        }
        return false;
    }
    public boolean isSafe(int row, int col, int n){
        if(!UsedInRow(row,n) && !UsedInColumn(col,n) && !UsedInBox(row-row%3,col-col%3,n))
            return true;
        return false;
    }
    public boolean solveSudoku(){
        int row;
        int col;
        int[] blankCell=findBlankLocation();
        row= blankCell[0];
        col=blankCell[1];
        if(row==-1)
            return true;
        for(int i=1;i<=size;i++){
            if(isSafe(row,col,i)){
                grid[row][col]=i;
                if(solveSudoku())
                    return true;
                grid[row][col]=0;
            }
        }
        return false;
    }
}
