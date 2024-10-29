package A_OnsiteClassical.Tiktok;

import java.util.*;

public class NO1257_SmallestCommonRegion {
  // 用了最低祖先的算法，就是map记录每个节点的一路上去的祖先，
  // 然后set先采集其中一个节点这个一路上去的路，
  // 另一个也依法炮制直到他们两的路有所交集即为找到最低公共祖先了
  public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
    Map<String, String> parents = new HashMap<>();
    Set<String> ancestry = new HashSet<>();

    for (List<String> region : regions) {
      for (int i = 1; i < region.size(); ++i) {
        parents.put(region.get(i), region.get(0));
      }
    }

    while (region1 != null) {
      ancestry.add(region1);
      region1 = parents.get(region1);
    }

    while (!ancestry.contains(region2)) {
      region2 = parents.get(region2);
    }

    return region2;
  }
}
