package Imitate;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SubdomainVisitCount {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        List<String> res = new LinkedList<>();
        for (String domain : cpdomains) {
            process(domain, map);
        }

        //traverse map and generate String
        for (String key : map.keySet()) {
            res.add(map.get(key) + " " + key);
        }

        return res;
    }

    void process(String s, Map<String,Integer> map) {
        // find number
        int idx = s.indexOf(' '), cnt = Integer.parseInt(s.substring(0, idx));
        // except number
        String domain = s.substring(idx + 1);
        map.put(domain, map.getOrDefault(domain, 0) + cnt);

        for (int i = 0; i < domain.length(); ++i) {
            // find split
            if (domain.charAt(i) == '.') {
                String seg = domain.substring(i + 1);
                map.put(seg, map.getOrDefault(seg, 0) + cnt);
            }
        }
    }
}
