package model;

import Algorithms.BackTracking;
import Algorithms.DepthFirstSearch;
import Algorithms.StochasticSearch;
import Algorithms.SudokuAlgorithms;

import java.io.BufferedReader;

import java.io.FileReader;


public class SudokuReader {
    public SudokuAlgorithms getPuzzle(String inputFileName,String outputFileName, int type, SudokuWriter sudokuWriter) {
        String[][] puzzle = null;
        //List<String> domain = new ArrayList<>();
        int side = 0;
        String[] domain = new String[0];
        try {
            BufferedReader br = new BufferedReader(new FileReader(inputFileName));

            side = Integer.valueOf(br.readLine());
            double sq= Math.sqrt(side);
            if(sq-Math.floor(sq)!=0){
                System.out.println("Array must be a perfect square");
                System.exit(1);
            }
            domain = null;
            domain = br.readLine().split(" ");
            for (String c : domain) {
                System.out.print(c + " ");
            }
            System.out.println();

            String line = br.readLine();
            puzzle = new String[side][];
            puzzle[0] = readRow(line, side);

            int rowNum = 1;
            while ((line = br.readLine()) != null) {
                if (rowNum >= side) {
                    System.out.println("Puzzle is not apt");
                    System.exit(1);
                }
                puzzle[rowNum++] = readRow(line, side);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < side; i++) {
            for (int j = 0; j < side; j++) {
                if (puzzle[i][j].equals("-")) {
                    puzzle[i][j] = "0";
                }
                System.out.print(puzzle[i][j]);
            }

            System.out.println();
        }
        SudokuAlgorithms algo=null;

        if(type==1){
            algo= new BackTracking(puzzle,side,domain,outputFileName,sudokuWriter);
        }
        else if(type==2){
            algo = new DepthFirstSearch(puzzle, side, domain,outputFileName,sudokuWriter);
        }
        else if(type==3){
            algo=new StochasticSearch(puzzle,side,domain,outputFileName,sudokuWriter);
        }

        return algo;
    }
    public static String[] readRow(String line, int side){
        String[] row= new String[side];
        String[] elements= line.split(" ");
        if(elements.length!=side){
            System.out.println("Bad Puzzle");
            System.exit(1);
        }
        for(int i=0;i<elements.length;i++){
            row[i]=elements[i];
        }
        return row;
    }
}
