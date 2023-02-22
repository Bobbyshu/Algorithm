package A_OUEI.Citadel;

import java.util.ArrayList;
import java.util.List;

public class getTheGroup {
  List<Integer> getTheGroups(int n, String[] queryTypes, int[] s1, int[] s2) {
    UF uf = new UF(n);
    List<Integer> res = new ArrayList<>();
    for (int i = 0; i < queryTypes.length; ++i) {
      if (queryTypes[i].equals("Friend")) {
        uf.union(s1[i], s2[i]);
      } else {
        int x = uf.find(s1[i]), y = uf.find(s2[i]);
        if (x == y) {
          res.add(uf.cnt[x]);
        } else {
          res.add(uf.cnt[x] + uf.cnt[y]);
        }
      }
    }
    return res;
  }
}

class UF {
  int[] cnt = new int[100005];
  int[] par = new int[100005];

  public UF(int n) {
    for (int i = 1; i <= n; ++i) {
      cnt[i] = 1;
      par[i] = i;
    }
  }

  int find(int x) {
    if (x == par[x]) {
      return x;
    }

    return par[x] = find(par[x]);
  }

  void union(int p, int q) {
    p = find(p);
    q = find(q);

    if (p == q) {
      return;
    }

    if (cnt[p] > cnt[q]) {
      int temp = p;
      p = q;
      q = temp;
    }

    par[p] = q;
    cnt[q] += p;
  }
}


