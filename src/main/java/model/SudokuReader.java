package model;

import Algorithms.BackTracking;

import java.io.BufferedReader;

import java.io.FileReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SudokuReader {
    public BackTracking getPuzzle(String inputFileName) throws Exception {
        String[][] puzzle = null;
        //List<String> domain = new ArrayList<>();
        int side = 0;
        String[] domain = new String[0];
        try {
            BufferedReader br = new BufferedReader(new FileReader(inputFileName));

            side = Integer.valueOf(br.readLine());
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
        BackTracking backTracking = new BackTracking(puzzle, side, domain);
        return backTracking;
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
