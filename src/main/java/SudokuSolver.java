import Algorithms.BackTracking;
import Algorithms.SudokuAlgorithms;
import model.SudokuReader;
import java.util.Scanner;

public class SudokuSolver{
    public static void main(String[] args) throws Exception {
        Scanner cin= new Scanner(System.in);
//        System.out.println("Enter the type of Algorithm");
//        String type= cin.next();
        System.out.println("Enter the name of input file");
        String inputFileName= cin.next();
        SudokuReader sr= new SudokuReader();

        String path="Input\\"+inputFileName;
        String[][] puzzle=null;

        SudokuAlgorithms backTracking= sr.getPuzzle(path);
        backTracking.solve();
        //backTracking.printSolution(solvable);

    }

}