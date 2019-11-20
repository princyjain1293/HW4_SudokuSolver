import Algorithms.BackTracking;
import Algorithms.SudokuAlgorithms;
import model.SudokuReader;
import model.SudokuWriter;

import java.util.Scanner;

public class SudokuSolver{
    public static void main(String[] args) throws Exception {
        Scanner cin= new Scanner(System.in);
        System.out.println("Enter the name of input file");
        String inputFileName= cin.next();
        System.out.println("Enter the name of file where you want to write the output");
        String outputFileName= cin.next();
        System.out.println("Select the number based on the type of Algorithm:");
        System.out.println("1. Backtracking"+"\n"+"2. Depth First Search"+"\n"+"3. Stochastic Search");
        int type= cin.nextInt();


        SudokuReader sr= new SudokuReader();

        String inputPath="Input\\"+inputFileName;
        String outputPath="Output\\"+outputFileName;
        String[][] puzzle=null;
        SudokuWriter sudokuWriter= new SudokuWriter();

        SudokuAlgorithms sudokuAlgorithms= sr.getPuzzle(inputPath,outputPath,type,sudokuWriter);
        //SudokuAlgorithms depthFirstSearch= sr.getPuzzle(path);
        sudokuAlgorithms.solve();
        //backTracking.printSolution(solvable);

    }

}