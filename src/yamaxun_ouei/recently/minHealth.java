package yamaxun_ouei.recently;
/*
玩家失去力量 [ i ] 生命值以完成第 i 回合;
玩家的生命值必须始终大于0;
玩家可以选择在任何一个回合中使用盔甲。护甲将防止伤害最小（护甲，力量[ i ]）;
确定玩家赢得比赛的最低起始生命值。
[1,2,6,7] armor = 5

 */
public class minHealth {
    int min(int[] nums, int armor) {
        int sum = 1;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, num);
        }

        if (max > armor) {
            sum -= armor;
        } else {
            sum -= max;
        }
        return sum;
    }
}
