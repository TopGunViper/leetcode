package edu.ouc.contest74;

import org.junit.Assert;

public class _794_Valid_Tic_Tac_Toe_State {

    /**
     * The number of O must no more than number of X.
     *
     * @param board
     *
     * @return
     */
    public boolean validTicTacToe(String[] board) {

        int countO = count(board, 'O');
        int countX = count(board, 'X');
        if (countX < countO || countX > (countO + 1)) {
            return false;
        }
        if(isGameOver(board, 'X') && isGameOver(board, 'O')){
            return false;
        }
        if(isGameOver(board, 'X') && (countX == countO)){
            return false;
        }
        if(isGameOver(board, 'O') && (countX != countO)){
            return false;
        }
        return true;
    }

    private int count(String[] board, Character target) {
        int retVal = 0;
        for (int i = 0; i < 3; i++) {
            for (Character c : board[i].toCharArray()) {
                if (c.equals(target)) {
                    retVal++;
                }
            }
        }
        return retVal;
    }

    public boolean isGameOver(String[] board, Character c) {

        for (int i = 0; i < 3; i++) {
            if (board[i].equals(("" + c + c + c))) {
                return true;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (c == board[0].charAt(i) && board[0].charAt(i) == board[1].charAt(i) && board[0].charAt(i) == board[2]
                    .charAt(i)) {
                return true;
            }
        }
        if (c == board[0].charAt(0) && board[0].charAt(0) == board[1].charAt(1) && board[0].charAt(0) == board[2]
                .charAt(2)) {
            return true;
        }
        if (c == board[0].charAt(2) && board[0].charAt(2) == board[1].charAt(1) && board[0].charAt(2) == board[2]
                .charAt(0)) {
            return true;
        }
        return false;
    }

    public static void main(String args[]) {
        //test case1
        _794_Valid_Tic_Tac_Toe_State tester = new _794_Valid_Tic_Tac_Toe_State();
        String[] board = {"O  ", "   ", "   "};
        Assert.assertFalse(tester.validTicTacToe(board));

        String[] board2 = {"XOX", " X ", "   "};
        Assert.assertFalse(tester.validTicTacToe(board2));

        String[] board3 = {"XXX", "   ", "OOO"};
        Assert.assertFalse(tester.validTicTacToe(board3));

        String[] board4 = {"XOX", "O O", "XOX"};
        Assert.assertTrue(tester.validTicTacToe(board4));

        String[] board5 = {"XXX","XOO","OO "};
        Assert.assertFalse(tester.validTicTacToe(board5));

    }
}
