package BitManipulation.bitmask;

/**
 * leetcode 1255
 * 你将会得到一份单词表 words，一个字母表 letters （可能会有重复字母），以及每个字母对应的得分情况表 score。
 * <p>
 * 请你帮忙计算玩家在单词拼写游戏中所能获得的「最高得分」：
 * 能够由 letters 里的字母拼写出的 任意 属于 words 单词子集中，分数最高的单词集合的得分。
 * <p>
 * 输入：words = ["dog","cat","dad","good"], letters = ["a","a","c","d","d","d","g","o","o"],
 * score = [1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0]
 * 输出：23
 * 解释：
 * 字母得分为  a=1, c=9, d=5, g=3, o=2
 * 使用给定的字母表 letters，我们可以拼写单词 "dad" (5+1+5)和 "good" (3+2+2+5)，得分为 23 。
 * 而单词 "dad" 和 "dog" 只能得到 21 分。
 * <p>
 * 1. 对于单词集合中每一个词，都可以选择，用/不用
 * 所以就可以用位 0/1 来表示
 * <p>
 * 2. 单词集合中每个单词都表示出来，总和就是 2^N种
 * 可以用 1 << N 来表示
 * <p>
 * 3. 当遍历到其中一个组合时，其数字的二进制位表示的就是各个单词的使用状态
 * 比如 5，二进制 101，代表第 0 个和第 2 个单词使用，第 1 个单词不使用
 * <p>
 * 4. 检查时，对于第 i 个单词，使用 1 << i，得到二进制除了第 i 位（顺序是从右至左）其余全 0 的数字
 * 比如第 2 个单词，1 << 2 之后得到 4（二进制 100）
 * <p>
 * 5. 再与状态位进行 & 操作，得到是否使用
 * 4（二进制 100）与刚才的 5（二进制 101）&操作，得到 true
 */
public class MaximumScoreWords {
  public static void main(String[] args) {
    String[] w = {"dog", "cat", "dad", "good"};
    char[] c = {'a', 'a', 'c', 'd', 'd', 'd', 'g', 'o', 'o'};
    int[] s = {1, 0, 9, 5, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    maxScoreWords(w, c, s);
  }

  public static int maxScoreWords(String[] words, char[] letters, int[] score) {
    int[] cntLetter = new int[26];
    for (char c : letters) {
      cntLetter[c - 'a']++;
    }

    int res = 0;
    for (int i = 0; i < (1 << words.length); ++i) {
      int[] cntString = group(words, i);
      res = Math.max(res, getScore(cntString, cntLetter, score));
    }

    return res;
  }

  // 将第（bit）种组合情况，所使用的单词中的字母数量统计出来
  static int[] group(String[] words, int bit) {
    int[] cnt = new int[26];
    for (int i = 0; i < words.length; ++i) {
      // 检查使用与否
      // 比如占用了 1010说明选的是words[0]和words[2]，那这种情况下
      // 1010 & 0100 和 & 0001 才不会被continue，这两个也分别代表了
      // 选用第二个和选用第四个字符串（在1和3不能选的情况下）
      if ((bit & (1 << i)) != 0) {
        continue;
      }
      // 确定选哪个之后，就统计哪个
      for (char c : words[i].toCharArray()) {
        cnt[c - 'a']++;
      }
    }
    return cnt;
  }

  // get score
  static int getScore(int[] cnt, int[] letter, int[] score) {
    int sum = 0;
    for (int i = 0; i < 26; ++i) {
      if (letter[i] < cnt[i]) {
        return 0;
      }
      sum += cnt[i] * score[i];
    }
    return sum;
  }
}
