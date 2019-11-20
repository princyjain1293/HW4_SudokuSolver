package Algorithms;

import model.SudokuWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public abstract class SudokuAlgorithms {
    private double start;
    private double stop;
    //private long numberOfSteps;
    private boolean solvable;

    protected void stopTimer() {
        if (start != 0) {
            stop = System.currentTimeMillis();
        }
        System.out.println("Total Time Taken: " + ((stop - start) / 1000) + " secs");
        //System.out.println("Number of Steps: " + numberOfSteps);
    }

    protected void startTimer() {
        start = System.currentTimeMillis();
    }
//    protected void writeOutput(String outputName, String[][] solution, int size) throws IOException {
//        File file = new File("Output\\"+outputName);
//        FileWriter writer= new FileWriter(file);
//        writer.write("Solution:");
//        for(int i=0;i<size;i++){
//            for(int j=0;j<size;j++)
//                writer.write(solution[i][j]+" ");
//            writer.write("\n");
//        }
//    }

    public abstract boolean solveSudoku();
    public abstract String[][] printSolution(boolean solvable) throws IOException;
    public abstract String[][] getPuzzle();
    public final void solve() throws IOException {
        startTimer();
        solvable=solveSudoku();
        stopTimer();
        String[][]puzzle=printSolution(solvable);

    }
}
