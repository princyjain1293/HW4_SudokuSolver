import Algorithms.BackTracking;
import Algorithms.DepthFirstSearch;
import Algorithms.StochasticSearch;
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
        SudokuAlgorithms sudokuAlgorithms=null;
        SudokuWriter sudokuWriter= new SudokuWriter();

        sr.getPuzzle(inputPath);
        if(type==1){
            sudokuAlgorithms= new BackTracking(sr.getPuzzle(),sr.getSide(),sr.getDomain(),outputPath,sudokuWriter);
        }
        else if(type==2){
            sudokuAlgorithms=new DepthFirstSearch(sr.getPuzzle(),sr.getSide(),sr.getDomain(),outputPath,sudokuWriter);
        }
        else if(type==3){
            sudokuAlgorithms= new StochasticSearch(sr.getPuzzle(),sr.getSide(),sr.getDomain(),outputPath,sudokuWriter);
        }

        sudokuAlgorithms.solve();


    }

}