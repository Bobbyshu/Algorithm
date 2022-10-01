package zip;

public class t2 {
    public static void main(String[] args) {
        t2 te2 = new t2();
        int[] arr = {1, 1, 1, 0, 0, 0};
        System.out.println(te2.zeroToOnes(arr, 2));
    }

    int zeroToOnes(int[] arr, int zeroToOnes) {
        int zero = 0, one = 0;
        for (int i : arr) {
            if (i == 1) {
                one++;
            } else {
                zero++;
            }
        }

        int res = 0;
        while (zero >= zeroToOnes || one > 0) {
            res++;
            if (zero > zeroToOnes) {
                zero -= zeroToOnes;
                one++;
            } else {
                zero++;
                one--;
            }
        }

        return res;
    }
}
