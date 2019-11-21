package model;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidatorTest {

    @Test
    public void testValidatePerfectSquares() {
        String inputPath="Input\\Puzzle-4x4-0101.txt";
        Validator validator= new Validator();
        SudokuReader sudokuReader= new SudokuReader();
        sudokuReader.getPuzzle(inputPath);
        validator.validatePerfectSquares(sudokuReader.getBoard());
    }

    @Test
    public void validateValues() {
    }
}