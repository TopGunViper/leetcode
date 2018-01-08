package edu.ouc.contest66;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.sun.tools.javac.util.Assert;

/**
 * 759. Employee Free Time My SubmissionsBack to Contest
 * <p>
 * We are given a list schedule of employees, which represents the working time for each employee.
 * <p>
 * Each employee has a list of non-overlapping Intervals, and these intervals are in sorted order.
 * <p>
 * Return the list of finite intervals representing common, positive-length free time for all
 * employees, also in sorted order.
 *
 * @author wqx
 */
public class _759_Employee_Free_Time {

    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> res = new LinkedList<>();
        List<Interval> allIntervals = new LinkedList<>();

        schedule.forEach(elems -> allIntervals.addAll(elems));

        // sort with start
        Collections.sort(allIntervals, ((a, b) -> a.start - b.start));

        Interval cur = allIntervals.get(0);

        for (Interval interval : allIntervals) {
            if (cur.end < interval.start) {
                res.add(new Interval(cur.end, interval.start));
                cur = interval;
            } else {
                cur = cur.end < interval.end ? interval : cur;
            }
        }
        return res;
    }

    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public static void main(String args[]) {
        //test case1
        _759_Employee_Free_Time tester = new _759_Employee_Free_Time();
    }
}
