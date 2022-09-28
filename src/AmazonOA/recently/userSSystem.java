package AmazonOA.recently;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class userSSystem {
    public static void parselogs(ArrayList<String> logs) {
        int n = logs.size();
        Map<String, String> database = new HashMap<>();
        Map<String, String> online = new HashMap<>();
        List<String> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String commands = logs.get(i);
            String[] split = commands.split(" ");
            if (split[0].equals("register")) {
                if (database.containsKey(split[1])) {
                    res.add("Username already exists");
                } else {
                    res.add("Registered Successfully");
                    database.put(split[1], split[2]);
                }
            } else if (split[0].equals("login")) {
                if (database.containsKey(split[1])) {
                    if (online.containsKey(split[1])) {
                        res.add("Login Unsuccessful");
                    } else {
                        if (database.get(split[1]).equals(split[2])) {
                            res.add("Logged In Successfully");
                            online.put(split[1], split[2]);
                        } else {
                            res.add("Login Unsuccessfully");
                        }
                    }
                } else {
                    res.add("Login Unsuccessfully");
                }
            } else if (split[0].equals("logout")) {
                if (database.containsKey(split[1])) {
                    if (online.containsKey(split[1])) {
                        res.add("Logged Out Successfully");
                        online.remove(split[1]);
                    } else {
                        res.add("Logout Unsuccessful");
                    }
                } else {
                    res.add("Logout Unsuccessful");
                }
            }
        }

        for (String s : res) {
            System.out.println(s);
        }
    }
}
