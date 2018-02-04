package edu.ouc.contest70;

import org.junit.Assert;

/**
 * @author wqx
 */
public class _779_K_th_Symbol_in_Grammar {

    /**
     * @param N
     * @param K
     *
     * @return
     */
    public int kthGrammar(int N, int K) {
        if (N == 1) {
            return 0;
        }
        if(N == 2){
            return K == 1 ? 0 : 1;
        }
        int len = (int) Math.pow(2, N - 1);
        if (K <= len / 2) {
            return kthGrammar(N - 1, K);
        } else {
            return kthGrammar(N - 1, K - len /2) == 0 ? 1 : 0;
        }
    }

    public static void main(String args[]) {
        //test case1
        _779_K_th_Symbol_in_Grammar tester = new _779_K_th_Symbol_in_Grammar();
        int N = 1, K = 1;
        Assert.assertEquals(0, tester.kthGrammar(N, K));

        int N2 = 2, K2 = 1;
        Assert.assertEquals(0, tester.kthGrammar(N2, K2));

        int N3 = 2, K3 = 2;
        Assert.assertEquals(1, tester.kthGrammar(N3, K3));

        int N4 = 3, K4 = 4;
        Assert.assertEquals(0, tester.kthGrammar(N4, K4));

        int N5 = 3, K5 = 3;
        Assert.assertEquals(1, tester.kthGrammar(N5, K5));
    }
}
