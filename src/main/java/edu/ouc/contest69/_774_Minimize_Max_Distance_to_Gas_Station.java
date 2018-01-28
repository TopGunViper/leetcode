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
public class _774_Minimize_Max_Distance_to_Gas_Station {

    public double minmaxGasDist(int[] stations, int K) {
        int count, N = stations.length;
        float left = 0, right = stations[N - 1] - stations[0], mid;

        while (left + 0.00001 < right) {
            mid = (left + right) / 2;
            count = 0;
            for (int i = 0; i < N - 1; ++i) {
                count += Math.ceil((stations[i + 1] - stations[i]) / mid) - 1;
            }
            if (count > K) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return right;
    }

    public static void main(String args[]) {
        //test case1
        _774_Minimize_Max_Distance_to_Gas_Station tester = new _774_Minimize_Max_Distance_to_Gas_Station();
        int[] stations = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int K = 9;

        Assert.assertEquals(0.500000, tester.minmaxGasDist(stations, K), 0.00001);

    }

}
