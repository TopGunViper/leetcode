package edu.ouc.dp;

public class _338_Counting_Bits_M {

    /**
     * 1
     * 10
     * 11
     * 100
     * 101
     * 110
     * 111
     * 1000
     *
     *
     * @param num
     * @return
     */
    public int[] countBits(int num) {
        String binaryStr = Integer.toBinaryString(num);
        System.out.println("binary:" + binaryStr);

        return new int[]{1,2};
    }

    public static void main(String[] args) {
        //test case1
        _338_Counting_Bits_M
                tester = new _338_Counting_Bits_M();
        int n = 3;
        tester.countBits(n);
    }
}
