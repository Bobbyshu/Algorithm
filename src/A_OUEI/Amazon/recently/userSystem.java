package A_OUEI.Amazon.recently;

import java.util.*;

public class userSystem {


}

class userSystem2 {
    public static void parselogs(ArrayList<String> logs) {
        int n = logs.size();
        Map<String, String> register = new HashMap<>();
        Map<String, String> login = new HashMap<>();
        List<String> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String temp = logs.get(i);
            //         \\s表示空格,回车,换行等空白符，+号表示一个或多个的意思
            String[] split = temp.split(" ");
            if (split[0].equals("register")) {
                if (register.containsKey(split[1]))
                    res.add("Username already exists");
                else {
                    res.add("Registered Successfully");
                    register.put(split[1], split[2]);
                }
            } else if (split[0].equals("login")) {
                if (register.containsKey(split[1])) {
                    if ((login.containsKey(split[1]))) {
                        res.add("Login Unsuccessful");
                    } else {
                        if (register.get(split[1]).equals(split[2])) {
                            res.add("Logged In Successfully");
                            login.put(split[1], split[2]);
                        } else {
                            res.add("Login Unsuccessful");
                        }
                    }
                } else {
                    res.add("Login Unsuccessful");
                }

            } else {
                if (register.containsKey(split[1])) {
                    if ((login.containsKey(split[1]))) {
                        res.add("Logged Out Successfully");
                        login.remove(split[1]);
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
