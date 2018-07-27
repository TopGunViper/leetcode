package edu.ouc.contest91;

import org.junit.Assert;

public class _860_Lemonade_Change {

    public boolean lemonadeChange(int[] bills) {
        int numOfFiveBill = 0;
        int numOfTenBill = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                numOfFiveBill++;
            } else if (bills[i] == 10) {
                numOfFiveBill--;
                numOfTenBill++;
            } else {
                if (numOfTenBill != 0) {
                    numOfTenBill--;
                    numOfFiveBill--;
                } else {
                    numOfFiveBill -= 3;
                }
            }
            if (numOfFiveBill <= -1 || numOfTenBill <= -1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        _860_Lemonade_Change
                tester = new _860_Lemonade_Change();
        int[] bills = {5, 5, 5, 10, 20};
        Assert.assertTrue(tester.lemonadeChange(bills));
        int[] bills2 = {5, 5, 5, 10, 5, 5, 10, 20, 20, 20};
        Assert.assertFalse(tester.lemonadeChange(bills2));
    }
}
