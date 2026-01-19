package programmers.hash;

import java.util.HashMap;
import java.util.Map;

public class 할인행사 {

    public static void main(String[] args) {

    }

    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        // 1. 내가 원하는 품목과 수량을 Map에 저장
        Map<String, Integer> wantMap = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }

        for (int i = 0; i < discount.length-9; i++) {
            HashMap<String ,Integer> discount10d = new HashMap<>();

            for (int j = i; j < i+10 ; j++) {
                 if (wantMap.containsKey(discount[j])){
                     discount10d.put(discount[j],discount10d.getOrDefault(discount[j],0)+1);
                 }
                 if (discount10d.equals(wantMap))
                     answer+=1;
            }
        }
        return answer;
    }
}