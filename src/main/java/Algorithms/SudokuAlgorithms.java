package Algorithms;

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

    public abstract boolean solveSudoku();
    public abstract void printSolution(boolean solvable);
    public final void solve(){
        startTimer();
        solvable=solveSudoku();
        stopTimer();
        printSolution(solvable);
    }
}
