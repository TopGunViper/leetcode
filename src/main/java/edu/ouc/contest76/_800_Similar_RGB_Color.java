package edu.ouc.contest76;

import java.util.Arrays;

import org.junit.Assert;

public class _800_Similar_RGB_Color {

    private int[] shorthand = {0, 17, 34, 51, 68, 85, 102,
            119, 136, 153, 170, 187, 204, 221, 238, 255};

    public String similarRGB(String color) {

        String R = color.substring(1, 3);
        String G = color.substring(3, 5);
        String B = color.substring(6);
        System.out.println(Arrays.binarySearch(shorthand, 200));
        return "#" + closest(R) + closest(G) + closest(B);
    }

    private String closest(String str) {
        int key = Integer.parseInt(str, 16);
        if (key == 0) {
            return "00";
        }

        int pos = 0;
        int low = 0;
        int high = shorthand.length;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = shorthand[mid];

            if (midVal < key) {
                low = mid + 1;
            } else if (midVal > key) {
                high = mid - 1;
            } else {
                pos = mid;
                break;
            }
        }

        int closest;
        if (pos == shorthand.length) {
            closest = shorthand[pos - 1];
        } else {
            closest = (key - shorthand[pos - 1]) < (shorthand[pos] - key) ? shorthand[pos - 1] : shorthand[pos];
        }
        return Integer.toHexString(closest);
    }

    public static void main(String args[]) {
        //test case1
        _800_Similar_RGB_Color
                tester = new _800_Similar_RGB_Color();

        //        String color = "#09f166";
        //        Assert.assertEquals("#11ee66", tester.similarRGB(color));
        //
        //        String color2 = "#aaffbb";
        //        Assert.assertEquals("#aaffbb", tester.similarRGB(color2));
        //
        //        String color3 = "#aa00bb";
        //        Assert.assertEquals("#aa00bb", tester.similarRGB(color3));

        String color4 = "#4e3fe1";
        Assert.assertEquals("#5544dd", tester.similarRGB(color4));

    }
}
