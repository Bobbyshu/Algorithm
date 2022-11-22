package DataStructure.HashMap;

import java.util.HashMap;
import java.util.Objects;

public class overwrite {
    public static void main(String[] args) {
        HashMap<Key, String> map = new HashMap();
        Key key = new Key("hyb");
        map.put(key, key.getKey());
        Key key2 = new Key("hyb");
        System.out.println(map.get(key2));
    }
}

class Key {
    String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Key(String key) {
        this.key = key;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Key key1 = (Key) o;
        return Objects.equals(key, key1.key);
    }

    @Override
    public int hashCode() {

        return key.hashCode();
    }
}
