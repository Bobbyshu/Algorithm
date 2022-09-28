package yamaxun_ouei.former;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProcessingLogs {
    public static List<String> processingLogs(List<String> logs, int threshold) {
        Map<String, Integer> map = new HashMap<>();
        for (String log : logs) {
            String[] splited = log.split(" ");
            String uid_1 = splited[0];
            String uid_2 = splited[1];
            map.put(uid_1, map.getOrDefault(uid_1, 0) + 1);
            if (!uid_2.equals(uid_1)) {
                map.put(uid_2, map.getOrDefault(uid_2, 0) + 1);
            }
        }

        List<String> resUid = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= threshold) {
                resUid.add(entry.getKey());
            }
        }

        resUid.sort((String a, String b) -> (Integer.parseInt(b) - Integer.parseInt(a)));
        return resUid;
    }



}
