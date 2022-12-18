package String.SubArray;

public class SumOfBeautyOfAllSubstrings {
    public int beautySum(String s) {
        int sum = 0;
        int n = s.length();

        for (int i = 0; i < n; ++i) {
            int[] dict = new int[26];
            for (int j = i; j < n; ++j) {
                dict[s.charAt(j) - 'a']++;
                int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
                if (j - i >= 1) {
                    for (int k = 0; k < 26; ++k) {
                        if (dict[k] != 0) {
                            min = Math.min(min, dict[k]);
                            max = Math.max(max, dict[k]);
                        }
                    }
                    // System.out.println(max);
                    // System.out.println(min);
                    sum += (max - min);
                }
            }
        }

        return sum;
    }
}
