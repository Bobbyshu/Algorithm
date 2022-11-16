package Trick;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class test {
    public static void main(String[] args) {
        int[][] box = {{5,10},{2,5},{4,7},{3,9}};
        int size = 10;
        maximumUnits(box, size);
    }

    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (int[] o1, int[] o2) -> o2[1] - o1[1]);
        int res = 0;

        for (int[] box : boxTypes) {
            // if (truckSize <= 0)
            //     break;
            if (truckSize >= box[0]) {
                res += box[0] * box[1];
            } else {
                res += truckSize * box[1];
            }
            truckSize -= box[0];
        }

        return res;
    }
}
