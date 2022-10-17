package A_OUEI.tooSenPo;

public class maximumGoodPeople {
    public int maximumGood(int[][] statements) {
        int ans = 0;
        int n = statements.length;
        next:
        for (int i = 1; i < 1 << n; i++) {
            int cnt = 0; // i 中好人个数
            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) == 1) { // 枚举 i 中的好人 j
                    for (int k = 0; k < n; k++) { // 枚举 j 的所有陈述
                        if (statements[j][k] < 2 && statements[j][k] != ((i >> k) & 1)) { // 该陈述与实际情况矛盾
                            continue next;
                        }
                    }
                    cnt++;
                }
            }
            ans = Math.max(ans, cnt);
        }
        return ans;
    }
}
