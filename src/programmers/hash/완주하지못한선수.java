package programmers.hash;

import java.util.HashMap;
import java.util.Map;

public class 완주하지못한선수 {

    public static void main(String[] args) {
         solution(new String[]{"mislav", "stanko", "mislav", "ana" }
                 ,new String[]{"stanko", "ana", "mislav"});
    }
    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        for (String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }
        for (String c : completion) {
              map.put(c, map.get(c) - 1);
        }
        for (String key : map.keySet()) {
            if (map.get(key) != 0) {
                return key;
            }
        }
        return answer;
    }
}
