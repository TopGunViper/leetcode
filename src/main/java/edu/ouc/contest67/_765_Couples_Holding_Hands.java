package edu.ouc.contest67;

/**
 * @author wqx
 */
public class _765_Couples_Holding_Hands {

    public int minSwapsCouples(int[] row) {
        int res = 0;
        int[] pos = new int[row.length];

        for (int i = 0; i < row.length; i++) {
            pos[row[i]] = i;
        }

        for (int i = 0; i < row.length; i += 2) {
            int expectedCouple = row[i] % 2 == 0 ? row[i] + 1 : row[i] - 1;
            if (expectedCouple != row[i + 1]) {
                swap(row, pos, i + 1, pos[expectedCouple]);
                res++;
            }
        }
        return res;
    }

    void swap(int[] row, int[] pos, int x, int y) {
        int t = row[x];
        pos[t] = y;
        pos[row[y]] = x;
        row[x] = row[y];
        row[y] = t;
    }

    public static void main(String args[]) {
        //test case1
        _765_Couples_Holding_Hands tester = new _765_Couples_Holding_Hands();
        int[] row = {0, 2, 1, 3};
        System.out.println(tester.minSwapsCouples(row));
        int[] row2 = {3, 2, 0, 1};
        System.out.println(tester.minSwapsCouples(row2));
    }
}
