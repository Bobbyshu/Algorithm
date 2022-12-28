package leetcode.HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class lc2456 {
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        int n = creators.length;
        HashMap<String, Double> nameSumMap = new HashMap<>();
        HashMap<String, Integer> nameMaxViewMap = new HashMap<>();
        HashMap<String, String> nameIdMap = new HashMap<>();
        double maxValue = 0;
        for (int i = 0; i < n; i++) {
            nameSumMap.put(creators[i], nameSumMap.getOrDefault(creators[i], 0.0) + views[i]);
            maxValue = Math.max(maxValue, nameSumMap.get(creators[i]));

            if (nameMaxViewMap.get(creators[i]) == null
                    || views[i] > nameMaxViewMap.get(creators[i])
                    || (views[i] == nameMaxViewMap.get(creators[i]) && nameIdMap.get(creators[i]).compareTo(ids[i]) > 0)) {
                nameMaxViewMap.put(creators[i], views[i]);
                nameIdMap.put(creators[i], ids[i]);
            }
        }

        List<List<String>> res = new ArrayList<>();
        for (String s : nameSumMap.keySet()) {
            if (nameSumMap.get(s).equals(maxValue)) {
                List<String> path = new ArrayList<>();
                path.add(s);
                path.add(nameIdMap.get(s));
                res.add(path);
            }
        }

        return res;
    }
}
