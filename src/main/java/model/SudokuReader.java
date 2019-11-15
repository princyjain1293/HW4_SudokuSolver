package model;

import java.io.BufferedReader;

import java.io.FileReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SudokuReader {
    public String[][] getPuzzle(String inputFileName) throws Exception {
        String[][] puzzle= null;
        List<String> domain= new ArrayList<>();
        BufferedReader br= new BufferedReader(new FileReader(inputFileName));
        int side= Integer.valueOf(br.readLine());
        domain.addAll(Arrays.asList(br.readLine().split(" ")));
        System.out.println(domain);
        String line= br.readLine();
        puzzle= new String[side][side];

        puzzle[0]= readRow(line,side);
        int rowNum=1;
        while ((line=br.readLine())!=null){
            if(rowNum>=side){
                System.out.println("Puzzle is not apt");
                System.exit(1);
            }
            puzzle[rowNum++]=readRow(line,side);
        }
        for(int i=0;i<side;i++){
            for(int j=0;j<side;j++){
                System.out.print(puzzle[i][j]);
            }
            System.out.println();

        }

        return puzzle;
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
