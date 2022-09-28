package AmazonOA.recently;

/*
maxima frequency是在目前index上的substring (0,i)给目前最大freq occurrence的字母加一分，
结果要整个string最大的maxima frequency.
 */
public class maximumFreqCount {
    public static void main(String[] args) {
        maximumFreqCount max = new maximumFreqCount();
        String s = "bccaaacb";
        System.out.println(max.freq(s));
    }

    int freq(String s) {
        int[] dict = new int[26];
        int[] res = new int[26];

        for (int i = 0; i < s.length(); i++) {
            dict[s.charAt(i) - 'a']++;
            int max = 0;
            for (int j = 0; j < 26; j++) {
                max = Math.max(max, dict[i]);
            }
            for (int k = 0; k < 26; k++) {
                if (dict[k] == max) {
                    res[k]++;
                }
            }
        }
        int ans = 0;
        for (int num : res) {
            ans = Math.max(ans, num);
        }

        return ans;
    }
}
