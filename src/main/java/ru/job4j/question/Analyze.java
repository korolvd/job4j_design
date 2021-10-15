package ru.job4j.question;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Analyze {

    public static Info diff(Set<User> previous, Set<User> current) {
        int added = 0, changed = 0, deleted = 0, equal = 0;
        Map<Integer, User> map = new HashMap<>();
        for (User user : current) {
            map.put(user.getId(), user);
        }
        for (User user : previous) {
            int id = user.getId();
            if (map.containsKey(id)) {
                if (user.equals(map.get(id))) {
                    equal++;
                } else {
                    changed++;
                }
            } else {
                deleted++;
            }
        }
        added = current.size() - equal - changed;
        return new Info(added, changed, deleted);
    }
}
