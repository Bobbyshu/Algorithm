package Trick;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static Trick.test1.testi;

public class test {
    public static void main(String[] args) {
        AuthenticationManager am = new AuthenticationManager(5);
        System.out.println(testi);
    }
}

class test1 {
    public static int testi = 1;
}
class AuthenticationManager {
    Map<String, Integer> map;
    int timeToLive;
    public AuthenticationManager(int timeToLive) {
        map = new HashMap<>();
        this.timeToLive = timeToLive;
    }

    public void generate(String tokenId, int currentTime) {
        map.put(tokenId, currentTime);
    }

    public void renew(String tokenId, int currentTime) {
        if (map.containsKey(tokenId)) {
            if (map.get(tokenId) + timeToLive > currentTime) {
                map.put(tokenId, currentTime);
            }
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        int cnt = 0;
        for (String s : map.keySet()) {
            // System.out.println(s);
            // System.out.println(map.get(s));
            if (map.get(s) + timeToLive > currentTime) {
                ++cnt;
            }
        }
        return cnt;
    }
}
