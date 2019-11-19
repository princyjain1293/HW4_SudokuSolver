package Algorithms;

public class DepthFirstSearch extends SudokuAlgorithms {
    public String[][] puzzle;
    public int size;
    public String[] domain;


    public DepthFirstSearch(String[][] puzzle, int size,String[] domain){
        this.puzzle=puzzle;
        this.size=size;
        this.domain=domain;
    }

    public int[] findBlankLocation(){
        int[] cell = new int[2];
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(puzzle[j][i]=="0"){
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
    public boolean UsedInRow(int row,String n){
        for(int i=0;i<size;i++){
            if(puzzle[row][i].equals(n))
                return true;
        }
        return false;
    }

    public boolean UsedInColumn(int col,String n){
        for(int i=0;i<size;i++){
            if(puzzle[i][col].equals(n))
                return true;
        }
        return false;
    }
    int root = (int)Math.sqrt(size);
    public boolean UsedInBox(int boxStartRow,int boxStartCol,String n){
        for(int i=0;i<root;i++){
            for(int j=0;j<root;j++){
                if(puzzle[i+boxStartRow][j+boxStartCol].equals(n))
                    return true;
            }
        }
        return false;
    }
    public boolean isSafe(int row, int col, String n){
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
        for(String s:domain){
            if(isSafe(row,col,s)){
                puzzle[row][col]=s;
                if(solveSudoku())
                    return true;
                puzzle[row][col]="0";
            }
        }
        return false;
    }
    public void printSolution(boolean solvable){
        if(solvable){
            for(int i=0;i<size;i++){
                for(int j=0;j<size;j++){
                    System.out.print(puzzle[i][j]);
                }
                System.out.println();
            }
        }
        else{
            System.out.println("The sudoku puzzle is not solvable");
        }


    }
    public String[][] getPuzzle(){
        return puzzle;
    }

}
