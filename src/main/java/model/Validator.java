package model;

public class Validator {
    public static void validatePerfectSquares(String[][] board){
        double sr = Math.sqrt(board.length);
        if((sr - Math.floor(sr)) != 0){
            System.out.println("Not a valid puzzle: Perfect Square Required");
            System.exit(1);
        }
    }

    public static void validateValues(String[][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                char ch = board[i][j].charAt(0);
                if(board[i][j].isEmpty()|| Character.isLetterOrDigit(ch)==false){
                    System.out.println("Not a valid puzzle: Only Numbers and Alphabets allowed");
                    System.exit(1);
                }
            }
        }
    }


}
