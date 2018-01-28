package edu.ouc.contest69;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import org.junit.Assert;

/**
 * @author wqx
 */
public class _773_Sliding_Puzzle {

    public int slidingPuzzle(int[][] board) {

        int curPosX = 0;
        int curPosY = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 0) {
                    curPosX = i;
                    curPosY = j;
                }
            }
        }
        Set<State> states = new HashSet<>();
        Queue<State> queue = new LinkedList<>();
        State state = new State(board, curPosX, curPosY);
        queue.offer(state);
        states.add(state);

        int minMoves = -1;
        while (!queue.isEmpty()) {
            minMoves++;
            int size = queue.size();
            System.out.println("size:" + size);
            for (int i = 0; i < size; i++) {
                State curState = queue.poll();
                //System.out.println(Arrays.deepToString(curState.board));
                if (curState.isSolvedState()) {
                    return minMoves;
                }
                List<State> nextStates = curState.next();
                nextStates.stream().forEach(s -> {
                    for(State tmp : states){
                        if(!s.equals(tmp) && s.hashCode()== tmp.hashCode()){
                            System.out.println("src:" + Arrays.deepToString(tmp.board) );
                            System.out.println("dest:" + Arrays.deepToString(s.board) );
                        }
                    }
                    if (!states.contains(s)) {
                        states.add(s);
                        queue.offer(s);
                    }
                });
            }
        }
        return -1;
    }

    static class State {
        int[][] board;
        int curPosX;
        int curPosY;

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        public State(int[][] board, int curPosX, int curPosY) {
            this.board = board;
            this.curPosX = curPosX;
            this.curPosY = curPosY;
        }

        public List<State> next() {
            List<State> result = new LinkedList<>();

            for (int k = 0; k < 4; k++) {
                int nextPosX = curPosX + dx[k];
                int nextPosY = curPosY + dy[k];
                if (nextPosX >= 0 && nextPosX < 2 && nextPosY >= 0 && nextPosY < 3) {
                    swap(board, curPosX, curPosY, nextPosX, nextPosY);
                    int[][] next = new int[2][3];
                    for (int i = 0; i < 2; i++) {
                        for (int j = 0; j < 3; j++) {
                            next[i][j] = board[i][j];
                        }
                    }
                    result.add(new State(next, nextPosX, nextPosY));
                    swap(board, curPosX, curPosY, nextPosX, nextPosY);
                }
            }
            return result;
        }

        public boolean isSolvedState() {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i == 1 && j == 2) {
                        continue;
                    }
                    if (board[i][j] != i * 3 + j + 1) {
                        return false;
                    }
                }
            }
            return true;
        }

        private void swap(int[][] board, int curPosX, int curPosY, int nextPosX, int nextPosY) {
            int tmp = board[curPosX][curPosY];
            board[curPosX][curPosY] = board[nextPosX][nextPosY];
            board[nextPosX][nextPosY] = tmp;
        }

        @Override
        public boolean equals(Object obj) {
            if(obj instanceof State){
                State state = (State)obj;
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 3; j++) {
                        if(board[i][j] != state.board[i][j]){
                            return false;
                        }
                    }
                }
            }
            return true;
        }

        @Override
        public int hashCode() {
            return Arrays.deepHashCode(board);
        }
    }

    public static void main(String args[]) {
        //test case1
        _773_Sliding_Puzzle tester = new _773_Sliding_Puzzle();
        int[][] A = {{1, 2, 3}, {4, 0, 5}};

        Assert.assertEquals(1, tester.slidingPuzzle(A));

        int[][] A2 = {{1, 2, 3}, {5, 4, 0}};
        Assert.assertEquals(-1, tester.slidingPuzzle(A2));

        int[][] A3 = {{4, 1, 2}, {5, 0, 3}};
        Assert.assertEquals(5, tester.slidingPuzzle(A3));

        int[][] A4 = {{3, 2, 4}, {1, 5, 0}};
        Assert.assertEquals(14, tester.slidingPuzzle(A4));

    }
}
