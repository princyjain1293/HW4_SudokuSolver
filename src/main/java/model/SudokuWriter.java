package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SudokuWriter {
    public void writeOutput(String outputName, String[][] solution, int size) throws IOException {
        File file = new File(outputName);
        FileWriter writer= new FileWriter(file);
        writer.write("Solution:");
        writer.flush();
        writer.write(System.getProperty("line.separator"));
        writer.flush();
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++) {
                writer.write(solution[i][j] + " ");
                writer.flush();
            }
            writer.write(System.getProperty("line.separator"));
            writer.flush();
        }
    }
}
