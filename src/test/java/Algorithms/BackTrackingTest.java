package Algorithms;

import model.SudokuReader;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.*;

public class BackTrackingTest {

    @Test
    public void testValidConstructor() throws IOException {
        String path="Input\\Puzzle-4x4-0101.txt";
        SudokuReader sudokuReader= new SudokuReader();
        BackTracking br=sudokuReader.getPuzzle(path);
        br.solveSudoku();
        String[][] actualPuzzle=br.getPuzzle();
        String[][] puzzle= {{"2","4","3","1"},{"1","3","2","4"},{"3","1","4","2"},{"4","2","1","3"}};
        assertEquals(puzzle,actualPuzzle);
    }

    @Test
    public void testFindBlankLocation() {

    }

    @Test
    public void usedInRow() {
    }

    @Test
    public void usedInColumn() {
    }

    @Test
    public void usedInBox() {
    }

    @Test
    public void isSafe() {
    }

    @Test
    public void solveSudoku() {
    }

    @Test
    public void printSolution() {
    }
}